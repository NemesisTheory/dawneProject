package dawneproject.content;

import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;

public class DawneUnitTypes {

    public static UnitType

            //yes most of these names are from Architects songs

    // specialist ground

    hymn, anthem, serenade, symphony, euphony,

    // assault ground

    misanthrope, naysayer, despondent, nihilist, fatalist,

    // assault aerial

    portent, premonition, doomsday, hereafter, damnation,

    // special

    deathwish, gravedigger, downfall, icarus, solstice, everglow,

    // core

    contingent;

    public static void load() {
        /* portent = new UnitType("portent") {{
            health = 60;
            speed = 2.85f;
            accel = 0.09f;
            drag = 0.008f;
            flying = true;
            hitSize = 11f;
            targetAir = false;
            engineOffset = 6f;
            range = 140f;
            faceTarget = false;
            armor = 0f;
            itemCapacity = 0;
            targetFlags = new BlockFlag[]{BlockFlag.factory, null};
            circleTarget = true;
            ammoType = new ItemAmmoType(DawneItems.caris);

            weapons.add(new Weapon() {{
                minShootVelocity = 0.75f;
                x = 3f;
                shootY = 0f;
                reload = 8f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 18f;
                ignoreRotation = true;
                shootSound = Sounds.none;
                bullet = new BombBulletType(6f, 16.8f) {{
                    width = 8f;
                    height = 10f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;

                    status = StatusEffects.blasted;
                    statusDuration = 30f;
                }};
            }});
        }};*/
    }
}