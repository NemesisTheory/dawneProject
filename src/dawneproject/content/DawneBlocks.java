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
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Sounds;
import mindustry.content.Liquids;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.world.blocks.power.Battery;

import static mindustry.type.ItemStack.with;

public class DawneBlocks {
    public static Block

    // distribution - Dawne

    erumConveyor, erumJunction, erumBridge, erumRouter, erumOverflow, erumUnderflow, erumSorter, erumInvertedSorter,
    aspecTransporter,

    // production - Dawne

    carisPress, kasevForge, actiumSmelter,

    // power - Dawne

    dawnePowernode, dawneLargePowerNode, dawneBattery, dawneLargeBattery, thermalCondenser, solarArray, thermonuclearReactor,

    // pewpews - Dawne

    fracture, rupture, broadside,

    // wall - Dawne

    erumWall, largeErumWall, vasilWall, largeVasilWall, sevasWall, largeSevasWall, tavorWall, largeTavorWall,

    // core

    coreLegion,

    // special

    airspaceControl,

    // effect

    accelerator, massAccelerator;

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

        aspecTransporter = new ItemBridge("aspec-transporter") {{
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

        kasevForge = new GenericCrafter("kasev-forge") {{
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

        actiumSmelter = new GenericCrafter("actium-smelter") {{
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

        dawnePowernode = new PowerNode("dawne-power-node"){{
            requirements(Category.power, with(DawneItems.erum, 1, DawneItems.caris, 2));
            health = 5;
            maxNodes = 8;
            laserRange = 8;
        }};

        dawneLargePowerNode = new PowerNode("dawne-large-power-node"){{
            requirements(Category.power, with(DawneItems.caris, 10, DawneItems.vasil, 5, DawneItems.kasev, 2));
            health = 5;
            size = 3;
            maxNodes = 15;
            laserRange = 12;
        }};

        dawneBattery = new Battery("dawne-battery"){{
            requirements(Category.power, with(DawneItems.erum, 5, DawneItems.caris, 10));
            size = 2;
            health = 5;
            consumePowerBuffered(800f);
            baseExplosiveness = 2f;
        }};

        dawneLargeBattery = new Battery("dawne-large-battery"){{
            requirements(Category.power, with(DawneItems.caris, 20, DawneItems.vasil, 50, DawneItems.kasev, 25));
            size = 3;
            health = 8;
            consumePowerBuffered(10000f);
            baseExplosiveness = 5f;
        }};

        //TODO improve power gen blocks
        thermalCondenser = new ThermalGenerator("thermal-condenser") {{
            requirements(Category.power, with(DawneItems.erum, 50, DawneItems.caris, 15));
            health = 35;
            generateEffect = Fx.redgeneratespark;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.04f;
            powerProduction = 0.25f;
            size = 2;
        }};

        solarArray = new SolarGenerator("solar-array"){{
            requirements(Category.power, with(DawneItems.erum, 150, DawneItems.caris, 70, DawneItems.vasil, 120, DawneItems.kasev, 200, DawneItems.aspec, 50));
            size = 3;
            health = 20;
            powerProduction = 0.2f;
        }};

        thermonuclearReactor = new NuclearReactor("thermonuclear-reactor") {{
            requirements(Category.power, with(DawneItems.erum, 850, DawneItems.caris, 250, DawneItems.vasil, 400, DawneItems.kasev, 600, DawneItems.actium, 300));
            health = 50;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 4;
            itemDuration = 2f;
            powerProduction = 15f;
            heating = 0.02f;

            consumeItem(Items.thorium);
            consumeLiquid(DawneLiquids.camberCoolant, heating / coolantPower).update(false);
        }};

        fracture = new ItemTurret("fracture") {{
                requirements(Category.turret, with(DawneItems.erum, 75, DawneItems.caris, 30));
                Effect frt = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                health = 30;
                recoil = 3f;
                reload = 40f;
                range = 120;
                shootCone = 1f;
                inaccuracy = 0.5f;
                targetAir = false;
                targetGround = true;
                coolantMultiplier = 0.75f;
                coolant = consumeCoolant(1f);
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
                        DawneItems.caris, new BasicBulletType(9f, 16) {
                            {
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

        rupture = new ItemTurret("rupture") {{
                requirements(Category.turret, with(DawneItems.erum, 80, DawneItems.caris, 30));
                health = 35;
                range = 240;
                recoil = 2f;
                reload = 10f;
                shootCone = 9f;
                inaccuracy = 5.5f;
                shoot = new ShootAlternate(){{
                        spread = 6f;
                        shots = 3;
                        barrels = 3;
                    }};
                targetAir = true;
                targetGround = false;
                coolantMultiplier = 0.6f;
                coolant = consumeCoolant(1f);
                hasLiquids = true;
                shake = 1f;
                size = 4;
                rotateSpeed = 2.5f;
                researchCostMultiplier = 0.06f;
                ammo(
                        DawneItems.verent, new BasicBulletType() {{
                                damage = 12;
                                pierce = true;
                                pierceCap = 3;
                                speed = 4.25f;
                                width = height = 16;
                                shrinkY = 0.3f;
                                velocityRnd = 0.11f;
                                collidesGround = false;
                                collidesTiles = false;
                                shootEffect = Fx.shootBig2;
                                smokeEffect = Fx.shootSmokeDisperse;
                                backColor = trailColor = hitColor = frontColor = Color.valueOf("c48282");
                                trailChance = 0.44f;
                                ammoMultiplier = 4f;

                                lifetime = 34f;
                                rotationOffset = 90f;
                                trailRotation = true;
                                trailEffect = Fx.disperseTrail;

                                hitEffect = despawnEffect = Fx.hitBulletColor;
                            }},
                        DawneItems.vasil, new BasicBulletType(){{
                            damage = 20;
                            speed = 4.25f;
                            width = height = 16;
                            shrinkY = 0.3f;
                            velocityRnd = 0.11f;
                            collidesGround = false;
                            collidesTiles = false;
                            shootEffect = Fx.shootBig2;
                            smokeEffect = Fx.shootSmokeDisperse;
                            backColor = trailColor = hitColor = frontColor = Color.valueOf("bad3f5");
                            trailChance = 0.44f;
                            ammoMultiplier = 4f;
                            reloadMultiplier = 0.75f;

                            lifetime = 34f;
                            rotationOffset = 90f;
                            trailRotation = true;
                            trailEffect = Fx.disperseTrail;

                            hitEffect = despawnEffect = Fx.hitBulletColor;
                }});

                erumWall = new Wall("erum-wall") {{
                    requirements(Category.defense, with(DawneItems.erum, 8));
                    size = 1;
                    health = 35;
                    researchCostMultiplier = 0.1f;
                }};

                largeErumWall = new Wall("large-erum-wall") {{
                    requirements(Category.defense, with(DawneItems.erum, 32));
                    size = 2;
                    health = 180;
                    researchCostMultiplier = 0.1f;
                }};

                vasilWall = new Wall("vasil-wall") {{
                    requirements(Category.defense, with(DawneItems.caris, 4, DawneItems.vasil, 8));
                    size = 1;
                    health = 85;
                    researchCostMultiplier = 0.2f;
                }};

                largeVasilWall = new Wall("large-vasil-wall") {{
                    requirements(Category.defense, with(DawneItems.caris, 16, DawneItems.vasil, 32));
                    size = 2;
                    health = 400;
                    researchCostMultiplier = 0.2f;
                }};

                sevasWall = new Wall("sevas-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 5, DawneItems.vasil, 6, DawneItems.sevas, 8));
                    size = 1;
                    health = 200;
                    researchCostMultiplier = 0.2f;
                }};

                largeSevasWall = new Wall("large-sevas-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 20, DawneItems.vasil, 24, DawneItems.sevas, 32));
                    health = 1000;
                    researchCostMultiplier = 0.3f;
                }};

                tavorWall = new Wall("tavor-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 8, DawneItems.vasil, 6, DawneItems.sevas, 10, DawneItems.tavor, 6));
                    size = 1;
                    health = 150;
                    researchCostMultiplier = 0.3f;
                    lightningChance = 0.2f;
                    lightningDamage = 6;
                    lightningLength = 120;
                    lightningColor = Color.valueOf("02de6b");
                    chanceDeflect = 0.5f;
                }};

                largeTavorWall = new Wall("large-tavor-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 32, DawneItems.vasil, 24, DawneItems.sevas, 40, DawneItems.tavor, 24));
                    size = 2;
                    health = 800;
                    researchCostMultiplier = 0.5f;
                    lightningChance = 0.4f;
                    lightningDamage = 8;
                    lightningLength = 125;
                    lightningColor = Color.valueOf("02de6b");
                    chanceDeflect = 0.6f;
                }};
            }
        };
    }
}