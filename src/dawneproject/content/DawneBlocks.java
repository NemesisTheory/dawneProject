package dawneproject.content;

import arc.graphics.Color;
import dawneproject.content.world.blocks.power.ThermonuclearReactor;
import mindustry.entities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.*;
import mindustry.type.LiquidStack;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.TractorBeamTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Sounds;
import mindustry.content.Liquids;
import mindustry.world.blocks.storage.CoreBlock;
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

    transporter, bridgeTransporter, routerTransporter, aspecConveyor, massTransporter, materialHandlingSystem,

    // liquid distribution

    fluidArch, fluidRouter, fluidTank,

    // production - Dawne

    carisPress, kasevForge, actiumSmelter, aspecMixer, tavorSmelter, napalmMixer, camberHeatSink, hypercoolantSynthesizer,

    // power - Dawne

    energyNode, energySpire, energyRelay, energyCell, accumulator, massCapacitor, thermalCondenser, solarArray,
    thermonuclearReactor, fusionReactor,

    // drill

    thermalDrill, rotaryDrill, nuclearDrill, dischargeDrill,

    // pewpews - Dawne

    fracture, rupture, broadside, rend, forebode,

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

    regenerator, massRegenerator, energyProjector, massEnergyProjector, aegisFate, accelerator, primeAccelerator, massAccelerator, reinforcer;

    public static void load() {
        transporter = new StackConveyor("transporter") {{
            requirements(Category.distribution, with(DawneItems.erum, 1));
            health = 50;
            speed = 4f / 60f;
            itemCapacity = 8;
            researchCost = with(DawneItems.erum, 5);
        }};

        bridgeTransporter = new BufferedItemBridge("bridge-transporter") {{
            requirements(Category.distribution, with(DawneItems.erum, 4, DawneItems.caris, 2));
            health = 50;
            range = 4;
            arrowSpacing = 5f;
            speed = 12f;
            bufferCapacity = 3;
        }};

        routerTransporter = new StackRouter("router-transporter") {{
            requirements(Category.distribution, with(DawneItems.erum, 2));
            health = 50;
            speed = 5f;
            buildCostMultiplier = 2f;
        }};

        aspecConveyor = new ItemBridge("aspec-conveyor") {{
            requirements(Category.distribution, with(DawneItems.erum, 2, DawneItems.aspec, 3));
            health = 50;
            range = 8;
            buildCostMultiplier = 1f;
            conductivePower = true;
            hasPower = true;
            pulse = true;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;

            consumePower(0.1f);
        }};

        //TODO imminent for change (big item bridge is fucking stupid)
        massTransporter = new BufferedItemBridge("mass-transporter"){{
            health = 120;
            size = 3;
            range = 25;
            speed = 5f;
            itemCapacity = 250;
            hasPower = true;

            consumePower(10f);
        }};

        materialHandlingSystem = new StackConveyor("mhs"){{
            requirements(Category.distribution, with(DawneItems.erum, 3, DawneItems.kasev, 2, DawneItems.sevas, 1));
            health = 80;
            size = 2;
            speed = 2f / 60f;
            itemCapacity = 80;
        }};

        fluidArch = new LiquidBridge("fluid-arch"){{
            requirements(Category.liquid, with(DawneItems.caris, 4, DawneItems.vasil, 5, DawneItems.erum, 2));
            health = 50;
            range = 8;
            hasPower = false;
            fadeIn = moveArrows = false;
            arrowSpacing = 6.5f;
        }};

        fluidRouter = new LiquidRouter("fluid-router"){{
            requirements(Category.liquid, with(DawneItems.caris, 4, DawneItems.erum, 4));
            health = 50;
            liquidCapacity = 30f;
            underBullets = true;
            solid = false;
        }};

        fluidTank = new LiquidRouter("fluid-tank"){{
            requirements(Category.liquid, with(DawneItems.caris, 20, DawneItems.vasil, 30, DawneItems.erum, 20));
            health = 600;
            size = 4;
            solid = true;
            liquidCapacity = 2000f;
        }};

        carisPress = new GenericCrafter("caris-press") {{
            requirements(Category.crafting, with(DawneItems.erum, 40));
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
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 30;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(DawneItems.erum, 2, DawneItems.talcPowder, 3));
            consumePower(1.5f);
        }};

        actiumSmelter = new GenericCrafter("actium-smelter") {{
            requirements(Category.crafting, with(DawneItems.erum, 85, DawneItems.caris, 20, DawneItems.vasil, 45));
            hasPower = true;
            outputItem = new ItemStack(DawneItems.actium, 3);
            craftEffect = Fx.smeltsmoke;
            craftTime = 150f;
            size = 4;
            hasItems = true;

            consumeItems(with(DawneItems.erum, 1, DawneItems.caris, 2, DawneItems.vasil, 3));
            consumePower(3f);
        }};

        aspecMixer = new GenericCrafter("aspec-mixer"){{
            requirements(Category.crafting, with(DawneItems.kasev, 100, DawneItems.erum, 140, DawneItems.sevas, 50));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DawneItems.aspec, 2);
            craftTime = 140f;
            size = 3;
            hasPower = true;
            itemCapacity = 10;

            consumeItems(with(DawneItems.talcPowder, 6, DawneItems.sevas, 2));
            consumePower(2.5f);
        }};

        tavorSmelter = new GenericCrafter("tavor-smelter"){{
            requirements(Category.crafting, with(DawneItems.erum, 100, DawneItems.caris, 50, DawneItems.vasil, 60, DawneItems.sevas, 140));
            hasPower = true;
            outputItem = new ItemStack(DawneItems.tavor, 2);
            craftEffect =  Fx.smeltsmoke;
            craftTime = 200f;
            size = 5;
            hasItems = true;
            itemCapacity = 15;

            consumeItems(with(DawneItems.vasil, 2, DawneItems.sevas, 5, DawneItems.verent, 3, DawneItems.kasev, 2));
            consumePower(5f);
        }};

        camberHeatSink = new GenericCrafter("camber-heat-sink"){{
            requirements(Category.crafting, with(DawneItems.erum,  50, DawneItems.caris, 80, DawneItems.vasil, 220, DawneItems.kasev, 80));
            size = 4;
            hasPower = true;
            hasLiquids = true;
            hasItems = true;
            rotate = false;
            solid = true;
            craftTime = 250f;
            itemCapacity = 15;
            liquidCapacity = 30f;
            outputsLiquid = true;

            outputLiquid = new LiquidStack(DawneLiquids.camberCoolant, 10f / 60f);

            consumePower(4f);
            consumeItems(with(DawneItems.rime, 2, DawneItems.erum, 1));
            consumeLiquid(Liquids.slag, 14f / 60f);
        }};

        energyNode = new BeamNode("energy-node"){{
            requirements(Category.power, with(DawneItems.erum, 1, DawneItems.caris, 2));
            health = 60;
            consumesPower = outputsPower = true;
            range = 6;
            fogRadius = 1;
            consumePowerBuffered(100f);
        }};

        energySpire = new BeamNode("energy-spire"){{
            requirements(Category.power, with(DawneItems.caris, 50, DawneItems.vasil, 20, DawneItems.kasev, 40));
            health = 80;
            size = 3;
            range = 16;
            fogRadius = 1;
            consumePowerBuffered(450f);
        }};

        energyRelay = new LongPowerNode("energy-relay"){{
            requirements(Category.power, with(DawneItems.vasil, 500, DawneItems.kasev, 800, DawneItems.aspec, 350));
            size = 4;
            maxNodes = 2;
            autolink = false;
            laserRange = 40f;
            fogRadius = 1;
            consumePowerBuffered(800f);
        }};

        energyCell = new Battery("energy-cell"){{
            requirements(Category.power, with(DawneItems.erum, 5, DawneItems.caris, 10));
            size = 2;
            consumePowerBuffered(4500f);
            baseExplosiveness = 2f;
        }};

        accumulator = new Battery("accumulator"){{
            requirements(Category.power, with(DawneItems.caris, 20, DawneItems.vasil, 50, DawneItems.kasev, 25));
            size = 4;
            consumePowerBuffered(60000f);
            baseExplosiveness = 5f;
        }};

        massCapacitor = new Battery("mass-capacitor"){{
            requirements(Category.power, with(DawneItems.caris, 600, DawneItems.vasil, 450, DawneItems.kasev, 600, DawneItems.aspec, 250));
            size = 6;
            consumePowerBuffered(400000f);
            baseExplosiveness = 20f;
        }};

        //TODO improve power gen blocks
        thermalCondenser = new ThermalGenerator("thermal-condenser") {{
            requirements(Category.power, with(DawneItems.erum, 50, DawneItems.caris, 15));
            generateEffect = Fx.redgeneratespark;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.04f;
            powerProduction = 0.5f;
            size = 2;
        }};

        solarArray = new SolarGenerator("solar-array"){{
            requirements(Category.power, with(DawneItems.erum, 160, DawneItems.caris, 80, DawneItems.vasil, 120, DawneItems.kasev, 200, DawneItems.aspec, 60));
            size = 4;
            powerProduction = 0.8f;
        }};

        thermonuclearReactor = new ThermonuclearReactor("thermonuclear-reactor") {{
            requirements(Category.power, with(DawneItems.erum, 850, DawneItems.caris, 250, DawneItems.vasil, 400, DawneItems.kasev, 600, DawneItems.actium, 300));
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 4;
            health = 700;
            itemDuration = 360f;
            powerProduction = 15f;
            heating = 0.02f;

            consumeItem(DawneItems.sevas);
            consumeLiquid(DawneLiquids.camberCoolant, heating / coolantPower).update(false);
        }};

        //plasma bore/pneumatic equivalent for Dawne
        thermalDrill = new Drill("thermal-drill"){{
            requirements(Category.production, with(DawneItems.erum, 40, DawneItems.caris, 10));
            tier = 3;
            size = 2;
            drillTime = 400;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            consumeLiquid(Liquids.water, 0.06f).boost();
        }};

        rotaryDrill = new Drill("rotary-drill"){{
            requirements(Category.production, with(DawneItems.erum, 40, DawneItems.kasev, 50, DawneItems.vasil, 40));
            drillTime = 340;
            tier = 3;
            size = 3;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            consumePower(1.4f);
            consumeLiquid(Liquids.water, 0.08f).boost();
        }};

        // TODO create `NuclearDrill` class
        nuclearDrill = new Drill("nuclear-drill"){{
            requirements(Category.production, with(DawneItems.erum, 60, DawneItems.kasev, 80, DawneItems.vasil, 50, DawneItems.sevas, 80));
            drillTime = 210;
            size = 4;
            hasPower = true;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            updateEffectChance = 0.02f;
            drillEffect = Fx.mineHuge;
            rotateSpeed = 6f;
            warmupSpeed = 0.01f;
            itemCapacity = 10;

            consumePower(5f);
            consumeLiquid(DawneLiquids.camberCoolant, 0.01f).boost();
        }};

        dischargeDrill = new Drill("discharge-drill"){{
            requirements(Category.production, with(DawneItems.erum, 120, DawneItems.caris, 20, DawneItems.kasev, 100, DawneItems.vasil, 120, DawneItems.sevas, 100));
            drillTime = 280;
            size = 5;
            hasPower = true;
            tier = 5;
            updateEffect = Fx.pulverizeMedium;
            updateEffectChance = 0.02f;
            drillEffect = Fx.mineHuge;
            rotateSpeed = 8f;
            warmupSpeed = 0.015f;
            itemCapacity = 15;

            liquidBoostIntensity = 1.1f;

            consumePower(6f);
            consumeLiquid(DawneLiquids.hypercoolant, 0.01f);
        }};

        fracture = new ItemTurret("fracture") {{
                requirements(Category.turret, with(DawneItems.erum, 75, DawneItems.caris, 30));
                Effect frt = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                recoil = 3f;
                shoot = new ShootAlternate(5f);
                reload = 30f;
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
                rotateSpeed = 4.5f;
                researchCostMultiplier = 0.05f;
                ammo(
                        DawneItems.verent, new BasicBulletType(8f, 15) {{
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
                        DawneItems.caris, new BasicBulletType(9f, 35) {{
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
                requirements(Category.turret, with(DawneItems.erum, 120, DawneItems.caris, 80));
                range = 240;
                recoil = 2f;
                reload = 16f;
                shootCone = 12f;
                inaccuracy = 8f;
                shoot = new ShootAlternate(){{
                        spread = 7f;
                        shots = 3;
                        barrels = 3;
                    }};
                targetAir = true;
                targetGround = false;
                coolantMultiplier = 0.8f;
                coolant = consumeCoolant(0.2f);
                hasLiquids = true;
                shake = 1f;
                size = 4;
                rotateSpeed = 8.5f;
                researchCostMultiplier = 0.06f;
                ammo(
                        DawneItems.verent, new BasicBulletType(4.25f, 15) {{
                                pierce = true;
                                pierceCap = 3;
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
                        DawneItems.vasil, new BasicBulletType(4.25f, 35){{
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
                    range = 320;
                    targetAir = false;
                    targetGround = true;
                    shootSound = Sounds.swish;
                    reload = 450f;
                    recoil = 0f;
                    shootCone = 85;
                    inaccuracy = 25;
                    shake = 1.2f;
                    maxAmmo = 60;
                    ammoUseEffect = Fx.casing3;
                    ammoEjectBack = 10;
                    displayAmmoMultiplier = true;
                    rotateSpeed = 90;
                    hasPower = true;
                    shoot = new ShootSpread(15, 4f);
                    velocityRnd = 0.17f;
                    hasLiquids = false;
                    researchCostMultiplier = 0.4f;

                    consumePower(8f);
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
                                knockback = 4.5f;
                                status = DawneStatusEffects.destabilized;
                                statusDuration = 140;
                                hittable = false;
                            }}
                    );
                }};

                int wallHealthMultiplier = 4;

                erumWall = new Wall("erum-wall") {{
                    requirements(Category.defense, with(DawneItems.erum, 8));
                    size = 1;
                    health = 100 * wallHealthMultiplier;
                    researchCostMultiplier = 0.1f;
                }};

                largeErumWall = new Wall("large-erum-wall") {{
                    requirements(Category.defense, with(DawneItems.erum, 32));
                    size = 2;
                    health = 100 * 4 * wallHealthMultiplier;
                    researchCostMultiplier = 0.1f;
                }};

                vasilWall = new Wall("vasil-wall") {{
                    requirements(Category.defense, with(DawneItems.caris, 4, DawneItems.vasil, 8));
                    size = 1;
                    health = 180 * wallHealthMultiplier;
                    researchCostMultiplier = 0.2f;
                }};

                largeVasilWall = new Wall("large-vasil-wall") {{
                    requirements(Category.defense, with(DawneItems.caris, 16, DawneItems.vasil, 32));
                    size = 2;
                    health = 180 * 4 * wallHealthMultiplier;
                    researchCostMultiplier = 0.2f;
                }};

                sevasWall = new Wall("sevas-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 5, DawneItems.vasil, 6, DawneItems.sevas, 8));
                    size = 1;
                    health = 250 * wallHealthMultiplier;
                    researchCostMultiplier = 0.2f;
                }};

                largeSevasWall = new Wall("large-sevas-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 20, DawneItems.vasil, 24, DawneItems.sevas, 32));
                    health = 250 * 4 * wallHealthMultiplier;
                    researchCostMultiplier = 0.3f;
                }};

                tavorWall = new Wall("tavor-wall"){{
                    requirements(Category.defense, with(DawneItems.caris, 8, DawneItems.vasil, 6, DawneItems.sevas, 10, DawneItems.tavor, 6));
                    size = 1;
                    health = 300 * wallHealthMultiplier;
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
                    health = 300 * 4 * wallHealthMultiplier;
                    researchCostMultiplier = 0.5f;
                    lightningChance = 0.4f;
                    lightningDamage = 8;
                    lightningLength = 125;
                    lightningColor = Color.valueOf("02de6b");
                    chanceDeflect = 0.6f;
                }};


                //TODO create more core units
                coreLegion = new CoreBlock("core-legion"){{
                    requirements(Category.effect, with(DawneItems.erum, 4500, DawneItems.caris, 3500, DawneItems.vasil, 2500, DawneItems.kasev, 5000, DawneItems.sevas, 3000));
                    health = 4500;
                    size = 3;
                    armor = 2;
                    itemCapacity = 13000;
                    unitCapModifier = 15;
                    unitType = DawneUnitTypes.contingent;
                    researchCostMultiplier = 0.12f;
                }};

                coreAllegiance = new CoreBlock("core-allegiance"){{
                    requirements(Category.effect, with(DawneItems.erum, 6000, DawneItems.caris, 4000, DawneItems.vasil, 3000, DawneItems.kasev, 6000, DawneItems.sevas, 4000, DawneItems.actium, 2500));
                    health = 7500;
                    size = 4;
                    armor = 4f;
                    itemCapacity = 14000;
                    unitCapModifier = 28;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.2f;
                }};

                coreDevotion = new CoreBlock("core-devotion"){{
                    requirements(Category.effect, with(DawneItems.erum, 9000, DawneItems.caris, 6000, DawneItems.vasil, 4000, DawneItems.kasev, 10000, DawneItems.sevas, 5500, DawneItems.actium, 3000, DawneItems.aspec, 500));
                    health = 8500;
                    size = 6;
                    armor = 12f;
                    itemCapacity = 18000;
                    unitCapModifier = 35;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.24f;
                }};


                // alternative to the Allegiance but the tech tree path for this won't lead to the Devotion
                coreFidelity = new CoreBlock("core-fidelity"){{
                    requirements(Category.effect, with(DawneItems.erum, 4500, DawneItems.caris, 4500, DawneItems.vasil, 2500, DawneItems.kasev, 4500, DawneItems.sevas, 3500, DawneItems.actium, 3500));
                    health = 6000;
                    size = 5;
                    armor = 8f;
                    itemCapacity = 13500;
                    unitCapModifier = 42;
                    unitType = UnitTypes.gamma;
                    researchCostMultiplier = 0.4f;
                }};

                storageDeposit = new StorageBlock("storage-deposit"){{
                    requirements(Category.effect, with(DawneItems.vasil, 200));
                    size = 3;
                    itemCapacity = 400;
                }};

                largeStorageDeposit = new StorageBlock("large-storage-deposit"){{
                    requirements(Category.effect, with(DawneItems.vasil, 400, DawneItems.sevas, 250));
                    size = 4;
                    itemCapacity = 1500;
                    coreMerge = false;
                }};

                warehouse = new StorageBlock("warehouse"){{
                    requirements(Category.effect, with(DawneItems.vasil, 800, DawneItems.sevas, 500, DawneItems.caris, 400, DawneItems.kasev, 700));
                    size = 8;
                    itemCapacity = 6000;
                    coreMerge = false;
                }};

                unitRepairStation = new RepairTower("unit-repair-station"){{
                    requirements(Category.units, with(DawneItems.caris, 50, DawneItems.kasev, 120, DawneItems.vasil, 20));
                    size = 2;
                    range = 80f;
                    healAmount = 0.8f;

                    consumePower(1.2f);
                }};

                unitPrimeRepairStation = new RepairTurret("unit-greater-repair-station"){{
                        requirements(Category.units, with(DawneItems.caris, 350, DawneItems.kasev, 200, DawneItems.erum, 200, DawneItems.vasil, 40, DawneItems.sevas, 200, DawneItems.aspec, 50, DawneItems.actium, 15));
                        size = 4;
                        repairSpeed = 4f;
                        repairRadius = 120f;
                        beamWidth = 1.05f;
                        pulseRadius = 7f;
                        length = 6f;
                        powerUse = 5.5f;

                        consumeItems(with(DawneItems.kasev, 2, DawneItems.aspec, 1));
                }};


                // a lustre-parallax turret that I'm confused where to put. Effect? Turret?
                laserTargeter = new TractorBeamTurret("laser-targeter"){{
                    requirements(Category.turret, with(DawneItems.erum, 200, DawneItems.caris, 50, DawneItems.kasev, 400, DawneItems.vasil, 200, DawneItems.sevas, 50, DawneItems.actium, 20));
                    size = 3;
                    hasPower = true;
                    force = 0f;
                    scaledForce = 0f;
                    range = 180f;
                    damage = 1f;
                    rotateSpeed = 6.5f;
                    targetGround = true;
                    targetAir = false;

                    consumePower(8f);
                }};

                regenerator = new MendProjector("regenerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 30, DawneItems.erum, 20));
                    size = 2;
                    reload = 220f;
                    range = 60f;
                    healPercent = 4f;
                    phaseBoost = 5f;
                    phaseRangeBoost = -15f;

                    consumePower(0.4f);
                    consumeItem(DawneItems.kasev).boost();
                }};

                massRegenerator = new MendProjector("mass-regenerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 150, DawneItems.vasil, 40, DawneItems.kasev, 50, DawneItems.erum, 40));
                    size = 4;
                    reload = 280f;
                    range = 150f;
                    healPercent = 12f;
                    phaseBoost = 16f;
                    phaseRangeBoost = -30f;

                    consumePower(2f);
                    consumeItem(DawneItems.aspec).boost();
                }};

                energyProjector = new ForceProjector("energy-projector"){{
                    requirements(Category.effect, with(DawneItems.caris, 200, DawneItems.vasil, 80, DawneItems.kasev, 150));
                    size = 3;
                    phaseRadiusBoost = 20f;
                    radius = 80f;
                    shieldHealth = 500;
                    cooldownNormal = 1.6f;
                    cooldownLiquid = 1.2f;
                    cooldownBrokenBase = 0.35f;

                    itemConsumer = consumeItem(DawneItems.aspec).boost();
                    consumePower(5f);
                }};

                massEnergyProjector = new ForceProjector("mass-energy-projector"){{
                    requirements(Category.effect, with(DawneItems.caris, 400, DawneItems.vasil, 100, DawneItems.kasev, 200, DawneItems.aspec, 50, DawneItems.actium, 80));
                    size = 5;
                    radius = 160f;
                    shieldHealth = 1800;
                    cooldownNormal = 3f;
                    cooldownLiquid = 2f;
                    cooldownBrokenBase = 0.4f;

                    itemConsumer = consumeItems(with(DawneItems.kasev, 1, DawneItems.aspec, 2));
                    consumePower(12f);
                }};

                // you will probably never be able to build this yourself in the Dawne campaign
                aegisFate = new BaseShield("aegis-fate"){{
                    requirements(Category.effect, with(DawneItems.erum, 600, DawneItems.vasil, 200, DawneItems.caris, 600, DawneItems.kasev, 560, DawneItems.aspec, 250, DawneItems.actium, 100, DawneItems.tavor, 200));
                    size = 6;
                    radius = 90;

                    consumePower(30f);
                    consumeItems(with(DawneItems.kasev, 3, DawneItems.aspec, 2, DawneItems.tavor, 1));
                }};

                accelerator = new OverdriveProjector("accelerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 80, DawneItems.vasil, 40, DawneItems.kasev, 50, DawneItems.aspec, 20));
                    size = 2;
                    hasPower = true;
                    range = 90;
                    speedBoost = 1.5f;
                    consumePower(4f);
                    hasBoost = false;

                    consumeItem(DawneItems.aspec).boost();
                }};

                primeAccelerator = new OverdriveProjector("prime-accelerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 350, DawneItems.vasil, 500, DawneItems.kasev, 250, DawneItems.sevas, 400, DawneItems.aspec, 85));
                    size = 4;
                    hasPower = true;
                    reload = 180;
                    range = 180;
                    speedBoost = 2.8f;
                    useTime = 360;
                    itemCapacity = 15;
                    consumePower(11.5f);
                    hasBoost = false;

                    consumeItems(with(DawneItems.kasev, 2, DawneItems.aspec, 3));
                }};

                massAccelerator = new OverdriveProjector("mass-accelerator"){{
                    requirements(Category.effect, with(DawneItems.caris, 800, DawneItems.vasil, 400, DawneItems.kasev, 500, DawneItems.sevas, 450, DawneItems.aspec, 200, DawneItems.tavor, 100));
                    size = 5;
                    hasPower = true;
                    reload = 200;
                    range = 400;
                    speedBoost = 1.8f;
                    useTime = 250;
                    itemCapacity = 10;
                    consumePower(16f);
                    hasBoost = false;

                    consumeItems(with(DawneItems.kasev, 5, DawneItems.aspec, 6, DawneItems.tavor, 2));
                }};
            }
        };
    }
}