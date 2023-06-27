package dawneproject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class DawneItems {
    public static Item

    //raw - Dawne

    erum, verent, vasil, sevas,

    //manufactured - Dawne

    caris, actium, placeholderName;

    public static Seq<Item> DawneItems = new Seq<>();
    public static Seq<Item> DawneOnlyItems = new Seq<>();

    public static void load() {
        erum = new Item("erum", Color.valueOf("537d90")){{
            flammability = 0f;
            cost = 1.0f;
            hardness = 2;
            explosiveness = 0f;
            radioactivity = 0f;
        }};

        verent = new Item("verent", Color.valueOf("a3837e")){{
            flammability = 0.15f;
            cost = 1.0f;
            hardness = 1;
            explosiveness = 0.20f;
            radioactivity = 0f;
        }};

        //TODO vasil color
        vasil = new Item("vasil", Color.valueOf("111111")){{
            flammability = 0.4f;
            cost = 1.2f;
            hardness = 3;
            explosiveness = 0f;
            radioactivity = 1.3f;
        }};

        //TODO name change + color (change history: "kastov" to "sevas"
        sevas = new Item("sevas", Color.valueOf("222222")){{
            flammability = 0.54f;
            cost = 1.3f;
            hardness = 3;
            explosiveness = 0.12f;
            radioactivity = 2.8f;
        }};

        caris = new Item("caris", Color.valueOf("7973d3")){{
            flammability = 0f;
            cost = 1.1f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 0f;
        }};

        //TODO actium color
        actium = new Item("actium", Color.valueOf("555555")){{
            flammability = 0f;
            cost = 1.3f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 0.8f;
        }};

        //TODO change name obviously, phase-like material
        placeholderName = new Item("placeholder-name", Color.valueOf("333333")){{
            flammability = 0f;
            cost = 1.4f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 1.2f;
        }};

        DawneItems.addAll(erum,verent, vasil, sevas, caris, actium);
        DawneOnlyItems.addAll(erum, verent, vasil, sevas, caris, actium);
    }
}