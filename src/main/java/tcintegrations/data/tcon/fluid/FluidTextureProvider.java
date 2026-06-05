package tcintegrations.data.tcon.fluid;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;

import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;

import tcintegrations.TCIntegrations;
import tcintegrations.items.TCIntegrationsItems;

import static slimeknights.tconstruct.TConstruct.getResource;

import static tcintegrations.util.ResourceLocationHelper.resource;

@SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
public class FluidTextureProvider extends AbstractFluidTextureProvider {

    public FluidTextureProvider(PackOutput packOutput) {
        super(packOutput, TCIntegrations.MODID);
    }

    @Override
    public @NotNull String getName() {
        return "TCIntegrations - TCon Fluid Textures";
    }

    @Override
    public void addTextures() {
        if (TCIntegrationsItems.MOLTEN_CLOGGRUM != null) tintedStone(TCIntegrationsItems.MOLTEN_CLOGGRUM).color(0xFFB79A7A);
        if (TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL != null) compatAlloy(TCIntegrationsItems.MOLTEN_FORGOTTEN_METAL);
        if (TCIntegrationsItems.MOLTEN_FROSTSTEEL != null) compatAlloy(TCIntegrationsItems.MOLTEN_FROSTSTEEL);
        if (TCIntegrationsItems.MOLTEN_MANASTEEL != null) compatAlloy(TCIntegrationsItems.MOLTEN_MANASTEEL);
        if (TCIntegrationsItems.MOLTEN_NEPTUNIUM != null) compatAlloy(TCIntegrationsItems.MOLTEN_NEPTUNIUM);
        if (TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL != null) compatAlloy(TCIntegrationsItems.MOLTEN_SOUL_STAINED_STEEL);
        if (TCIntegrationsItems.MOLTEN_SOURCE_GEM != null) compatOre(TCIntegrationsItems.MOLTEN_SOURCE_GEM);
        if (TCIntegrationsItems.MOLTEN_DESH != null) tintedStone(TCIntegrationsItems.MOLTEN_DESH).color(0xFFCD7F48);
        if (TCIntegrationsItems.MOLTEN_CALORITE != null) tintedStone(TCIntegrationsItems.MOLTEN_CALORITE).color(0xFFC24148);
        if (TCIntegrationsItems.MOLTEN_OSTRUM != null) tintedStone(TCIntegrationsItems.MOLTEN_OSTRUM).color(0xFF73515E);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE != null) compatAlloy(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_FIRE);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE != null) compatAlloy(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_ICE);
        if (TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING != null) compatAlloy(TCIntegrationsItems.MOLTEN_DRAGONSTEEL_LIGHTNING);
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(resource("fluid/" + name + "/"), false, false);
    }

    private FluidTexture.Builder namedTcon(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(getResource("fluid/" + name + "/"), false, false);
    }

    private FluidTexture.Builder moltenFolder(FluidObject<?> fluid, String folder) {
        return named(fluid, "molten/" + folder + "/" + fluid.getId().getPath());
    }

    private FluidTexture.Builder compatAlloy(FluidObject<?> fluid) {
        return moltenFolder(fluid, "compat_alloy");
    }

    private FluidTexture.Builder compatOre(FluidObject<?> fluid) {
        return moltenFolder(fluid, "compat_ore");
    }

    private FluidTexture.Builder tintedStone(FluidObject<?> fluid) {
        return namedTcon(fluid, "molten/stone");
    }

}
