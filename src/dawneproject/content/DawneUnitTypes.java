package dawneproject.content;

import mindustry.type.*;
import mindustry.type.UnitType;
import mindustry.entities.bullet.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import mindustry.content.StatusEffects;
import mindustry.content.Fx;
import mindustry.gen.Sounds;

public class DawneUnitTypes {

    public static UnitType

    // assault aerial

    portent;

    public static void load() {
        portent = new UnitType("portent"){{
            health = 25;
            speed = 2.65f;
            accel = 0.12f;
            drag = 0.010f;
            flying = true;
            hitSize = 11f;
            targetAir = false;
            engineOffset = 6f;
            range = 140f;
            faceTarget = false;
            armor = 1f;
            itemCapacity = 10;
            targetFlags = new BlockFlag[]{BlockFlag.factory, null};
            circleTarget = true;
            ammoType = new ItemAmmoType(DawneItems.verent);

            weapons.add(new Weapon(){{
                minShootVelocity = 0.75f;
                x = 3f;
                shootY = 0f;
                reload = 12f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 48f;
                shoot.shots = 6;
                shoot.shotDelay = 3f;
                ignoreRotation = true;
                shootSound = Sounds.none;
                bullet = new BombBulletType(1, 20f){{
                    width = 8f;
                    height = 12f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }};
            }});
        }};}
    }