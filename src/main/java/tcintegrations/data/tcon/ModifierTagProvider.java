package tcintegrations.data.tcon;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import slimeknights.tconstruct.library.data.tinkering.AbstractModifierTagProvider;

import tcintegrations.data.tcon.material.TciModifierIds;

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
        // General upgrades (always available + mod-gated)
        this.tag(GENERAL_UPGRADES)
            .addOptional(TciModifierIds.livingwood.location())
            .addOptional(TciModifierIds.engineersGoggles.location())
            .addOptional(TciModifierIds.multiVision.location())
            .addOptional(TciModifierIds.waterPowered.location())
            .addOptional(TciModifierIds.capturing.location());

        // Melee upgrades
        this.tag(MELEE_UPGRADES)
            .addOptional(TciModifierIds.soulStained.location())
            .addOptional(TciModifierIds.siren.location())
            .addOptional(TciModifierIds.utherium.location())
            .addOptional(TciModifierIds.flamed.location())
            .addOptional(TciModifierIds.iced.location())
            .addOptional(TciModifierIds.zapped.location())
            .addOptional(TciModifierIds.forgottenTrait.location())
            .addOptional(TciModifierIds.precipitate.location())
            .addOptional(TciModifierIds.twilit.location());

        // Harvest upgrades
        this.tag(HARVEST_UPGRADES)
            .addOptional(TciModifierIds.siren.location())
            .addOptional(TciModifierIds.froststeelTrait.location())
            .addOptional(TciModifierIds.forgottenTrait.location())
            .addOptional(TciModifierIds.precipitate.location())
            .addOptional(TciModifierIds.twilit.location());

        // Ranged upgrades
        this.tag(RANGED_UPGRADES)
            .addOptional(TciModifierIds.flamed.location())
            .addOptional(TciModifierIds.iced.location())
            .addOptional(TciModifierIds.zapped.location())
            .addOptional(TciModifierIds.precipitate.location())
            .addOptional(TciModifierIds.twilit.location());

        // Armor upgrades (general)
        this.tag(GENERAL_ARMOR_UPGRADES)
            .addOptional(TciModifierIds.masticate.location())
            .addOptional(TciModifierIds.soulStained.location())
            .addOptional(TciModifierIds.dragonScales.location())
            .addOptional(TciModifierIds.sculking.location());

        // Helmet upgrades
        this.tag(HELMET_UPGRADES)
            .addOptional(TciModifierIds.frontierCap.location())
            .addOptional(TciModifierIds.turtleShell.location())
            .addOptional(TciModifierIds.bisonFur.location());

        // Chestplate upgrades
        this.tag(CHESTPLATE_UPGRADES)
            .addOptional(TciModifierIds.shieldOfTheDeep.location())
            .addOptional(TciModifierIds.crocodile.location());

        // Boot upgrades
        this.tag(BOOT_UPGRADES)
            .addOptional(TciModifierIds.roadrunner.location())
            .addOptional(TciModifierIds.mosquito.location());

        // General abilities
        this.tag(GENERAL_ABILITIES)
            .addOptional(TciModifierIds.mechanicalArm.location())
            .addOptional(TciModifierIds.poseidon.location())
            .addOptional(TciModifierIds.kinetic.location())
            .addOptional(TciModifierIds.phantasmal.location());

        // Interaction abilities
        this.tag(INTERACTION_ABILITIES)
            .addOptional(TciModifierIds.glowup.location());
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Modifier Tag Provider";
    }

}
