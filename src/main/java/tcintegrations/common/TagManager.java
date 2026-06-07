package tcintegrations.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import tcintegrations.TCIntegrations;

public class TagManager {

    public static class Blocks {
        public static final TagKey<Block> BRONZE = blockTag(TCIntegrations.MODID, "bronze");
        public static final TagKey<Block> SOUL_STAINED_STEEL = blockTag("forge", "storage_blocks/soul_stained_steel");
        public static final TagKey<Block> DRAGONSTEEL_FIRE = blockTag("forge", "storage_blocks/dragonsteel_fire");
        public static final TagKey<Block> DRAGONSTEEL_ICE = blockTag("forge", "storage_blocks/dragonsteel_ice");
        public static final TagKey<Block> DRAGONSTEEL_LIGHTNING = blockTag("forge", "storage_blocks/dragonsteel_lightning");
        public static final TagKey<Block> SOURCE_GEM_BLOCK = blockTag("forge", "storage_blocks/source_gem");

        private static TagKey<Block> blockTag(String modId, String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class Items {
        public static final TagKey<Item> BRONZE = itemTag(TCIntegrations.MODID, "bronze");
        public static final TagKey<Item> BRONZE_INGOTS = itemTag("forge", "ingots/bronze");
        public static final TagKey<Item> BRONZE_NUGGETS = itemTag("forge", "nuggets/bronze");

        public static final TagKey<Item> SOUL_STAINED_STEEL = itemTag("forge", "storage_blocks/soul_stained_steel");
        public static final TagKey<Item> SOUL_STAINED_STEEL_INGOTS = itemTag("forge", "ingots/soul_stained_steel");
        public static final TagKey<Item> SOUL_STAINED_STEEL_NUGGETS = itemTag("forge", "nuggets/soul_stained_steel");

        public static final TagKey<Item> WITHER_BONES = itemTag("forge", "wither_bones");
        public static final TagKey<Item> DRAGONSTEEL_FIRE = itemTag("forge", "storage_blocks/dragonsteel_fire");
        public static final TagKey<Item> DRAGONSTEEL_FIRE_INGOTS = itemTag("forge", "ingots/dragonsteel_fire");
        public static final TagKey<Item> DRAGONSTEEL_ICE = itemTag("forge", "storage_blocks/dragonsteel_ice");
        public static final TagKey<Item> DRAGONSTEEL_ICE_INGOTS = itemTag("forge", "ingots/dragonsteel_ice");
        public static final TagKey<Item> DRAGONSTEEL_LIGHTNING = itemTag("forge", "storage_blocks/dragonsteel_lightning");
        public static final TagKey<Item> DRAGONSTEEL_LIGHTNING_INGOTS = itemTag("forge", "ingots/dragonsteel_lightning");

        public static final TagKey<Item> SOURCE_GEM = itemTag("forge", "gems/source");
        public static final TagKey<Item> SOURCE_GEM_BLOCK = itemTag("forge", "storage_blocks/source_gem");
        public static final TagKey<Item> SOURCE_GEM_C = itemTag("c", "gems/source_gem");
        public static final TagKey<Item> SOURCE_GEM_BLOCK_C = itemTag("c", "storage_blocks/source_gem");

        public static final TagKey<Item> SOUL_STAINED_STEEL_BLOCK_C = itemTag("c", "storage_blocks/soul_stained_steel");
        public static final TagKey<Item> SOUL_STAINED_STEEL_NUGGET_C = itemTag("c", "nuggets/soul_stained_steel");

        // Ars Nouveau
        public static final TagKey<Item> MAGE_FIBER = itemTag("ars_nouveau", "mage_fiber");

        // Alex's Mobs
        public static final TagKey<Item> ROADRUNNER_FEATHER = itemTag(TCIntegrations.MODID, "roadrunner_feather");
        public static final TagKey<Item> SPIKED_SCUTE = itemTag(TCIntegrations.MODID, "spiked_scute");
        public static final TagKey<Item> BISON_FUR = itemTag(TCIntegrations.MODID, "bison_fur");
        public static final TagKey<Item> BEAR_FUR = itemTag(TCIntegrations.MODID, "bear_fur");
        public static final TagKey<Item> RACCOON_TAIL = itemTag(TCIntegrations.MODID, "raccoon_tail");
        public static final TagKey<Item> SERRATED_SHARK_TOOTH = itemTag(TCIntegrations.MODID, "serrated_shark_tooth");
        public static final TagKey<Item> SHARK_TOOTH = itemTag(TCIntegrations.MODID, "shark_tooth");
        public static final TagKey<Item> MOSQUITO_PROBOSCIS = itemTag(TCIntegrations.MODID, "mosquito_probosis");
        public static final TagKey<Item> CROCODILE_SCUTE = itemTag(TCIntegrations.MODID, "crocodile_scute");

        // Aquaculture
        public static final TagKey<Item> NEPTUNIUM_INGOT = itemTag("forge", "ingots/neptunium");
        public static final TagKey<Item> TIN_CAN = itemTag("aquaculture", "tin_can");
        public static final TagKey<Item> REDSTONE_HOOK = itemTag("aquaculture", "redstone_hook");
        public static final TagKey<Item> IRON_HOOK = itemTag("aquaculture", "iron_hook");
        public static final TagKey<Item> FISH_FILLET_RAW = itemTag("aquaculture", "fish_fillet_raw");

        // Create
        public static final TagKey<Item> MECHANICAL_ARM = itemTag("create", "mechanical_arm");

        // Mekanism
        public static final TagKey<Item> INGOT_REFINED_GLOWSTONE = itemTag("forge", "ingots/refined_glowstone");

        // Undergarden
        public static final TagKey<Item> CLOGGRUM_INGOT = itemTag("forge", "ingots/cloggrum");
        public static final TagKey<Item> FROSTSTEEL_INGOT = itemTag("forge", "ingots/froststeel");
        public static final TagKey<Item> FORGOTTEN_INGOT = itemTag("forge", "ingots/forgotten");
        public static final TagKey<Item> UTHERIUM_CRYSTAL = itemTag("undergarden", "utherium_crystal");

        // Ice and Fire
        public static final TagKey<Item> DRAGON_BONE = itemTag("forge", "bones/dragon");
        public static final TagKey<Item> FIRE_DRAGON_BLOOD = itemTag(TCIntegrations.MODID, "fire_dragon_blood");
        public static final TagKey<Item> ICE_DRAGON_BLOOD = itemTag(TCIntegrations.MODID, "ice_dragon_blood");
        public static final TagKey<Item> LIGHTNING_DRAGON_BLOOD = itemTag(TCIntegrations.MODID, "lightning_dragon_blood");
        public static final TagKey<Item> GHOST_INGOT = itemTag("forge", "ingots/ghost");

        // Deeper and Darker
        public static final TagKey<Item> REINFORCED_ECHO_SHARD = itemTag("deeperdarker", "reinforced_echo_shard");

        // Twilight Forest
        public static final TagKey<Item> FIERY_INGOT = itemTag("forge", "ingots/fiery");
        public static final TagKey<Item> ARCTIC_FUR = itemTag("twilightforest", "arctic_fur");
        public static final TagKey<Item> NAGA_SCALE = itemTag("twilightforest", "naga_scale");
        public static final TagKey<Item> STEELEAF_INGOT = itemTag("forge", "ingots/steeleaf");

        // Ars Elemental
        public static final TagKey<Item> AIR_ESSENCE = itemTag("ars_elemental", "air_essence");
        public static final TagKey<Item> WATER_ESSENCE = itemTag("ars_elemental", "water_essence");
        public static final TagKey<Item> EARTH_ESSENCE = itemTag("ars_elemental", "earth_essence");
        public static final TagKey<Item> FIRE_ESSENCE = itemTag("ars_elemental", "fire_essence");
        public static final TagKey<Item> MARK_OF_MASTERY = itemTag("ars_nouveau", "mark_of_mastery");

        // Immersive Engineering
        public static final TagKey<Item> VOLTMETER = itemTag("immersiveengineering", "voltmeter");

        private static TagKey<Item> itemTag(String modId, String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> ELEMENTAL_SEVERING_MOBS = entityTypeTag(TCIntegrations.MODID, "elemental_severing_mobs");
        public static final TagKey<EntityType<?>> MILK_PRODUCER = entityTypeTag(TCIntegrations.MODID, "milk_producer");

        private static TagKey<EntityType<?>> entityTypeTag(String modId, String path) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }
}
