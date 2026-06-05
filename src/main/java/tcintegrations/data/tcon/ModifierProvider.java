package tcintegrations.data.tcon;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier.TooltipDisplay;

import tcintegrations.data.integration.ModIntegration;
import tcintegrations.data.tcon.material.TciModifierIds;
import tcintegrations.items.TCIntegrationsModifiers;

public class ModifierProvider extends AbstractModifierProvider implements IConditionBuilder {

    public ModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Modifiers";
    }

    @Override
    protected void addModifiers() {
        // Unconditional modifiers
        buildModifier(TciModifierIds.moderate).tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.livingwood);

        // Create
        buildModifier(TciModifierIds.engineersGoggles, modLoaded(ModIntegration.CREATE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS);
        buildModifier(TciModifierIds.mechanicalArm, modLoaded(ModIntegration.CREATE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Mekanism
        buildModifier(TciModifierIds.kinetic, modLoaded(ModIntegration.MEKANISM_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.glowup, modLoaded(ModIntegration.MEKANISM_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Ice and Fire
        buildModifier(TciModifierIds.flamed, modLoaded(ModIntegration.IFD_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.iced, modLoaded(ModIntegration.IFD_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.zapped, modLoaded(ModIntegration.IFD_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.phantasmal, modLoaded(ModIntegration.IFD_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.dragonScales, modLoaded(ModIntegration.IFD_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Alex's Mobs
        buildModifier(TciModifierIds.roadrunner, modLoaded(ModIntegration.ALEX_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.frontierCap, modLoaded(ModIntegration.ALEX_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.turtleShell, modLoaded(ModIntegration.ALEX_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.bisonFur, modLoaded(ModIntegration.ALEX_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.shieldOfTheDeep, modLoaded(ModIntegration.ALEX_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.mosquito, modLoaded(ModIntegration.ALEX_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.crocodile, modLoaded(ModIntegration.ALEX_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Apotheosis
        buildModifier(TciModifierIds.capturing, modLoaded(ModIntegration.APOTH_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Ars Nouveau
        if (TCIntegrationsModifiers.ARS_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.ARS_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_MODID))
                .levelDisplay(new ModifierLevelDisplay.UniqueForLevels(3));
        if (TCIntegrationsModifiers.ENCHANTERS_SHIELD_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.ENCHANTERS_SHIELD_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_MODID))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        if (TCIntegrationsModifiers.AETHERMANCER_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.AETHERMANCER_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_ELEMENTAL_MODID))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        if (TCIntegrationsModifiers.AQUAMANCER_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.AQUAMANCER_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_ELEMENTAL_MODID))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        if (TCIntegrationsModifiers.GEOMANCER_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.GEOMANCER_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_ELEMENTAL_MODID))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        if (TCIntegrationsModifiers.PYROMANCER_MODIFIER != null)
            buildModifier(TCIntegrationsModifiers.PYROMANCER_MODIFIER.getModifierId(), modLoaded(ModIntegration.ARS_ELEMENTAL_MODID))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Malum
        buildModifier(TciModifierIds.soulStained, modLoaded(ModIntegration.MALUM_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Aquaculture
        buildModifier(TciModifierIds.waterPowered, modLoaded(ModIntegration.AQUACULTURE_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.poseidon, modLoaded(ModIntegration.AQUACULTURE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.siren, modLoaded(ModIntegration.AQUACULTURE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Undergarden
        buildModifier(TciModifierIds.masticate, modLoaded(ModIntegration.UNDERGARDEN_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.utherium, modLoaded(ModIntegration.UNDERGARDEN_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.froststeelTrait, modLoaded(ModIntegration.UNDERGARDEN_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.forgottenTrait, modLoaded(ModIntegration.UNDERGARDEN_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Deeper and Darker
        buildModifier(TciModifierIds.sculking, modLoaded(ModIntegration.DEEPERDARKER_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // Twilight Forest
        buildModifier(TciModifierIds.precipitate, modLoaded(ModIntegration.TWILIGHT_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);
        buildModifier(TciModifierIds.twilit, modLoaded(ModIntegration.TWILIGHT_MODID))
            .tooltipDisplay(TooltipDisplay.TINKER_STATION);

        // IE
        buildModifier(TciModifierIds.multiVision, modLoaded(ModIntegration.IE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS);
    }

}
