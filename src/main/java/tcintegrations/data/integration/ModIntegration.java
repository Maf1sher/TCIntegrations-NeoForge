package tcintegrations.data.integration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.fml.ModList;

import tcintegrations.common.TCIntegrationsModule;
import tcintegrations.util.ModItemRef;

import static tcintegrations.util.ResourceLocationHelper.location;

public final class ModIntegration extends TCIntegrationsModule {

    public static final String BOTANIA_MODID = "botania";
    public static final String IE_MODID = "immersiveengineering";
    public static final String TCON_MODID = "tconstruct";
    public static final String CREATE_MODID = "create";
    public static final String AQUACULTURE_MODID = "aquaculture";
    public static final String ARS_MODID = "ars_nouveau";
    public static final String ALEX_MODID = "alexsmobs";
    public static final String MALUM_MODID = "malum";
    public static final String UNDERGARDEN_MODID = "undergarden";
    public static final String MEKANISM_MODID = "mekanism";
    public static final String MYTHIC_BOTANY_MODID = "mythicbotany";
    public static final String IFD_MODID = "iceandfire";
    public static final String CONSECRATION_MODID = "consecration";
    public static final String APOTH_MODID = "apotheosis";
    public static final String ARS_ELEMENTAL_MODID = "ars_elemental";
    public static final String DEEPERDARKER_MODID = "deeperdarker";
    public static final String TWILIGHT_MODID = "twilightforest";

    // Botania items
    public static final Item BOTANIA_LIVINGWOOD_PLANKS = ModItemRef.of(BOTANIA_MODID, "livingwood_planks").get();
    public static final Item LIVING_ROCK = ModItemRef.of(BOTANIA_MODID, "livingrock").get();
    public static final Item MANA_STRING = ModItemRef.of(BOTANIA_MODID, "mana_string").get();
    public static final Item LIVINGWOOD_TWIG = ModItemRef.of(BOTANIA_MODID, "livingwood_twig").get();
    public static final Item RUNE_SPRING = ModItemRef.of(BOTANIA_MODID, "rune_spring").get();
    public static final Item RUNE_SUMMER = ModItemRef.of(BOTANIA_MODID, "rune_summer").get();
    public static final Item RUNE_AUTUMN = ModItemRef.of(BOTANIA_MODID, "rune_autumn").get();
    public static final Item RUNE_WINTER = ModItemRef.of(BOTANIA_MODID, "rune_winter").get();

    // MythicBotany items
    public static final Item ALFSTEEL_INGOT = ModItemRef.of(MYTHIC_BOTANY_MODID, "alfsteel_ingot").get();

    // Create items
    public static final Item GOGGLES = ModItemRef.of(CREATE_MODID, "goggles").get();
    public static final Item MECHANICAL_ARM = ModItemRef.of(CREATE_MODID, "mechanical_arm").get();

    // Aquaculture items
    public static final Item NEPTUNIUM_INGOT = ModItemRef.of(AQUACULTURE_MODID, "neptunium_ingot").get();
    public static final Item TIN_CAN = ModItemRef.of(AQUACULTURE_MODID, "tin_can").get();
    public static final Item REDSTONE_HOOK = ModItemRef.of(AQUACULTURE_MODID, "redstone_hook").get();
    public static final Item FISH_FILLET_RAW = ModItemRef.of(AQUACULTURE_MODID, "fish_fillet_raw").get();
    public static final Item IRON_HOOK = ModItemRef.of(AQUACULTURE_MODID, "iron_hook").get();

    // Ars Nouveau items
    public static final Item MAGE_FIBER = ModItemRef.of(ARS_MODID, "mage_fiber").get();
    public static final Item MARK_OF_MASTERY = ModItemRef.of(ARS_MODID, "mark_of_mastery").get();
    public static final Item AIR_ESSENCE = ModItemRef.of(ARS_MODID, "air_essence").get();
    public static final Item WATER_ESSENCE = ModItemRef.of(ARS_MODID, "water_essence").get();
    public static final Item EARTH_ESSENCE = ModItemRef.of(ARS_MODID, "earth_essence").get();
    public static final Item FIRE_ESSENCE = ModItemRef.of(ARS_MODID, "fire_essence").get();
    public static final Item SOURCE_GEM = ModItemRef.of(ARS_MODID, "source_gem").get();
    public static final Item SOURCE_GEM_BLOCK = ModItemRef.of(ARS_MODID, "source_gem_block").get();

