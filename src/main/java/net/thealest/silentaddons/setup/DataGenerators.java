package net.thealest.silentaddons.setup;

import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.thealest.silentaddons.data.AddonsEntityTags;
import net.thealest.silentaddons.data.AddonsMaterials;
import net.thealest.silentaddons.data.AddonsTraits;

import static net.thealest.silentaddons.SilentAddons.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public final class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        generator.addProvider(true, new AddonsTraits(generator));
        generator.addProvider(true, new AddonsEntityTags(output, event.getLookupProvider(), MOD_ID, event.getExistingFileHelper()));
        generator.addProvider(true, new AddonsMaterials(generator, MOD_ID));
    }
}

