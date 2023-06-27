package dawneproject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Liquid;

import static mindustry.content.Liquids.*;

public class DawneLiquids {

    public static Liquid

            //coolants - Dawne

            camberCoolant;

    public static Seq<Liquid> DawneLiquids = new Seq<>();
    public static Seq<Liquid> DawneOnlyLiquids = new Seq<>();

    public static void load() {
        camberCoolant = new Liquid("camber-coolant", Color.valueOf("7efbbb3")){{
            viscosity = 0.02f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.2f;
            boilPoint = 40f;
            canStayOn.add(water);
        }};
        DawneLiquids.addAll(camberCoolant);
        DawneOnlyLiquids.addAll(camberCoolant);
    }
}