    // Alex's Mobs items
    public static final Item ROADRUNNER_FEATHER = ModItemRef.of(ALEX_MODID, "roadrunner_feather").get();
    public static final Item SPIKED_SCUTE = ModItemRef.of(ALEX_MODID, "spiked_scute").get();
    public static final Item BISON_FUR = ModItemRef.of(ALEX_MODID, "bison_fur").get();
    public static final Item BEAR_FUR = ModItemRef.of(ALEX_MODID, "bear_fur").get();
    public static final Item RACCOON_TAIL = ModItemRef.of(ALEX_MODID, "raccoon_tail").get();
    public static final Item SERRATED_SHARK_TOOTH = ModItemRef.of(ALEX_MODID, "serrated_shark_tooth").get();
    public static final Item SHARK_TOOTH = ModItemRef.of(ALEX_MODID, "shark_tooth").get();
    public static final Item MOSQUITO_PROBOSCIS = ModItemRef.of(ALEX_MODID, "mosquito_proboscis").get();
    public static final Item CROCODILE_SCUTE = ModItemRef.of(ALEX_MODID, "crocodile_scute").get();

    // Malum items
    public static final Item SOUL_STAINED_STEEL_INGOT = ModItemRef.of(MALUM_MODID, "soul_stained_steel_ingot").get();

    // Undergarden items
    public static final Item MASTICATOR_SCALES = ModItemRef.of(UNDERGARDEN_MODID, "masticator_scales").get();
    public static final Item UTHERIUM_CRYSTAL = ModItemRef.of(UNDERGARDEN_MODID, "utherium_crystal").get();
    public static final Item FROSTSTEEL_INGOT = ModItemRef.of(UNDERGARDEN_MODID, "froststeel_ingot").get();
    public static final Item CLOGGRUM_INGOT = ModItemRef.of(UNDERGARDEN_MODID, "cloggrum_ingot").get();
    public static final Item FORGOTTEN_INGOT = ModItemRef.of(UNDERGARDEN_MODID, "forgotten_ingot").get();

    // Mekanism items
    public static final Item INGOT_REFINED_GLOWSTONE = ModItemRef.of(MEKANISM_MODID, "ingot_refined_glowstone").get();

    // Ice and Fire items
    public static final Item DRAGON_BONE = ModItemRef.of(IFD_MODID, "dragon_bone").get();
    public static final Item FIRE_DRAGON_BLOOD = ModItemRef.of(IFD_MODID, "fire_dragon_blood").get();
    public static final Item ICE_DRAGON_BLOOD = ModItemRef.of(IFD_MODID, "ice_dragon_blood").get();
    public static final Item LIGHTNING_DRAGON_BLOOD = ModItemRef.of(IFD_MODID, "lightning_dragon_blood").get();
    public static final Item GHOST_INGOT = ModItemRef.of(IFD_MODID, "ghost_ingot").get();
    public static final Item IFD_SILVER_METAL_HELMET = ModItemRef.of(IFD_MODID, "silver_metal_helmet").get();
    public static final Item IFD_SILVER_METAL_CHESTPLATE = ModItemRef.of(IFD_MODID, "silver_metal_chestplate").get();
    public static final Item IFD_SILVER_METAL_LEGGINGS = ModItemRef.of(IFD_MODID, "silver_metal_leggings").get();
    public static final Item IFD_SILVER_METAL_BOOTS = ModItemRef.of(IFD_MODID, "silver_metal_boots").get();
    public static final Item IFD_SILVER_AXE = ModItemRef.of(IFD_MODID, "silver_axe").get();
    public static final Item IFD_SILVER_PICKAXE = ModItemRef.of(IFD_MODID, "silver_pickaxe").get();
    public static final Item IFD_SILVER_SWORD = ModItemRef.of(IFD_MODID, "silver_sword").get();
    public static final Item IFD_SILVER_HOE = ModItemRef.of(IFD_MODID, "silver_hoe").get();
    public static final Item IFD_SILVER_SHOVEL = ModItemRef.of(IFD_MODID, "silver_shovel").get();
    public static final Item IFD_DRAGONARMOR_SILVER_HEAD = ModItemRef.of(IFD_MODID, "dragonarmor_silver_head").get();
    public static final Item IFD_DRAGONARMOR_SILVER_NECK = ModItemRef.of(IFD_MODID, "dragonarmor_silver_neck").get();
    public static final Item IFD_DRAGONARMOR_SILVER_BODY = ModItemRef.of(IFD_MODID, "dragonarmor_silver_body").get();
    public static final Item IFD_DRAGONARMOR_SILVER_TAIL = ModItemRef.of(IFD_MODID, "dragonarmor_silver_tail").get();
    public static final Item IFD_COPPER_METAL_HELMET = ModItemRef.of(IFD_MODID, "copper_metal_helmet").get();
    public static final Item IFD_COPPER_METAL_CHESTPLATE = ModItemRef.of(IFD_MODID, "copper_metal_chestplate").get();
    public static final Item IFD_COPPER_METAL_LEGGINGS = ModItemRef.of(IFD_MODID, "copper_metal_leggings").get();
    public static final Item IFD_COPPER_METAL_BOOTS = ModItemRef.of(IFD_MODID, "copper_metal_boots").get();
    public static final Item IFD_COPPER_AXE = ModItemRef.of(IFD_MODID, "copper_axe").get();
    public static final Item IFD_COPPER_PICKAXE = ModItemRef.of(IFD_MODID, "copper_pickaxe").get();
    public static final Item IFD_COPPER_SWORD = ModItemRef.of(IFD_MODID, "copper_sword").get();
    public static final Item IFD_COPPER_HOE = ModItemRef.of(IFD_MODID, "copper_hoe").get();
    public static final Item IFD_COPPER_SHOVEL = ModItemRef.of(IFD_MODID, "copper_shovel").get();
    public static final Item IFD_DRAGONARMOR_COPPER_HEAD = ModItemRef.of(IFD_MODID, "dragonarmor_copper_head").get();
    public static final Item IFD_DRAGONARMOR_COPPER_NECK = ModItemRef.of(IFD_MODID, "dragonarmor_copper_neck").get();
    public static final Item IFD_DRAGONARMOR_COPPER_BODY = ModItemRef.of(IFD_MODID, "dragonarmor_copper_body").get();
    public static final Item IFD_DRAGONARMOR_COPPER_TAIL = ModItemRef.of(IFD_MODID, "dragonarmor_copper_tail").get();

