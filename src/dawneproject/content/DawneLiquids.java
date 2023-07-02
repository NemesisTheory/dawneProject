package dawneproject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Liquid;

import static mindustry.content.Liquids.*;

public class DawneLiquids {

    public static Liquid

            //coolants - Dawne

            camberCoolant, hypercoolant;

    public static void load() {
        // cools down: Turrets, buildings, factories, reactors.
        camberCoolant = new Liquid("camber-coolant", Color.valueOf("7efbbb3")){{
            viscosity = 0.02f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.2f;
            boilPoint = 40f;
            canStayOn.add(water);
        }};

        // cools down: Reactors. (TODO)
        hypercoolant = new Liquid("hypercoolant", Color.valueOf("111111")){{
            viscosity = 0.04f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.8f;
            boilPoint = 80f;
        }};
    }
}
