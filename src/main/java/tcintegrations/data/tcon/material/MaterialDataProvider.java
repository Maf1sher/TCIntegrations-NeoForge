package tcintegrations.data.tcon.material;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;

import slimeknights.mantle.recipe.condition.TagFilledCondition;
import slimeknights.tconstruct.common.json.ConfigEnabledCondition;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import tcintegrations.data.integration.ModIntegration;

import java.util.List;

public class MaterialDataProvider extends AbstractMaterialDataProvider {

    public MaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Materials";
    }

    @Override
    protected void addMaterials() {
        // Bronze: unconditional, always available
        addMaterial(MaterialIds.bronze, 2, ORDER_GENERAL, false);

        // Botania
        ICondition botaniaCondition = modOrTagCondition(ModIntegration.BOTANIA_MODID, "manasteel");
        addMaterial(MaterialIds.livingWood, 1, ORDER_GENERAL, true, false, new ModLoadedCondition(ModIntegration.BOTANIA_MODID));
        addMaterial(MaterialIds.livingRock, 1, ORDER_GENERAL, true, false, new ModLoadedCondition(ModIntegration.BOTANIA_MODID));
        addMaterial(MaterialIds.manaSteel, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, botaniaCondition);
        addMaterial(MaterialIds.manaString, 3, ORDER_COMPAT + ORDER_GENERAL, true, false, new ModLoadedCondition(ModIntegration.BOTANIA_MODID));
        addMaterial(MaterialIds.neptunium, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.AQUACULTURE_MODID, "neptunium"));

        // Malum
        addMaterial(MaterialIds.soulStainedSteel, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.MALUM_MODID, "soul_stained_steel"));

        // Create
        addMaterial(MaterialIds.brass, 3, ORDER_COMPAT + ORDER_REPAIR, false, false, modOrTagCondition(ModIntegration.CREATE_MODID, "brass"));

        // Undergarden
        ICondition undergardenCondition = modOrTagCondition(ModIntegration.UNDERGARDEN_MODID, "cloggrum");
        addMaterial(MaterialIds.cloggrum, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, undergardenCondition);
        addMaterial(MaterialIds.froststeel, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, undergardenCondition);
        addMaterial(MaterialIds.forgottenMetal, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, undergardenCondition);

        // Ars Nouveau
        addMaterial(MaterialIds.sourceGem, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.ARS_MODID, "source_gem"));

        // Ice and Fire
        addMaterial(MaterialIds.dragonsteelFire, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_fire"));
        addMaterial(MaterialIds.dragonsteelIce, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_ice"));
        addMaterial(MaterialIds.dragonsteelLightning, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, modOrTagCondition(ModIntegration.IFD_MODID, "dragonsteel_lightning"));
    }

    /** Condition: mod loaded OR c:ingots/X tag filled OR forge:ingots/X tag filled */
    private static ICondition modOrTagCondition(String modId, String ingotName) {
        return new OrCondition(List.of(
            ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS,
            new ModLoadedCondition(modId),
            new TagFilledCondition<>(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ingotName)),
            new TagFilledCondition<>(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", "ingots/" + ingotName))
        ));
    }
}
