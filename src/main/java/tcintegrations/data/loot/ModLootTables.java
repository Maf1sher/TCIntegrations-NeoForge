package tcintegrations.data.loot;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTables {

    public static LootTableProvider create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        return new LootTableProvider(
            packOutput,
            Collections.emptySet(),
            List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)),
            registries
        );
    }

}
