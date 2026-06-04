package tcintegrations.items.modifiers.traits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;

import com.sammy.malum.registry.common.MalumAttributes;

import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static tcintegrations.util.ResourceLocationHelper.resource;

public class SoulStained extends NoLevelsModifier implements EquipmentChangeModifierHook {

    private static final ResourceLocation SW_CAP_HELMET_ID = resource("soul_stained_helmet_sw_cap");
    private static final ResourceLocation SW_CAP_CHESTPLATE_ID = resource("soul_stained_chestplate_sw_cap");
    private static final ResourceLocation SW_CAP_LEGGINGS_ID = resource("soul_stained_leggings_sw_cap");
    private static final ResourceLocation SW_CAP_BOOTS_ID = resource("soul_stained_boots_sw_cap");
    private static final ResourceLocation SW_REC_HELMET_ID = resource("soul_stained_helmet_sw_rec");
    private static final ResourceLocation SW_REC_CHESTPLATE_ID = resource("soul_stained_chestplate_sw_rec");
    private static final ResourceLocation SW_REC_LEGGINGS_ID = resource("soul_stained_leggings_sw_rec");
    private static final ResourceLocation SW_REC_BOOTS_ID = resource("soul_stained_boots_sw_rec");

    private static final AttributeModifier HELMET_SW_CAP = new AttributeModifier(SW_CAP_HELMET_ID, 6, Operation.ADD_VALUE);
    private static final AttributeModifier CHESTPLATE_SW_CAP = new AttributeModifier(SW_CAP_CHESTPLATE_ID, 8, Operation.ADD_VALUE);
    private static final AttributeModifier LEGGINGS_SW_CAP = new AttributeModifier(SW_CAP_LEGGINGS_ID, 6, Operation.ADD_VALUE);
    private static final AttributeModifier BOOTS_SW_CAP = new AttributeModifier(SW_CAP_BOOTS_ID, 4, Operation.ADD_VALUE);
    private static final AttributeModifier HELMET_SW_REC = new AttributeModifier(SW_REC_HELMET_ID, 2, Operation.ADD_VALUE);
    private static final AttributeModifier CHESTPLATE_SW_REC = new AttributeModifier(SW_REC_CHESTPLATE_ID, 3, Operation.ADD_VALUE);
    private static final AttributeModifier LEGGINGS_SW_REC = new AttributeModifier(SW_REC_LEGGINGS_ID, 2, Operation.ADD_VALUE);
    private static final AttributeModifier BOOTS_SW_REC = new AttributeModifier(SW_REC_BOOTS_ID, 2, Operation.ADD_VALUE);

    @Override
    protected void registerHooks(Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.EQUIPMENT_CHANGE);
    }

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;
            AttributeInstance capAttr = sp.getAttribute(MalumAttributes.SOUL_WARD_CAPACITY);
            AttributeInstance recAttr = sp.getAttribute(MalumAttributes.SOUL_WARD_RECOVERY_RATE);

            if (capAttr == null || recAttr == null) return;

            EquipmentSlot slot = context.getChangedSlot();

            switch (slot) {
                case HEAD -> {
                    if (!capAttr.hasModifier(SW_CAP_HELMET_ID)) capAttr.addTransientModifier(HELMET_SW_CAP);
                    if (!recAttr.hasModifier(SW_REC_HELMET_ID)) recAttr.addTransientModifier(HELMET_SW_REC);
                }
                case CHEST -> {
                    if (!capAttr.hasModifier(SW_CAP_CHESTPLATE_ID)) capAttr.addTransientModifier(CHESTPLATE_SW_CAP);
                    if (!recAttr.hasModifier(SW_REC_CHESTPLATE_ID)) recAttr.addTransientModifier(CHESTPLATE_SW_REC);
                }
                case LEGS -> {
                    if (!capAttr.hasModifier(SW_CAP_LEGGINGS_ID)) capAttr.addTransientModifier(LEGGINGS_SW_CAP);
                    if (!recAttr.hasModifier(SW_REC_LEGGINGS_ID)) recAttr.addTransientModifier(LEGGINGS_SW_REC);
                }
                case FEET -> {
                    if (!capAttr.hasModifier(SW_CAP_BOOTS_ID)) capAttr.addTransientModifier(BOOTS_SW_CAP);
                    if (!recAttr.hasModifier(SW_REC_BOOTS_ID)) recAttr.addTransientModifier(BOOTS_SW_REC);
                }
            }
        }
    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;
            AttributeInstance capAttr = sp.getAttribute(MalumAttributes.SOUL_WARD_CAPACITY);
            AttributeInstance recAttr = sp.getAttribute(MalumAttributes.SOUL_WARD_RECOVERY_RATE);

            if (capAttr == null || recAttr == null) return;

            EquipmentSlot slot = context.getChangedSlot();

            switch (slot) {
                case HEAD -> {
                    capAttr.removeModifier(SW_CAP_HELMET_ID);
                    recAttr.removeModifier(SW_REC_HELMET_ID);
                }
                case CHEST -> {
                    capAttr.removeModifier(SW_CAP_CHESTPLATE_ID);
                    recAttr.removeModifier(SW_REC_CHESTPLATE_ID);
                }
                case LEGS -> {
                    capAttr.removeModifier(SW_CAP_LEGGINGS_ID);
                    recAttr.removeModifier(SW_REC_LEGGINGS_ID);
                }
                case FEET -> {
                    capAttr.removeModifier(SW_CAP_BOOTS_ID);
                    recAttr.removeModifier(SW_REC_BOOTS_ID);
                }
            }
        }
    }

}
