package tcintegrations.util;

import net.neoforged.fml.ModList;

import tcintegrations.data.integration.ModIntegration;

public class IfdWorkaroundHelper {

    /*
     * This class is necessary since the Community Edition breaks the API of IFD, but doesn't bother to change the modid.
     */

    public static boolean isLoaded() {
        if (ModList.get().isLoaded(ModIntegration.IFD_MODID)) {
            try {
                Class.forName("com.iafenvoy.iceandfire.IceAndFire");

                return true;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }

        return false;
    }

}
