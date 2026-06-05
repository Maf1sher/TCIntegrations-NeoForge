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
        ICondition botaniaLoadedCondition = new ModLoadedCondition(ModIntegration.BOTANIA_MODID);

        addMaterial(MaterialIds.livingWood, 1, ORDER_GENERAL, true, false, botaniaLoadedCondition);
        addMaterial(MaterialIds.livingRock, 1, ORDER_GENERAL, true, false, botaniaLoadedCondition);
        addMaterial(MaterialIds.desh, 2, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("desh"));
        addMaterial(MaterialIds.calorite, 2, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("calorite"));
        addMaterial(MaterialIds.ostrum, 2, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("ostrum"));
        addMaterial(MaterialIds.manaSteel, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("manasteel"));
        addMaterial(MaterialIds.manaString, 3, ORDER_COMPAT + ORDER_GENERAL, true, false, botaniaLoadedCondition);
        addMaterial(MaterialIds.neptunium, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("neptunium"));
        addMaterial(MaterialIds.soulStainedSteel, 3, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("soul_stained_steel"));
        addMaterial(MaterialIds.brass, 3, ORDER_COMPAT + ORDER_REPAIR, false, false, dualTagIngotCondition("brass"));
        addMaterial(MaterialIds.pendoriteAlloy, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("pendorite_alloy"));
        addMaterial(MaterialIds.dragonsteelFire, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("dragonsteel_fire"));
        addMaterial(MaterialIds.dragonsteelIce, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("dragonsteel_ice"));
        addMaterial(MaterialIds.dragonsteelLightning, 4, ORDER_COMPAT + ORDER_GENERAL, false, false, dualTagIngotCondition("dragonsteel_lightning"));
    }

    private static ICondition dualTagIngotCondition(String name) {
        return new OrCondition(List.of(
            ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS,
            new TagFilledCondition<>(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/" + name)),
            new TagFilledCondition<>(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", "ingots/" + name))
        ));
    }

}
