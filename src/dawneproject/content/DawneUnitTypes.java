package dawneproject.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.math.geom.*;
import arc.struct.ObjectSet;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.ai.types.*;

public class DawneUnitTypes {

    public static UnitType

            // specialist ground (spider)

            hymn, anthem,

            // assault ground (mech)

            misanthrope,

            // secondary assault ground (tank)

            gleam, radiance, everglow, incandescence,

            // assault aerial

            portent,

            /* special
            * tier 4 to tier 6 in strength, this is gonna be a pain to balance
            * 4: Deathwish
            * 5: Gravedigger, Northlane
            * 6: Daybreaker, Architect, Alpha Omega
            */

            deathwish, gravedigger, northlane, daybreaker, architect, ao,

            // core

            contingent;

    public static void load() {

        hymn = new UnitType("hymn") {{
            aiController = SuicideAI::new;

            hitSize = 16;
            itemCapacity = 0;
            constructor = MechUnit::create;
            health = 250;
            armor = 4;
            speed = 1.4f;
            rotateSpeed = 190;
            legCount = 4;
            legLength = 12;
            legBaseOffset = 5;
            legExtension = -1;
            legSpeed = 0.8f;
            legGroupSize = 3;
            allowLegStep = true;
            drawShields = true;
            range = 40;
            mechSideSway = 0.3f;
            deathSound = Sounds.explosionbig;

            weapons.add(new Weapon("hymn1") {{
                shootOnDeath = true;
                reload = 24;
                shootCone = 180f;
                shootSound = Sounds.explosionbig;
                x = shootY = 0f;
                mirror = false;
                top = false;
                ignoreRotation = true;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    rangeOverride = 40;
                    collides = false;
                    hitSound = Sounds.explosionbig;
                    speed = 0f;
                    hitEffect = Fx.pulverizeMedium;
                    instantDisappear = true;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                    splashDamage = 180;
                    splashDamageRadius = 50;
                    makeFire = true;
                    incendAmount = 2;
                    incendSpread = 6;
                    incendChance = 0.08f;
                    shootEffect = Fx.scatheExplosion;
                }};
            }});

        }};

        anthem = new UnitType("anthem") {{
            hitSize = 28;
            itemCapacity = 0;
            constructor = LegsUnit::create;
            health = 750;
            targetAir = false;
            armor = 3;
            speed = 0.68f;
            rotateSpeed = 2.4f;
            legCount = 6;
            legLength = 14;
            legBaseOffset = 5;
            legExtension = -1;
            legSpeed = 0.8f;
            legGroupSize = 3;
            allowLegStep = true;
            legSplashDamage = 10;
            legSplashRange = 12;
            drawShields = true;
            mechSideSway = 0.30f;
            deathSound = Sounds.explosionbig;

            immunities = ObjectSet.with(StatusEffects.shocked, StatusEffects.overclock, StatusEffects.wet, StatusEffects.electrified);

            weapons.add(new Weapon("anthem-rail") {{
                rotate = false;
                x = 6;
                y = 3;
                reload = 154;
                recoil = 3.4f;
                shake = 2;
                shootSound = Sounds.shotgun;
                bullet = new BasicBulletType(40, 65) {{
                    width = 0;
                    height = 0;
                    hitSize = 4;
                    lifetime = 5;
                    hittable = false;
                    collidesAir = false;
                    absorbable = false;
                    pierce = true;
                    pierceCap = 3;
                    pierceArmor = true;
                    pierceBuilding = true;
                    status = DawneStatusEffects.destabilized;
                    statusDuration = 20;
                }};
            }});
            weapons.add(new Weapon("anthem-weapon") {{
                rotate = true;
                x = 0;
                y = -3;
                mirror = true;
                reload = 8;
                shoot = new ShootBarrel() {{
                    barrels = new float[]{
                            -1, -1,
                            0, 0,
                            1, 1,
                    };
                    shots = 1;
                }};
                inaccuracy = 2;
                shootCone = 8;
                recoil = 4;
                shake = 1.4f;
                shootSound = Sounds.shootBig;
                bullet = new BasicBulletType(10, 12) {{
                    hitSize = 4;
                    lifetime = 20.5f;
                    hittable = true;
                    absorbable = true;
                    pierce = true;
                    pierceCap = 2;
                    pierceArmor = false;
                    pierceBuilding = true;
                }};
            }});
            abilities.add(new ForceFieldAbility(30f, 0.9f, 140f, 425));

            abilities.add(new StatusFieldAbility(StatusEffects.overclock, 220, 520, 185));
        }};

        misanthrope = new UnitType("misanthrope") {{
            health = 250;
            constructor = MechUnit::create;
            speed = 1.25f;
            hitSize = 12;
            armor = 1;
            rotateSpeed = 8.2f;
            deathSound = Sounds.explosionbig;
            itemCapacity = 0;

            immunities = ObjectSet.with(DawneStatusEffects.meltdownStatus, StatusEffects.overclock, StatusEffects.melting);

            weapons.add(new Weapon("misanthrope-weapon") {{
                rotate = false;
                x = 0;
                y = 6;
                reload = 15;
                recoil = 1.4f;
                shake = 1.1f;
                inaccuracy = 2;
                shootCone = 4;
                shoot = new ShootBarrel() {{
                    barrels = new float[]{
                            0, 1, 0,
                            1, 0, 1,
                            0, 1, 0,
                    };
                    shots = 1;
                }};
                bullet = new BasicBulletType(12, 4) {{
                    hitSize = 4;
                    collidesAir = true;
                    lifetime = 23;
                    mirror = true;
                }};
            }});

            weapons.add(new Weapon("misanthrope-cannon") {{
                rotate = true;
                x = 0;
                y = 0;
                reload = 120;
                recoil = 1.9f;
                shake = 1.1f;
                inaccuracy = 2;
                shootCone = 4;
                bullet = new BasicBulletType(12, 55) {{
                    hitSize = 3;
                    collidesAir = true;
                    width = 1.5f;
                    height = 4;
                    lifetime = 23;
                }};
            }});

            abilities.add(new ShieldArcAbility() {{
                radius = 12f;
                angle = 82;
                regen = 0.3f;
                cooldown = 9f * 60f;
                max = 80;
                y = -1;
                width = 4f;
                whenShooting = true;
            }});

            abilities.add(new ShieldArcAbility() {{
                radius = 12f;
                angle = 82;
                regen = 0.3f;
                cooldown = 9f * 60f;
                max = 80;
                y = 1;
                width = 4f;
                whenShooting = true;
            }});
        }};

        gleam = new TankUnitType("gleam") {
            {
                hitSize = 18f;
                treadPullOffset = 5;
                speed = 0.67f;
                health = 1850;
                armor = 4f;
                treadRects = new Rect[]{new Rect(16 - 60f, 48 - 70f, 30, 75), new Rect(44 - 60f, 17 - 70f, 17, 60)};

                constructor = TankUnit::create;
                weapons.add(new Weapon("dawneproject-gleam-weapon") {{
                    shootSound = Sounds.dullExplosion;
                    layerOffset = 0.0001f;
                    reload = 80f;
                    shootY = 11f;
                    recoil = 3f;
                    rotate = true;
                    rotateSpeed = 1.3f;
                    mirror = false;
                    shootCone = 2f;
                    x = 0f;
                    y = -1f;
                    heatColor = Color.valueOf("f9350f");
                    cooldownTime = 30f;
                    bullet = new BasicBulletType(7f, 110) {{
                        width = 4.5f;
                        sprite = "missile-large";
                        height = 11f;
                        lifetime = 27f;
                        hitSize = 4f;
                        pierceCap = 2;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 2.8f;
                        trailLength = 8;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        shootEffect = Fx.shootTitan;
                        smokeEffect = Fx.shootSmokeTitan;
                        splashDamageRadius = 12f;
                        splashDamage = 10;

                        trailEffect = Fx.hitSquaresColor;
                        trailRotation = true;
                        trailInterval = 3f;

                        parts.addAll(
                                new RegionPart("-glow") {{
                                    color = Color.red;
                                    blending = Blending.additive;
                                    outline = mirror = false;
                                }});
                    }};
                }});

                portent = new UnitType("portent") {{
                    health = 360;
                    constructor = UnitEntity::create;
                    speed = 2.85f;
                    accel = 0.09f;
                    drag = 0.008f;
                    flying = true;
                    hitSize = 11f;
                    targetAir = false;
                    engineOffset = 6f;
                    range = 140f;
                    faceTarget = false;
                    armor = 1f;
                    itemCapacity = 0;
                    targetFlags = new BlockFlag[]{BlockFlag.factory, null};
                    circleTarget = true;
                    ammoType = new ItemAmmoType(DawneItems.napalm);

                    weapons.add(new Weapon() {{
                        minShootVelocity = 0.75f;
                        x = 3f;
                        shootY = 0f;
                        reload = 60f;
                        cooldownTime = 90f;
                        shootCone = 180f;
                        ejectEffect = Fx.none;
                        inaccuracy = 45f;
                        shoot.shots = 6;
                        shoot.shotDelay = 3f;
                        ignoreRotation = true;
                        bullet = new BombBulletType(25f, 18.8f) {{
                            width = 8f;
                            height = 10f;
                            hitEffect = Fx.flakExplosion;
                            shootEffect = Fx.none;
                            smokeEffect = Fx.none;

                            status = StatusEffects.blasted;
                            statusDuration = 30f;

                            makeFire = true;
                            incendAmount = 1;
                            incendChance = 0.01f;
                            incendSpread = 2f;
                        }};
                    }});
                }};

                deathwish = new UnitType("deathwish") {{
                    health = 8580;
                    constructor = MechUnit::create;
                    hitSize = 32;
                    armor = 8;
                    speed = 0.85f;
                    rotateSpeed = 2.4f;
                    mechSideSway = 0.30f;
                    mechFrontSway = 1.2f;
                    mechStepParticles = true;
                    stepShake = 0.21f;
                    drownTimeMultiplier = 5;
                    deathSound = Sounds.explosionbig;
                    itemCapacity = 0;

                    immunities = ObjectSet.with(StatusEffects.shocked, StatusEffects.burning, DawneStatusEffects.destabilized, DawneStatusEffects.shutdown);

                    // it's 'dash' ability
                    weapons.add(new Weapon("deathwish1") {
                        {
                            top = false;
                            mirror = false;
                            shake = 1;
                            reload = 280;
                            recoil = 4;
                            rotate = false;
                            bullet = new ContinuousLaserBulletType(0) {
                                {
                                    lifetime = 140f;
                                    width = 0f;
                                    length = 0f;
                                    drawSize = 0f;
                                    hitSize = 0f;
                                    recoil = -20f;
                                }
                            };
                        }
                    });
                    weapons.add(new Weapon("deathwish-weapon") {{
                        controllable = false;
                        autoTarget = true;
                        shake = 2;
                        rotate = true;
                        targetInterval = 15;
                        targetSwitchInterval = 20;
                        rotateSpeed = 2.2f;
                        reload = 6;
                        recoil = 2;
                        bullet = new BasicBulletType(10, 25) {{
                            inaccuracy = 6;
                            x = 0;
                            y = 16;
                            shootCone = 12;
                            shoot = new ShootBarrel() {{
                                barrels = new float[]{
                                        -1, -1,
                                        0, 0,
                                        1, 1,
                                };
                                shots = 1;
                                shotDelay = 0.5f;
                                width = 10;
                            }};
                            height = 16;
                            width = 10;
                            hitSize = 6;
                            lifetime = 21;
                            hittable = true;
                            collidesAir = true;
                            absorbable = true;
                            pierce = true;
                            pierceCap = 3;
                            pierceArmor = true;
                            pierceBuilding = true;
                            mirror = true;
                        }};
                    }});
                }};

                contingent = new UnitType("contingent") {{
                    flying = true;
                    health = 350;
                    constructor = UnitEntity::create;
                    speed = 3.92f;
                    accel = 0.8f;
                    mineTier = 3;
                    buildSpeed = 0.89f;
                    mineSpeed = 1.5f;
                    armor = 2;
                    engineOffset = 0;
                    engineSize = 2;
                    hitSize = 16;
                    rotateSpeed = 16;
                    itemCapacity = 25;

                    immunities = ObjectSet.with(StatusEffects.melting, DawneStatusEffects.destabilized);

                    weapons.add(new Weapon("contingent-laser") {{
                        rotate = false;
                        x = 0;
                        y = 0;
                        reload = 135;
                        recoil = 3.6f;
                        shake = 2;
                        shootSound = Sounds.laser;
                        bullet = new LaserBulletType(50) {{
                            status = DawneStatusEffects.destabilized;
                            statusDuration = 20;
                            length = 153;
                            hitSize = 4;
                            lifetime = 16;
                            drawSize = 400;
                            collidesAir = true;
                            absorbable = true;
                            pierce = true;
                            pierceCap = 3;
                            buildingDamageMultiplier = 0.01f;
                        }};
                    }});
                    weapons.add(new Weapon("contingent-weapon") {{
                        rotate = true;
                        x = 0;
                        y = 0;
                        reload = 6;
                        recoil = 1.5f;
                        shake = 2;
                        shootSound = Sounds.pew;
                        drag = 0.02f;
                        bullet = new BasicBulletType(5, 12) {{
                            hitSize = 3;
                            width = 4;
                            height = 8;
                            lifetime = 22;
                            shoot = new ShootBarrel() {{
                                barrels = new float[]{
                                        6, 0, 0,
                                        -6, 0, 0,
                                        0, 6, 0,
                                };
                                shots = 1;
                            }};
                            collidesAir = false;
                            absorbable = true;
                            inaccuracy = 4;
                            shootCone = 8;
                            buildingDamageMultiplier = 0.01f;
                        }};
                    }});
                }};
            }
        };
    }
}