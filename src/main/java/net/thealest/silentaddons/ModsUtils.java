package net.thealest.silentaddons;

import net.minecraft.resources.ResourceLocation;

public class ModsUtils {
    public static final class ModsReference {
        public static ResourceLocation EnderZoology (String entityname) {
            return ResourceLocation.fromNamespaceAndPath("enderzoology", entityname);
        }
        public static ResourceLocation EndermanOverhaul (String entityname) {
            return ResourceLocation.fromNamespaceAndPath("endermanoverhaul", entityname);
        }
        public static ResourceLocation CreeperOverhaul (String entityname) {
            return ResourceLocation.fromNamespaceAndPath("creeperoverhaul", entityname);
        }

        public static ResourceLocation LuminousWorld (String entityname) {
            return ResourceLocation.fromNamespaceAndPath("luminousworld", entityname);
        }

        public static ResourceLocation LuminousNether (String entityname) {
            return ResourceLocation.fromNamespaceAndPath("luminous_nether", entityname);
        }
    }


}
