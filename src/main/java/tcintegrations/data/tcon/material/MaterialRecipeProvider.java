package tcintegrations.data.tcon.material;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.conditions.OrCondition;

import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;

import tcintegrations.common.TagManager;
import tcintegrations.data.BaseRecipeProvider;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.items.TCIntegrationsItems;

public class MaterialRecipeProvider extends BaseRecipeProvider implements IMaterialRecipeHelper {

    public MaterialRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    public void buildRecipes(RecipeOutput consumer) {
        addMaterialItems(consumer);
        addMaterialSmeltery(consumer);
    }

    private void addMaterialItems(RecipeOutput consumer) {
        String folder = "tools/materials/";
        RecipeOutput botaniaConsumer = withCondition(consumer, modLoaded(ModIntegration.BOTANIA_MODID));
        RecipeOutput aquacultureConsumer = withCondition(consumer, modLoaded(ModIntegration.AQUACULTURE_MODID));
        RecipeOutput malumConsumer = withCondition(consumer, modLoaded(ModIntegration.MALUM_MODID));
        RecipeOutput brassConsumer = withCondition(consumer, tagCondition("ingots/brass"));
        RecipeOutput ifdConsumer = withCondition(consumer, modLoaded(ModIntegration.IFD_MODID));
        RecipeOutput adAstraConsumer = withCondition(consumer, new OrCondition(List.of(modLoaded(ModIntegration.AD_ASTRA_MODID), modLoaded(ModIntegration.BEYOND_EARTH_MODID))));

        if (ModIntegration.BOTANIA_LIVINGWOOD_PLANKS != null && ModIntegration.BOTANIA_LIVINGWOOD_PLANKS != Items.AIR)
            materialRecipe(botaniaConsumer, MaterialIds.livingWood, Ingredient.of(ModIntegration.BOTANIA_LIVINGWOOD_PLANKS), 1, 1, folder + "livingwood/planks");
        if (ModIntegration.BOTANIA_LIVINGWOOD_PLANKS != null && ModIntegration.BOTANIA_LIVINGWOOD_PLANKS != Items.AIR)
            materialRecipe(botaniaConsumer, MaterialIds.livingWood, Ingredient.of(TagManager.Items.BOTANIA_LIVINGWOOD_LOGS), 4, 1, ItemOutput.fromStack(new ItemStack(ModIntegration.BOTANIA_LIVINGWOOD_PLANKS)), folder + "livingwood/logs");
        if (ModIntegration.LIVING_ROCK != null && ModIntegration.LIVING_ROCK != Items.AIR)
            materialRecipe(botaniaConsumer, MaterialIds.livingRock, Ingredient.of(new ItemStack(ModIntegration.LIVING_ROCK)), 1, 1, folder + "livingrock");
        if (ModIntegration.MANA_STRING != null && ModIntegration.MANA_STRING != Items.AIR)
            materialRecipe(botaniaConsumer, MaterialIds.manaString, Ingredient.of(new ItemStack(ModIntegration.MANA_STRING)), 1, 1, folder + "manastring");

        metalMaterialRecipe(botaniaConsumer, MaterialIds.manaSteel, folder, MaterialIds.manaSteel.getPath(), true);
        metalMaterialRecipe(aquacultureConsumer, MaterialIds.neptunium, folder, MaterialIds.neptunium.getPath(), true);
        metalMaterialRecipe(malumConsumer, MaterialIds.soulStainedSteel, folder, MaterialIds.soulStainedSteel.getPath(), true);
        metalMaterialRecipe(brassConsumer, MaterialIds.brass, folder, MaterialIds.brass.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelFire, folder, MaterialIds.dragonsteelFire.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelIce, folder, MaterialIds.dragonsteelIce.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelLightning, folder, MaterialIds.dragonsteelLightning.getPath(), true);
        metalMaterialRecipe(adAstraConsumer, MaterialIds.desh, folder, MaterialIds.desh.getPath(), true);
        metalMaterialRecipe(adAstraConsumer, MaterialIds.calorite, folder, MaterialIds.calorite.getPath(), true);
        metalMaterialRecipe(adAstraConsumer, MaterialIds.ostrum, folder, MaterialIds.ostrum.getPath(), true);
    }

    private void addMaterialSmeltery(RecipeOutput consumer) {
        String folder = "tools/materials/";

        compatMeltingCasting(consumer, MaterialIds.brass, TinkerFluids.moltenBrass, folder);
        if (TCIntegrationsItems.MOLTEN_MANASTEEL != null) compatMeltingCasting(consumer, MaterialIds.manaSteel, TCIntegrationsItems.MOLTEN_MANASTEEL, folder);
        if (TCIntegrationsItems.MOLTEN_NEPTUNIUM != null) compatMeltingCasting(consumer, MaterialIds.neptunium, TCIntegrationsItems.MOLTEN_NEPTUNIUM, folder);
        if (TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL != null) compatMeltingCasting(consumer, MaterialIds.soulStainedSteel, TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL, folder);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null) compatMeltingCasting(consumer, MaterialIds.dragonsteelFire, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE, folder);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null) compatMeltingCasting(consumer, MaterialIds.dragonsteelIce, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE, folder);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null) compatMeltingCasting(consumer, MaterialIds.dragonsteelLightning, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING, folder);
        if (TCIntegrationsItems.MOLTEN_DESH != null) compatMeltingCasting(consumer, MaterialIds.desh, TCIntegrationsItems.MOLTEN_DESH, folder);
        if (TCIntegrationsItems.MOLTEN_CALORITE != null) compatMeltingCasting(consumer, MaterialIds.calorite, TCIntegrationsItems.MOLTEN_CALORITE, folder);
        if (TCIntegrationsItems.MOLTEN_OSTRUM != null) compatMeltingCasting(consumer, MaterialIds.ostrum, TCIntegrationsItems.MOLTEN_OSTRUM, folder);
    }

}
