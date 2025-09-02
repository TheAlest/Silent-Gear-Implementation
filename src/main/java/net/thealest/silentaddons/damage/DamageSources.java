package net.thealest.silentaddons.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.silentchaos512.gear.api.util.DataResource;
import net.silentchaos512.gear.gear.trait.Trait;
import net.silentchaos512.gear.util.TraitHelper;
import net.thealest.silentaddons.constants.Traits;

import java.util.ArrayList;
import java.util.Map;

import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.*;
import static net.thealest.silentaddons.constants.Damages.FROST_DAMAGE;

public class DamageSources {

    public record ExtraDamageRecords(ResourceKey<DamageType> damageType, float level) {}

    public static DamageSource freezingDamage(ServerLevel level, Entity attacker) {
        return new DamageSource(level.registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(FROST_DAMAGE), attacker);
    }

    public static DamageSource SpellDamage(ServerLevel level, Entity attacker, ResourceKey<DamageType> type){
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), attacker);
    }

    public static ArrayList<ExtraDamageRecords> GetExtraDamageTraits(Entity attacker){
        ArrayList<ExtraDamageRecords> list = new ArrayList<>();
        if (!(attacker instanceof Player player)) return list;
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        Map<ResourceKey<DamageType>, DataResource<Trait>> traits = Map.of(
                ICE_MAGIC, Traits.FREEZING,
                LIGHTNING_MAGIC, Traits.ELECTRIC,
                ENDER_MAGIC, Traits.MAGICAL,
                FIRE_MAGIC, Traits.BURNING,
                BLOOD_MAGIC, Traits.VAMPIRIC,
                HOLY_MAGIC, Traits.BLESSED
        );

        for (var entry : traits.entrySet()) {
            if (TraitHelper.hasTrait(stack, entry.getValue())) {
                list.add(new ExtraDamageRecords(entry.getKey(), TraitHelper.getTraitLevel(stack, entry.getValue())));
            }
        }
        return list;
    }
}
