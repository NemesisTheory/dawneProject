package dawneproject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class DawneItems {
    public static Item

    //raw - Dawne

    erum, verent, vasil, sevas, talcPowder,

    //manufactured - Dawne

    caris, kasev, actium, aspec, tavor;

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

        vasil = new Item("vasil", Color.valueOf("b7c9e2")){{
            flammability = 0.4f;
            cost = 1.2f;
            hardness = 3;
            explosiveness = 0f;
            radioactivity = 1.3f;
        }};

        //TODO name change?
        sevas = new Item("sevas", Color.valueOf("192841")){{
            flammability = 0.54f;
            cost = 1.3f;
            hardness = 3;
            explosiveness = 0.12f;
            radioactivity = 2.8f;
        }};

        talcPowder = new Item("talc-powder", Color.valueOf("c0ad79")){{
            flammability = 0.4f;
            cost = 1f;
            hardness = 1;
            explosiveness = 0.1f;
            radioactivity = 0.08f;
        }};

        caris = new Item("caris", Color.valueOf("7973d3")){{
            flammability = 0f;
            cost = 1.1f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 0f;
        }};

        actium = new Item("actium", Color.valueOf("9abdcc")){{
            flammability = 0f;
            cost = 1.3f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 0.8f;
        }};

        kasev = new Item("kasev", Color.valueOf("c0afe2")){{
            flammability = 0.05f;
            cost = 1.0f;
            hardness = 3;
            explosiveness = 0f;
            radioactivity = 0.02f;
        }};

        aspec = new Item("aspec", Color.valueOf("e5f3fd")){{
            flammability = 0f;
            cost = 1.4f;
            hardness = 1;
            explosiveness = 0f;
            radioactivity = 1.2f;
        }};

        tavor = new Item("tavor", Color.valueOf("014421")){{
            flammability = 0.25f;
            cost = 1.4f;
            hardness = 1;
            explosiveness = 0.6f;
            radioactivity = 0.8f;
        }};

        //side note these names are so bad

        DawneItems.addAll(erum,verent, vasil, sevas, talcPowder, caris, kasev, actium, aspec, tavor);
        DawneOnlyItems.addAll(erum, verent, vasil, sevas, talcPowder, caris, kasev, actium, aspec, tavor);
    }
}