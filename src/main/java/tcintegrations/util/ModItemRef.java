package tcintegrations.util;

import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public record ModItemRef(ResourceLocation id) implements Supplier<Item> {

    @Override
    public Item get() {
        return BuiltInRegistries.ITEM.get(id);
    }

    public static ModItemRef of(String namespace, String path) {
        return new ModItemRef(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }
}
