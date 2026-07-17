package tcintegrations.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import tcintegrations.TCIntegrations;
import tcintegrations.data.client.FluidBlockstateModelProvider;
import tcintegrations.data.client.FluidBucketModelProvider;
import tcintegrations.data.client.ModBlockStateProvider;
import tcintegrations.data.client.ModItemModelProvider;
import tcintegrations.data.loot.ModLootTables;
import tcintegrations.data.recipes.ModRecipesProvider;
import tcintegrations.data.tcon.CombinedRecipeProvider;
import tcintegrations.data.tcon.IfdMeltingRecipeProvider;
import tcintegrations.data.tcon.EnchantmentToModifierProvider;
import tcintegrations.data.tcon.ModifierProvider;
import tcintegrations.data.tcon.ModifierTagProvider;
import tcintegrations.data.tcon.fluid.FluidEffectProvider;
import tcintegrations.data.tcon.fluid.FluidTagProvider;
import tcintegrations.data.tcon.fluid.FluidTextureProvider;
import tcintegrations.data.tcon.material.MaterialDataProvider;
import tcintegrations.data.tcon.material.MaterialRenderInfoProvider;
import tcintegrations.data.tcon.material.MaterialStatsDataProvider;
import tcintegrations.data.tcon.material.MaterialTraitsDataProvider;
import tcintegrations.data.tcon.sprite.TinkerMaterialSpriteProvider;
import tcintegrations.data.integration.ModIntegration;

@EventBusSubscriber(modid = TCIntegrations.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ModIntegration.setForceLoaded();
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();

        // Server-side providers (block tags first for item tag dependency)
        var blockTags = new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        gen.addProvider(event.includeServer(), ModLootTables.create(packOutput, lookupProvider));
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, blockTags, existingFileHelper));
        gen.addProvider(event.includeServer(), new EntityTypeTagProvider(packOutput, lookupProvider, existingFileHelper));

        // Mod recipes (use PackGenerator to avoid duplicate name conflict with CombinedRecipeProvider)
        gen.getVanillaPack(event.includeServer()).addProvider(output -> new ModRecipesProvider(output, lookupProvider));

        // TCon providers
        gen.addProvider(event.includeServer(), new ModifierProvider(packOutput));
        gen.addProvider(event.includeServer(), new CombinedRecipeProvider(packOutput, lookupProvider));
        gen.addProvider(event.includeServer(), new IfdMeltingRecipeProvider(packOutput));
        gen.addProvider(event.includeServer(), new EnchantmentToModifierProvider(packOutput));
        gen.addProvider(event.includeServer(), new ModifierTagProvider(packOutput, TCIntegrations.MODID, existingFileHelper));

        // TCon material providers (ordered by dependencies)
        var materialData = new MaterialDataProvider(packOutput);
        gen.addProvider(event.includeServer(), materialData);
        gen.addProvider(event.includeServer(), new MaterialStatsDataProvider(packOutput, materialData));
        gen.addProvider(event.includeServer(), new MaterialTraitsDataProvider(packOutput, materialData));

        // TCon fluid providers
        gen.addProvider(event.includeServer(), new FluidEffectProvider(packOutput, TCIntegrations.MODID));
        gen.addProvider(event.includeServer(), new FluidTagProvider(packOutput, lookupProvider, existingFileHelper));

        // TCon sprite/render providers
        var spriteProvider = new TinkerMaterialSpriteProvider();
        gen.addProvider(event.includeClient(), new MaterialRenderInfoProvider(packOutput, spriteProvider, existingFileHelper));

        // Client-side providers
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new FluidTextureProvider(packOutput));
        gen.addProvider(event.includeClient(), new FluidBlockstateModelProvider(packOutput, TCIntegrations.MODID));
        gen.addProvider(event.includeClient(), new FluidBucketModelProvider(packOutput, TCIntegrations.MODID));

    }

}
