package tcintegrations.data;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.Tags;

import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.shared.TinkerMaterials;

import tcintegrations.common.TagManager;
import tcintegrations.data.integration.ModIntegration;
import tcintegrations.items.TCIntegrationsItems;
import tcintegrations.TCIntegrations;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ModBlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), TCIntegrations.MODID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "TCIntegrations - Item Tags";
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.copy(TagManager.Blocks.BRONZE, TagManager.Items.BRONZE);

        this.tag(Tags.Items.INGOTS)
            .add(TCIntegrationsItems.BRONZE.getIngot())
            .addOptional(ModIntegration.malumLoc("soul_stained_steel_ingot"));
        this.tag(Tags.Items.NUGGETS)
            .add(TCIntegrationsItems.BRONZE.getNugget())
            .addOptional(ModIntegration.malumLoc("soul_stained_steel_nugget"));

        this.tag(TagManager.Items.BRONZE_INGOTS).add(TCIntegrationsItems.BRONZE.getIngot());
        this.tag(TagManager.Items.BRONZE_NUGGETS).add(TCIntegrationsItems.BRONZE.getNugget());

        // Botania
        addBotaniaLogVariants(TagManager.Items.BOTANIA_LIVINGWOOD_LOGS, "livingwood");
        this.tag(TinkerTags.Items.VARIANT_LOGS).addOptionalTag(TagManager.Items.BOTANIA_LIVINGWOOD_LOGS.location());
        this.tag(TinkerTags.Items.VARIANT_PLANKS).addOptional(ModIntegration.botaniaLoc("livingwood_planks"));

        // Malum
        this.copy(TagManager.Blocks.SOUL_STAINED_STEEL, TagManager.Items.SOUL_STAINED_STEEL);
        this.tag(TagManager.Items.SOUL_STAINED_STEEL_INGOTS).addOptional(ModIntegration.malumLoc("soul_stained_steel_ingot"));
        this.tag(TagManager.Items.SOUL_STAINED_STEEL_NUGGETS).addOptional(ModIntegration.malumLoc("soul_stained_steel_nugget"));
        this.tag(TagManager.Items.SOUL_STAINED_STEEL_BLOCK_C).addOptional(ModIntegration.malumLoc("block_of_soul_stained_steel"));
        this.tag(TagManager.Items.SOUL_STAINED_STEEL_NUGGET_C).addOptional(ModIntegration.malumLoc("soul_stained_steel_nugget"));

        // Ice and Fire: Dragons
        this.tag(TagManager.Items.WITHER_BONES)
            .add(TinkerMaterials.necroticBone.get())
            .addOptional(ModIntegration.ifdLoc("witherbone"));
        this.copy(TagManager.Blocks.DRAGONSTEEL_FIRE, TagManager.Items.DRAGONSTEEL_FIRE);
        this.tag(TagManager.Items.DRAGONSTEEL_FIRE_INGOTS).addOptional(ModIntegration.ifdLoc("dragonsteel_fire_ingot"));
        this.copy(TagManager.Blocks.DRAGONSTEEL_ICE, TagManager.Items.DRAGONSTEEL_ICE);
        this.tag(TagManager.Items.DRAGONSTEEL_ICE_INGOTS).addOptional(ModIntegration.ifdLoc("dragonsteel_ice_ingot"));
        this.copy(TagManager.Blocks.DRAGONSTEEL_LIGHTNING, TagManager.Items.DRAGONSTEEL_LIGHTNING);
        this.tag(TagManager.Items.DRAGONSTEEL_LIGHTNING_INGOTS).addOptional(ModIntegration.ifdLoc("dragonsteel_lightning_ingot"));

        // Ars Nouveau
        this.tag(TagManager.Items.SOURCE_GEM)
            .addOptional(ModIntegration.arsLoc("source_gem"));
        this.tag(TagManager.Items.SOURCE_GEM_BLOCK)
            .addOptional(ModIntegration.arsLoc("source_gem_block"));
        this.tag(TagManager.Items.SOURCE_GEM_C)
            .addOptional(ModIntegration.arsLoc("source_gem"));
        this.tag(TagManager.Items.SOURCE_GEM_BLOCK_C)
            .addOptional(ModIntegration.arsLoc("source_gem_block"));

        // Aquaculture
        this.tag(TagManager.Items.TIN_CAN)
            .addOptional(ModIntegration.aquaLoc("tin_can"));
        this.tag(TagManager.Items.REDSTONE_HOOK)
            .addOptional(ModIntegration.aquaLoc("redstone_hook"));
        this.tag(TagManager.Items.IRON_HOOK)
            .addOptional(ModIntegration.aquaLoc("iron_hook"));
        this.tag(TagManager.Items.FISH_FILLET_RAW)
            .addOptional(ModIntegration.aquaLoc("fish_fillet_raw"));

        // Undergarden
        this.tag(TagManager.Items.UTHERIUM_CRYSTAL)
            .addOptional(ModIntegration.ugLoc("utherium_crystal"));

        // Twilight Forest
        this.tag(TagManager.Items.NAGA_SCALE)
            .addOptional(ModIntegration.twilightLoc("naga_scale"));
        this.tag(TagManager.Items.ARCTIC_FUR)
            .addOptional(ModIntegration.twilightLoc("arctic_fur"));

        // Deeper and Darker
        this.tag(TagManager.Items.REINFORCED_ECHO_SHARD)
            .addOptional(ModIntegration.deeperDarkerLoc("reinforced_echo_shard"));

        // Immersive Engineering
        this.tag(TagManager.Items.VOLTMETER)
            .addOptional(ModIntegration.ieLoc("voltmeter"));

        // Ensure integration metal ingots appear in both c: and forge: ingot tags
        addCompatibilityIngot("manasteel", ModIntegration.botaniaLoc("manasteel_ingot"));
        addCompatibilityIngot("neptunium", ModIntegration.aquaLoc("neptunium_ingot"));
        addCompatibilityIngot("soul_stained_steel", ModIntegration.malumLoc("soul_stained_steel_ingot"));
        addCompatibilityIngot("cloggrum", ModIntegration.ugLoc("cloggrum_ingot"));
        addCompatibilityIngot("froststeel", ModIntegration.ugLoc("froststeel_ingot"));
        addCompatibilityIngot("forgotten", ModIntegration.ugLoc("forgotten_ingot"));
        addCompatibilityIngot("dragonsteel_fire", ModIntegration.ifdLoc("dragonsteel_fire_ingot"));
        addCompatibilityIngot("dragonsteel_ice", ModIntegration.ifdLoc("dragonsteel_ice_ingot"));
        addCompatibilityIngot("dragonsteel_lightning", ModIntegration.ifdLoc("dragonsteel_lightning_ingot"));
        addCompatibilityIngot("fiery", ModIntegration.twilightLoc("fiery_ingot"));
        addCompatibilityIngot("steeleaf", ModIntegration.twilightLoc("steeleaf_ingot"));

        // Alex's Mobs
        this.tag(TagManager.Items.ROADRUNNER_FEATHER)
            .addOptional(ModIntegration.alexLoc("roadrunner_feather"));
        this.tag(TagManager.Items.SPIKED_SCUTE)
            .addOptional(ModIntegration.alexLoc("spiked_scute"));
        this.tag(TagManager.Items.BISON_FUR)
            .addOptional(ModIntegration.alexLoc("bison_fur"));
        this.tag(TagManager.Items.BEAR_FUR)
            .addOptional(ModIntegration.alexLoc("bear_fur"));
        this.tag(TagManager.Items.RACCOON_TAIL)
            .addOptional(ModIntegration.alexLoc("raccoon_tail"));
        this.tag(TagManager.Items.SERRATED_SHARK_TOOTH)
            .addOptional(ModIntegration.alexLoc("serrated_shark_tooth"));
        this.tag(TagManager.Items.SHARK_TOOTH)
            .addOptional(ModIntegration.alexLoc("shark_tooth"));
        this.tag(TagManager.Items.MOSQUITO_PROBOSCIS)
            .addOptional(ModIntegration.alexLoc("mosquito_proboscis"));
        this.tag(TagManager.Items.CROCODILE_SCUTE)
            .addOptional(ModIntegration.alexLoc("crocodile_scute"));

        // Ice and Fire: Dragon Bloods
        this.tag(TagManager.Items.FIRE_DRAGON_BLOOD)
            .addOptional(ModIntegration.ifdLoc("fire_dragon_blood"));
        this.tag(TagManager.Items.ICE_DRAGON_BLOOD)
            .addOptional(ModIntegration.ifdLoc("ice_dragon_blood"));
        this.tag(TagManager.Items.LIGHTNING_DRAGON_BLOOD)
            .addOptional(ModIntegration.ifdLoc("lightning_dragon_blood"));

        // Ice and Fire: Dragon Bone (item id is "dragonbone", not "dragon_bone")
        this.tag(TagManager.Items.DRAGON_BONE)
            .addOptional(ModIntegration.ifdLoc("dragonbone"));
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "bones/dragon")))
            .addOptional(ModIntegration.ifdLoc("dragonbone"));

        // Ice and Fire: Ghost Ingot
        this.tag(TagManager.Items.GHOST_INGOT)
            .addOptional(ModIntegration.ifdLoc("ghost_ingot"));

        // Ice and Fire: Dragonsteel storage blocks (both forge: and c:)
        this.tag(TagManager.Items.DRAGONSTEEL_FIRE)
            .addOptional(ModIntegration.ifdLoc("dragonsteel_fire_block"));
        this.tag(TagManager.Items.DRAGONSTEEL_ICE)
            .addOptional(ModIntegration.ifdLoc("dragonsteel_ice_block"));
        this.tag(TagManager.Items.DRAGONSTEEL_LIGHTNING)
            .addOptional(ModIntegration.ifdLoc("dragonsteel_lightning_block"));
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/dragonsteel_fire")))
            .addOptional(ModIntegration.ifdLoc("dragonsteel_fire_block"));
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/dragonsteel_ice")))
            .addOptional(ModIntegration.ifdLoc("dragonsteel_ice_block"));
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/dragonsteel_lightning")))
            .addOptional(ModIntegration.ifdLoc("dragonsteel_lightning_block"));

        // Mekanism: Refined Glowstone Ingot
        this.tag(TagManager.Items.INGOT_REFINED_GLOWSTONE)
            .addOptional(ModIntegration.mekanismLoc("ingot_refined_glowstone"));

        // Create: Mechanical Arm
        this.tag(TagManager.Items.MECHANICAL_ARM)
            .addOptional(ModIntegration.createLoc("mechanical_arm"));
    }

    /** Adds an ingot to both c:ingots/<name> and forge:ingots/<name> tags */
    private void addCompatibilityIngot(String name, ResourceLocation ingotLoc) {
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/" + name)))
            .addOptional(ingotLoc);
        this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", "ingots/" + name)))
            .addOptional(ingotLoc);
    }

    private void addBotaniaLogVariants(TagKey<Item> tag, String type) {
        this.tag(tag)
            .addOptional(ModIntegration.botaniaLoc(type + "_log"))
            .addOptional(ModIntegration.botaniaLoc("stripped_" + type + "_log"))
            .addOptional(ModIntegration.botaniaLoc(type))
            .addOptional(ModIntegration.botaniaLoc("stripped_" + type));
    }

}
