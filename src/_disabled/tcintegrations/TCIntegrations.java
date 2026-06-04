package tcintegrations;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tcintegrations.common.TCIntegrationsModule;

@Mod(TCIntegrations.MODID)
public class TCIntegrations {

    public static final String MODID = "tcintegrations";
    public static final Logger LOGGER = LogManager.getFormatterLogger(TCIntegrations.MODID);

    public static IEventBus BUS;

    public TCIntegrations(IEventBus modEventBus) {
        BUS = modEventBus;
        TCIntegrationsModule.initRegistries(BUS);
    }

}
