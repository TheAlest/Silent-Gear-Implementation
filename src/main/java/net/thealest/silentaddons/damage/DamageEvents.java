package net.thealest.silentaddons.damage;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.silentchaos512.gear.util.TraitHelper;
import net.thealest.silentaddons.SilentAddons;
import net.thealest.silentaddons.constants.Damages;


import java.util.List;
import java.util.Map;

import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.BLOOD_MAGIC;
import static net.thealest.silentaddons.damage.DamageSources.GetExtraDamageTraits;
import static net.thealest.silentaddons.damage.DamageSources.SpellDamage;
import static net.thealest.silentaddons.constants.Traits.VAMPIRIC;

@EventBusSubscriber(modid = SilentAddons.MOD_ID)
public class DamageEvents {

    @SubscribeEvent
    public static void onAttacking(AttackEntityEvent event) {
        Entity attacker = event.getEntity();
        Entity target = event.getTarget();

        if (!(target instanceof LivingEntity)) return;
        if (!(attacker.level() instanceof ServerLevel serverLevel)) return;
        List<DamageSources.ExtraDamageRecords> list = GetExtraDamageTraits(attacker);

        for (DamageSources.ExtraDamageRecords entry : list){
            target.hurt(SpellDamage(serverLevel, attacker,entry.damageType()), entry.level() * 2.0f);
            target.invulnerableTime = 0;
        }

    }

    @SubscribeEvent
    public static void onDamage(LivingDamageEvent.Pre event){
        ResourceKey<DamageType> damageKey = event.getSource().typeHolder().unwrapKey().orElse(null);
        if (damageKey == null) return;

        Map<TagKey<EntityType<?>>, Float> modifiers = Damages.DAMAGE_MULTS.get(damageKey);
        if (modifiers == null) return;

        float damage = event.getOriginalDamage();
        EntityType<?> type = event.getEntity().getType();

        for (var entry : modifiers.entrySet()) {
            if (type.is(entry.getKey())) {
                event.setNewDamage(damage * entry.getValue());
            }
        }
    }
    @SubscribeEvent
    public static void afterDamage(LivingDamageEvent.Post event){
        ResourceKey<DamageType> damageKey = event.getSource().typeHolder().unwrapKey().orElse(null);
        if (damageKey == null || !damageKey.equals(BLOOD_MAGIC)) return;
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        float damage = event.getOriginalDamage();
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!TraitHelper.hasTrait(stack, VAMPIRIC)) return;
        player.heal(damage / 2.0f);
    }

}
