package net.thealest.silentaddons.data;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.silentchaos512.gear.api.data.trait.TraitBuilder;
import net.silentchaos512.gear.api.data.trait.TraitsProviderBase;
import net.silentchaos512.gear.gear.trait.effect.AttributeTraitEffect;
import net.silentchaos512.gear.setup.gear.GearTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

import static net.thealest.silentaddons.constants.Traits.*;

public class AddonsTraits extends TraitsProviderBase{
    public AddonsTraits(DataGenerator generator) {
        super(generator, "thealestsilentaddons");
    }


    @Override
    public @NotNull Collection<TraitBuilder> getTraits() {
        Collection<TraitBuilder> ret = new ArrayList<>();
        ret.add(TraitBuilder.of(SPIKED, 3));
        ret.add(TraitBuilder.of(FREEZING, 5)
                .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(BURNING, 5)
            .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(BLESSED, 5)
                .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(MAGICAL, 5)
                .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(VAMPIRIC, 5)
                .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(ELECTRIC, 5)
                .withGearTypeCondition(GearTypes.WEAPON));
        ret.add(TraitBuilder.of(DEFLECT_MAGIC, 5)
                .withGearTypeCondition(GearTypes.CURIO, GearTypes.ARMOR)
                .effects(AttributeTraitEffect.builder()
                        .addAnySlot(GearTypes.ALL,
                                AttributeRegistry.SPELL_RESIST,
                                AttributeModifier.Operation.ADD_VALUE,
                                0.08f, 0.16f, 0.24f, 0.32f, 0.40f)
                        .build()));
        ret.add(TraitBuilder.of(MANA, 5)
                .withGearTypeCondition(GearTypes.CURIO, GearTypes.ARMOR)
                .effects(AttributeTraitEffect.builder()
                        .addAnySlot(GearTypes.ALL,
                                AttributeRegistry.MAX_MANA,
                                AttributeModifier.Operation.ADD_VALUE,
                                25, 50, 75, 100, 125)
                        .build()));
        ret.add(TraitBuilder.of(MANA_REGEN, 5)
                .effects(AttributeTraitEffect.builder()
                        .addAnySlot(GearTypes.ALL,
                                AttributeRegistry.MANA_REGEN,
                                AttributeModifier.Operation.ADD_VALUE,
                                0.25f, 0.50f, 0.75f, 1.00f, 1.25f)
                        .build()));
        ret.add(TraitBuilder.of(SPELL_POWER, 5)
                .withGearTypeCondition(GearTypes.CURIO, GearTypes.WEAPON)
                .effects(AttributeTraitEffect.builder()
                        .addAnySlot(GearTypes.ALL,
                                AttributeRegistry.SPELL_POWER,
                                AttributeModifier.Operation.ADD_VALUE,
                                0.10f, 0.20f, 0.30f, 0.40f, 0.50f)
                        .build()));

        return ret;
        }


}
