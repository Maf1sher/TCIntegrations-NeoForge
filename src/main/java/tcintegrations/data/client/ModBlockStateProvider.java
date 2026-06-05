package tcintegrations.data.client;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import tcintegrations.TCIntegrations;

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
    }

}
