package tcintegrations.data.tcon;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.tconstruct.library.data.tinkering.AbstractModifierTagProvider;

import tcintegrations.data.tcon.material.TciModifierIds;
import tcintegrations.items.TCIntegrationsModifiers;

import static slimeknights.tconstruct.common.TinkerTags.Modifiers.BOOT_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.CHESTPLATE_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.GENERAL_ABILITIES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.GENERAL_ARMOR_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.GENERAL_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.HARVEST_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.HELMET_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.INTERACTION_ABILITIES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.MELEE_UPGRADES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.RANGED_UPGRADES;

public class ModifierTagProvider extends AbstractModifierTagProvider {

    public ModifierTagProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        var generalUpgrades = this.tag(GENERAL_UPGRADES)
            .addOptional(TciModifierIds.livingwood.location())
            .addOptional(TciModifierIds.engineersGoggles.location())
            .addOptional(TciModifierIds.multiVision.location());
        if (TCIntegrationsModifiers.ALF_MODIFIER != null) generalUpgrades.addOptional(TCIntegrationsModifiers.ALF_MODIFIER.getId());
        if (TCIntegrationsModifiers.ALFHEIM_MODIFIER != null) generalUpgrades.addOptional(TCIntegrationsModifiers.ALFHEIM_MODIFIER.getId());
        if (TCIntegrationsModifiers.TERRESTRIAL_MODIFIER != null) generalUpgrades.addOptional(TCIntegrationsModifiers.TERRESTRIAL_MODIFIER.getId());

        var meleeUpgrades = this.tag(MELEE_UPGRADES);
        if (TCIntegrationsModifiers.TERRA_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.TERRA_MODIFIER.getId());
        if (TCIntegrationsModifiers.ELEMENTAL_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.ELEMENTAL_MODIFIER.getId());
        if (TCIntegrationsModifiers.SIREN_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.SIREN_MODIFIER.getId());
        if (TCIntegrationsModifiers.UTHERIUM_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.UTHERIUM_MODIFIER.getId());
        if (TCIntegrationsModifiers.FLAMED_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.FLAMED_MODIFIER.getId());
        if (TCIntegrationsModifiers.ICED_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.ICED_MODIFIER.getId());
        if (TCIntegrationsModifiers.ZAPPED_MODIFIER != null) meleeUpgrades.addOptional(TCIntegrationsModifiers.ZAPPED_MODIFIER.getId());

        var harvestUpgrades = this.tag(HARVEST_UPGRADES);
        if (TCIntegrationsModifiers.SIREN_MODIFIER != null) harvestUpgrades.addOptional(TCIntegrationsModifiers.SIREN_MODIFIER.getId());
        if (TCIntegrationsModifiers.FROSTSTEEL_MODIFIER != null) harvestUpgrades.addOptional(TCIntegrationsModifiers.FROSTSTEEL_MODIFIER.getId());
        if (TCIntegrationsModifiers.FORGOTTEN_MODIFIER != null) harvestUpgrades.addOptional(TCIntegrationsModifiers.FORGOTTEN_MODIFIER.getId());

        var generalArmor = this.tag(GENERAL_ARMOR_UPGRADES);
        if (TCIntegrationsModifiers.GREAT_FAIRY_MODIFIER != null) generalArmor.addOptional(TCIntegrationsModifiers.GREAT_FAIRY_MODIFIER.getId());
        if (TCIntegrationsModifiers.ALFHEIM_MODIFIER != null) generalArmor.addOptional(TCIntegrationsModifiers.ALFHEIM_MODIFIER.getId());
        if (TCIntegrationsModifiers.ARS_MODIFIER != null) generalArmor.addOptional(TCIntegrationsModifiers.ARS_MODIFIER.getId());
        if (TCIntegrationsModifiers.SOUL_STAINED_MODIFIER != null) generalArmor.addOptional(TCIntegrationsModifiers.SOUL_STAINED_MODIFIER.getId());
        generalArmor.addOptional(TciModifierIds.masticate.location());

        var generalAbilities = this.tag(GENERAL_ABILITIES);
        if (TCIntegrationsModifiers.MECHANICAL_ARM_MODIFIER != null) generalAbilities.addOptional(TCIntegrationsModifiers.MECHANICAL_ARM_MODIFIER.getId());
        if (TCIntegrationsModifiers.POSEIDON_MODIFIER != null) generalAbilities.addOptional(TCIntegrationsModifiers.POSEIDON_MODIFIER.getId());
        if (TCIntegrationsModifiers.ALFHEIM_MODIFIER != null) generalAbilities.addOptional(TCIntegrationsModifiers.ALFHEIM_MODIFIER.getId());

        var interactionAbilities = this.tag(INTERACTION_ABILITIES);
        if (TCIntegrationsModifiers.ALF_MODIFIER != null) interactionAbilities.addOptional(TCIntegrationsModifiers.ALF_MODIFIER.getId());
        if (TCIntegrationsModifiers.GLOWUP_MODIFIER != null) interactionAbilities.addOptional(TCIntegrationsModifiers.GLOWUP_MODIFIER.getId());

        var helmetUpgrades = this.tag(HELMET_UPGRADES);
        if (TCIntegrationsModifiers.FRONTIER_CAP_MODIFIER != null) helmetUpgrades.addOptional(TCIntegrationsModifiers.FRONTIER_CAP_MODIFIER.getId());
        if (TCIntegrationsModifiers.TURTLE_SHELL_MODIFIER != null) helmetUpgrades.addOptional(TCIntegrationsModifiers.TURTLE_SHELL_MODIFIER.getId());
        if (TCIntegrationsModifiers.BISON_FUR_MODIFIER != null) helmetUpgrades.addOptional(TCIntegrationsModifiers.BISON_FUR_MODIFIER.getId());

        var chestplateUpgrades = this.tag(CHESTPLATE_UPGRADES);
        if (TCIntegrationsModifiers.ENCHANTERS_SHIELD_MODIFIER != null) chestplateUpgrades.addOptional(TCIntegrationsModifiers.ENCHANTERS_SHIELD_MODIFIER.getId());
        if (TCIntegrationsModifiers.SHIELD_OF_THE_DEEP_MODIFIER != null) chestplateUpgrades.addOptional(TCIntegrationsModifiers.SHIELD_OF_THE_DEEP_MODIFIER.getId());
        if (TCIntegrationsModifiers.CROCODILE_MODIFIER != null) chestplateUpgrades.addOptional(TCIntegrationsModifiers.CROCODILE_MODIFIER.getId());

        var bootUpgrades = this.tag(BOOT_UPGRADES);
        if (TCIntegrationsModifiers.ROADRUNNER_MODIFIER != null) bootUpgrades.addOptional(TCIntegrationsModifiers.ROADRUNNER_MODIFIER.getId());
        if (TCIntegrationsModifiers.MOSQUITO_MODIFIER != null) bootUpgrades.addOptional(TCIntegrationsModifiers.MOSQUITO_MODIFIER.getId());

        var rangedUpgrades = this.tag(RANGED_UPGRADES);
        if (TCIntegrationsModifiers.FLAMED_MODIFIER != null) rangedUpgrades.addOptional(TCIntegrationsModifiers.FLAMED_MODIFIER.getId());
        if (TCIntegrationsModifiers.ICED_MODIFIER != null) rangedUpgrades.addOptional(TCIntegrationsModifiers.ICED_MODIFIER.getId());
        if (TCIntegrationsModifiers.ZAPPED_MODIFIER != null) rangedUpgrades.addOptional(TCIntegrationsModifiers.ZAPPED_MODIFIER.getId());
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Modifier Tag Provider";
    }

}
