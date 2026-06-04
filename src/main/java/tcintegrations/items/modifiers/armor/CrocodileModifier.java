package tcintegrations.items.modifiers.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import net.neoforged.neoforge.common.NeoForgeMod;

import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static tcintegrations.util.ResourceLocationHelper.resource;

public class CrocodileModifier extends NoLevelsModifier implements EquipmentChangeModifierHook {

    private static final ResourceLocation SWIM_SPEED_MODIFIER_ID = resource("crocodile_swim_speed");
    private static final ResourceLocation ARMOR_MODIFIER_ID = resource("crocodile_armor");
    private static final ResourceLocation ARMOR_TOUGHNESS_MODIFIER_ID = resource("crocodile_armor_toughness");

    private static final AttributeModifier INCREASED_SWIM_SPEED = new AttributeModifier(
        SWIM_SPEED_MODIFIER_ID,
        1,
        AttributeModifier.Operation.ADD_VALUE
    );
    private static final AttributeModifier INCREASED_ARMOR = new AttributeModifier(
        ARMOR_MODIFIER_ID,
        7,
        AttributeModifier.Operation.ADD_VALUE
    );
    private static final AttributeModifier INCREASED_ARMOR_TOUGHNESS = new AttributeModifier(
        ARMOR_TOUGHNESS_MODIFIER_ID,
        1,
        AttributeModifier.Operation.ADD_VALUE
    );

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.EQUIPMENT_CHANGE);
    }

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;

            if (context.getChangedSlot() == EquipmentSlot.CHEST) {
                AttributeInstance swimSpeed = sp.getAttribute(NeoForgeMod.SWIM_SPEED);
                if (swimSpeed != null && !swimSpeed.hasModifier(SWIM_SPEED_MODIFIER_ID)) {
                    swimSpeed.addPermanentModifier(INCREASED_SWIM_SPEED);
                }

                AttributeInstance armor = sp.getAttribute(Attributes.ARMOR);
                if (armor != null && !armor.hasModifier(ARMOR_MODIFIER_ID)) {
                    armor.addPermanentModifier(INCREASED_ARMOR);
                }

                AttributeInstance toughness = sp.getAttribute(Attributes.ARMOR_TOUGHNESS);
                if (toughness != null && !toughness.hasModifier(ARMOR_TOUGHNESS_MODIFIER_ID)) {
                    toughness.addPermanentModifier(INCREASED_ARMOR_TOUGHNESS);
                }
            }
        }
    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;

            if (context.getChangedSlot() == EquipmentSlot.CHEST) {
                AttributeInstance swimSpeed = sp.getAttribute(NeoForgeMod.SWIM_SPEED);
                if (swimSpeed != null && swimSpeed.hasModifier(SWIM_SPEED_MODIFIER_ID)) {
                    swimSpeed.removeModifier(SWIM_SPEED_MODIFIER_ID);
                }

                AttributeInstance armor = sp.getAttribute(Attributes.ARMOR);
                if (armor != null && armor.hasModifier(ARMOR_MODIFIER_ID)) {
                    armor.removeModifier(ARMOR_MODIFIER_ID);
                }

                AttributeInstance toughness = sp.getAttribute(Attributes.ARMOR_TOUGHNESS);
                if (toughness != null && toughness.hasModifier(ARMOR_TOUGHNESS_MODIFIER_ID)) {
                    toughness.removeModifier(ARMOR_TOUGHNESS_MODIFIER_ID);
                }
            }
        }
    }

}
