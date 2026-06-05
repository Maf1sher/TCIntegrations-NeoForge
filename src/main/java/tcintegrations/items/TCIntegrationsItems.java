package tcintegrations.items;

import java.util.function.Function;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.neoforge.registries.DeferredHolder;

import slimeknights.mantle.item.BlockTooltipItem;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.mantle.registration.object.MetalItemObject;

import slimeknights.tconstruct.world.TinkerWorld;

import tcintegrations.common.TCIntegrationsModule;
import tcintegrations.TCIntegrations;

public final class TCIntegrationsItems extends TCIntegrationsModule {

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM_TAB_GROUP;
    public static Function<Block, ? extends BlockItem> GENERAL_TOOLTIP_BLOCK_ITEM;

    public static MetalItemObject BRONZE;

    // Molten fluid objects (registered via FLUID_REGISTRY in init)
    public static FluidObject<?> MOLTEN_MANASTEEL;
    public static FluidObject<?> MOLTEN_NEPTUNIUM;
    public static FluidObject<?> MOLTEN_SOURCE_GEM;
    public static FluidObject<?> MOLTEN_SOUL_STAINED_STEEL;
    public static FluidObject<?> MOLTEN_CLOGGRUM;
    public static FluidObject<?> MOLTEN_FROSTSTEEL;
    public static FluidObject<?> MOLTEN_FORGOTTEN_METAL;
    public static FluidObject<?> MOLTEN_DESH;
    public static FluidObject<?> MOLTEN_CALORITE;
    public static FluidObject<?> MOLTEN_OSTRUM;
    public static FluidObject<?> MOLTEN_DRAGONSTEEL_FIRE;
    public static FluidObject<?> MOLTEN_DRAGONSTEEL_ICE;
    public static FluidObject<?> MOLTEN_DRAGONSTEEL_LIGHTNING;

    public static void init() {
        ITEM_TAB_GROUP = CREATIVE_TABS.register(
            TCIntegrations.MODID + ".items",
                () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + TCIntegrations.MODID + ".items"))
                    .icon(() -> new ItemStack(BRONZE.getNugget()))
                    .displayItems(TCIntegrationsItems::addTabItems)
                    .withTabsBefore(TinkerWorld.tabWorld.getId())
                    .build()
        );
        GENERAL_TOOLTIP_BLOCK_ITEM = (b) -> new BlockTooltipItem(b, new Item.Properties());

        BRONZE = METAL_BLOCK_REGISTRY.registerMetal(
            "bronze",
            metalBuilder(MapColor.WOOD),
            GENERAL_TOOLTIP_BLOCK_ITEM,
            new Item.Properties()
        );
    }

    private static BlockBehaviour.Properties builder(SoundType soundType) {
        return Block.Properties.of().sound(soundType);
    }

    private static BlockBehaviour.Properties builder(MapColor color, SoundType soundType) {
        return builder(soundType).mapColor(color);
    }

    private static BlockBehaviour.Properties metalBuilder(MapColor color) {
        return builder(color, SoundType.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0f);
    }

    private static void addTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        output.accept(BRONZE.getNugget());
        output.accept(BRONZE.getIngot());
        output.accept(BRONZE.get());
    }

}
