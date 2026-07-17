package tcintegrations.data.tcon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class IfdMeltingRecipeProvider implements DataProvider {

    private final PackOutput packOutput;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public IfdMeltingRecipeProvider(PackOutput packOutput) {
        this.packOutput = packOutput;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Path base = packOutput.getOutputFolder().resolve("data/tcintegrations/recipe/smeltery/melting/metal");
        return CompletableFuture.allOf(
            generateSilver(base, cache),
            generateCopper(base, cache)
        );
    }

    @Override
    public String getName() {
        return "IFD Melting Recipes";
    }

    private CompletableFuture<?> generateSilver(Path base, CachedOutput cache) {
        Path silver = base.resolve("silver");
        return CompletableFuture.allOf(
            write(silver.resolve("helmet.json"), cache, buildSilver("silver_metal_helmet", 450)),
            write(silver.resolve("chestplate.json"), cache, buildSilver("silver_metal_chestplate", 720)),
            write(silver.resolve("leggings.json"), cache, buildSilver("silver_metal_leggings", 630)),
            write(silver.resolve("boots.json"), cache, buildSilver("silver_metal_boots", 360)),
            write(silver.resolve("axes.json"), cache, buildSilverMulti(new String[]{"silver_axe", "silver_pickaxe"}, 270)),
            write(silver.resolve("weapon.json"), cache, buildSilverMulti(new String[]{"silver_sword", "silver_hoe"}, 180)),
            write(silver.resolve("small.json"), cache, buildSilver("silver_shovel", 90)),
            write(silver.resolve("dragon_armor_head_neck.json"), cache, buildSilverMulti(new String[]{"dragonarmor_silver_head", "dragonarmor_silver_neck"}, 4050)),
            write(silver.resolve("dragon_armor_head_body.json"), cache, buildSilver("dragonarmor_silver_body", 6480)),
            write(silver.resolve("dragon_armor_head_tail.json"), cache, buildSilver("dragonarmor_silver_tail", 2430))
        );
    }

    private CompletableFuture<?> generateCopper(Path base, CachedOutput cache) {
        Path copper = base.resolve("copper");
        return CompletableFuture.allOf(
            write(copper.resolve("helmet.json"), cache, buildCopper("copper_metal_helmet", 450)),
            write(copper.resolve("chestplate.json"), cache, buildCopper("copper_metal_chestplate", 720)),
            write(copper.resolve("leggings.json"), cache, buildCopper("copper_metal_leggings", 630)),
            write(copper.resolve("boots.json"), cache, buildCopper("copper_metal_boots", 360)),
            write(copper.resolve("axes.json"), cache, buildCopperMulti(new String[]{"copper_axe", "copper_pickaxe"}, 270)),
            write(copper.resolve("weapon.json"), cache, buildCopperMulti(new String[]{"copper_sword", "copper_hoe"}, 180)),
            write(copper.resolve("small.json"), cache, buildCopper("copper_shovel", 90)),
            write(copper.resolve("dragon_armor_head_neck.json"), cache, buildCopperMulti(new String[]{"dragonarmor_copper_head", "dragonarmor_copper_neck"}, 4050)),
            write(copper.resolve("dragon_armor_head_body.json"), cache, buildCopper("dragonarmor_copper_body", 6480)),
            write(copper.resolve("dragon_armor_head_tail.json"), cache, buildCopper("dragonarmor_copper_tail", 2430))
        );
    }

    private static JsonObject conditions() {
        JsonObject cond = new JsonObject();
        cond.addProperty("type", "neoforge:mod_loaded");
        cond.addProperty("modid", "iceandfire");
        JsonArray arr = new JsonArray();
        arr.add(cond);
        JsonObject root = new JsonObject();
        root.add("neoforge:conditions", arr);
        return root;
    }

    private static JsonObject build(String itemId, String fluid, int amount, int temperature, int time) {
        JsonObject root = conditions();
        root.addProperty("type", "tconstruct:damagable_melting");
        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", itemId);
        root.add("ingredient", ingredient);
        JsonObject result = new JsonObject();
        result.addProperty("fluid", fluid);
        result.addProperty("amount", amount);
        result.addProperty("unit_size", 10);
        root.add("result", result);
        root.addProperty("temperature", temperature);
        root.addProperty("time", time);
        return root;
    }

    private static JsonObject buildMulti(String[] itemIds, String fluid, int amount, int temperature, int time) {
        JsonObject root = conditions();
        root.addProperty("type", "tconstruct:damagable_melting");
        JsonArray ingredient = new JsonArray();
        for (String id : itemIds) {
            JsonObject item = new JsonObject();
            item.addProperty("item", id);
            ingredient.add(item);
        }
        root.add("ingredient", ingredient);
        JsonObject result = new JsonObject();
        result.addProperty("fluid", fluid);
        result.addProperty("amount", amount);
        result.addProperty("unit_size", 10);
        root.add("result", result);
        root.addProperty("temperature", temperature);
        root.addProperty("time", time);
        return root;
    }

    private static JsonObject buildSilver(String item, int amount) {
        return build("iceandfire:" + item, "tconstruct:molten_silver", amount, 500, amount / 4);
    }

    private static JsonObject buildSilverMulti(String[] items, int amount) {
        String[] full = new String[items.length];
        for (int i = 0; i < items.length; i++) full[i] = "iceandfire:" + items[i];
        return buildMulti(full, "tconstruct:molten_silver", amount, 500, amount / 4);
    }

    private static JsonObject buildCopper(String item, int amount) {
        return build("iceandfire:" + item, "tconstruct:molten_copper", amount, 500, amount / 4);
    }

    private static JsonObject buildCopperMulti(String[] items, int amount) {
        String[] full = new String[items.length];
        for (int i = 0; i < items.length; i++) full[i] = "iceandfire:" + items[i];
        return buildMulti(full, "tconstruct:molten_copper", amount, 500, amount / 4);
    }

    private CompletableFuture<?> write(Path path, CachedOutput cache, JsonObject json) {
        return CompletableFuture.runAsync(() -> {
            try {
                Files.createDirectories(path.getParent());
                String content = GSON.toJson(json);
                byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
                cache.writeIfNeeded(path, bytes, com.google.common.hash.Hashing.sha1().hashBytes(bytes));
            } catch (IOException e) {
                throw new RuntimeException("Failed to write recipe: " + path, e);
            }
        });
    }
}
