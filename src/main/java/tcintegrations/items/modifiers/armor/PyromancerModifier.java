package tcintegrations.items.modifiers.armor;

import net.minecraft.world.entity.player.Player;

import slimeknights.tconstruct.library.modifiers.ModifierId;

import tcintegrations.common.attachments.ArsElementalSet;
import tcintegrations.items.TCIntegrationsModifiers;
import tcintegrations.util.ArsElementalClientHelper;
import tcintegrations.util.ArsElementalHelper;

public class PyromancerModifier extends ArsElementalSetBase {

    @Override
    public boolean hasArmorSet() {
        return ArsElementalClientHelper.hasFireArmorSet();
    }

    @Override
    public void setHasSet(ArsElementalSet data, boolean hasSet) {
        data.setFire(hasSet);
    }

    @Override
    public ModifierId getModifierId() {
        return new ModifierId(TCIntegrationsModifiers.PYROMANCER_MODIFIER.getId());
    }

    @Override
    public boolean hasArmorSet(Player player) {
        return ArsElementalHelper.hasFireArmorSet(player);
    }

}
