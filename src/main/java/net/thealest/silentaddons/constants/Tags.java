package net.thealest.silentaddons.constants;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import static net.thealest.silentaddons.SilentAddons.MOD_ID;

public final class Tags {
        public static final TagKey<EntityType<?>> ICE_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"ice_resistant"));

        public static final TagKey<EntityType<?>> ICE_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"ice_weak"));

        public static final TagKey<EntityType<?>> FIRE_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"fire_resistant"));

        public static final TagKey<EntityType<?>> FIRE_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"fire_weak"));

        public static final TagKey<EntityType<?>> LIGHTNING_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"lightning_resistant"));

        public static final TagKey<EntityType<?>> LIGHTNING_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"lightning_weak"));

        public static final TagKey<EntityType<?>> BLOOD_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"blood_resistant"));

        public static final TagKey<EntityType<?>> BLOOD_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"blood_weak"));

        public static final TagKey<EntityType<?>> HOLY_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"holy_resistant"));

        public static final TagKey<EntityType<?>> HOLY_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"holy_weak"));

        public static final TagKey<EntityType<?>> ENDER_RESISTANT = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"ender_resistant"));

        public static final TagKey<EntityType<?>> ENDER_WEAK = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"ender_weak"));

        public static final TagKey<EntityType<?>> ANIMALS = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"animals"));

        public static final TagKey<EntityType<?>> NETHERBORN = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"netherborne"));

        public static final TagKey<EntityType<?>> ENDERBORN = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"enderborn"));

        public static final TagKey<EntityType<?>> SLIMES = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"slimes"));

        public static final TagKey<EntityType<?>> FLYINGS = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"flyings"));

        public static final TagKey<EntityType<?>> WITCHS = TagKey.create(
                Registries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MOD_ID,"witchs"));

    private Tags() {}
}
