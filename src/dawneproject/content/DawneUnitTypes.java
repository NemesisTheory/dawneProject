package dawneproject.content;

import arc.struct.ObjectSet;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.ai.types.*;

public class DawneUnitTypes {

    public static UnitType

    // specialist ground

    hymn, anthem, serenade, symphony, euphony,

    // assault ground

    misanthrope, naysayer, despondent, nihilist, fatalist,

    // assault aerial

    portent, premonition, doomsday, hereafter, damnation,

    // special

    deathwish,

    // core

    contingent;

    public static void load() {

        hymn = new UnitType("hymn"){{
            aiController = SuicideAI::new;

            hitSize = 16;
            constructor = UnitEntity::create;
            health = 450;
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
            range = 50;
            mechSideSway = 0.3f;
            deathSound = Sounds.explosionbig;

            weapons.add(new Weapon("hymn1"){{
                shootOnDeath = true;
                reload = 24;
                shootCone = 180f;
                shootSound = Sounds.explosionbig;
                x = shootY = 0f;
                mirror = false;
                top = false;
                ignoreRotation = true;
                bullet = new BulletType(){{
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
                    splashDamageRadius = 40;
                    makeFire = true;
                    incendAmount = 2;
                    incendSpread = 6;
                    incendChance = 0.08f;
                    shootEffect = Fx.scatheExplosion;
                }};
            }});

        }};

        anthem = new UnitType("anthem"){{
            hitSize = 28;
            constructor = UnitEntity::create;
            health = 650;
            targetAir = false;
            armor = 2;
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
            range = 50;
            mechSideSway = 0.30f;
            deathSound = Sounds.explosionbig;

            immunities = ObjectSet.with(StatusEffects.shocked, StatusEffects.overclock, StatusEffects.wet, StatusEffects.electrified);

            weapons.add(new Weapon("anthemrail"){{
                rotate = false;
                x = 6;
                y = 3;
                reload = 154;
                recoil = 3.4f;
                shake = 2;
                shootSound = Sounds.shotgun;
                bullet = new BasicBulletType(40, 65){{
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
            weapons.add(new Weapon("anthemauto"){{
                rotate = true;
                x = 0;
                y = -3;
                mirror = true;
                reload = 8;
                shoot = new ShootAlternate(){{
                    shots = 1;
                    barrels = 2;
                }};
                inaccuracy = 2;
                shootCone = 8;
                recoil = 4;
                shake = 1.4f;
                shootSound = Sounds.shootBig;
                bullet = new BasicBulletType(10, 12){{
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

        misanthrope = new UnitType("misanthrope"){{
            health = 250;
            constructor = UnitEntity::create;
            speed = 1.25f;
            range = 50;
            hitSize = 12;
            armor = 1;
            rotateSpeed = 8.2f;
            deathSound = Sounds.explosionbig;

            immunities = ObjectSet.with(DawneStatusEffects.meltdownStatus, StatusEffects.overclock, StatusEffects.melting);

            weapons.add(new Weapon("mg1"){{
                rotate = false;
                x = 0;
                y = 6;
                reload = 15;
                recoil = 1.4f;
                shake = 1.1f;
                inaccuracy = 2;
                shootCone = 4;
                shoot = new ShootAlternate(){{
                    shots = 1;
                    barrels = 2;
                }};
                bullet = new BasicBulletType(12, 4){{
                    hitSize = 4;
                    collidesAir = true;
                    lifetime = 25;
                    mirror = true;
                }};
            }});

            weapons.add(new Weapon("cnn1"){{
                rotate = true;
                x = 0;
                y = 0;
                reload = 120;
                recoil = 1.9f;
                shake = 1.1f;
                inaccuracy = 2;
                shootCone = 4;
                bullet = new BasicBulletType(4, 55){{
                    hitSize = 3;
                    collidesAir = true;
                    width = 1.5f;
                    height = 4;
                    lifetime = 25;
                }};
            }});

            abilities.add(new ShieldArcAbility(){{
                radius = 12f;
                angle = 82;
                regen = 0.3f;
                cooldown = 9f * 60f;
                max = 80;
                y = -10;
                width = 4f;
                whenShooting = true;
            }});

            abilities.add(new ShieldArcAbility(){{
                radius = 12f;
                angle = 82;
                regen = 0.3f;
                cooldown = 9f * 60f;
                max = 80;
                y = 10;
                width = 4f;
                whenShooting = true;
            }});
        }};

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
            itemCapacity = 5;
            targetFlags = new BlockFlag[]{BlockFlag.factory, null};
            circleTarget = true;
            ammoType = new ItemAmmoType(DawneItems.napalm);

            weapons.add(new Weapon() {{
                minShootVelocity = 0.75f;
                x = 3f;
                shootY = 0f;
                reload = 12f;
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
                health = 12580;
                constructor = UnitEntity::create;
                hitSize = 32;
                armor = 12;
                speed = 0.85f;
                rotateSpeed = 2.4f;
                range = 144;
                mechSideSway = 0.30f;
                mechFrontSway = 1.2f;
                mechStepParticles = true;
                stepShake = 0.21f;
                drownTimeMultiplier = 5;
                deathSound = Sounds.explosionbig;

                immunities = ObjectSet.with(StatusEffects.shocked, StatusEffects.burning, DawneStatusEffects.destabilized, DawneStatusEffects.shutdown);

                weapons.add(new Weapon("deathwish1") {{
                        top = false;
                        mirror = false;
                        shake = 1;
                        reload = 280;
                        recoil = 64;
                        rotate = false;
                        bullet = new BasicBulletType(5, 0) {{
                                lifetime = 10;
                                width = 0;
                                height = 0;
                                hitSize = 0;
                            }
                        };
                    }
                });
                weapons.add(new Weapon("deathwish2"){{
                    controllable = false;
                    autoTarget = true;
                    shake = 2;
                    rotate = true;
                    targetInterval = 15;
                    targetSwitchInterval = 20;
                    rotateSpeed = 2.2f;
                    reload = 6;
                    recoil = 2;
                    bullet = new BasicBulletType(10, 42){{
                        inaccuracy = 6;
                        x = 0;
                        y = 16;
                        shootCone = 12;
                        shoot = new ShootAlternate(){{
                                shots = 1;
                                barrels = 3;
                                spread = 4f;
                                shotDelay = 0.5f;
                                width = 10;
                            }};
                        height = 16;
                        width = 10;
                        hitSize = 6;
                        lifetime = 28;
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

        contingent = new UnitType("contingent"){{
            flying = true;
            health = 350;
            constructor = UnitEntity::create;
            speed = 4.25f;
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

            weapons.add(new Weapon("contingent-laser"){{
                rotate = false;
                x = 0;
                y = 0;
                reload = 135;
                recoil = 3.6f;
                shake = 2;
                shootSound = Sounds.laser;
                drag = 0.011f;
                bullet = new LaserBulletType(120){{
                    status = DawneStatusEffects.destabilized;
                    statusDuration = 30;
                    length = 173;
                    hitSize = 4;
                    lifetime = 16;
                    drawSize = 400;
                    collidesAir = true;
                    absorbable = true;
                    pierce = true;
                    pierceCap = 4;
                    buildingDamageMultiplier = 0.01f;
                }};
            }});
            weapons.add(new Weapon("contingent-machine"){{
                rotate = true;
                x = 0;
                y = 0;
                reload = 6;
                recoil = 1.5f;
                shake = 2;
                shootSound = Sounds.pew;
                drag = 0.02f;
                bullet = new BasicBulletType(5, 20){{
                    hitSize = 3;
                    width = 4;
                    height = 8;
                    lifetime = 32;
                    shoot = new ShootAlternate(){{
                            shots = 1;
                            barrels = 3;
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
}