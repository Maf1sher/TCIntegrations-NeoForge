package tcintegrations.items.modifiers.armor;

import net.minecraft.world.entity.player.Player;

import slimeknights.tconstruct.library.modifiers.ModifierId;

import tcintegrations.common.attachments.ArsElementalSet;
import tcintegrations.data.tcon.material.TciModifierIds;
import tcintegrations.items.TCIntegrationsModifiers;
import tcintegrations.util.ArsElementalClientHelper;
import tcintegrations.util.ArsElementalHelper;

public class AethermancerModifier extends ArsElementalSetBase {

    @Override
    public boolean hasArmorSet() {
        return ArsElementalClientHelper.hasAirArmorSet();
    }

    @Override
    public void setHasSet(ArsElementalSet data, boolean hasSet) {
        data.setAir(hasSet);
    }

    @Override
    public ModifierId getModifierId() {
        return TciModifierIds.aethermancer;
    }

    @Override
    public boolean hasArmorSet(Player player) {
        return ArsElementalHelper.hasAirArmorSet(player);
    }

}
