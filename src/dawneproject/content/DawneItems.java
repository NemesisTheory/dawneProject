package dawneproject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import dawneproject.content.type.ExtrasItem;
import mindustry.type.Item;

public class DawneItems {
    public static Item

            //raw - Dawne

            erum, verent, vasil, rime, sevas, talc,

            //manufactured - Dawne

            caris, napalm, kasev, actium, aspec, tavor;

    public static Seq<Item> DawneItems = new Seq<>();
    public static Seq<Item> DawneOnlyItems = new Seq<>();

    public static Seq<Item> VolirItems = new Seq<>();
    public static Seq<Item> VolirOnlyItems = new Seq<>();

    public static Seq<Item> ConcordItems = new Seq<>();
    public static Seq<Item> ConcordOnlyItems = new Seq<>();

    public static void load() {
        // copper + lead
        erum = new ExtrasItem("erum", Color.valueOf("3f3f3f")){{
            cost = 1.0f;
            hardness = 2;
            radioactivity = 0.15f;
            temperature = -1.24f;
            explosiveness = 0f;
            flammability = 0f;
            charge = 0f;
        }};

        // coal
        verent = new ExtrasItem("verent", Color.valueOf("151515")){{
            flammability = 0.15f;
            cost = 1.0f;
            hardness = 1;
            explosiveness = 0.20f;
            radioactivity = 0f;
            temperature = 0.25f;
            charge = 0f;
        }};

        // titanium
        vasil = new Item("vasil", Color.valueOf("b7c9e2")){{
            flammability = 0.3f;
            cost = 1.2f;
            hardness = 3;
            radioactivity = 1.3f;
        }};

        // titanium v2
        rime = new ExtrasItem("rime", Color.valueOf("a5f2f3")){{
            hardness = 1;
            temperature = -2.4f;
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;
        }};

        // thorium TODO name change
        sevas = new Item("sevas", Color.valueOf("6b295d")){{
            flammability = 0.54f;
            cost = 1.3f;
            hardness = 4;
            explosiveness = 0.12f;
            radioactivity = 2.8f;
            healthScaling = 0.21f;
        }};

        // sand
        talc = new Item("talc", Color.valueOf("cccccc")){{
            flammability = 0.4f;
            cost = 1f;
            hardness = 1;
            explosiveness = 0.1f;
            radioactivity = 0.08f;
            lowPriority = true;
        }};

        // graphite + metaglass
        caris = new Item("caris", Color.valueOf("d3737b")){{
            cost = 1.2f;
        }};

        // pyratite + blast compound
        napalm = new ExtrasItem("napalm", Color.valueOf("cf5a3a")){{
            flammability = 3f;
            cost = 1f;
            explosiveness = 2.45f;
            temperature = 3.5f;
            radioactivity = 0f;
            charge = 0f;
        }};

        // plastanium
        actium = new Item("actium", Color.valueOf("6ba7cf")){{
            cost = 1.3f;
            explosiveness = 0.1f;
            radioactivity = 0.8f;
        }};

        // silicon
        kasev = new Item("kasev", Color.valueOf("847c94")){{
            flammability = 0.05f;
            cost = 0.9f;
            radioactivity = 0.02f;
        }};

        // phase
        aspec = new Item("aspec", Color.valueOf("fcfc9d")){{
            cost = 1.4f;
            radioactivity = 1.2f;
        }};

        // surge
        tavor = new Item("tavor", Color.valueOf("0d948f")){{
            flammability = 0.25f;
            cost = 1.5f;
            explosiveness = 0.6f;
            radioactivity = 0.8f;
        }};

        //side note these names are so bad god damn

        DawneItems.addAll(erum, verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);
        DawneOnlyItems.addAll(erum, verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);

        VolirItems.addAll(erum,verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);
        VolirOnlyItems.addAll(erum, verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);

        ConcordItems.addAll(erum,verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);
        ConcordOnlyItems.addAll(erum, verent, vasil, rime, sevas, talc, caris, napalm, kasev, actium, aspec, tavor);
    }
}