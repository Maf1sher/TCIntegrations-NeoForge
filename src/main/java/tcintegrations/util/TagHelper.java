package tcintegrations.util;

import java.util.Objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.datamaps.DataMapFile;

public class TagHelper {

    public static TagKey<Item> getTag(ResourceLocation loc) {
        return TagKey.create(Registries.ITEM, loc);
    }

    public static TagKey<Item> getTag(TagKey<Item> name) {
        return name;
    }

}
