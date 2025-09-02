package net.thealest.silentaddons.constants;

import net.silentchaos512.gear.api.material.Material;
import net.silentchaos512.gear.api.util.DataResource;

import static net.thealest.silentaddons.SilentAddons.getId;

public final class Materials {
    //VANILLA
    public static final DataResource<Material> GLASS = material("glass");
    public static final DataResource<Material> MAGMA = material("magma");
    public static final DataResource<Material> GUNPOWDER = material("gunpowder");
    public static final DataResource<Material> ARMADILLO_SCUTE = material("armadillo_scute");

    //IRON'S
    public static final DataResource<Material> ARCANE_ESSENCE = material("arcane_essence");
    public static final DataResource<Material> BLOOD_VIAL = material("blood_vial");
    public static final DataResource<Material> DIVINE_PEARL = material("divine_pearl");
    public static final DataResource<Material> FIRE_ALE = material("fire_ale");
    public static final DataResource<Material> FROZEN_BONE = material("frozen_bone");
    public static final DataResource<Material> LIGHTNING_BOTTLE = material("lightning_bottle");
    public static final DataResource<Material> ARCANE_CLOTH = material("arcane_cloth");

    //BIOMES O' PLENTY
    public static final DataResource<Material> BRAMBLE = material("glass");
    public static final DataResource<Material> ROSE_QUARTZ = material("rose_quartz");

    private static  DataResource<Material> material(String name) {
        return DataResource.material(getId(name));
    }
}
