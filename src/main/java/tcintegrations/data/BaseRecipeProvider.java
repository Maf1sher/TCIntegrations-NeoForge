package tcintegrations.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import slimeknights.mantle.recipe.data.IRecipeHelper;

import tcintegrations.TCIntegrations;

public abstract class BaseRecipeProvider extends RecipeProvider implements IConditionBuilder, IRecipeHelper {

    public BaseRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    /** Wraps a recipe output in the given conditions; NeoForge moved this onto {@link RecipeOutput}. */
    protected static RecipeOutput withConditions(RecipeOutput output, ICondition... conditions) {
        return output.withConditions(conditions);
    }

    @Override
    protected abstract void buildRecipes(RecipeOutput recipeOutput);

    @Override
    public String getModId() {
        return TCIntegrations.MODID;
    }

}
