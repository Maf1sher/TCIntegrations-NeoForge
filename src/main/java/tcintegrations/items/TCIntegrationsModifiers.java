package tcintegrations.items;

import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import tcintegrations.common.TCIntegrationsModule;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.items.modifiers.armor.PoseidonModifier;
import tcintegrations.items.modifiers.armor.SculkingModifier;
import tcintegrations.items.modifiers.tool.ModerateModifier;
import tcintegrations.items.modifiers.tool.PrecipitateModifier;
import tcintegrations.items.modifiers.tool.SirenModifier;
import tcintegrations.items.modifiers.tool.TwilitModifier;
import tcintegrations.items.modifiers.traits.WaterPowered;

public class TCIntegrationsModifiers extends TCIntegrationsModule {

    public static StaticModifier<ModerateModifier> MODERATE_MODIFIER;
    public static StaticModifier<WaterPowered> WATER_POWERED_MODIFIER;
    public static StaticModifier<PoseidonModifier> POSEIDON_MODIFIER;
    public static StaticModifier<SirenModifier> SIREN_MODIFIER;
    public static StaticModifier<PrecipitateModifier> PRECIPITATE_MODIFIER;
    public static StaticModifier<TwilitModifier> TWILIT_MODIFIER;
    public static StaticModifier<SculkingModifier> SCULKING_MODIFIER;

    public static void init() {
        MODERATE_MODIFIER = MODIFIERS_REGISTRY.register("moderate", ModerateModifier::new);

        if (ModIntegration.canLoad(ModIntegration.AQUACULTURE_MODID)) {
            WATER_POWERED_MODIFIER = MODIFIERS_REGISTRY.register("water_powered", WaterPowered::new);
            POSEIDON_MODIFIER = MODIFIERS_REGISTRY.register("poseidon", PoseidonModifier::new);
            SIREN_MODIFIER = MODIFIERS_REGISTRY.register("siren", SirenModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.DEEPERDARKER_MODID)) {
            SCULKING_MODIFIER = MODIFIERS_REGISTRY.register("sculking", SculkingModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.TWILIGHT_MODID)) {
            PRECIPITATE_MODIFIER = MODIFIERS_REGISTRY.register("precipitate", PrecipitateModifier::new);
            TWILIT_MODIFIER = MODIFIERS_REGISTRY.register("twilit", TwilitModifier::new);
        }
    }

}
