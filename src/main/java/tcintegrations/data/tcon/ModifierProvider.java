package tcintegrations.data.tcon;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.modules.behavior.RepairModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;

import tcintegrations.data.integration.ModIntegration;
import tcintegrations.data.tcon.material.TciModifierIds;
import tcintegrations.items.modifiers.armor.EngineersGogglesModifier;
import tcintegrations.items.modifiers.armor.MultiVisionModifier;

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
        // engineers_goggles: ModifierModule, needs data-driven singleton
        buildModifier(TciModifierIds.engineersGoggles, modLoaded(ModIntegration.CREATE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .addModule(EngineersGogglesModifier.INSTANCE);

        // multivision: ModifierModule, needs data-driven singleton
        buildModifier(TciModifierIds.multiVision, modLoaded(ModIntegration.IE_MODID))
            .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
            .addModule(MultiVisionModifier.INSTANCE);
    }

}
