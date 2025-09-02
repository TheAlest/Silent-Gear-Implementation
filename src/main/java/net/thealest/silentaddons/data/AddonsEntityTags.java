package net.thealest.silentaddons.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.EntityTypeTags.*;
import static net.thealest.silentaddons.ModsUtils.ModsReference.*;
import static net.thealest.silentaddons.SilentAddons.MOD_ID;
import static net.thealest.silentaddons.constants.Tags.*;

public class AddonsEntityTags extends EntityTypeTagsProvider {


    public AddonsEntityTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvvider){
        AddVanillaTags();
        AddEnderZoologyTags();
        AddEndermanOverhaulTags();
        AddLuminousTags();
    }
    private void AddVanillaTags() {
        tag(HOLY_RESISTANT)
                .add(EntityType.COW, EntityType.VEX);

        tag(HOLY_WEAK)
                .addTag(UNDEAD);

        tag(FIRE_RESISTANT)
                .add(EntityType.HUSK);

        tag(FIRE_WEAK)
                .add(EntityType.BOGGED, EntityType.CREEPER, EntityType.STRAY);

        tag(LIGHTNING_RESISTANT)
                .add(EntityType.BREEZE);

        tag(LIGHTNING_WEAK)
                .add(EntityType.WARDEN)
                .addTag(FLYINGS);

        tag(ICE_RESISTANT)
                .add(EntityType.BREEZE, EntityType.CREEPER, EntityType.DROWNED)
                .addTag(SLIMES)
                .addOptionalTag(TagKey.create(Registries.ENTITY_TYPE, CreeperOverhaul("creepers")));

        tag(ICE_WEAK);

        tag(BLOOD_WEAK)
                .addTag(ENDERBORN);

        tag(BLOOD_RESISTANT)
                .add(EntityType.BOGGED)
                .addTag(WITCHS);

        tag(ENDER_WEAK)
                .add(EntityType.EVOKER);

        tag(ENDER_RESISTANT);

        tag(ANIMALS)
                .add(EntityType.HOGLIN, EntityType.RAVAGER)
                .addTag(ARTHROPOD);

        tag(NETHERBORN)
                .add(EntityType.GHAST, EntityType.BLAZE, EntityType.HOGLIN, EntityType.MAGMA_CUBE, EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.SPIDER, EntityType.WITHER_SKELETON);

        tag(ENDERBORN)
                .add(EntityType.ENDER_DRAGON, EntityType.ENDERMAN, EntityType.ENDERMITE, EntityType.SHULKER);

        tag(SLIMES)
                .add(EntityType.SLIME, EntityType.MAGMA_CUBE);

        tag(FLYINGS)
                .add(EntityType.PHANTOM, EntityType.VEX, EntityType.ENDER_DRAGON, EntityType.GHAST);

        tag(WITCHS)
                .add(EntityType.WITCH);
    }

    private void AddEnderZoologyTags() {
        tag(ICE_RESISTANT)
                .addOptional(EnderZoology("dire_wolf"));

        tag(ANIMALS)
                .addOptional(EnderZoology("wither_cat"))
                .addOptional(EnderZoology("dire_wolf"))
                .addOptional(EnderZoology("owl"));

        tag(ENDERBORN)
                .addOptional(EnderZoology("infested_zombie"))
                .addOptional(EnderZoology("concussion_creeper"))
                .addOptional(EnderZoology("enderminy"));

        tag(WITCHS)
                .addOptional(EnderZoology("wither_witch"));
    }

    private void AddEndermanOverhaulTags(){
        tag(ENDERBORN)
                .addOptional(EndermanOverhaul("badlands_enderman"))
                .addOptional(EndermanOverhaul("cave_enderman"))
                .addOptional(EndermanOverhaul("coral_enderman"))
                .addOptional(EndermanOverhaul("crimson_forest_enderman"))
                .addOptional(EndermanOverhaul("dark_oak_enderman"))
                .addOptional(EndermanOverhaul("desert_enderman"))
                .addOptional(EndermanOverhaul("end_enderman"))
                .addOptional(EndermanOverhaul("end_islands_enderman"))
                .addOptional(EndermanOverhaul("flower_fields_enderman"))
                .addOptional(EndermanOverhaul("ice_spikes_enderman"))
                .addOptional(EndermanOverhaul("mushroom_fields_enderman"))
                .addOptional(EndermanOverhaul("nether_wastes_enderman"))
                .addOptional(EndermanOverhaul("savanna_enderman"))
                .addOptional(EndermanOverhaul("snowy_enderman"))
                .addOptional(EndermanOverhaul("soulsand_valley_enderman"))
                .addOptional(EndermanOverhaul("swamp_enderman"))
                .addOptional(EndermanOverhaul("warped_forest_enderman"))
                .addOptional(EndermanOverhaul("windswept_hills_enderman"));
    }

    private void AddLuminousTags(){
        tag(FIRE_WEAK)
                .addOptional(LuminousWorld("treant"))
                .addOptional(LuminousWorld("cherry_treant"))
                .addOptional(LuminousWorld("yeti"));

        tag(FIRE_RESISTANT)
                .addOptional(LuminousWorld("arid_yeti"))
                .addOptional(LuminousWorld("pheonix"))
                .addOptional(LuminousWorld("baby_phoenix"));

        tag(ICE_RESISTANT)
                .addOptional(LuminousWorld("yeti"));

        tag(ICE_WEAK)
                .addOptional(LuminousWorld("arid_yeti"))
                .addOptional(LuminousWorld("pheonix"))
                .addOptional(LuminousWorld("baby_phoenix"));

        tag(ANIMALS)
                .addOptional(LuminousWorld("king_crab"))
                .addOptional(LuminousWorld("golden_king_hermit"))
                .addOptional(LuminousWorld("sea_viper"))
                .addOptional(LuminousWorld("coral_sea_viper"))
                .addOptional(LuminousWorld("frigid_gator"))
                .addOptional(LuminousWorld("toxic_gator"));

        tag(FLYINGS)
                .addOptional(LuminousWorld("pheonix"))
                .addOptional(LuminousWorld("wind_pheonix"))
                .addOptional(LuminousWorld("baby_wind_phoenix"))
                .addOptional(LuminousWorld("baby_phoenix"));

        tag(SKELETONS)
                .addOptional(LuminousWorld("bone_stalker"))
                .addOptional(LuminousWorld("bogged_bone_stalker"))
                .addOptional(LuminousWorld("auburn_skeleton"))
                .addOptional(LuminousWorld("cherry_skeleton"))
                .addOptional(LuminousWorld("dark_oak_skeleton"))
                .addOptional(LuminousWorld("savannah_skeleton"))
                .addOptional(LuminousWorld("swamp_skeleton"))
                .addOptional(LuminousWorld("frigid_skeleton"))
                .addOptional(LuminousWorld("miner_skeleton"));

        tag(WITCHS)
                .addOptional(LuminousWorld("witch_doctor"))
                .addOptional(LuminousWorld("woodland_witch_doctor"));

        tag(NETHERBORN)
                .addOptional(LuminousNether("basalt_executioner"))
                .addOptional(LuminousNether("crimson_walker"))
                .addOptional(LuminousNether("cultist_archer"))
                .addOptional(LuminousNether("cultist_rider"))
                .addOptional(LuminousNether("gilded_cultist"))
                .addOptional(LuminousNether("glider"))
                .addOptional(LuminousNether("guzzleghast"))
                .addOptional(LuminousNether("mushlin_bumper"))
                .addOptional(LuminousNether("mushlin_king"))
                .addOptional(LuminousNether("mushlin_king_2"))
                .addOptional(LuminousNether("mushlin_king_3"))
                .addOptional(LuminousNether("piglin_executioner"))
                .addOptional(LuminousNether("piglin_executioner_2"))
                .addOptional(LuminousNether("piglin_executioner_3"))
                .addOptional(LuminousNether("ghost"))
                .addOptional(LuminousNether("poltergeist"))
                .addOptional(LuminousNether("revenant_skeleton"))
                .addOptional(LuminousNether("spirit"))
                .addOptional(LuminousNether("warped_king"))
                .addOptional(LuminousNether("zombie_piglin_cultist"))
                .addOptional(LuminousNether("zombie_piglin_cultist_leader"))
                .addOptional(LuminousNether("the_furnace"))
                .addOptional(LuminousNether("the_furnace_2"))
                .addOptional(LuminousNether("the_furnace_3"));

        tag(FLYINGS)
                .addOptional(LuminousNether("ghost"))
                .addOptional(LuminousNether("spirit"))
                .addOptional(LuminousNether("poltergeist"))
                .addOptional(LuminousNether("guzzleghast"));


    }
}
