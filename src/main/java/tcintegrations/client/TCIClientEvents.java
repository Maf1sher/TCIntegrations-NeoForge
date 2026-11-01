package tcintegrations.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import slimeknights.mantle.fluid.texture.ClientTextureFluidType;

import tcintegrations.TCIntegrations;

/** Client-only setup for the add-on content. */
@EventBusSubscriber(modid = TCIntegrations.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class TCIClientEvents {

    private TCIClientEvents() {}

    /**
     * Registers the data-driven fluid textures for every TCI fluid type.
     * Without this the vanilla extension applies, whose still texture is null.
     */
    @SubscribeEvent
    static void registerFluidExtensions(RegisterClientExtensionsEvent event) {
        for (var entry : NeoForgeRegistries.FLUID_TYPES.entrySet()) {
            if (entry.getKey().location().getNamespace().equals(TCIntegrations.MODID)) {
                event.registerFluidType(new ClientTextureFluidType(entry.getValue()), entry.getValue());
            }
        }
    }

}
