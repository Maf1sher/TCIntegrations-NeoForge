package tcintegrations.data.client;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.mantle.registration.object.MetalItemObject;

import tcintegrations.TCIntegrations;
import tcintegrations.items.TCIntegrationsItems;

import static tcintegrations.util.ResourceLocationHelper.resource;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, TCIntegrations.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "TCIntegrations - Item Models";
    }

    @Override
    protected void registerModels() {
        metalItemModels(TCIntegrationsItems.BRONZE);
    }

    private void metalItemModels(MetalItemObject metal) {
        // Block item — parent the block model
        String blockPath = BuiltInRegistries.BLOCK.getKey(metal.get()).getPath();
        withExistingParent(blockPath, resource("block/" + blockPath));

        // Ingot — item/generated
        String ingotPath = BuiltInRegistries.ITEM.getKey(metal.getIngot()).getPath();
        generated(ingotPath, resource("item/materials/" + ingotPath));

        // Nugget — item/generated
        String nuggetPath = BuiltInRegistries.ITEM.getKey(metal.getNugget()).getPath();
        generated(nuggetPath, resource("item/materials/" + nuggetPath));
    }

    private ItemModelBuilder generated(String name, ResourceLocation texture) {
        return getBuilder(name).parent(new UncheckedModelFile("item/generated")).texture("layer0", texture);
    }

}
