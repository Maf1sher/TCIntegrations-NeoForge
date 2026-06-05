package tcintegrations.util;

import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public record ModItemRef(ResourceLocation id) implements Supplier<Item> {
    private static boolean isDataGen = false;

    public static void setDataGenMode(boolean value) {
        isDataGen = value;
    }

    @Override
    public Item get() {
        if (isDataGen) return Items.STONE;
        Item item = BuiltInRegistries.ITEM.get(id);
        return item == Items.AIR ? Items.STONE : item;
    }

    public static ModItemRef of(String namespace, String path) {
        return new ModItemRef(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }
}
