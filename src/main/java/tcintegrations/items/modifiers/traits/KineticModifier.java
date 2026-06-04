package tcintegrations.items.modifiers.traits;

import org.jetbrains.annotations.Nullable;

import mekanism.api.Action;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.common.integration.energy.EnergyCompatUtils;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class KineticModifier extends NoLevelsModifier implements MeleeHitModifierHook, BlockBreakModifierHook {

    @Override
    protected void registerHooks(Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public void failedMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageAttempted) {
        final ServerPlayer sp = (ServerPlayer) context.getPlayerAttacker();

        if (sp != null) {
            chargeInventoryItem(sp);
        }
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        final ServerPlayer sp = (ServerPlayer) context.getPlayerAttacker();

        if (sp != null) {
            chargeInventoryItem(sp);
        }
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        final ServerPlayer sp = context.getPlayer();

        if (sp != null && !sp.level().isClientSide) {
            chargeInventoryItem(sp);
        }
    }

    private void chargeInventoryItem(ServerPlayer sp) {
        for (int slot = 0; slot < sp.getInventory().getContainerSize(); slot++) {
            ItemStack stack = sp.getInventory().getItem(slot);

            if (!stack.isEmpty() && provideEnergy(EnergyCompatUtils.getStrictEnergyHandler(stack))) {
                return;
            }
        }
    }

    private boolean provideEnergy(@Nullable IStrictEnergyHandler energyHandler) {
        if (energyHandler == null) return false;

        long energyToGive = 20;

        energyHandler.insertEnergy(energyToGive, Action.EXECUTE);

        return true;
    }

}
