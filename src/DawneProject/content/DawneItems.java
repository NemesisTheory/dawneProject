package DawneProject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class DawneItems {
    public static Item

    //Dawne

    erum, verent, caris;

    public static Seq<Item> DawneItems = new Seq<>();
    public static Seq<Item> DawneOnlyItems = new Seq<>();

    public static void load() {
        erum = new Item("erum", Color.valueOf("537d90")){{
            flammability = 0f;
            cost = 1.0f;
            hardness = 2;
            radioactivity = 0f;
        }};

        verent = new Item("verent", Color.valueOf("a3837e")){{
            flammability = 0.15f;
            cost = 1.0f;
            hardness = 1;
            radioactivity = 0f;
        }};

        caris = new Item("caris", Color.valueOf("d39573")){{
            flammability = 0f;
            cost = 1.1f;
            hardness = 3;
            radioactivity = 0f;
        }};

        DawneItems.addAll(erum,verent, caris);
        DawneOnlyItems.addAll(erum, verent, caris);
    }
}