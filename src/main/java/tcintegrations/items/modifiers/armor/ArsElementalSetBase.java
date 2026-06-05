package tcintegrations.items.modifiers.armor;

import com.hollingsworth.arsnouveau.setup.registry.EnchantmentRegistry;
import com.hollingsworth.arsnouveau.setup.registry.ModPotions;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import net.neoforged.neoforge.network.PacketDistributor;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.ModifyDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import tcintegrations.common.attachments.ArsElementalSet;
import tcintegrations.common.attachments.TCIntegrationAttachments;
import tcintegrations.items.TCIntegrationsModifiers;
import tcintegrations.network.ArsElementalSetData;

public class ArsElementalSetBase extends Modifier implements EquipmentChangeModifierHook, ModifyDamageModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.EQUIPMENT_CHANGE, ModifierHooks.MODIFY_DAMAGE);
    }

    @Override
    public Component getDisplayName(int level) {
        return applyStyle(Component.translatable(getTranslationKey()));
    }

    public boolean hasArmorSet() {
        return false;
    }

    public MutableComponent applyStyle(MutableComponent component) {
        if (hasArmorSet()) {
            return component.withStyle(style -> style.withColor(getTextColor()));
        }
        else {
            return component.withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.STRIKETHROUGH);
        }
    }

    public void setHasSet(ArsElementalSet data, boolean hasSet) {}

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;
            ItemStack replacement = context.getReplacement();

            ArsElementalSet data = sp.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get());
            boolean hasSet =
                    hasArmorSetItem(sp, EquipmentSlot.HEAD) &&
                        hasArmorSetItem(sp, EquipmentSlot.CHEST) &&
                        hasArmorSetItem(sp, EquipmentSlot.LEGS) &&
                        hasArmorSetItem(sp, EquipmentSlot.FEET);

            setHasSet(data, hasSet);

            PacketDistributor.sendToPlayer(sp,
                new ArsElementalSetData(data.hasAir(), data.hasAqua(), data.hasEarth(), data.hasFire())
            );

            int modifierLevel = tool.getModifierLevel(TCIntegrationsModifiers.ARS_MODIFIER.get());

            modifierLevel++;

            var registry = sp.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            ItemEnchantments.Mutable enchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);

            enchantments.set(registry.getOrThrow(EnchantmentRegistry.MANA_BOOST_ENCHANTMENT), modifierLevel);
            enchantments.set(registry.getOrThrow(EnchantmentRegistry.MANA_REGEN_ENCHANTMENT), modifierLevel);

            EnchantmentHelper.setEnchantments(replacement, enchantments.toImmutable());
        }

    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;

        if (player != null && !player.level().isClientSide) {
            final ServerPlayer sp = (ServerPlayer) player;

            ArsElementalSet data = sp.getData(TCIntegrationAttachments.ARS_ELEMENTAL_SET.get());
            setHasSet(data, false);

            PacketDistributor.sendToPlayer(sp,
                new ArsElementalSetData(data.hasAir(), data.hasAqua(), data.hasEarth(), data.hasFire())
            );
        }
    }

    public ModifierId getModifierId() {
        return new ModifierId(TCIntegrationsModifiers.AETHERMANCER_MODIFIER.getId());
    }

    public boolean hasArmorSetItem(ServerPlayer sp, EquipmentSlot slot) {
        ItemStack stack = sp.getItemBySlot(slot);

        if (stack.isEmpty()) return false;

        ToolStack armor = ToolStack.from(stack);

        if (armor.isBroken()) return false;

        return armor.getUpgrades().getLevel(getModifierId()) > 0;
    }

    public boolean hasArmorSet(Player player) {
        return false;
    }

    @Override
    public float modifyDamageTaken(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource damageSource, float amount, boolean isDirectDamage) {
        final Player player = context.getEntity() instanceof Player ? (Player) context.getEntity() : null;
        int bonusReduction = 0;

        if (player != null && !player.level().isClientSide) {
            if (hasArmorSet(player) && damageSource.is(DamageTypeTags.IS_FALL)) {
                bonusReduction += 5;
            }
            else if (hasArmorSet(player) && damageSource.is(DamageTypeTags.IS_DROWNING)) {
                player.setAirSupply(player.getMaxAirSupply());
                bonusReduction += 5;
            }
            else if (hasArmorSet(player) && damageSource.is(DamageTypeTags.IS_FIRE)) {
                player.clearFire();
                bonusReduction += 5;
            }
        }

        if (bonusReduction > 0) {
            int finalBonusReduction = bonusReduction;

            var mana = com.hollingsworth.arsnouveau.setup.registry.CapabilityRegistry.getMana(player);
            if (mana != null) {
                mana.addMana(amount);
                player.addEffect(new MobEffectInstance(ModPotions.MANA_REGEN_EFFECT, 200, finalBonusReduction / 2));
            }

            return amount * (1 - (bonusReduction / 10F));
        }
        else {
            return amount;
        }
    }

}
