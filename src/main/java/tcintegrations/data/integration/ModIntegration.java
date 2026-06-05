package tcintegrations.data.integration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.fml.ModList;

import tcintegrations.common.TCIntegrationsModule;

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
    public static final String BEYOND_EARTH_MODID = "beyond_earth";
    public static final String MEKANISM_MODID = "mekanism";
    public static final String MYTHIC_BOTANY_MODID = "mythicbotany";
    public static final String IFD_MODID = "iceandfire";
    public static final String CONSECRATION_MODID = "consecration";
    public static final String AD_ASTRA_MODID = "ad_astra";
    public static final String APOTH_MODID = "apotheosis";
    public static final String ARS_ELEMENTAL_MODID = "ars_elemental";
    public static final String DEEPERDARKER_MODID = "deeperdarker";
    public static final String TWILIGHT_MODID = "twilightforest";

    // Botania items (placeholders - port properly with actual items)
    public static final Item BOTANIA_LIVINGWOOD_PLANKS = Items.STONE;
    public static final Item LIVING_ROCK = Items.STONE;
    public static final Item MANA_STRING = Items.STONE;
    public static final Item LIVINGWOOD_TWIG = Items.STONE;
    public static final Item RUNE_SPRING = Items.STONE;
    public static final Item RUNE_SUMMER = Items.STONE;
    public static final Item RUNE_AUTUMN = Items.STONE;
    public static final Item RUNE_WINTER = Items.STONE;

    // MythicBotany items
    public static final Item ALFSTEEL_INGOT = Items.STONE;

    // Create items
    public static final Item GOGGLES = Items.STONE;
    public static final Item MECHANICAL_ARM = Items.STONE;

    // Aquaculture items
    public static final Item NEPTUNIUM_INGOT = Items.STONE;
    public static final Item TIN_CAN = Items.STONE;
    public static final Item REDSTONE_HOOK = Items.STONE;
    public static final Item FISH_FILLET_RAW = Items.STONE;
    public static final Item IRON_HOOK = Items.STONE;

    // Ars Nouveau items
    public static final Item MAGE_FIBER = Items.STONE;
    public static final Item MARK_OF_MASTERY = Items.STONE;
    public static final Item AIR_ESSENCE = Items.STONE;
    public static final Item WATER_ESSENCE = Items.STONE;
    public static final Item EARTH_ESSENCE = Items.STONE;
    public static final Item FIRE_ESSENCE = Items.STONE;
    public static final Item SOURCE_GEM_BLOCK = Items.STONE;

    // Alex's Mobs items
    public static final Item ROADRUNNER_FEATHER = Items.STONE;
    public static final Item SPIKED_SCUTE = Items.STONE;
    public static final Item BISON_FUR = Items.STONE;
    public static final Item BEAR_FUR = Items.STONE;
    public static final Item RACCOON_TAIL = Items.STONE;
    public static final Item SERRATED_SHARK_TOOTH = Items.STONE;
    public static final Item SHARK_TOOTH = Items.STONE;
    public static final Item MOSQUITO_PROBOSCIS = Items.STONE;
    public static final Item CROCODILE_SCUTE = Items.STONE;

    // Malum items
    public static final Item SOUL_STAINED_STEEL_INGOT = Items.STONE;

    // Undergarden items
    public static final Item MASTICATOR_SCALES = Items.STONE;
    public static final Item UTHERIUM_CRYSTAL = Items.STONE;
    public static final Item FROSTSTEEL_INGOT = Items.STONE;
    public static final Item CLOGGRUM_INGOT = Items.STONE;
    public static final Item FORGOTTEN_INGOT = Items.STONE;

    // Mekanism items
    public static final Item INGOT_REFINED_GLOWSTONE = Items.STONE;

    // Ice and Fire items
    public static final Item DRAGON_BONE = Items.STONE;
    public static final Item FIRE_DRAGON_BLOOD = Items.STONE;
    public static final Item ICE_DRAGON_BLOOD = Items.STONE;
    public static final Item LIGHTNING_DRAGON_BLOOD = Items.STONE;
    public static final Item GHOST_INGOT = Items.STONE;
    public static final Item IFD_SILVER_METAL_HELMET = Items.STONE;
    public static final Item IFD_SILVER_METAL_CHESTPLATE = Items.STONE;
    public static final Item IFD_SILVER_METAL_LEGGINGS = Items.STONE;
    public static final Item IFD_SILVER_METAL_BOOTS = Items.STONE;
    public static final Item IFD_SILVER_AXE = Items.STONE;
    public static final Item IFD_SILVER_PICKAXE = Items.STONE;
    public static final Item IFD_SILVER_SWORD = Items.STONE;
    public static final Item IFD_SILVER_HOE = Items.STONE;
    public static final Item IFD_SILVER_SHOVEL = Items.STONE;
    public static final Item IFD_DRAGONARMOR_SILVER_HEAD = Items.STONE;
    public static final Item IFD_DRAGONARMOR_SILVER_NECK = Items.STONE;
    public static final Item IFD_DRAGONARMOR_SILVER_BODY = Items.STONE;
    public static final Item IFD_DRAGONARMOR_SILVER_TAIL = Items.STONE;
    public static final Item IFD_COPPER_METAL_HELMET = Items.STONE;
    public static final Item IFD_COPPER_METAL_CHESTPLATE = Items.STONE;
    public static final Item IFD_COPPER_METAL_LEGGINGS = Items.STONE;
    public static final Item IFD_COPPER_METAL_BOOTS = Items.STONE;
    public static final Item IFD_COPPER_AXE = Items.STONE;
    public static final Item IFD_COPPER_PICKAXE = Items.STONE;
    public static final Item IFD_COPPER_SWORD = Items.STONE;
    public static final Item IFD_COPPER_HOE = Items.STONE;
    public static final Item IFD_COPPER_SHOVEL = Items.STONE;
    public static final Item IFD_DRAGONARMOR_COPPER_HEAD = Items.STONE;
    public static final Item IFD_DRAGONARMOR_COPPER_NECK = Items.STONE;
    public static final Item IFD_DRAGONARMOR_COPPER_BODY = Items.STONE;
    public static final Item IFD_DRAGONARMOR_COPPER_TAIL = Items.STONE;

    // Deeper and Darker items
    public static final Item REINFORCED_ECHO_SHARD = Items.STONE;

    // Twilight Forest items
    public static final Item FIERY_INGOT = Items.STONE;
    public static final Item ARCTIC_FUR = Items.STONE;
    public static final Item NAGA_SCALE = Items.STONE;
    public static final Item STEELEAF_INGOT = Items.STONE;

    // Immersive Engineering items
    public static final Item VOLTMETER = Items.STONE;

    public static ResourceLocation botaniaLoc(String name) { return location(BOTANIA_MODID, name); }
    public static ResourceLocation malumLoc(String name) { return location(MALUM_MODID, name); }
    public static ResourceLocation beyondEarthLoc(String name) { return location(BEYOND_EARTH_MODID, name); }
    public static ResourceLocation arsLoc(String name) { return location(ARS_MODID, name); }
    public static ResourceLocation ifdLoc(String name) { return location(IFD_MODID, name); }
    public static ResourceLocation mbotLoc(String name) { return location(MYTHIC_BOTANY_MODID, name); }
    public static ResourceLocation ieLoc(String name) { return location(IE_MODID, name); }
    public static ResourceLocation alexLoc(String name) { return location(ALEX_MODID, name); }
    public static ResourceLocation createLoc(String name) { return location(CREATE_MODID, name); }
    public static ResourceLocation aquaLoc(String name) { return location(AQUACULTURE_MODID, name); }
    public static ResourceLocation ugLoc(String name) { return location(UNDERGARDEN_MODID, name); }
    public static ResourceLocation mekanismLoc(String name) { return location(MEKANISM_MODID, name); }
    public static ResourceLocation adAstraLoc(String name) { return location(AD_ASTRA_MODID, name); }
    public static ResourceLocation arsElementalLoc(String name) { return location(ARS_ELEMENTAL_MODID, name); }
    public static ResourceLocation deeperDarkerLoc(String name) { return location(DEEPERDARKER_MODID, name); }
    public static ResourceLocation twilightLoc(String name) { return location(TWILIGHT_MODID, name); }

    public static boolean canLoad(String modid) {
        return ModList.get().isLoaded(modid);
    }

}
