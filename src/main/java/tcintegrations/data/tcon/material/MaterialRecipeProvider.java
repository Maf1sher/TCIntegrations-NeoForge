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
        RecipeOutput bronzeConsumer = withCondition(consumer, tagCondition("ingots/bronze"));
        RecipeOutput aquacultureConsumer = withCondition(consumer, modLoaded(ModIntegration.AQUACULTURE_MODID));
        RecipeOutput malumConsumer = withCondition(consumer, modLoaded(ModIntegration.MALUM_MODID));
        RecipeOutput brassConsumer = withCondition(consumer, tagCondition("ingots/brass"));
        RecipeOutput ifdConsumer = withCondition(consumer, modLoaded(ModIntegration.IFD_MODID));
        RecipeOutput undergardenConsumer = withCondition(consumer, modLoaded(ModIntegration.UNDERGARDEN_MODID));
        RecipeOutput arsConsumer = withCondition(consumer, modLoaded(ModIntegration.ARS_MODID));

        // Bronze
        metalMaterialRecipe(bronzeConsumer, MaterialIds.bronze, folder, MaterialIds.bronze.getPath(), true);

        metalMaterialRecipe(aquacultureConsumer, MaterialIds.neptunium, folder, MaterialIds.neptunium.getPath(), true);
        metalMaterialRecipe(malumConsumer, MaterialIds.soulStainedSteel, folder, MaterialIds.soulStainedSteel.getPath(), true);
        metalMaterialRecipe(brassConsumer, MaterialIds.brass, folder, MaterialIds.brass.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelFire, folder, MaterialIds.dragonsteelFire.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelIce, folder, MaterialIds.dragonsteelIce.getPath(), true);
        metalMaterialRecipe(ifdConsumer, MaterialIds.dragonsteelLightning, folder, MaterialIds.dragonsteelLightning.getPath(), true);

        // Undergarden
        metalMaterialRecipe(undergardenConsumer, MaterialIds.cloggrum, folder, MaterialIds.cloggrum.getPath(), true);
        metalMaterialRecipe(undergardenConsumer, MaterialIds.froststeel, folder, MaterialIds.froststeel.getPath(), true);
        metalMaterialRecipe(undergardenConsumer, MaterialIds.forgottenMetal, folder, MaterialIds.forgottenMetal.getPath(), true);

        // Ars Nouveau
        if (ModIntegration.SOURCE_GEM != null && ModIntegration.SOURCE_GEM != Items.AIR)
            materialRecipe(arsConsumer, MaterialIds.sourceGem, Ingredient.of(new ItemStack(ModIntegration.SOURCE_GEM)), 1, 1, folder + "source_gem");
    }

    private void addMaterialSmeltery(RecipeOutput consumer) {
        String folder = "tools/materials/";

        compatMeltingCasting(consumer, MaterialIds.bronze, TinkerFluids.moltenBronze, folder);
        compatMeltingCasting(consumer, MaterialIds.brass, TinkerFluids.moltenBrass, folder);
        compatMeltingCasting(consumer, MaterialIds.neptunium, TCIntegrationsItems.MOLTEN_NEPTUNIUM, folder);
        compatMeltingCasting(consumer, MaterialIds.soulStainedSteel, TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL, folder);
        compatMeltingCasting(consumer, MaterialIds.dragonsteelFire, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE, folder);
        compatMeltingCasting(consumer, MaterialIds.dragonsteelIce, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE, folder);
        compatMeltingCasting(consumer, MaterialIds.dragonsteelLightning, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING, folder);
        compatMeltingCasting(consumer, MaterialIds.cloggrum, TCIntegrationsItems.MOLTEN_CLOGGRUM, folder);
        compatMeltingCasting(consumer, MaterialIds.froststeel, TCIntegrationsItems.MOLTEN_FROSTSTEEL, folder);
        compatMeltingCasting(consumer, MaterialIds.forgottenMetal, TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL, folder);
    }

}
