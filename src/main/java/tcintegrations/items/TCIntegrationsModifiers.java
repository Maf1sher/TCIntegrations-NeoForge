package tcintegrations.items;

import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import tcintegrations.common.TCIntegrationsModule;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.items.modifiers.armor.BisonFurModifier;
import tcintegrations.items.modifiers.armor.CrocodileModifier;
import tcintegrations.items.modifiers.armor.EngineersGogglesModifier;
import tcintegrations.items.modifiers.armor.FrontierCapModifier;
import tcintegrations.items.modifiers.armor.MasticateModifier;
import tcintegrations.items.modifiers.armor.MosquitoModifier;
import tcintegrations.items.modifiers.armor.PoseidonModifier;
import tcintegrations.items.modifiers.armor.RoadrunnerModifier;
import tcintegrations.items.modifiers.armor.SculkingModifier;
import tcintegrations.items.modifiers.armor.ShieldOfTheDeepModifier;
import tcintegrations.items.modifiers.armor.TurtleShellModifier;
import tcintegrations.items.modifiers.tool.ForgottenModifier;
import tcintegrations.items.modifiers.tool.MechanicalArmModifier;
import tcintegrations.items.modifiers.tool.FroststeelModifier;
import tcintegrations.items.modifiers.tool.ModerateModifier;
import tcintegrations.items.modifiers.tool.PrecipitateModifier;
import tcintegrations.items.modifiers.tool.SirenModifier;
import tcintegrations.items.modifiers.tool.TwilitModifier;
import tcintegrations.items.modifiers.tool.UtheriumModifier;
import tcintegrations.items.modifiers.tool.GlowUpModifier;
import tcintegrations.items.modifiers.traits.KineticModifier;
import tcintegrations.items.modifiers.traits.WaterPowered;

public class TCIntegrationsModifiers extends TCIntegrationsModule {

    public static StaticModifier<ModerateModifier> MODERATE_MODIFIER;
    public static StaticModifier<MechanicalArmModifier> MECHANICAL_ARM_MODIFIER;
    public static StaticModifier<RoadrunnerModifier> ROADRUNNER_MODIFIER;
    public static StaticModifier<FrontierCapModifier> FRONTIER_CAP_MODIFIER;
    public static StaticModifier<TurtleShellModifier> TURTLE_SHELL_MODIFIER;
    public static StaticModifier<BisonFurModifier> BISON_FUR_MODIFIER;
    public static StaticModifier<ShieldOfTheDeepModifier> SHIELD_OF_THE_DEEP_MODIFIER;
    public static StaticModifier<MosquitoModifier> MOSQUITO_MODIFIER;
    public static StaticModifier<CrocodileModifier> CROCODILE_MODIFIER;
    public static StaticModifier<KineticModifier> KINETIC_MODIFIER;
    public static StaticModifier<GlowUpModifier> GLOWUP_MODIFIER;
    public static StaticModifier<WaterPowered> WATER_POWERED_MODIFIER;
    public static StaticModifier<PoseidonModifier> POSEIDON_MODIFIER;
    public static StaticModifier<SirenModifier> SIREN_MODIFIER;
    public static StaticModifier<MasticateModifier> MASTICATE_MODIFIER;
    public static StaticModifier<UtheriumModifier> UTHERIUM_MODIFIER;
    public static StaticModifier<FroststeelModifier> FROSTSTEEL_MODIFIER;
    public static StaticModifier<ForgottenModifier> FORGOTTEN_MODIFIER;
    public static StaticModifier<PrecipitateModifier> PRECIPITATE_MODIFIER;
    public static StaticModifier<TwilitModifier> TWILIT_MODIFIER;
    public static StaticModifier<SculkingModifier> SCULKING_MODIFIER;

    public static void init() {
        MODERATE_MODIFIER = MODIFIERS_REGISTRY.register("moderate", ModerateModifier::new);

        if (ModIntegration.canLoad(ModIntegration.CREATE_MODID)) {
            MECHANICAL_ARM_MODIFIER = MODIFIERS_REGISTRY.register("mechanical_arm", MechanicalArmModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.MEKANISM_MODID)) {
            KINETIC_MODIFIER = MODIFIERS_REGISTRY.register("kinetic", KineticModifier::new);
            GLOWUP_MODIFIER = MODIFIERS_REGISTRY.register("glowup", GlowUpModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.ALEX_MODID)) {
            ROADRUNNER_MODIFIER = MODIFIERS_REGISTRY.register("roadrunner", RoadrunnerModifier::new);
            FRONTIER_CAP_MODIFIER = MODIFIERS_REGISTRY.register("frontier_cap", FrontierCapModifier::new);
            TURTLE_SHELL_MODIFIER = MODIFIERS_REGISTRY.register("turtle_shell", TurtleShellModifier::new);
            BISON_FUR_MODIFIER = MODIFIERS_REGISTRY.register("bison_fur", BisonFurModifier::new);
            SHIELD_OF_THE_DEEP_MODIFIER = MODIFIERS_REGISTRY.register("shield_of_the_deep", ShieldOfTheDeepModifier::new);
            MOSQUITO_MODIFIER = MODIFIERS_REGISTRY.register("mosquito", MosquitoModifier::new);
            CROCODILE_MODIFIER = MODIFIERS_REGISTRY.register("crocodile", CrocodileModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.AQUACULTURE_MODID)) {
            WATER_POWERED_MODIFIER = MODIFIERS_REGISTRY.register("water_powered", WaterPowered::new);
            POSEIDON_MODIFIER = MODIFIERS_REGISTRY.register("poseidon", PoseidonModifier::new);
            SIREN_MODIFIER = MODIFIERS_REGISTRY.register("siren", SirenModifier::new);
        }

        if (ModIntegration.canLoad(ModIntegration.UNDERGARDEN_MODID)) {
            MASTICATE_MODIFIER = MODIFIERS_REGISTRY.register("masticate", MasticateModifier::new);
            UTHERIUM_MODIFIER = MODIFIERS_REGISTRY.register("utherium", UtheriumModifier::new);
            FROSTSTEEL_MODIFIER = MODIFIERS_REGISTRY.register("froststeel", FroststeelModifier::new);
            FORGOTTEN_MODIFIER = MODIFIERS_REGISTRY.register("forgotten", ForgottenModifier::new);
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
