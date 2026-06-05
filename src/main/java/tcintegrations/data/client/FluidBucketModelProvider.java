package tcintegrations.data.client;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.PackOutput.Target;
import net.minecraft.world.item.BucketItem;
import slimeknights.mantle.data.GenericDataProvider;

import java.util.concurrent.CompletableFuture;

public class FluidBucketModelProvider extends GenericDataProvider {
    private final String modId;
    public FluidBucketModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, Target.RESOURCE_PACK, "models/item");
        this.modId = modId;
    }

    private static JsonObject makeJson(BucketItem bucket) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", "neoforge:item/bucket_drip");
        json.addProperty("loader", "tconstruct:fluid_container");
        json.addProperty("flip_gas", bucket.content.getFluidType().isLighterThanAir());
        json.addProperty("fluid", BuiltInRegistries.FLUID.getKey(bucket.content).toString());
        return json;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return allOf(
            BuiltInRegistries.ITEM.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(modId) && entry.getValue() instanceof BucketItem)
                .map(entry -> saveJson(cache, entry.getKey().location(), makeJson((BucketItem)entry.getValue()))));
    }

    @Override
    public String getName() {
        return modId + " Fluid Bucket Model Provider";
    }
}
