package tcintegrations.data.tcon.fluid;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import slimeknights.tconstruct.common.TinkerTags;

import tcintegrations.items.TCIntegrationsItems;
import tcintegrations.TCIntegrations;

@SuppressWarnings("unchecked")
public class FluidTagProvider extends FluidTagsProvider {

    public FluidTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, TCIntegrations.MODID, helper);
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Fluid Tags";
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        if (TCIntegrationsItems.MOLTEN_MANASTEEL != null) fluidTag(TCIntegrationsItems.MOLTEN_MANASTEEL);
        if (TCIntegrationsItems.MOLTEN_NEPTUNIUM != null) fluidTag(TCIntegrationsItems.MOLTEN_NEPTUNIUM);
        if (TCIntegrationsItems.MOLTEN_SOURCE_GEM != null) fluidTag(TCIntegrationsItems.MOLTEN_SOURCE_GEM);
        if (TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL != null) fluidTag(TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL);
        if (TCIntegrationsItems.MOLTEN_CLOGGRUM != null) fluidTag(TCIntegrationsItems.MOLTEN_CLOGGRUM);
        if (TCIntegrationsItems.MOLTEN_FROSTSTEEL != null) fluidTag(TCIntegrationsItems.MOLTEN_FROSTSTEEL);
        if (TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL != null) fluidTag(TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL);
        if (TCIntegrationsItems.MOLTEN_DESH != null) fluidTag(TCIntegrationsItems.MOLTEN_DESH);
        if (TCIntegrationsItems.MOLTEN_CALORITE != null) fluidTag(TCIntegrationsItems.MOLTEN_CALORITE);
        if (TCIntegrationsItems.MOLTEN_OSTRUM != null) fluidTag(TCIntegrationsItems.MOLTEN_OSTRUM);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null) fluidTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null) fluidTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null) fluidTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING);

        if (TCIntegrationsItems.MOLTEN_MANASTEEL != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_MANASTEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_NEPTUNIUM != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_NEPTUNIUM.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_CLOGGRUM != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_CLOGGRUM.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_FROSTSTEEL != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_FROSTSTEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DESH != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DESH.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_CALORITE != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_CALORITE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_OSTRUM != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_OSTRUM.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null)
            this.tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING.getCommonTag().location());

        if (TCIntegrationsItems.MOLTEN_MANASTEEL != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_MANASTEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_CLOGGRUM != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_CLOGGRUM.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_FROSTSTEEL != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_FROSTSTEEL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null)
            this.tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING.getCommonTag().location());

        if (TCIntegrationsItems.MOLTEN_NEPTUNIUM != null)
            this.tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_NEPTUNIUM.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL != null)
            this.tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null)
            this.tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null)
            this.tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE.getCommonTag().location());
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null)
            this.tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING.getCommonTag().location());

        if (TCIntegrationsItems.MOLTEN_SOURCE_GEM != null)
            this.tag(TinkerTags.Fluids.SMALL_GEM_TOOLTIPS)
                .addOptionalTag(TCIntegrationsItems.MOLTEN_SOURCE_GEM.getId());
    }

    private void fluidTag(FluidObject<?> fluid) {
        tag(Objects.requireNonNull(fluid.getCommonTag())).add(fluid.get());
    }

    /** Adds tags for a placable fluid */
    private void fluidTag(FlowingFluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
        TagKey<Fluid> tag = fluid.getCommonTag();

        if (tag != null) {
            tag(tag).addTag(fluid.getLocalTag());
        }
    }

}
