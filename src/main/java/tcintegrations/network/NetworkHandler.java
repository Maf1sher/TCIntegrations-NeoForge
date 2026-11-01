package tcintegrations.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import tcintegrations.TCIntegrations;
import tcintegrations.util.ArsElementalClientHelper;

@EventBusSubscriber(modid = TCIntegrations.MODID, bus = EventBusSubscriber.Bus.MOD)
public class NetworkHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar reg = event.registrar("1");
        reg.playToClient(
            ArsElementalSetData.TYPE,
            ArsElementalSetData.STREAM_CODEC,
            (data, context) -> context.enqueueWork(() -> ArsElementalClientHelper.apply(data))
        );
    }

}
