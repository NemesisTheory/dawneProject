package dawneproject.content;

import arc.graphics.*;
import mindustry.type.*;

public class DawneStatusEffects {
    public static StatusEffect

    // damaging

    meltdown,

    // healing

    regenerating,

    // disrupting

    destabilized, shutdown;

    public static void load() {
        meltdown = new StatusEffect("meltdown-status"){{
            speedMultiplier = 0.45f;
            buildSpeedMultiplier = 0.45f;
            dragMultiplier = 0.4f;
            reloadMultiplier = 0.19f;
            damage = 8;
        }};

        regenerating = new StatusEffect("regenerating"){{
            speedMultiplier = 0.85f;
            reloadMultiplier = 0.79f;
            damage = -5.6f;
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
    }
}
