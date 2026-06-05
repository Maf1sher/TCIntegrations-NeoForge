package tcintegrations.data.client;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.PackOutput.Target;
import net.minecraft.world.level.block.LiquidBlock;
import slimeknights.mantle.data.GenericDataProvider;

import java.util.concurrent.CompletableFuture;

public class FluidBlockstateModelProvider extends GenericDataProvider {
    private final String modId;
    public FluidBlockstateModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, Target.RESOURCE_PACK, "blockstates");
        this.modId = modId;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        JsonObject normal = new JsonObject();
        normal.addProperty("model", "tconstruct:block/fluid");
        JsonObject variants = new JsonObject();
        variants.add("", normal);
        JsonObject blockstate = new JsonObject();
        blockstate.add("variants", variants);

        return allOf(
            BuiltInRegistries.BLOCK.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(modId) && entry.getValue() instanceof LiquidBlock)
                .map(entry -> saveJson(cache, entry.getKey().location(), blockstate)));
    }

    @Override
    public String getName() {
        return modId + " Fluid Blockstate Model Provider";
    }
}
