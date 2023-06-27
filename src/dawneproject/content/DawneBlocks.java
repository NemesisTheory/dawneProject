package dawneproject.content;

import arc.graphics.Color;
import mindustry.entities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import mindustry.content.Items;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.Fracker;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Sounds;

import static mindustry.type.ItemStack.with;

public class DawneBlocks {
    public static Block

    //distribution - Dawne

    erumConveyor, erumJunction, erumBridge, erumRouter, erumOverflow, erumUnderflow, erumSorter, erumInvertedSorter,
    aspecTransporter,

    //production - Dawne

    carisPress, actiumSmelter, kasevForge,

    //power gen - Dawne

    thermalCondenser, thermonuclearReactor,

    //pewpews - Dawne

    fracture, broadside,

    //wall - Dawne

    erumWall, largeErumWall, vasilWall, largeVasilWall;

    public static void load() {
        erumConveyor = new Conveyor("erum-conveyor") {{
            requirements(Category.distribution, with(DawneItems.erum, 1));
            health = 5;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            researchCost = with(Items.scrap, 5);
            junctionReplacement = erumJunction;
            bridgeReplacement = erumBridge;
        }};

        erumJunction = new Junction("erum-junction") {{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 5;
            speed = 12f;
            capacity = 1;
            buildCostMultiplier = 3f;
        }};

        erumBridge = new BufferedItemBridge("erum-bridge") {{
            requirements(Category.distribution, with(DawneItems.erum, 4, DawneItems.caris, 2));
            health = 5;
            range = 4;
            arrowSpacing = 5f;
            speed = 12f;
            bufferCapacity = 3;
        }};

        erumRouter = new Router("erum-router") {{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 5;
            buildCostMultiplier = 2f;
        }};

        erumOverflow = new OverflowGate("erum-overflow") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};

        erumUnderflow = new OverflowGate("erum-underflow") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
            invert = true;
        }};

        erumSorter = new Sorter("erum-sorter") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
        }};

        erumInvertedSorter = new Sorter("erum-inverted-sorter") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.caris, 1));
            health = 5;
            buildCostMultiplier = 1f;
            invert = true;
        }};

        aspecTransporter = new ItemBridge("aspec-transporter"){{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.aspec, 3));
            health = 5;
            range = 3;
            buildCostMultiplier = 1f;
            conductivePower = true;
            hasPower = true;
            pulse = true;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;

            consumePower(0.004f);
        }};

        carisPress = new GenericCrafter("caris-press") {{
            requirements(Category.crafting, with(DawneItems.erum, 40));
            health = 15;
            outputItem = new ItemStack(DawneItems.caris, 2);
            craftEffect = Fx.smeltsmoke;
            craftTime = 138f;
            size = 3;
            hasItems = true;

            consumeItems(with(DawneItems.verent, 2));
        }};

        kasevForge = new GenericCrafter("kasev-forge"){{
            requirements(Category.crafting, with(DawneItems.erum, 35, DawneItems.caris, 60, DawneItems.vasil, 40));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DawneItems.kasev, 4);
            craftTime = 80f;
            size = 3;
            health = 20;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 30;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(DawneItems.erum, 2, DawneItems.talcPowder, 3));
            consumePower(0.25f);
        }};

        actiumSmelter = new GenericCrafter("actium-smelter"){{
            requirements(Category.crafting, with(DawneItems.erum, 85, DawneItems.caris, 20, DawneItems.vasil, 45));
            health = 20;
            hasPower = true;
            outputItem = new ItemStack(DawneItems.actium, 3);
            craftEffect = Fx.smeltsmoke;
            craftTime = 150f;
            size = 4;
            hasItems = true;

            consumeItems(with(DawneItems.erum, 1, DawneItems.caris, 2, DawneItems.vasil, 3));
            consumePower(0.75f);
        }};

        //TODO improve power gen blocks
        thermalCondenser = new ThermalGenerator("thermal-condenser"){{
            requirements(Category.power, with(DawneItems.erum, 30, DawneItems.caris, 5));
            health = 35;
            generateEffect = Fx.redgeneratespark;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.04f;
            powerProduction = 0.25f;
            size = 2;
        }};

        thermonuclearReactor = new NuclearReactor("thermonuclear-reactor"){{
            requirements(Category.power, with(DawneItems.erum, 85, DawneItems.caris, 25, DawneItems.vasil, 40, DawneItems.actium, 30));
            health = 50;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.04f;
            powerProduction = 2f;
            size = 4;
            hasItems = true;
            hasLiquids = true;
            itemDuration = 400f;
            heating = 0.02f;

            consumeItems(with(DawneItems.sevas, 4));
            consumeLiquid(DawneLiquids.camberCoolant, heating / coolantPower).update(false);
        }};

        fracture = new ItemTurret("fracture") {{
                requirements(Category.turret, with(DawneItems.erum, 70, DawneItems.caris, 15));
                Effect frt = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                health = 20;
                recoil = 3f;
                reload = 40f;
                range = 120;
                shootCone = 1f;
                inaccuracy = 0.5f;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 3f;
                hasLiquids = true;
                shake = 2f;
                ammoPerShot = 2;
                shootY = -1;
                size = 3;
                rotateSpeed = 1.5f;
                researchCostMultiplier = 0.05f;
                ammo(
                        DawneItems.verent, new BasicBulletType(8f, 6) {{
                            lifetime = 17.5f;
                            width = 12f;
                            hitSize = 7f;
                            height = 20f;
                            shootEffect = frt;
                            smokeEffect = Fx.shootBigSmoke;
                            ammoMultiplier = 1;
                            pierceCap = 4;
                            pierce = true;
                            pierceBuilding = true;
                            hitColor = backColor = trailColor = Color.valueOf("c48282");
                            frontColor = Color.white;
                            trailWidth = 2.1f;
                            trailLength = 10;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            buildingDamageMultiplier = 0.2f;
                        }},
                        DawneItems.caris, new BasicBulletType(9f, 16) {{
                                splashDamage = 4;
                                splashDamageRadius = 12.5f;
                                lifetime = 17.5f;
                                width = 12f;
                                hitSize = 7f;
                                height = 20f;
                                shootEffect = frt;
                                smokeEffect = Fx.shootBigSmoke;
                                ammoMultiplier = 2;
                                pierceCap = 2;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = Color.valueOf("8a83eb");
                                frontColor = Color.white;
                                reloadMultiplier = 1.15f;
                                trailWidth = 2.1f;
                                trailLength = 10;
                                hitEffect = despawnEffect = Fx.hitBulletColor;
                                buildingDamageMultiplier = 0.2f;
                            }
                        }
                );
            }
        };

        erumWall = new Wall("erum-wall"){{
            requirements(Category.defense, with(DawneItems.erum, 8));
            size = 1;
            health = 35;
            researchCostMultiplier = 0.1f;
        }};

        largeErumWall = new Wall("large-erum-wall"){{
            requirements(Category.defense, with(DawneItems.erum, 32));
            size = 2;
            health = 160;
            researchCostMultiplier = 0.1f;
        }};

        vasilWall = new Wall("vasil-wall"){{
            requirements(Category.defense, with(DawneItems.caris, 4, DawneItems.vasil, 8));
            size = 1;
            health = 85;
            researchCostMultiplier = 0.2f;
        }};

        largeVasilWall = new Wall("large-vasil-wall"){{
            requirements(Category.defense, with(DawneItems.caris, 16, DawneItems.vasil, 32));
            size = 2;
            health = 350;
            researchCostMultiplier = 0.2f;
        }};
    }
}