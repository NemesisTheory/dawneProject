package dawneproject.content;

import arc.graphics.Color;
import mindustry.entities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.*;
import mindustry.type.UnitType;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.TractorBeamTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.content.Items;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Sounds;
import mindustry.content.Liquids;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.content.UnitTypes;
import mindustry.world.blocks.units.RepairTurret;
import mindustry.world.blocks.units.RepairTower;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.storage.StorageBlock;

import static mindustry.type.ItemStack.with;

public class DawneBlocks {
    public static Block
    // distribution - Dawne

    erumConveyor, erumJunction, erumBridge, erumRouter, erumOverflow, erumUnderflow, erumSorter, erumInvertedSorter,
    aspecTransporter, massTransporter,

    // liquid distribution TODO something....



    // production - Dawne

    carisPress, kasevForge, actiumSmelter, aspecMixer, tavorSmelter,

    // power - Dawne

    dawnePowernode, dawneLargePowerNode, dawneBattery, dawneLargeBattery, massCapacitor, thermalCondenser, solarArray,
    thermonuclearReactor, fusionReactor,

    // drill

    thermalDrill, nuclearDrill,

    // pewpews - Dawne

    fracture, rupture, broadside, rend,

    // wall - Dawne

    erumWall, largeErumWall, vasilWall, largeVasilWall, sevasWall, largeSevasWall, tavorWall, largeTavorWall,

    // core

    coreLegion, coreAllegiance, coreDevotion, coreFidelity,

    // storage

    storageDeposit, largeStorageDeposit, warehouse,

    // unit TODO unit shield proj = adds shields/force shield to unit

    unitRepairStation, unitPrimeRepairStation, unitShieldProjector,

    // special TODO groundDisruptor = destabilize ground unit, massDisruptor = destabilize all, totalDistruptor = infilict shutdown, retriever = parallax for ground (name change is inevitable)

    airspaceControl, groundDisruptor, massDisruptor, totalDisruptor, laserTargeter,

    // effect TODO reinforcer increases block health multip.

    regenerator, massRegenerator, energyProjector, massEnergyProjector, aegisFate, accelerator, massAccelerator, reinforcer;

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

