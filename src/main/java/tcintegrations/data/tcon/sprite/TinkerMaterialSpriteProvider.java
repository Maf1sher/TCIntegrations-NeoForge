package tcintegrations.data.tcon.sprite;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import tcintegrations.data.tcon.material.MaterialIds;

public class TinkerMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "TCIntegrations - TCon Materials";
    }

    @Override
    protected void addAllMaterials() {
        // tier 3
        buildMaterial(MaterialIds.neptunium)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF01140F).addARGB(102, 0xFF03503A).addARGB(140, 0xFF056B50).addARGB(178, 0xFF0AE2A7).addARGB(216, 0xFF17F4B8).addARGB(255, 0xFF8CFBDC).build());
        buildMaterial(MaterialIds.soulStainedSteel)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF2D2349).addARGB(102, 0xFF40365B).addARGB(140, 0xFF593b7C).addARGB(178, 0xFF8A5EAE).addARGB(216, 0xFFA96EC7).addARGB(255, 0xFFEE8FFF).build());
        buildMaterial(MaterialIds.brass)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF563B1F).addARGB(102, 0xFF775633).addARGB(140, 0xFFA0763E).addARGB(178, 0xFFCCA353).addARGB(216, 0xFFEDD578).addARGB(255, 0xFFFCF7AE).build());
        // tier 4
        buildMaterial(MaterialIds.dragonsteelFire)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF070202).addARGB(102, 0xFF29080a).addARGB(140, 0xFF77717c).addARGB(178, 0xFF8f8e9a).addARGB(216, 0xFF828a9a).addARGB(255, 0xFFccd2db).build());
        buildMaterial(MaterialIds.dragonsteelIce)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF284754).addARGB(102, 0xFF325C73).addARGB(140, 0xFFA4D2F9).addARGB(178, 0xFFDBF1FD).addARGB(216, 0xFFE0F3FD).addARGB(255, 0xFFFCFCFC).build());
        buildMaterial(MaterialIds.dragonsteelLightning)
            .meleeHarvest().armor()
            .fallbacks("metal")
            .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF1D1726).addARGB(102, 0xFF261C61).addARGB(140, 0xFF594470).addARGB(178, 0xFF554589).addARGB(216, 0xFF6B6091).addARGB(255, 0xFFCCCCDC).build());
    }

}