package dawneproject.content.type;

import mindustry.game.Team;
import mindustry.gen.Payloadc;
import mindustry.gen.Unit;
import mindustry.type.StatusEffect;
import mindustry.entities.Units;

public class ExtrasStatus extends StatusEffect {
    public boolean targetable = false;
    public boolean vulnerableWithPayloads = false;

    public ExtrasStatus(String name) {
        super(name);
    }

    public boolean targetable(Unit unit, Team targeter){
        return targetable || (vulnerableWithPayloads && unit instanceof Payloadc p && p.hasPayload());
    }
}
