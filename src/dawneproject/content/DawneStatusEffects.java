package dawneproject.content;

import arc.graphics.*;
import mindustry.type.*;

public class DawneStatusEffects {
    public static StatusEffect

    // damaging

    meltdown, instantDestroy,

    // healing

    regenerating, instantRepair,

    // disrupting

    destabilized, shutdown, invincibleDisarmedUnmoving,

    // supporting

    accelerate;

    public static void load() {
        meltdown = new StatusEffect("meltdown-status"){{
            speedMultiplier = 0.45f;
            buildSpeedMultiplier = 0.45f;
            dragMultiplier = 0.4f;
            reloadMultiplier = 0.19f;
            damage = 8;
        }};

        instantDestroy = new StatusEffect("instant-destroy"){{
            damage = 16666666f;
            show = false;
        }};

        regenerating = new StatusEffect("regenerating"){{
            speedMultiplier = 0.85f;
            reloadMultiplier = 0.79f;
            damage = -5.6f;
        }};

        instantRepair = new StatusEffect("instant-repair"){{
            damage = -16666666f;
            show = false;
        }};

        destabilized = new StatusEffect("destabilized"){{
            speedMultiplier = 0.35f;
            buildSpeedMultiplier = 0.24f;
            dragMultiplier = 0.37f;
            reloadMultiplier = 0.34f;
        }};

        shutdown = new StatusEffect("shutdown"){{
            speedMultiplier = 0f;
            buildSpeedMultiplier = 0f;
            dragMultiplier = 0f;
            disarm = true;
        }};

        invincibleDisarmedUnmoving = new StatusEffect("invincible-disarmed-unmoving"){{
            speedMultiplier = 0f;
            buildSpeedMultiplier = 0f;
            dragMultiplier = 0f;
            healthMultiplier = 16666666f;
            disarm = true;
        }};

        accelerate = new StatusEffect("accelerate"){{
            speedMultiplier = 5.5f;
            dragMultiplier = 0f;
        }};
    }
}
