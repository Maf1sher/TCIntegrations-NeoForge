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
            .addOptional(TciModifierIds.engineersGoggles.getLocation())
            .addOptional(TciModifierIds.multiVision.getLocation())
            .addOptional(TciModifierIds.waterPowered.getLocation())
            .addOptional(TciModifierIds.capturing.getLocation());

        // Melee upgrades
        this.tag(MELEE_UPGRADES)
            .addOptional(TciModifierIds.soulStained.getLocation())
            .addOptional(TciModifierIds.siren.getLocation())
            .addOptional(TciModifierIds.utherium.getLocation())
            .addOptional(TciModifierIds.flamed.getLocation())
            .addOptional(TciModifierIds.iced.getLocation())
            .addOptional(TciModifierIds.zapped.getLocation())
            .addOptional(TciModifierIds.forgottenTrait.getLocation())
            .addOptional(TciModifierIds.precipitate.getLocation())
            .addOptional(TciModifierIds.twilit.getLocation());

        // Harvest upgrades
        this.tag(HARVEST_UPGRADES)
            .addOptional(TciModifierIds.siren.getLocation())
            .addOptional(TciModifierIds.froststeelTrait.getLocation())
            .addOptional(TciModifierIds.forgottenTrait.getLocation())
            .addOptional(TciModifierIds.precipitate.getLocation())
            .addOptional(TciModifierIds.twilit.getLocation());

        // Ranged upgrades
        this.tag(RANGED_UPGRADES)
            .addOptional(TciModifierIds.flamed.getLocation())
            .addOptional(TciModifierIds.iced.getLocation())
            .addOptional(TciModifierIds.zapped.getLocation())
            .addOptional(TciModifierIds.precipitate.getLocation())
            .addOptional(TciModifierIds.twilit.getLocation());

        // Armor upgrades (general)
        this.tag(GENERAL_ARMOR_UPGRADES)
            .addOptional(TciModifierIds.soulStained.getLocation())
            .addOptional(TciModifierIds.dragonScales.getLocation())
            .addOptional(TciModifierIds.sculking.getLocation());

        // Helmet upgrades
        this.tag(HELMET_UPGRADES)
            .addOptional(TciModifierIds.frontierCap.getLocation())
            .addOptional(TciModifierIds.turtleShell.getLocation())
            .addOptional(TciModifierIds.bisonFur.getLocation());

        // Chestplate upgrades
        this.tag(CHESTPLATE_UPGRADES)
            .addOptional(TciModifierIds.shieldOfTheDeep.getLocation())
            .addOptional(TciModifierIds.crocodile.getLocation());

        // Boot upgrades
        this.tag(BOOT_UPGRADES)
            .addOptional(TciModifierIds.roadrunner.getLocation())
            .addOptional(TciModifierIds.mosquito.getLocation());

        // General abilities
        this.tag(GENERAL_ABILITIES)
            .addOptional(TciModifierIds.mechanicalArm.getLocation())
            .addOptional(TciModifierIds.poseidon.getLocation())
            .addOptional(TciModifierIds.kinetic.getLocation())
            .addOptional(TciModifierIds.phantasmal.getLocation());

        // Interaction abilities
        this.tag(INTERACTION_ABILITIES)
            .addOptional(TciModifierIds.glowup.getLocation());
    }

    @Override
    public String getName() {
        return "TCIntegrations - TCon Modifier Tag Provider";
    }

}
