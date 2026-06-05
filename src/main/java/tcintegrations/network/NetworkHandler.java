package tcintegrations.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import tcintegrations.TCIntegrations;

@EventBusSubscriber(modid = TCIntegrations.MODID, bus = EventBusSubscriber.Bus.MOD)
public class NetworkHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar reg = event.registrar("1");
        reg.playToClient(
            ArsElementalSetData.TYPE,
            ArsElementalSetData.STREAM_CODEC,
            (data, context) -> {
                // Client-side handling will be added when porting client helpers
            }
        );
    }

}
