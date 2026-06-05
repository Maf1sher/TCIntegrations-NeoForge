package tcintegrations.data.tcon;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

import tcintegrations.data.BaseRecipeProvider;
import tcintegrations.data.tcon.material.MaterialRecipeProvider;

public class CombinedRecipeProvider extends BaseRecipeProvider {

    private final SmelteryRecipeProvider smeltery;
    private final ModifierRecipeProvider modifier;
    private final MaterialRecipeProvider material;

    public CombinedRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
        this.smeltery = new SmelteryRecipeProvider(packOutput, registries);
        this.modifier = new ModifierRecipeProvider(packOutput, registries);
        this.material = new MaterialRecipeProvider(packOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        smeltery.buildRecipes(consumer);
        modifier.buildRecipes(consumer);
        material.buildRecipes(consumer);
    }

}
