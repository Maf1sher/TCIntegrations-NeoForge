package tcintegrations.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

import tcintegrations.common.attachments.ArsElementalSet;
import tcintegrations.common.attachments.TCIntegrationAttachments;
import tcintegrations.network.ArsElementalSetData;

/** Client-side set lookups and payload handling, safe to reference from common code. */
public class ArsElementalClientHelper {

    /** Writes the synced set flags into the client player's attachment. */
    public static void apply(ArsElementalSetData data) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientOnly.apply(data);
        }
    }

    public static boolean hasAirArmorSet() {
        return FMLEnvironment.dist == Dist.CLIENT && ClientOnly.hasAirArmorSet();
    }

    public static boolean hasAquaArmorSet() {
        return FMLEnvironment.dist == Dist.CLIENT && ClientOnly.hasAquaArmorSet();
    }

    public static boolean hasEarthArmorSet() {
        return FMLEnvironment.dist == Dist.CLIENT && ClientOnly.hasEarthArmorSet();
    }

    public static boolean hasFireArmorSet() {
        return FMLEnvironment.dist == Dist.CLIENT && ClientOnly.hasFireArmorSet();
    }

    /** This class is only ever loaded client side. */
    private static class ClientOnly {

        private static void apply(ArsElementalSetData data) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                ArsElementalSet set = player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get());
                set.setAir(data.hasAir());
                set.setAqua(data.hasAqua());
                set.setEarth(data.hasEarth());
                set.setFire(data.hasFire());
            }
        }

        private static boolean hasArmorSet(java.util.function.Predicate<ArsElementalSet> flag) {
            Player player = Minecraft.getInstance().player;
            return player != null
                && player.hasData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get())
                && flag.test(player.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get()));
        }

        private static boolean hasAirArmorSet() {
            return hasArmorSet(ArsElementalSet::hasAir);
        }

        private static boolean hasAquaArmorSet() {
            return hasArmorSet(ArsElementalSet::hasAqua);
        }

        private static boolean hasEarthArmorSet() {
            return hasArmorSet(ArsElementalSet::hasEarth);
        }

        private static boolean hasFireArmorSet() {
            return hasArmorSet(ArsElementalSet::hasFire);
        }
    }
}
