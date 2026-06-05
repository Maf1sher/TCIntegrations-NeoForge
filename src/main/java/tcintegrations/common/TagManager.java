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

        public static final TagKey<Item> BOTANIA_LIVINGWOOD_LOGS = itemTag("botania", "livingwood_logs");
        public static final TagKey<Item> MYSTICAL_FLOWERS = itemTag("botania", "mystical_flowers");
        public static final TagKey<Item> DOUBLE_MYSTICAL_FLOWERS = itemTag("botania", "double_mystical_flowers");
        public static final TagKey<Item> LIVINGWOOD_LOGS = itemTag("botania", "livingwood_logs");
        public static final TagKey<Item> LIVINGWOOD_LOGS_GLIMMERING = itemTag("botania", "glimmering_livingwood_logs");
        public static final TagKey<Item> INGOTS_TERRASTEEL = itemTag("forge", "ingots/terrasteel");
        public static final TagKey<Item> INGOTS_ELEMENTIUM = itemTag("forge", "ingots/elementium");

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

        public static final TagKey<Item> CHEESE = itemTag("forge", "cheese");

        public static final TagKey<Item> SOURCE_GEM = itemTag("forge", "gems/source");
        public static final TagKey<Item> SOURCE_GEM_BLOCK = itemTag("forge", "storage_blocks/source_gem");

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
