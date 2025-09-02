package net.thealest.silentaddons.data;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.silentchaos512.gear.api.data.material.MaterialBuilder;
import net.silentchaos512.gear.api.data.material.MaterialsProviderBase;
import net.silentchaos512.gear.api.material.TextureType;
import net.silentchaos512.gear.api.property.BooleanPropertyValue;
import net.silentchaos512.gear.api.property.GearProperty;
import net.silentchaos512.gear.api.property.HarvestTier;
import net.silentchaos512.gear.api.property.NumberProperty;
import net.silentchaos512.gear.api.util.PartGearKey;
import net.silentchaos512.gear.gear.material.MaterialCategories;
import net.silentchaos512.gear.gear.trait.condition.GearTypeTraitCondition;
import net.silentchaos512.gear.gear.trait.condition.MaterialCountTraitCondition;
import net.silentchaos512.gear.setup.gear.GearProperties;
import net.silentchaos512.gear.setup.gear.GearTypes;
import net.silentchaos512.gear.setup.gear.PartTypes;
import net.silentchaos512.gear.util.Const;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import static net.thealest.silentaddons.constants.Materials.*;
import static net.thealest.silentaddons.constants.Materials.*;
import static net.thealest.silentaddons.constants.Traits.*;

public class AddonsMaterials extends MaterialsProviderBase {
    public AddonsMaterials(DataGenerator generator, String modId) {
        super(generator, modId);
    }

    @Override


    protected Collection<MaterialBuilder<?>> getMaterials() {
        Collection<MaterialBuilder<?>> ret = new ArrayList<>();
        addVanillaMaterials(ret);
        addIronsMaterials(ret);
        return ret;
    }

    private void addVanillaMaterials(Collection<MaterialBuilder<?>> ret){
        // GLass
        ret.add(MaterialBuilder.simple(GLASS)
                .crafting(Tags.Items.GLASS_BLOCKS, MaterialCategories.ROCK, MaterialCategories.BASIC)
                .displayWithDefaultName(translate("material", "glass"), 0x7FFFFFFF, TextureType.HIGH_CONTRAST)
                //MAIN
                .mainStatsCommon(32, 6, 22, 20, 1)
                .mainStatsArmor(1, 2, 2 ,1, 0, 10)
                .mainStatsHarvest(HarvestTier.create("glass", "1", BlockTags.INCORRECT_FOR_STONE_TOOL),12)
                .mainStatsMelee(1, 4, 0)
                .mainStatsRanged(1, 1.10f)
                .mainStatsProjectile(1.1f, 1)
                .trait(PartTypes.MAIN, Const.Traits.BRITTLE, 3)
                .trait(PartTypes.MAIN, Const.Traits.CHIPPING, 2)
                .trait(PartTypes.MAIN, Const.Traits.SHARP, 1)
                //ROD
                .stat(PartTypes.ROD, GearProperties.HARVEST_SPEED, 3, NumberProperty.Operation.ADD)
                .trait(PartTypes.ROD, Const.Traits.BRITTLE, 3)
                .trait(PartTypes.ROD, Const.Traits.CHIPPING, 2)
                //TIP
                .stat(PartTypes.TIP, GearProperties.DURABILITY, 16, NumberProperty.Operation.ADD)
                .stat(PartTypes.TIP, GearProperties.MAGIC_DAMAGE, 2, NumberProperty.Operation.ADD)
                .trait(PartTypes.TIP, Const.Traits.SHARP, 1)
        );
        // Magma Block
        ret.add(MaterialBuilder.simple(MAGMA)
                .crafting(Items.MAGMA_BLOCK, MaterialCategories.ROCK, MaterialCategories.BASIC)
                .displayWithDefaultName(translate("material", "magma"), 0xB5332E, TextureType.HIGH_CONTRAST)
                //MAIN
                .mainStatsCommon(131, 5, 5, 15, 1)
                .mainStatsArmor(1, 2, 1 ,1, 0, 10)
                .mainStatsHarvest(HarvestTier.create("stone", "1", BlockTags.INCORRECT_FOR_STONE_TOOL),4)
                .mainStatsMelee(1, 0, 0)
                .mainStatsRanged(0, -0.2f, 1f, 0.8f)
                .mainStatsProjectile(1, 0.8f)
                .trait(PartTypes.MAIN, Const.Traits.ANCIENT, 1)
                .trait(PartTypes.MAIN, Const.Traits.MAGMATIC, 1)
                .trait(PartTypes.MAIN, BURNING, 1)
                //ROD
                .stat(PartTypes.ROD, GearProperties.HARVEST_SPEED, 0.1f, NumberProperty.Operation.MULTIPLY_TOTAL)
                .trait(PartTypes.ROD, Const.Traits.BRITTLE, 2)
                .trait(PartTypes.ROD, Const.Traits.CRUSHING, 2)
                //TIP
                .trait(PartTypes.TIP, Const.Traits.MAGMATIC, 1)
                .trait(PartTypes.TIP, BURNING, 1)
        );
        // Gunpowder
        ret.add(MaterialBuilder.simple(GUNPOWDER)
                .crafting(Items.GUNPOWDER, MaterialCategories.METAL, MaterialCategories.DUST, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "gunpowder"), 0x414257, TextureType.HIGH_CONTRAST)
                // main (additive)
                .stat(PartTypes.MAIN, GearProperties.ADDITIVE, new BooleanPropertyValue(true))
                .stat(PartTypes.MAIN, GearProperties.ENCHANTMENT_VALUE, -0.1f, NumberProperty.Operation.MULTIPLY_BASE)
                .stat(PartTypes.MAIN, GearProperties.CHARGING_VALUE, 0.1f, NumberProperty.Operation.MULTIPLY_BASE)
                .stat(PartTypes.MAIN, GearProperties.RARITY, 30)
                .stat(PartTypes.MAIN, GearProperties.HARVEST_SPEED, 12)
                .stat(PartTypes.MAIN, GearProperties.ATTACK_DAMAGE, 4)
                .stat(PartTypes.MAIN, GearProperties.RANGED_DAMAGE, 2)
                //tip
                .stat(PartTypes.TIP, GearProperties.RARITY, 10, NumberProperty.Operation.ADD)
                //TO DO .trait(PartTypes.TIP, DUSTS)
        );