        //TODO imminent for change (big item bridge is fucking stupid)
        massTransporter = new BufferedItemBridge("mass-transporter"){{
            health = 20;
            size = 3;
            range = 25;
            speed = 5f;
            itemCapacity = 250;
            hasPower = true;

            consumePower(1f);
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

        massCapacitor = new Battery("mass-capacitor"){{
            requirements(Category.power, with(DawneItems.caris, 600, DawneItems.vasil, 450, DawneItems.kasev, 600, DawneItems.aspec, 250));
            size = 5;
            health = 20;
            consumePowerBuffered(80000f);
            baseExplosiveness = 20f;
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
            requirements(Category.power, with(DawneItems.erum, 160, DawneItems.caris, 80, DawneItems.vasil, 120, DawneItems.kasev, 200, DawneItems.aspec, 60));
            size = 4;
            health = 20;
            powerProduction = 0.2f;
        }};

        thermonuclearReactor = new NuclearReactor("thermonuclear-reactor") {{
            requirements(Category.power, with(DawneItems.erum, 850, DawneItems.caris, 250, DawneItems.vasil, 400, DawneItems.kasev, 600, DawneItems.actium, 300));
            health = 50;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 5;
            itemDuration = 2f;
            powerProduction = 3f;
            heating = 0.02f;

            consumeItem(DawneItems.sevas);
            consumeLiquid(DawneLiquids.camberCoolant, heating / coolantPower).update(false);
        }};

        //plasma bore/pneumatic equivalent for Dawne
        thermalDrill = new Drill("thermal-drill"){{
            requirements(Category.production, with(DawneItems.erum, 40, DawneItems.caris, 10));
            tier = 3;
            size = 3;
            drillTime = 300;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            consumeLiquid(DawneLiquids.camberCoolant, 0.06f).boost();
        }};

        nuclearDrill = new Drill("nuclear-drill"){{
            requirements(Category.production, with(DawneItems.erum, 60, DawneItems.kasev, 80, DawneItems.vasil, 50, DawneItems.sevas, 80));
            drillTime = 200;
            size = 5;
            hasPower = true;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            updateEffectChance = 0.02f;
            drillEffect = Fx.mineHuge;
            rotateSpeed = 6f;
            warmupSpeed = 0.01f;
            itemCapacity = 10;

            liquidBoostIntensity = 1.4f;

            consumePower(0.5f);
            consumeLiquid(DawneLiquids.camberCoolant, 0.01f).boost();
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
                coolantMultiplier = 0.65f;
                coolant = consumeCoolant(0.3f);
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
                        spread = 7f;
                        shots = 3;
                        barrels = 3;
                    }};
                targetAir = true;
                targetGround = false;
                coolantMultiplier = 0.6f;
                coolant = consumeCoolant(0.2f);
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

                                lifetime = 49f;
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

                            lifetime = 49f;
                            rotationOffset = 90f;
                            trailRotation = true;
                            trailEffect = Fx.disperseTrail;

                            hitEffect = despawnEffect = Fx.hitBulletColor;
                }});

                //status effect inflictor basically TODO remove overdriveability
                rend = new ItemTurret("rend"){{
                    requirements(Category.turret, with(DawneItems.erum, 450, DawneItems.caris, 600, DawneItems.vasil, 250, DawneItems.kasev, 450, DawneItems.sevas, 200, DawneItems.actium, 100));

                    Effect amongus = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);

                    size = 5;
                    health = 260;
                    range = 320;
                    targetAir = false;
                    targetGround = true;
                    shootSound = Sounds.swish;
                    reload = 310f;
                    recoil = 0f;
                    shootCone = 85;
                    inaccuracy = 25;
                    shake = 1.2f;
                    maxAmmo = 60;
                    ammoUseEffect = Fx.casing3;
                    ammoEjectBack = 10;
                    displayAmmoMultiplier = true;
                    rotateSpeed = 360;
                    hasPower = true;
                    shoot = new ShootSpread(15, 4f);
                    velocityRnd = 0.17f;
                    hasLiquids = true;
                    researchCostMultiplier = 0.4f;

                    consumePower(4f);
                    ammo(
                            DawneItems.actium, new BasicBulletType() {{
                                damage = 0f;
                                ammoMultiplier = 2;
                                speed = 40;
                                hitSize = 24;
                                width = 0.0001f;
                                height = 0.0001f;
                                lifetime = 8;
                                collidesAir = false;
                                collidesGround = true;
                                shootEffect = amongus;
                                knockback = 10.5f;
                                status = DawneStatusEffects.destabilized;
                                statusDuration = 165;
                                hittable = false;
                            }}
                    );
                }};

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


                //TODO create contingent unit for legion core or something else idk
                coreLegion = new CoreBlock("core-legion"){{
                    requirements(Category.effect, with(DawneItems.erum, 4500, DawneItems.caris, 3500, DawneItems.vasil, 2500, DawneItems.kasev, 5000, DawneItems.sevas, 3000));
                    health = 2200;
                    size = 5;
                    armor = 2;
                    itemCapacity = 10000;
                    unitCapModifier = 34;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.12f;
                }};

                coreAllegiance = new CoreBlock("core-allegiance"){{
                    requirements(Category.effect, with(DawneItems.erum, 6000, DawneItems.caris, 4000, DawneItems.vasil, 3000, DawneItems.kasev, 6000, DawneItems.sevas, 4000, DawneItems.actium, 2500));
                    health = 4000;
                    size = 6;
                    armor = 4;
                    itemCapacity = 14000;
                    unitCapModifier = 40;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.2f;
                }};

                coreDevotion = new CoreBlock("core-devotion"){{
                    requirements(Category.effect, with(DawneItems.erum, 9000, DawneItems.caris, 6000, DawneItems.vasil, 4000, DawneItems.kasev, 10000, DawneItems.sevas, 5500, DawneItems.actium, 3000, DawneItems.aspec, 500));
                    health = 6500;
                    size = 8;
                    armor = 10;
                    itemCapacity = 22000;
                    unitCapModifier = 55;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.24f;
                }};


                // alternative to the Allegiance but the tech tree path for this won't lead to the Devotion
                coreFidelity = new CoreBlock("core-fidelity"){{
                    requirements(Category.effect, with(DawneItems.erum, 4500, DawneItems.caris, 4500, DawneItems.vasil, 2500, DawneItems.kasev, 4500, DawneItems.sevas, 3500, DawneItems.actium, 3500));
                    health = 3500;
                    size = 7;
                    armor = 2f;
                    itemCapacity = 12000;
                    unitCapModifier = 60;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.4f;
                }};

                storageDeposit = new StorageBlock("storage-deposit"){{
                    requirements(Category.effect, with(DawneItems.vasil, 200));
                    size = 3;
                    itemCapacity = 250;
                    health = 25;
                }};

                largeStorageDeposit = new StorageBlock("large-storage-deposit"){{
                    requirements(Category.effect, with(DawneItems.vasil, 400, DawneItems.sevas, 250));
                    size = 4;
                    itemCapacity = 850;
                    health = 30;
                    coreMerge = false;
                }};

                warehouse = new StorageBlock("warehouse"){{
                    requirements(Category.effect, with(DawneItems.vasil, 800, DawneItems.sevas, 500, DawneItems.caris, 400, DawneItems.kasev, 700));
                    size = 8;
                    itemCapacity = 6000;
                    health = 45;
                    coreMerge = false;
                }};

                unitRepairStation = new RepairTower("unit-repair-station"){{
                    requirements(Category.units, with(DawneItems.caris, 50, DawneItems.kasev, 120, DawneItems.vasil, 20));
                    size = 2;
                    health = 20;
                    range = 80f;
                    healAmount = 0.25f;

                    consumePower(0.17f);
                }};

                unitPrimeRepairStation = new RepairTurret("unit-greater-repair-station"){{
                        requirements(Category.units, with(DawneItems.caris, 350, DawneItems.kasev, 200, DawneItems.erum, 200, DawneItems.vasil, 40, DawneItems.sevas, 200, DawneItems.aspec, 50, DawneItems.actium, 15));
                        size = 5;
                        health = 45;
                        repairSpeed = 1.5f;
                        repairRadius = 120f;
                        beamWidth = 1.05f;
                        pulseRadius = 7f;
                        length = 6f;
                        powerUse = 1.5f;

                        consumeItems(with(DawneItems.kasev, 2, DawneItems.aspec, 1));
                }};


                // a lustre-parallax turret that I'm confused where to put. Effect? Turret?
                laserTargeter = new TractorBeamTurret("laser-targeter"){{
                    requirements(Category.turret, with(DawneItems.erum, 200, DawneItems.caris, 50, DawneItems.kasev, 400, DawneItems.vasil, 200, DawneItems.sevas, 50, DawneItems.actium, 20));
                    size = 3;
                    hasPower = true;
                    health = 110;
                    force = 0f;
                    scaledForce = 0f;
                    range = 180f;
                    damage = 1.25f;
                    rotateSpeed = 6.5f;
                    targetGround = true;
                    targetAir = false;

                    consumePower(2.4f);
                }};

                regenerator = new MendProjector("regenerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 30, DawneItems.erum, 20));
                    size = 2;
                    health = 20;
                    reload = 220f;
                    range = 60f;
                    healPercent = 4f;
                    phaseBoost = 5f;
                    phaseRangeBoost = -15f;

                    consumePower(0.15f);
                    consumeItem(DawneItems.kasev).boost();
                }};

                massRegenerator = new MendProjector("mass-regenerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 150, DawneItems.vasil, 40, DawneItems.kasev, 50, DawneItems.erum, 40));
                    size = 4;
                    health = 30;
                    reload = 280f;
                    range = 150f;
                    healPercent = 12f;
                    phaseBoost = 16f;
                    phaseRangeBoost = -30f;

                    consumePower(0.6f);
                    consumeItem(DawneItems.aspec).boost();
                }};

                energyProjector = new ForceProjector("energy-projector"){{
                    requirements(Category.effect, with(DawneItems.caris, 200, DawneItems.vasil, 80, DawneItems.kasev, 150));
                    size = 4;
                    health = 50;
                    phaseRadiusBoost = 20f;
                    radius = 80f;
                    shieldHealth = 250;
                    cooldownNormal = 1.6f;
                    cooldownLiquid = 1.2f;
                    cooldownBrokenBase = 0.35f;

                    itemConsumer = consumeItem(DawneItems.aspec).boost();
                    consumePower(0.8f);
                }};

                massEnergyProjector = new ForceProjector("mass-energy-projector"){{
                    requirements(Category.effect, with(DawneItems.caris, 400, DawneItems.vasil, 100, DawneItems.kasev, 200, DawneItems.aspec, 50, DawneItems.actium, 80));
                    size = 6;
                    health = 60;
                    phaseRadiusBoost = 40f;
                    radius = 176f;
                    shieldHealth = 800;
                    cooldownNormal = 2f;
                    cooldownLiquid = 1.4f;
                    cooldownBrokenBase = 0.4f;

                    itemConsumer = consumeItems(with(DawneItems.kasev, 1, DawneItems.aspec, 2));
                    consumePower(1.4f);
                }};

                // you will probably never be able to build this yourself in the Dawne campaign
                aegisFate = new BaseShield("aegis-fate"){{
                    requirements(Category.effect, with(DawneItems.erum, 600, DawneItems.vasil, 200, DawneItems.caris, 600, DawneItems.kasev, 560, DawneItems.aspec, 250, DawneItems.actium, 100, DawneItems.tavor, 200));
                    size = 8;
                    health = 120;
                    radius = 120;

                    consumePower(8.5f);
                    consumeItems(with(DawneItems.kasev, 3, DawneItems.aspec, 2, DawneItems.tavor, 1));
                }};

                accelerator = new OverdriveProjector("accelerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 80, DawneItems.vasil, 40, DawneItems.kasev, 50, DawneItems.aspec, 20));
                    size = 2;
                    health = 20;
                    hasPower = true;
                    reload = 180;
                    range = 160;
                    speedBoost = 1.5f;
                    consumePower(0.15f);
                    hasBoost = false;
                }};

                massAccelerator = new OverdriveProjector("mass-accelerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 350, DawneItems.vasil, 500, DawneItems.kasev, 250, DawneItems.sevas, 400, DawneItems.aspec, 85));
                    size = 4;
                    health = 25;
                    hasPower = true;
                    reload = 180;
                    range = 400;
                    speedBoost = 2.8f;
                    useTime = 360;
                    itemCapacity = 15;
                    consumePower(0.5f);
                    hasBoost = false;

                    consumeItems(with(DawneItems.kasev, 2, DawneItems.aspec, 3));
                }};
            }
        };
    }
}