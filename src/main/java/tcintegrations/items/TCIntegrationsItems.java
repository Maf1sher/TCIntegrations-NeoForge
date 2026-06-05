package tcintegrations.items;

import java.util.function.Function;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;

import slimeknights.mantle.item.BlockTooltipItem;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.MetalItemObject;

import slimeknights.tconstruct.world.TinkerWorld;

import tcintegrations.TCIntegrations;
import tcintegrations.common.TCIntegrationsModule;

public final class TCIntegrationsItems extends TCIntegrationsModule {

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM_TAB_GROUP;
    public static Function<Block, ? extends BlockItem> GENERAL_TOOLTIP_BLOCK_ITEM;

    public static MetalItemObject BRONZE;

    // Molten fluid objects
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_MANASTEEL;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_NEPTUNIUM;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_SOURCE_GEM;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_SOUL_STAINED_STEEL;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_CLOGGRUM;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_FROSTSTEEL;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_FORGOTTEN_METAL;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_DESH;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_CALORITE;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_OSTRUM;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_DRAGONSTEEL_FIRE;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_DRAGONSTEEL_ICE;
    public static FlowingFluidObject<BaseFlowingFluid> MOLTEN_DRAGONSTEEL_LIGHTNING;

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

        // Molten fluids
        MOLTEN_MANASTEEL = FLUID_REGISTRY.register("molten_manasteel")
            .type(hot("molten_manasteel").temperature(1100).lightLevel(12))
            .burningBlock(MapColor.COLOR_BLUE, 12, 10, 5f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_NEPTUNIUM = FLUID_REGISTRY.register("molten_neptunium")
            .type(hot("molten_neptunium").temperature(1300).lightLevel(10))
            .burningBlock(MapColor.WARPED_NYLIUM, 10, 10, 6f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_SOURCE_GEM = FLUID_REGISTRY.register("molten_source_gem")
            .type(hot("molten_source_gem").temperature(1200).lightLevel(9))
            .burningBlock(MapColor.COLOR_LIGHT_BLUE, 9, 10, 6f)
            .bucket()
            .flowing();
        MOLTEN_SOUL_STAINED_STEEL = FLUID_REGISTRY.register("molten_soul_stained_steel")
            .type(hot("molten_soul_stained_steel").temperature(1100).lightLevel(11))
            .burningBlock(MapColor.COLOR_PURPLE, 11, 10, 5f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_CLOGGRUM = FLUID_REGISTRY.register("molten_cloggrum")
            .type(hot("molten_cloggrum").temperature(1000).lightLevel(9))
            .burningBlock(MapColor.TERRACOTTA_ORANGE, 9, 10, 5f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_FROSTSTEEL = FLUID_REGISTRY.register("molten_froststeel")
            .type(hot("molten_froststeel").temperature(900).lightLevel(7))
            .burningBlock(MapColor.ICE, 7, 10, 4f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_FORGOTTEN_METAL = FLUID_REGISTRY.register("molten_forgotten_metal")
            .type(hot("molten_forgotten_metal").temperature(1400).lightLevel(13))
            .burningBlock(MapColor.COLOR_GREEN, 13, 10, 7f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_DESH = FLUID_REGISTRY.register("molten_desh")
            .type(hot("molten_desh").temperature(1200).lightLevel(10))
            .burningBlock(MapColor.TERRACOTTA_BROWN, 10, 10, 6f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_CALORITE = FLUID_REGISTRY.register("molten_calorite")
            .type(hot("molten_calorite").temperature(1400).lightLevel(12))
            .burningBlock(MapColor.COLOR_RED, 12, 10, 7f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_OSTRUM = FLUID_REGISTRY.register("molten_ostrum")
            .type(hot("molten_ostrum").temperature(1300).lightLevel(11))
            .burningBlock(MapColor.TERRACOTTA_MAGENTA, 11, 10, 6f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_DRAGONSTEEL_FIRE = FLUID_REGISTRY.register("molten_dragonsteel_fire")
            .type(hot("molten_dragonsteel_fire").temperature(1500).lightLevel(15))
            .burningBlock(MapColor.FIRE, 15, 10, 8f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_DRAGONSTEEL_ICE = FLUID_REGISTRY.register("molten_dragonsteel_ice")
            .type(hot("molten_dragonsteel_ice").temperature(800).lightLevel(6))
            .burningBlock(MapColor.COLOR_CYAN, 6, 10, 4f)
            .bucket()
            .commonTag()
            .flowing();
        MOLTEN_DRAGONSTEEL_LIGHTNING = FLUID_REGISTRY.register("molten_dragonsteel_lightning")
            .type(hot("molten_dragonsteel_lightning").temperature(1400).lightLevel(14))
            .burningBlock(MapColor.COLOR_YELLOW, 14, 10, 7f)
            .bucket()
            .commonTag()
            .flowing();
    }

    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create()
            .density(2000).viscosity(10000).temperature(1000)
            .descriptionId(ResourceLocation.fromNamespaceAndPath(TCIntegrations.MODID, name).toLanguageKey("fluid"))
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .motionScale(0.0023333333333333335D)
            .canSwim(false).canDrown(false)
            .pathType(net.minecraft.world.level.pathfinder.PathType.LAVA)
            .adjacentPathType(null);
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