        // Armadillo
        ret.add(MaterialBuilder.simple(ARMADILLO_SCUTE)
                .crafting(Items.ARMADILLO_SCUTE, MaterialCategories.ORGANIC, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "armadillo_scute"), 0xC68884, TextureType.LOW_CONTRAST)
                // main
                .stat(PartTypes.MAIN, GearProperties.DURABILITY, 0)
                .stat(PartGearKey.ofMain(GearTypes.LEGGINGS), GearProperties.ARMOR_DURABILITY, 25)
                .stat(PartTypes.MAIN, GearProperties.ENCHANTMENT_VALUE, 9)
                .stat(PartTypes.MAIN, GearProperties.CHARGING_VALUE, 0.5f)
                .stat(PartTypes.MAIN, GearProperties.RARITY, 20)
                .mainStatsArmor(0, 0, 3, 0, 0, 4)
                .trait(PartTypes.MAIN, Const.Traits.HEAT_RESISTANT, 1)
        );
    }

    private void addIronsMaterials(Collection<MaterialBuilder<?>> ret) {
        //Arcane Essence
        ret.add(MaterialBuilder.simple(ARCANE_ESSENCE)
                .crafting(ItemRegistry.ARCANE_ESSENCE.get(), MaterialCategories.DUST, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "arcane_essence"),0x005F9D, TextureType.HIGH_CONTRAST)
                // Coating
                .trait(PartTypes.COATING, MAGICAL, 1)
        );
        //FrozenBone
        ret.add(MaterialBuilder.simple(FROZEN_BONE)
                .crafting(ItemRegistry.FROZEN_BONE_SHARD.get(), MaterialCategories.ORGANIC, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "frozen_bone"),0xD1EDF2, TextureType.LOW_CONTRAST)
                // Coating
                .trait(PartTypes.ROD, Const.Traits.FLEXIBLE, 2)
                .trait(PartTypes.ROD, FREEZING, 1)
                .stat(PartTypes.ROD, GearProperties.ATTACK_DAMAGE, 0.20f, NumberProperty.Operation.MULTIPLY_TOTAL)
        );
        //Divine Pearl
        ret.add(MaterialBuilder.simple(DIVINE_PEARL)
                .crafting(ItemRegistry.DIVINE_PEARL.get(), MaterialCategories.GEM, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "divine_pearl"),0x80091B, TextureType.HIGH_CONTRAST)
                // Coating
                .trait(PartTypes.COATING, BLESSED, 1)
                // Setting
                .trait(PartTypes.SETTING, DEFLECT_MAGIC, 1)
        );
        //Fire Ale
        ret.add(MaterialBuilder.simple(FIRE_ALE)
                .crafting(ItemRegistry.FIRE_ALE.get(), MaterialCategories.ORGANIC, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "fire_ale"),0x80091B, TextureType.HIGH_CONTRAST)
                // Coating
                .trait(PartTypes.COATING, BURNING, 1)
        );
        //Blood Vial
        ret.add(MaterialBuilder.simple(BLOOD_VIAL)
                .crafting(ItemRegistry.BLOOD_VIAL.get(), MaterialCategories.ORGANIC, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "blood_vial"),0x6A1D1B, TextureType.HIGH_CONTRAST)
                // Coating
                .trait(PartTypes.COATING, VAMPIRIC, 1)
        );
        //Lighning Bottle
        ret.add(MaterialBuilder.simple(LIGHTNING_BOTTLE)
                .crafting(ItemRegistry.LIGHTNING_BOTTLE.get(), MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "lightning_bottle"),0xA2BFFF, TextureType.HIGH_CONTRAST)
                // Coating
                .trait(PartTypes.COATING, ELECTRIC, 1)
        );
        //Arcane Cloth
        ret.add(MaterialBuilder.simple(ARCANE_CLOTH)
                .crafting(ItemRegistry.MAGIC_CLOTH.get(), MaterialCategories.CLOTH, MaterialCategories.ORGANIC, MaterialCategories.INTERMEDIATE)
                .displayWithDefaultName(translate("material", "arcane_cloth"), 0xA2BFFF, TextureType.LOW_CONTRAST)
                // Main
                .mainStatsCommon(0, 5, 15, 11, 1)
                .mainStatsArmor(2, 6, 5, 2, 0, 12)
                .trait(PartTypes.MAIN, DEFLECT_MAGIC, 1)
                .trait(PartTypes.MAIN, MANA_REGEN, 1, new GearTypeTraitCondition(GearTypes.CHESTPLATE))
                // Binding
                .trait(PartTypes.BINDING, SPELL_POWER, 1)
                .trait(PartTypes.BINDING, MANA_REGEN, 1)
                // Lining
                .stat(PartTypes.LINING, GearProperties.MAGIC_ARMOR, 1, NumberProperty.Operation.ADD)
                .trait(PartTypes.LINING, MANA, 1)
                .trait(PartTypes.LINING, Const.Traits.FLEXIBLE, 2)
        );
    }

    private MutableComponent translate(String prefix, String suffix, Object... args) {
        return Component.translatable(prefix + ".thealestsilentaddons." + suffix, args);
    }
}
