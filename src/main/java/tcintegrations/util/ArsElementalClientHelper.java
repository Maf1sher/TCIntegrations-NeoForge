package tcintegrations.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import tcintegrations.common.attachments.TCIntegrationAttachments;

public class ArsElementalClientHelper {

    public static boolean hasAirArmorSet() {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get())) {
            return player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get()).hasAir();
        }
        return false;
    }

    public static boolean hasAquaArmorSet() {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get())) {
            return player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get()).hasAqua();
        }
        return false;
    }

    public static boolean hasEarthArmorSet() {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get())) {
            return player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get()).hasEarth();
        }
        return false;
    }

    public static boolean hasFireArmorSet() {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get())) {
            return player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get()).hasFire();
        }
        return false;
    }

}
