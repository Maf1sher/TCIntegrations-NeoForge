package tcintegrations.data.client;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.mantle.registration.object.MetalItemObject;

import tcintegrations.TCIntegrations;
import tcintegrations.items.TCIntegrationsItems;

import static tcintegrations.util.ResourceLocationHelper.resource;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, TCIntegrations.MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "TCIntegrations - Block State and Models";
    }

    @Override
    protected void registerStatesAndModels() {
        generateBronzeModels();
    }

    private void generateBronzeModels() {
        metalBlock(TCIntegrationsItems.BRONZE);
    }

    private void metalBlock(MetalItemObject metal) {
        Block block = metal.get();
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String name = path.replace("_block", "");
        ResourceLocation texture = resource("block/storage/" + name);
        ModelFile model = models().cubeAll("block/" + path, texture);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

}
