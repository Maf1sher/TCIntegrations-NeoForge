package tcintegrations.data.tcon.material;

import net.minecraft.data.PackOutput;

import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.GripMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.LimbMaterialStats;
import slimeknights.tconstruct.tools.stats.PlatingMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.IRON;
import static net.minecraft.world.item.Tiers.NETHERITE;

public class MaterialStatsDataProvider extends AbstractMaterialStatsDataProvider {

    public MaterialStatsDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Material Stats";
    }

    @Override
    protected void addMaterialStats() {
        // head order is durability, mining speed, mining level, damage

        // tier 2 (vanilla bronze)
        addMaterialStats(MaterialIds.bronze,
            new HeadMaterialStats(350, 5F, IRON, 2F),
            new LimbMaterialStats(350, -0.05F, 0.05F, 0),
            new GripMaterialStats(0.05F, 0F, 2F),
            HandleMaterialStats.multipliers().durability(1.10F).miningSpeed(1.05F).build(),
            StatlessMaterialStats.BINDING);

        // tier 3 (mod integration)
        addMaterialStats(MaterialIds.brass,
            new HeadMaterialStats(730, 6F, DIAMOND, 2.25F),
            new LimbMaterialStats(730, -0.2f, 0.15f, -0.2f),
            new GripMaterialStats(0.1f, 0f, 2.25f),
            HandleMaterialStats.multipliers().durability(1.05F).miningSpeed(1.15F).build(),
            StatlessMaterialStats.BINDING);
        addMaterialStats(MaterialIds.neptunium,
            new HeadMaterialStats(765, 7F, DIAMOND, 2.65F),
            HandleMaterialStats.multipliers().durability(1.15F).miningSpeed(1.25F).attackSpeed(1.2F).build(),
            new LimbMaterialStats(765, -0.25F, 0.18F, -0.15F),
            new GripMaterialStats(0.05F, -0.05F, 2.5F),
            StatlessMaterialStats.BINDING);
        addMaterialStats(MaterialIds.soulStainedSteel,
            new HeadMaterialStats(785, 6F, DIAMOND, 2.75F),
            new LimbMaterialStats(785, -0.3F, 0.2F, -0.1F),
            new GripMaterialStats(0.1F, -0.05F, 2.75F),
            HandleMaterialStats.multipliers().durability(1.05F).miningSpeed(1.05F).attackSpeed(1.05F).build(),
            StatlessMaterialStats.BINDING);
        addArmorShieldStats(MaterialIds.soulStainedSteel,
            PlatingMaterialStats.builder()
                .durabilityFactor(29)
                .armor(2, 6, 7, 3)
                .toughness(2),
            StatlessMaterialStats.MAILLE);

        // tier 4 (mod integration)
        addMaterialStats(MaterialIds.dragonsteelFire, new HeadMaterialStats(2500, 6.5F, NETHERITE, 20F));
        addArmorShieldStats(MaterialIds.dragonsteelFire,
            PlatingMaterialStats.builder()
                .durabilityFactor(60)
                .armor(6, 9, 12, 7)
                .toughness(4),
            StatlessMaterialStats.MAILLE);
        addMaterialStats(MaterialIds.dragonsteelIce, new HeadMaterialStats(2500, 6.5F, NETHERITE, 20F));
        addArmorShieldStats(MaterialIds.dragonsteelIce,
            PlatingMaterialStats.builder()
                .durabilityFactor(60)
                .armor(6, 9, 12, 7)
                .toughness(4),
            StatlessMaterialStats.MAILLE);
        addMaterialStats(MaterialIds.dragonsteelLightning, new HeadMaterialStats(2500, 6.5F, NETHERITE, 20F));
        addArmorShieldStats(MaterialIds.dragonsteelLightning,
            PlatingMaterialStats.builder()
                .durabilityFactor(60)
                .armor(6, 9, 12, 7)
                .toughness(4),
            StatlessMaterialStats.MAILLE);

        // Undergarden
        addMaterialStats(MaterialIds.cloggrum,
            new HeadMaterialStats(700, 5.5F, DIAMOND, 2.25F),
            new LimbMaterialStats(700, -0.25F, 0.15F, -0.1F),
            new GripMaterialStats(0.05F, 0F, 2.25F),
            HandleMaterialStats.multipliers().durability(1.05F).miningSpeed(1.1F).build(),
            StatlessMaterialStats.BINDING);
        addMaterialStats(MaterialIds.froststeel,
            new HeadMaterialStats(750, 6F, DIAMOND, 2.5F),
            new LimbMaterialStats(750, -0.25F, 0.15F, -0.1F),
            new GripMaterialStats(0.1F, -0.05F, 2.5F),
            HandleMaterialStats.multipliers().durability(1.1F).miningSpeed(1.1F).attackDamage(1.05F).build(),
            StatlessMaterialStats.BINDING);
        addMaterialStats(MaterialIds.forgottenMetal,
            new HeadMaterialStats(1550, 9F, NETHERITE, 3.5F),
            new LimbMaterialStats(1550, -0.05F, 0.15F, 0.05F),
            new GripMaterialStats(0.15F, -0.1F, 3.5F),
            HandleMaterialStats.multipliers().durability(1.3F).miningSpeed(1.3F).attackDamage(1.2F).build(),
            StatlessMaterialStats.BINDING);

        // Ars Nouveau
        addMaterialStats(MaterialIds.sourceGem, StatlessMaterialStats.BINDING);
    }

}
