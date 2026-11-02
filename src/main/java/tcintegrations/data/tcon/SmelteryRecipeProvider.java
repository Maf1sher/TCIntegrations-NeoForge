package tcintegrations.data.tcon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;

import slimeknights.mantle.recipe.condition.TagFilledCondition;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.json.ConfigEnabledCondition;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;
import slimeknights.tconstruct.library.recipe.melting.IMeltingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import tcintegrations.common.TagManager;
import tcintegrations.data.BaseRecipeProvider;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.items.TCIntegrationsItems;
import tcintegrations.util.ResourceLocationHelper;

import static slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder.itemTag;

public class SmelteryRecipeProvider extends BaseRecipeProvider implements ISmelteryRecipeHelper, ICommonRecipeHelper {

    public SmelteryRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        this.addMeltingRecipes(consumer);
        this.addAlloyRecipes(consumer);
    }

    private void addMeltingRecipes(RecipeOutput consumer) {
        // ores
        RecipeOutput aquacultureConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.AQUACULTURE_MODID, "neptunium"));
        RecipeOutput malumConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.MALUM_MODID, "soul_stained_steel"));
        RecipeOutput undergardenCloggrumConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.UNDERGARDEN_MODID, "cloggrum"));
        RecipeOutput undergardenFroststeelConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.UNDERGARDEN_MODID, "froststeel"));
        RecipeOutput undergardenForgottenConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.UNDERGARDEN_MODID, "forgotten"));
        RecipeOutput ifdFireConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_fire"));
        RecipeOutput ifdIceConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_ice"));
        RecipeOutput ifdLightningConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_lightning"));
        RecipeOutput arsConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.ARS_MODID, TagManager.Items.SOURCE_GEM));
        RecipeOutput adAstraDeshConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.AD_ASTRA_MODID, "desh"));
        RecipeOutput adAstraCaloriteConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.AD_ASTRA_MODID, "calorite"));
        RecipeOutput adAstraOstrumConsumer = withConditions(consumer, modOrTagCondition(ModIntegration.AD_ASTRA_MODID, "ostrum"));

        molten(arsConsumer, TCIntegrationsItems.MOLTEN_SOURCE_GEM).smallGem();
        metal(aquacultureConsumer, TCIntegrationsItems.MOLTEN_NEPTUNIUM).metal();
        metal(malumConsumer, TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL).metal();
        metal(undergardenCloggrumConsumer, TCIntegrationsItems.MOLTEN_CLOGGRUM).ore().metal();
        metal(undergardenFroststeelConsumer, TCIntegrationsItems.MOLTEN_FROSTSTEEL).ore().metal();
        metal(undergardenForgottenConsumer, TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL).metal();
        metal(adAstraDeshConsumer, TCIntegrationsItems.MOLTEN_DESH).ore().metal();
        metal(adAstraCaloriteConsumer, TCIntegrationsItems.MOLTEN_CALORITE).ore().metal();
        metal(adAstraOstrumConsumer, TCIntegrationsItems.MOLTEN_OSTRUM).ore().metal();
        metalWithoutNugget(ifdFireConsumer, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE);
        metalWithoutNugget(ifdIceConsumer, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE);
        metalWithoutNugget(ifdLightningConsumer, TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING);
    }

    private void addAlloyRecipes(RecipeOutput consumer) {
        String folder = "smeltery/alloys/";

        // Update Recipe to use Obsidian instead of Quartz to not interfere with Hepatizon
        RecipeOutput wrapped = withConditions(consumer, new TagEmptyCondition(ResourceLocationHelper.location("c", "ingots/tin")));

        AlloyRecipeBuilder.alloy(TinkerFluids.moltenBronze.get(), FluidValues.INGOT * 4)
            .addInput(TinkerFluids.moltenCopper.ingredient(FluidValues.INGOT * 3))
            .addInput(TinkerFluids.moltenObsidian.ingredient(FluidValues.GLASS_BLOCK))
            .save(wrapped, prefix(TinkerFluids.moltenBronze, folder));
    }

    /** Creates a metal from a tag */
    public SmelteryRecipeBuilder metal(RecipeOutput consumer, String name, TagKey<Fluid> fluid) {
        return SmelteryRecipeBuilder.fluid(consumer, location(name), fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    /** Creates a smeltery builder for a metal fluid */
    public SmelteryRecipeBuilder metal(RecipeOutput consumer, FluidObject<?> fluid) {
        return molten(consumer, fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    private void metalWithoutNugget(RecipeOutput consumer, FluidObject<?> fluid) {
        SmelteryRecipeBuilder builder = molten(consumer, fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
        ResourceLocation name = this.location(fluid.id().getPath().substring("molten_".length()));

        builder.oreRate(IMeltingContainer.OreRateType.METAL);
        builder.baseUnit(90);
        builder.damageUnit(10);
        builder.melting(9.0F, "block", "storage_blocks", 3.0F, false, false);
        basinMetalCasting(builder, consumer, fluid,  name);
        builder.meltingCasting(1.0F, TinkerSmeltery.ingotCast, 1.0F, false);
    }

    private void basinMetalCasting(SmelteryRecipeBuilder builder, RecipeOutput consumer, FluidObject<?> fluid, ResourceLocation name) {
        String castingFolder = "smeltery/casting/metal/";
        String tagName = "storage_blocks/" + name.getPath();

        ItemCastingRecipeBuilder.basinRecipe(ItemOutput.fromTag(itemTag(tagName))).setFluid(fluid.ingredient(810)).setCoolingTime(IMeltingRecipe.getTemperature(fluid), 810).save(consumer, location(name, castingFolder, "block"));
    }

    private ResourceLocation location(ResourceLocation name, String folder, String variant) {
        return name.withPath(folder + name.getPath() + "/" + variant);
    }

    /** Condition: mod loaded OR c:ingots/X tag filled */
    private static OrCondition modOrTagCondition(String modId, String ingotName) {
        return modOrTagCondition(modId, ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ingotName)));
    }

    /** Condition: mod loaded OR the given item tag filled */
    private static OrCondition modOrTagCondition(String modId, TagKey<Item> tag) {
        return new OrCondition(List.of(
            ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS,
            new ModLoadedCondition(modId),
            new TagFilledCondition<>(Registries.ITEM, tag.location())
        ));
    }
}
