package tcintegrations.data.loot;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import tcintegrations.items.TCIntegrationsItems;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(HolderLookup.Provider registries) {
        super(Collections.<Item>emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(TCIntegrationsItems.BRONZE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ImmutableList.of(TCIntegrationsItems.BRONZE.get());
    }

}
