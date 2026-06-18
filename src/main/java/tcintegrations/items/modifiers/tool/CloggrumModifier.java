package tcintegrations.items.modifiers.tool;

import net.minecraft.world.damagesource.DamageTypes;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;

import slimeknights.tconstruct.tools.modules.armor.ThornsModule;

public class CloggrumModifier extends Modifier {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addModule(ThornsModule.type(DamageTypes.THORNS).constantFlat(2).randomFlat(3).build());
    }

}
