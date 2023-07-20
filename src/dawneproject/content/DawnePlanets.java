package dawneproject.content;

import arc.graphics.Color;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;
import mindustry.game.Team;

import static dawneproject.content.DawneItems.*;
import static dawneproject.content.DawneLiquids.*;

public class DawnePlanets {
    public static Planet

    // sun

    kaeva,

    // planet

    volir, dawne, concord;

    // asteroids

    public static void load() {
        kaeva = new Planet("kaeva", Planets.sun, 8){{
            meshLoader = () -> new SunMesh(kaeva,
                    4, 5, 0.3, 2, 1.2, 1, 1.1f,
                    Color.valueOf("ffffff"), Color.valueOf("d7d3c6"), Color.valueOf("f7ca43"), Color.valueOf("e3c56b"), Color.valueOf("de9a97"), Color.valueOf("b39896"));
            bloom = true;
            accessible = true;
            iconColor = Color.valueOf("f7ca43");
            alwaysUnlocked = true;
            unlocked = true;
        }};

        dawne = new Planet("dawne", dawne, 2, 2){{
            generator = new SerpuloPlanetGenerator();
            meshLoader = () -> new HexMesh(dawne, 2);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(dawne, 2, 0.15f, 0.14f, 5,
                            Color.valueOf("fdef9a"), 2, 0.42f, 1, 0.43f)
            );
            atmosphereColor = Color.valueOf("824069");
            landCloudColor = Color.valueOf("3c7141");
            bloom = true;
            accessible = true;
            alwaysUnlocked = true;
            allowLaunchLoadout = true;
            allowLaunchSchematics = false;
            launchCapacityMultiplier = 0.75f;
            clearSectorOnLose = true;
            // for testing TODO change back to Kaeva + this fails to function - Dawne is INSIDE the sun
            camRadius = 0.5f;
            orbitSpacing = 2f;
            radius = 3f;
            solarSystem = Planets.sun;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.5f;
            visible = true;
            startSector = 16;
            sectorSeed = 3;
            rotateTime = 7 * 60;
            defaultCore = Blocks.coreNucleus;
            iconColor = Color.valueOf("f2f78a");
            totalRadius += 2.6f;
            hiddenItems.addAll(Vars.content.items()).removeAll(DawneItems);
            defaultEnv = Env.terrestrial;
            defaultAttributes.set(Attribute.heat, 1.7f);
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.onlyDepositCore = true;
                r.loadout = ItemStack.list(erum, 250);
                r.showSpawns = true;
                r.fog = true;
                r.solarMultiplier = 2f;
                r.coreDestroyClear = true;
                r.hideBannedBlocks = true;
                r.hiddenBuildItems.addAll(Vars.content.items());
                r.hiddenBuildItems.removeAll(DawneItems);
            };
            unlockedOnLand.add(DawneBlocks.coreLegion);
        }};

        Vars.content.planets().each(p -> {
            if (p == dawne) return;
            p.hiddenItems.addAll(DawneOnlyItems);
        });
        kaeva.parent = kaeva;
    }
}
