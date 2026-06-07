package tcintegrations.data.tcon.material;

import slimeknights.tconstruct.library.modifiers.ModifierId;

import tcintegrations.TCIntegrations;

public class TciModifierIds {

    public static final ModifierId moderate = id("moderate");
    public static final ModifierId waterPowered = id("water_powered");
    public static final ModifierId soulStained = id("soul_stained");
    public static final ModifierId kinetic = id("kinetic");
    public static final ModifierId engineersGoggles = id("engineers_goggles");
    public static final ModifierId multiVision = id("multivision");
    public static final ModifierId dragonScales = id("dragonscales");
    public static final ModifierId flamed = id("flamed");
    public static final ModifierId iced = id("iced");
    public static final ModifierId zapped = id("zapped");
    public static final ModifierId cloggrumTrait = id("cloggrum");
    public static final ModifierId froststeelTrait = id("froststeel");
    public static final ModifierId forgottenTrait = id("forgotten");
    public static final ModifierId sourceGem = id("source_gem");
    public static final ModifierId mechanicalArm = id("mechanical_arm");
    public static final ModifierId glowup = id("glowup");
    public static final ModifierId phantasmal = id("phantasmal");
    public static final ModifierId roadrunner = id("roadrunner");
    public static final ModifierId frontierCap = id("frontier_cap");
    public static final ModifierId turtleShell = id("turtle_shell");
    public static final ModifierId bisonFur = id("bison_fur");
    public static final ModifierId shieldOfTheDeep = id("shield_of_the_deep");
    public static final ModifierId mosquito = id("mosquito");
    public static final ModifierId crocodile = id("crocodile");
    public static final ModifierId capturing = id("capturing");
    public static final ModifierId poseidon = id("poseidon");
    public static final ModifierId siren = id("siren");
    public static final ModifierId utherium = id("utherium");
    public static final ModifierId sculking = id("sculking");
    public static final ModifierId precipitate = id("precipitate");
    public static final ModifierId twilit = id("twilit");

    private TciModifierIds() {}

    private static ModifierId id(String name) {
        return new ModifierId(TCIntegrations.MODID, name);
    }

}
