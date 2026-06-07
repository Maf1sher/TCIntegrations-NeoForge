package tcintegrations.data.tcon.material;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class MaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    public MaterialRenderInfoProvider(PackOutput packOutput, AbstractMaterialSpriteProvider spriteProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, spriteProvider, existingFileHelper);
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Material Render Info Provider";
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(MaterialIds.neptunium).color(0x1AF5B9).fallbacks("metal");
        buildRenderInfo(MaterialIds.soulStainedSteel).color(0xA96EC7).fallbacks("metal");
        buildRenderInfo(MaterialIds.brass);
        buildRenderInfo(MaterialIds.dragonsteelFire).color(0x77717C).fallbacks("metal");
        buildRenderInfo(MaterialIds.dragonsteelIce).color(0xE0F3FD).fallbacks("metal");
        buildRenderInfo(MaterialIds.dragonsteelLightning).color(0x6B6091).fallbacks("metal");

        buildRenderInfo(MaterialIds.bronze).color(0xD4874F).fallbacks("metal");
        buildRenderInfo(MaterialIds.cloggrum).color(0x5D4926).fallbacks("metal");
        buildRenderInfo(MaterialIds.froststeel).color(0x9DC6F2).fallbacks("metal");
        buildRenderInfo(MaterialIds.forgottenMetal).color(0x7536A7).fallbacks("metal");
        buildRenderInfo(MaterialIds.sourceGem).color(0xD4F5F9).fallbacks("gem");
    }

}
