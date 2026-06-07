package tcintegrations.data.tcon.material;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

import tcintegrations.TCIntegrations;

public final class MaterialIds {

    private MaterialIds() {}

    public static final MaterialId manaSteel = id("manasteel");
    public static final MaterialId livingWood = id("livingwood");
    public static final MaterialId livingRock = id("livingrock");
    public static final MaterialId manaString = id("manastring");
    public static final MaterialId neptunium = id("neptunium");
    public static final MaterialId soulStainedSteel = id("soul_stained_steel");
    public static final MaterialId brass = id("brass");
    public static final MaterialId dragonsteelFire = id("dragonsteel_fire");
    public static final MaterialId dragonsteelIce = id("dragonsteel_ice");
    public static final MaterialId dragonsteelLightning = id("dragonsteel_lightning");
    public static final MaterialId bronze = id("bronze");
    public static final MaterialId cloggrum = id("cloggrum");
    public static final MaterialId froststeel = id("froststeel");
    public static final MaterialId forgottenMetal = id("forgotten_metal");
    public static final MaterialId sourceGem = id("source_gem");

    private static MaterialId id(String name) {
        return new MaterialId(TCIntegrations.MODID, name);
    }

}
