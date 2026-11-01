package tcintegrations.data.tcon;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.Tags;

import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;
import slimeknights.tconstruct.library.recipe.modifiers.adding.IncrementalModifierRecipeBuilder;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import slimeknights.tconstruct.tools.TinkerModifiers;
import tcintegrations.common.TagManager;
import tcintegrations.data.BaseRecipeProvider;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.data.tcon.material.TciModifierIds;

public class ModifierRecipeProvider extends BaseRecipeProvider {

    public ModifierRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        addModifierRecipes(consumer);
    }

    private void addModifierRecipes(RecipeOutput consumer) {
        // upgrades
        String compatFolder = "tools/modifiers/compat/";
        String compatSalvage = "tools/modifiers/salvage/compat/";
        RecipeOutput createConsumer = withConditions(consumer, modLoaded(ModIntegration.CREATE_MODID));
        RecipeOutput aquacultureConsumer = withConditions(consumer, modLoaded(ModIntegration.AQUACULTURE_MODID));
        RecipeOutput arsConsumer = withConditions(consumer, modLoaded(ModIntegration.ARS_MODID));
        RecipeOutput alexConsumer = withConditions(consumer, modLoaded(ModIntegration.ALEX_MODID));
        RecipeOutput malumConsumer = withConditions(consumer, modLoaded(ModIntegration.MALUM_MODID));
        RecipeOutput undergardenConsumer = withConditions(consumer, modLoaded(ModIntegration.UNDERGARDEN_MODID));
        RecipeOutput ieConsumer = withConditions(consumer, modLoaded(ModIntegration.IE_MODID));
        RecipeOutput mekanismConsumer = withConditions(consumer, modLoaded(ModIntegration.MEKANISM_MODID));
        RecipeOutput ifdConsumer = withConditions(consumer, modLoaded(ModIntegration.IFD_MODID));
        RecipeOutput apothConsumer = withConditions(consumer, modLoaded(ModIntegration.APOTH_MODID));
        RecipeOutput arsElementalConsumer = withConditions(consumer, modLoaded(ModIntegration.ARS_ELEMENTAL_MODID));
        RecipeOutput deeperDarkerConsumer = withConditions(consumer, modLoaded(ModIntegration.DEEPERDARKER_MODID));
        RecipeOutput twilightForestConsumer = withConditions(consumer, modLoaded(ModIntegration.TWILIGHT_MODID));

        ModifierRecipeBuilder.modifier(TciModifierIds.mechanicalArm)
            .setTools(TinkerTags.Items.MELEE_PRIMARY)
            .addInput(TagManager.Items.MECHANICAL_ARM)
            .setSlots(SlotType.ABILITY, 1)
            .setMaxLevel(1)
            .saveSalvage(createConsumer, prefix(TciModifierIds.mechanicalArm.getLocation(), compatSalvage))
            .save(createConsumer, prefix(TciModifierIds.mechanicalArm.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.poseidon)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.TIN_CAN)
            .addInput(TagManager.Items.REDSTONE_HOOK)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(aquacultureConsumer, prefix(TciModifierIds.poseidon.getLocation(), compatSalvage))
            .save(aquacultureConsumer, prefix(TciModifierIds.poseidon.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.siren)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.HARVEST_PRIMARY))
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.NEPTUNIUM_INGOT)
            .addInput(TagManager.Items.FISH_FILLET_RAW)
            .addInput(TagManager.Items.IRON_HOOK)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(aquacultureConsumer, prefix(TciModifierIds.siren.getLocation(), compatSalvage))
            .save(aquacultureConsumer, prefix(TciModifierIds.siren.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.arsNouveau)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .setMaxLevel(1)
            .setSlots(SlotType.UPGRADE, 1)
            .disallowCrystal()
            .saveSalvage(arsConsumer, wrap(TciModifierIds.arsNouveau, compatSalvage, "_level_1"))
            .save(arsConsumer, wrap(TciModifierIds.arsNouveau, compatFolder, "_level_1"));

        ModifierRecipeBuilder.modifier(TciModifierIds.arsNouveau)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(Items.BLAZE_ROD)
            .addInput(Items.BLAZE_ROD)
            .exactLevel(2)
            .setSlots(SlotType.UPGRADE, 1)
            .disallowCrystal()
            .saveSalvage(arsConsumer, wrap(TciModifierIds.arsNouveau, compatSalvage, "_level_2"))
            .save(arsConsumer, wrap(TciModifierIds.arsNouveau, compatFolder, "_level_2"));

        ModifierRecipeBuilder.modifier(TciModifierIds.arsNouveau)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(TagManager.Items.MAGE_FIBER)
            .addInput(Items.CHORUS_FRUIT)
            .addInput(Items.ENDER_PEARL)
            .addInput(Items.ENDER_PEARL)
            .exactLevel(3)
            .setSlots(SlotType.UPGRADE, 1)
            .disallowCrystal()
            .saveSalvage(arsConsumer, wrap(TciModifierIds.arsNouveau, compatSalvage, "_level_3"))
            .save(arsConsumer, wrap(TciModifierIds.arsNouveau, compatFolder, "_level_3"));

        ModifierRecipeBuilder.modifier(TciModifierIds.aethermancer)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MARK_OF_MASTERY)
            .addInput(TagManager.Items.AIR_ESSENCE)
            .addInput(TagManager.Items.AIR_ESSENCE)
            .addInput(Items.NETHERITE_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(arsElementalConsumer, prefix(TciModifierIds.aethermancer, compatSalvage))
            .save(arsElementalConsumer, prefix(TciModifierIds.aethermancer, compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.aquamancer)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MARK_OF_MASTERY)
            .addInput(TagManager.Items.WATER_ESSENCE)
            .addInput(TagManager.Items.WATER_ESSENCE)
            .addInput(Items.NETHERITE_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(arsElementalConsumer, prefix(TciModifierIds.aquamancer, compatSalvage))
            .save(arsElementalConsumer, prefix(TciModifierIds.aquamancer, compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.geomancer)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MARK_OF_MASTERY)
            .addInput(TagManager.Items.EARTH_ESSENCE)
            .addInput(TagManager.Items.EARTH_ESSENCE)
            .addInput(Items.NETHERITE_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(arsElementalConsumer, prefix(TciModifierIds.geomancer, compatSalvage))
            .save(arsElementalConsumer, prefix(TciModifierIds.geomancer, compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.pyromancer)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.MARK_OF_MASTERY)
            .addInput(TagManager.Items.FIRE_ESSENCE)
            .addInput(TagManager.Items.FIRE_ESSENCE)
            .addInput(Items.NETHERITE_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(arsElementalConsumer, prefix(TciModifierIds.pyromancer, compatSalvage))
            .save(arsElementalConsumer, prefix(TciModifierIds.pyromancer, compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.enchantersShield)
            .setTools(TinkerTags.Items.CHESTPLATES)
            .addInput(TagManager.Items.SOURCE_GEM_BLOCK)
            .addInput(TagManager.Items.SOURCE_GEM_BLOCK)
            .addInput(Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD))
            .addInput(Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD))
            .addInput(Items.SHIELD)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(arsConsumer, prefix(TciModifierIds.enchantersShield.getLocation().withSuffix("_chestplates"), compatSalvage))
            .save(arsConsumer, prefix(TciModifierIds.enchantersShield.getLocation().withSuffix("_chestplates"), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.roadrunner)
            .setTools(TinkerTags.Items.BOOTS)
            .addInput(Items.CHISELED_SANDSTONE)
            .addInput(TagManager.Items.ROADRUNNER_FEATHER)
            .addInput(TagManager.Items.ROADRUNNER_FEATHER)
            .addInput(TagManager.Items.ROADRUNNER_FEATHER)
            .addInput(TagManager.Items.ROADRUNNER_FEATHER)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(3)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.roadrunner.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.roadrunner.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.frontierCap)
            .setTools(TinkerTags.Items.HELMETS)
            .addInput(TagManager.Items.BEAR_FUR)
            .addInput(TagManager.Items.BEAR_FUR)
            .addInput(TagManager.Items.BEAR_FUR)
            .addInput(TagManager.Items.BEAR_FUR)
            .addInput(TagManager.Items.RACCOON_TAIL)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(3)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.frontierCap.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.frontierCap.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.turtleShell)
            .setTools(TinkerTags.Items.HELMETS)
            .addInput(TagManager.Items.SPIKED_SCUTE)
            .addInput(TagManager.Items.SPIKED_SCUTE)
            .addInput(TagManager.Items.SPIKED_SCUTE)
            .addInput(TagManager.Items.SPIKED_SCUTE)
            .addInput(TagManager.Items.SPIKED_SCUTE)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.turtleShell.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.turtleShell.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.bisonFur)
            .setTools(TinkerTags.Items.BOOTS)
            .addInput(TagManager.Items.BISON_FUR)
            .addInput(TagManager.Items.BISON_FUR)
            .addInput(TagManager.Items.BISON_FUR)
            .addInput(TagManager.Items.BISON_FUR)
            .addInput(TagManager.Items.BISON_FUR)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.bisonFur.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.bisonFur.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.shieldOfTheDeep)
            .setTools(TinkerTags.Items.CHESTPLATES)
            .addInput(Items.HEART_OF_THE_SEA)
            .addInput(Items.PRISMARINE_BRICKS)
            .addInput(TagManager.Items.SERRATED_SHARK_TOOTH)
            .addInput(TagManager.Items.SHARK_TOOTH)
            .addInput(TagManager.Items.SHARK_TOOTH)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.shieldOfTheDeep.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.shieldOfTheDeep.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.mosquito)
            .setTools(TinkerTags.Items.BOOTS)
            .addInput(TagManager.Items.MOSQUITO_PROBOSCIS)
            .addInput(TagManager.Items.MOSQUITO_PROBOSCIS)
            .addInput(TagManager.Items.MOSQUITO_PROBOSCIS)
            .addInput(TagManager.Items.MOSQUITO_PROBOSCIS)
            .addInput(TagManager.Items.MOSQUITO_PROBOSCIS)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(3)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.mosquito.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.mosquito.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.crocodile)
            .setTools(TinkerTags.Items.CHESTPLATES)
            .addInput(TagManager.Items.CROCODILE_SCUTE)
            .addInput(TagManager.Items.CROCODILE_SCUTE)
            .addInput(TagManager.Items.CROCODILE_SCUTE)
            .addInput(TagManager.Items.CROCODILE_SCUTE)
            .addInput(TagManager.Items.CROCODILE_SCUTE)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(alexConsumer, prefix(TciModifierIds.crocodile.getLocation(), compatSalvage))
            .save(alexConsumer, prefix(TciModifierIds.crocodile.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.soulStained)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.SOUL_STAINED_STEEL_INGOTS)
            .addInput(TagManager.Items.SOUL_STAINED_STEEL_INGOTS)
            .addInput(TagManager.Items.SOUL_STAINED_STEEL_INGOTS)
            .addInput(TagManager.Items.SOUL_STAINED_STEEL_INGOTS)
            .addInput(TagManager.Items.SOUL_STAINED_STEEL_INGOTS)
            .setSlots(SlotType.DEFENSE, 1)
            .setMaxLevel(1)
            .saveSalvage(malumConsumer, prefix(TciModifierIds.soulStained.getLocation(), compatSalvage))
            .save(malumConsumer, prefix(TciModifierIds.soulStained.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.utherium)
            .setTools(TinkerTags.Items.MELEE_PRIMARY)
            .addInput(TagManager.Items.UTHERIUM_CRYSTAL)
            .addInput(TagManager.Items.UTHERIUM_CRYSTAL)
            .addInput(TagManager.Items.UTHERIUM_CRYSTAL)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(undergardenConsumer, prefix(TciModifierIds.utherium.getLocation(), compatSalvage))
            .save(undergardenConsumer, prefix(TciModifierIds.utherium.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.froststeelTrait)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.HARVEST_PRIMARY))
            .addInput(TagManager.Items.FROSTSTEEL_INGOT)
            .addInput(TagManager.Items.FROSTSTEEL_INGOT)
            .addInput(TagManager.Items.FROSTSTEEL_INGOT)
            .addInput(TagManager.Items.FROSTSTEEL_INGOT)
            .addInput(TagManager.Items.FROSTSTEEL_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(undergardenConsumer, prefix(TciModifierIds.froststeelTrait.getLocation(), compatSalvage))
            .save(undergardenConsumer, prefix(TciModifierIds.froststeelTrait.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.forgottenTrait)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.HARVEST_PRIMARY))
            .addInput(TagManager.Items.FORGOTTEN_INGOT)
            .addInput(TagManager.Items.CLOGGRUM_INGOT)
            .addInput(TagManager.Items.CLOGGRUM_INGOT)
            .addInput(TagManager.Items.CLOGGRUM_INGOT)
            .addInput(TagManager.Items.CLOGGRUM_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(undergardenConsumer, prefix(TciModifierIds.forgottenTrait.getLocation(), compatSalvage))
            .save(undergardenConsumer, prefix(TciModifierIds.forgottenTrait.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.multiVision)
            .setTools(TinkerTags.Items.HELMETS)
            .addInput(TagManager.Items.VOLTMETER)
            .save(ieConsumer, prefix(TciModifierIds.multiVision.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.glowup)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.HARVEST_PRIMARY))
            .addInput(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .addInput(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .addInput(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .addInput(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .addInput(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(3)
            .saveSalvage(mekanismConsumer, prefix(TciModifierIds.glowup.getLocation(), compatSalvage))
            .save(mekanismConsumer, prefix(TciModifierIds.glowup.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.flamed)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.RANGED))
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.WITHER_BONES)
            .addInput(TagManager.Items.FIRE_DRAGON_BLOOD)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(ifdConsumer, prefix(TciModifierIds.flamed.getLocation(), compatSalvage))
            .save(ifdConsumer, prefix(TciModifierIds.flamed.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.iced)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.RANGED))
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.WITHER_BONES)
            .addInput(TagManager.Items.ICE_DRAGON_BLOOD)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(ifdConsumer, prefix(TciModifierIds.iced.getLocation(), compatSalvage))
            .save(ifdConsumer, prefix(TciModifierIds.iced.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.zapped)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE_PRIMARY, TinkerTags.Items.RANGED))
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.WITHER_BONES)
            .addInput(TagManager.Items.LIGHTNING_DRAGON_BLOOD)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(ifdConsumer, prefix(TciModifierIds.zapped.getLocation(), compatSalvage))
            .save(ifdConsumer, prefix(TciModifierIds.zapped.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.phantasmal)
            .setTools(TinkerTags.Items.SWORD)
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.DRAGON_BONE)
            .addInput(TagManager.Items.WITHER_BONES)
            .addInput(TagManager.Items.GHOST_INGOT)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(ifdConsumer, prefix(TciModifierIds.phantasmal.getLocation(), compatSalvage))
            .save(ifdConsumer, prefix(TciModifierIds.phantasmal.getLocation(), compatFolder));

        IncrementalModifierRecipeBuilder.modifier(TciModifierIds.capturing)
            .setTools(TinkerTags.Items.MELEE_PRIMARY)
            .setInput(Items.EXPERIENCE_BOTTLE, 1, 28)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(7)
            .saveSalvage(apothConsumer, prefix(TciModifierIds.capturing.getLocation(), compatSalvage))
            .save(apothConsumer, prefix(TciModifierIds.capturing.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.sculking)
            .setTools(TinkerTags.Items.WORN_ARMOR)
            .addInput(TagManager.Items.REINFORCED_ECHO_SHARD)
            .addInput(Items.NETHERITE_INGOT)
            .addInput(Items.DIAMOND)
            .addInput(Items.DIAMOND)
            .addInput(Items.DIAMOND)
            .setSlots(SlotType.UPGRADE, 1)
            .setMaxLevel(1)
            .saveSalvage(deeperDarkerConsumer, prefix(TciModifierIds.sculking.getLocation(), compatSalvage))
            .save(deeperDarkerConsumer, prefix(TciModifierIds.sculking.getLocation(), compatFolder));

        IncrementalModifierRecipeBuilder.modifier(TinkerModifiers.fiery)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE, TinkerTags.Items.BOWS, TinkerTags.Items.WORN_ARMOR, TinkerTags.Items.SHIELDS))
            .setInput(TagManager.Items.FIERY_INGOT, 1, 2)
            .setMaxLevel(7) // +25 seconds fire damage
            .setSlots(SlotType.UPGRADE, 1)
            .saveSalvage(twilightForestConsumer, prefix(TinkerModifiers.fiery, compatSalvage))
            .save(twilightForestConsumer, prefix(TinkerModifiers.fiery, compatFolder));

        ModifierRecipeBuilder.modifier(TinkerModifiers.freezing)
            .addInput(TagManager.Items.ARCTIC_FUR)
            .setMaxLevel(5)
            .setSlots(SlotType.UPGRADE, 1)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE, TinkerTags.Items.BOWS, TinkerTags.Items.WORN_ARMOR, TinkerTags.Items.SHIELDS))
            .saveSalvage(twilightForestConsumer, prefix(TinkerModifiers.freezing, compatSalvage))
            .save(twilightForestConsumer, prefix(TinkerModifiers.freezing, compatFolder));

        ModifierRecipeBuilder.modifier(TinkerModifiers.autosmelt)
            .addInput(Tags.Items.RAW_MATERIALS)
            .addInput(TagManager.Items.FIERY_INGOT)
            .addInput(TagManager.Items.FIERY_INGOT)
            .addInput(TagManager.Items.FIERY_INGOT)
            .setMaxLevel(1).checkTraitLevel()
            .setSlots(SlotType.ABILITY, 1)
            .setTools(TinkerTags.Items.HARVEST)
            .saveSalvage(twilightForestConsumer, prefix(TinkerModifiers.autosmelt, compatSalvage))
            .save(twilightForestConsumer, prefix(TinkerModifiers.autosmelt, compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.precipitate)
            .addInput(TagManager.Items.NAGA_SCALE)
            .addInput(TagManager.Items.NAGA_SCALE)
            .addInput(TagManager.Items.NAGA_SCALE)
            .addInput(TagManager.Items.NAGA_SCALE)
            .addInput(TagManager.Items.NAGA_SCALE)
            .setMaxLevel(1)
            .setSlots(SlotType.ABILITY, 1)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE, TinkerTags.Items.HARVEST, TinkerTags.Items.RANGED))
            .saveSalvage(twilightForestConsumer, prefix(TciModifierIds.precipitate.getLocation(), compatSalvage))
            .save(twilightForestConsumer, prefix(TciModifierIds.precipitate.getLocation(), compatFolder));

        ModifierRecipeBuilder.modifier(TciModifierIds.twilit)
            .addInput(TagManager.Items.FIERY_INGOT)
            .addInput(TagManager.Items.FIERY_INGOT)
            .addInput(TagManager.Items.FIERY_INGOT)
            .addInput(TagManager.Items.STEELEAF_INGOT)
            .addInput(TagManager.Items.NAGA_SCALE)
            .setMaxLevel(1)
            .setSlots(SlotType.ABILITY, 1)
            .setTools(ingredientFromTags(TinkerTags.Items.MELEE, TinkerTags.Items.HARVEST, TinkerTags.Items.RANGED))
            .saveSalvage(twilightForestConsumer, prefix(TciModifierIds.twilit.getLocation(), compatSalvage))
            .save(twilightForestConsumer, prefix(TciModifierIds.twilit.getLocation(), compatFolder));
    }

    public ResourceLocation prefix(LazyModifier modifier, String prefix) {
        return prefix(modifier.id(), prefix);
    }

    @SafeVarargs
    private static Ingredient ingredientFromTags(TagKey<Item>... tags) {
        Ingredient[] tagIngredients = new Ingredient[tags.length];

        for (int i = 0; i < tags.length; i++) {
            tagIngredients[i] = Ingredient.of(tags[i]);
        }

        return net.neoforged.neoforge.common.crafting.CompoundIngredient.of(tagIngredients);
    }

}
