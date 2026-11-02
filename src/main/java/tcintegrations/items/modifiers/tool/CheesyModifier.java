package tcintegrations.items.modifiers.tool;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import net.neoforged.neoforge.common.util.Lazy;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import tcintegrations.common.TagManager;
import tcintegrations.data.integration.ModIntegration;

/*
 * Pretty much a copy of Tinkers' TastyModifier, with Ad Astra cheese as the representative food.
 */
public class CheesyModifier extends Modifier implements GeneralInteractionModifierHook, ProcessLootModifierHook {

    private static final Lazy<ItemStack> CHEESE_STACK = Lazy.of(() -> new ItemStack(getCheese()));

    private static ItemLike getCheese() {
        return BuiltInRegistries.ITEM.getTag(TagManager.Items.CHEESE)
            .flatMap(tag -> tag.getRandomElement(RandomSource.create()))
            .map(Holder::value)
            .orElse(ModIntegration.CHEESE);
    }

    @Override
    protected void registerHooks(Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.GENERAL_INTERACT, ModifierHooks.PROCESS_LOOT);
    }

    @Override
    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        if (source == InteractionSource.RIGHT_CLICK && !tool.isBroken() && player.canEat(false)) {
            GeneralInteractionModifierHook.startUsing(tool, modifier.getId(), player, hand);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onFinishUsing(IToolStackView tool, ModifierEntry modifier, LivingEntity entity) {
        if (!tool.isBroken() && entity instanceof Player player && player.canEat(false)) {
            // eat the food
            int level = modifier.getLevel();
            Level world = entity.level();
            player.getFoodData().eat(level, level * 0.1F);
            ModifierUtil.foodConsumer.onConsume(player, CHEESE_STACK.get(), level, level * 0.1F);
            player.awardStat(Stats.ITEM_USED.get(tool.getItem()));
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F,
                    1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.4F);
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 0.5F,
                    world.random.nextFloat() * 0.1F + 0.9F);

            // 15 damage for a bite per level, does not process reinforced/overslime, your teeth are tough
            ToolDamageUtil.directDamage(tool, 15 * level, player, player.getUseItem());
        }
    }

    @Override
    public UseAnim getUseAction(IToolStackView tool, ModifierEntry modifier) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(IToolStackView tool, ModifierEntry modifier) {
        return 16;
    }

    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> generatedLoot, LootContext context) {
        // if no damage source, probably not a mob
        // otherwise blocks breaking (where THIS_ENTITY is the player) start dropping cheese
        if (!context.hasParam(LootContextParams.DAMAGE_SOURCE)) {
            return;
        }

        // must have an entity
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (entity != null && entity.getType().is(TagManager.EntityTypes.MILK_PRODUCER)) {
            // looting is no longer exposed on the loot context in 1.21.1
            int looting = 0;
            if (RANDOM.nextInt(48 / modifier.intEffectiveLevel()) <= looting) {
                generatedLoot.add(new ItemStack(ModIntegration.CHEESE));
            }
        }
    }

}