    // Deeper and Darker items
    public static final Item REINFORCED_ECHO_SHARD = ModItemRef.of(DEEPERDARKER_MODID, "reinforced_echo_shard").get();

    // Twilight Forest items
    public static final Item FIERY_INGOT = ModItemRef.of(TWILIGHT_MODID, "fiery_ingot").get();
    public static final Item ARCTIC_FUR = ModItemRef.of(TWILIGHT_MODID, "arctic_fur").get();
    public static final Item NAGA_SCALE = ModItemRef.of(TWILIGHT_MODID, "naga_scale").get();
    public static final Item STEELEAF_INGOT = ModItemRef.of(TWILIGHT_MODID, "steeleaf_ingot").get();

    // Immersive Engineering items
    public static final Item VOLTMETER = ModItemRef.of(IE_MODID, "voltmeter").get();

    public static ResourceLocation botaniaLoc(String name) { return location(BOTANIA_MODID, name); }
    public static ResourceLocation malumLoc(String name) { return location(MALUM_MODID, name); }
    public static ResourceLocation arsLoc(String name) { return location(ARS_MODID, name); }
    public static ResourceLocation ifdLoc(String name) { return location(IFD_MODID, name); }
    public static ResourceLocation mbotLoc(String name) { return location(MYTHIC_BOTANY_MODID, name); }
    public static ResourceLocation ieLoc(String name) { return location(IE_MODID, name); }
    public static ResourceLocation alexLoc(String name) { return location(ALEX_MODID, name); }
    public static ResourceLocation createLoc(String name) { return location(CREATE_MODID, name); }
    public static ResourceLocation aquaLoc(String name) { return location(AQUACULTURE_MODID, name); }
    public static ResourceLocation ugLoc(String name) { return location(UNDERGARDEN_MODID, name); }
    public static ResourceLocation mekanismLoc(String name) { return location(MEKANISM_MODID, name); }
    public static ResourceLocation arsElementalLoc(String name) { return location(ARS_ELEMENTAL_MODID, name); }
    public static ResourceLocation deeperDarkerLoc(String name) { return location(DEEPERDARKER_MODID, name); }
    public static ResourceLocation twilightLoc(String name) { return location(TWILIGHT_MODID, name); }

    private static boolean forceLoaded = false;

    public static void setForceLoaded() {
        forceLoaded = true;
    }

    public static boolean canLoad(String modid) {
        if (forceLoaded) return true;
        return ModList.get().isLoaded(modid);
    }

}
