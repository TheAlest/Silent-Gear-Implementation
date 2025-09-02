package net.thealest.silentaddons.constants;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.neoforged.fml.ModList;

import java.util.HashMap;
import java.util.Map;

import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.*;
import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.BLOOD_MAGIC;
import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.ENDER_MAGIC;
import static io.redspace.ironsspellbooks.damage.ISSDamageTypes.HOLY_MAGIC;
import static net.minecraft.tags.EntityTypeTags.*;
import static net.minecraft.tags.EntityTypeTags.AQUATIC;
import static net.minecraft.tags.EntityTypeTags.SKELETONS;
import static net.thealest.silentaddons.ModsUtils.ModsReference.CreeperOverhaul;
import static net.thealest.silentaddons.SilentAddons.getId;

public final class Damages {

    public static final ResourceKey<DamageType> FROST_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, getId("frost"));

    public static final Map<ResourceKey<DamageType>, Map<TagKey<EntityType<?>>, Float>> DAMAGE_MULTS;

    static {
        Map<ResourceKey<DamageType>, Map<TagKey<EntityType<?>>, Float>> outer = new HashMap<>();

        Map<TagKey<EntityType<?>>, Float> ice = new HashMap<>();
        ice.put(UNDEAD, 0.0f);
        ice.put(AQUATIC, 0.5f);
        ice.put(Tags.ICE_RESISTANT, 2.0f / 3.0f);
        ice.put(Tags.ICE_WEAK, 1.5f);
        ice.put(Tags.NETHERBORN, 2.0f);

        if (ModList.get().isLoaded("creeperoverhaul")) {
            ice.put(TagKey.create(Registries.ENTITY_TYPE, CreeperOverhaul("creepers")), 2.0f / 3.0f);
        }

        outer.put(ICE_MAGIC, ice);

        Map<TagKey<EntityType<?>>, Float> fire = new HashMap<>();
        fire.put(AQUATIC, 0.5f);
        fire.put(ARTHROPOD, 1.75f);
        fire.put(Tags.NETHERBORN, 0.0f);
        fire.put(Tags.FIRE_RESISTANT, 2.0f / 3.0f);
        fire.put(Tags.FIRE_WEAK, 1.5f);
        fire.put(Tags.ANIMALS, 1.25f);

        if (ModList.get().isLoaded("creeperoverhaul")) {
            fire.put(TagKey.create(Registries.ENTITY_TYPE, CreeperOverhaul("creepers")), 1.5f);
        }

        outer.put(FIRE_MAGIC, fire);

        Map<TagKey<EntityType<?>>, Float> lightning = new HashMap<>();
        lightning.put(AQUATIC, 2.0f);
        lightning.put(Tags.LIGHTNING_RESISTANT, (2.0f / 3.0f));
        lightning.put(Tags.LIGHTNING_WEAK, 1.5f);

        outer.put(LIGHTNING_MAGIC, lightning);

        Map<TagKey<EntityType<?>>, Float> blood = new HashMap<>();
        blood.put(SKELETONS, 0.0f);
        blood.put(Tags.BLOOD_RESISTANT, (2.0f / 3.0f));
        blood.put(Tags.BLOOD_WEAK, 1.5f);
        blood.put(Tags.SLIMES, 0.5f);

        outer.put(BLOOD_MAGIC, blood);

        Map<TagKey<EntityType<?>>, Float> holy = new HashMap<>();
        holy.put(Tags.HOLY_RESISTANT, (2.0f / 3.0f));
        holy.put(Tags.HOLY_WEAK, 1.5f);
        holy.put(Tags.ANIMALS, 0.75f);

        outer.put(HOLY_MAGIC, holy);

        Map<TagKey<EntityType<?>>, Float> ender = new HashMap<>();
        ender.put(Tags.ENDER_RESISTANT, (2.0f / 3.0f));
        ender.put(Tags.ENDER_WEAK, 1.5f);
        ender.put(Tags.ENDERBORN, 0.0f);

        outer.put(ENDER_MAGIC, ender);

        DAMAGE_MULTS = Map.copyOf(outer);

    };

    private Damages() {
    }
}
