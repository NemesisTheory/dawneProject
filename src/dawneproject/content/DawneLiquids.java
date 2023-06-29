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
        camberCoolant = new Liquid("camber-coolant", Color.valueOf("7efbbb3")){{
            viscosity = 0.02f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.2f;
            boilPoint = 40f;
            canStayOn.add(water);
        }};

        hypercoolant = new Liquid("hypercoolant", Color.valueOf("111111")){{
            viscosity = 0.04f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.6f;
            boilPoint = 90f;
        }};
    }
}
