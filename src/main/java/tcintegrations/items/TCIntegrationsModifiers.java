package tcintegrations.items;

import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import tcintegrations.common.TCIntegrationsModule;
import tcintegrations.items.modifiers.tool.ModerateModifier;

public class TCIntegrationsModifiers extends TCIntegrationsModule {

    public static StaticModifier<ModerateModifier> MODERATE_MODIFIER;

    public static void init() {
        MODERATE_MODIFIER = MODIFIERS_REGISTRY.register("moderate", ModerateModifier::new);
    }

}
