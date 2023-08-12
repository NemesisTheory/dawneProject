package dawneproject.content.type;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.world.meta.Stat;

// pro name
public class DawneItem extends Item {
    public Color color;

    /** something */
    public float temperature = 0f;
    public float conductivity = 0f;
    public float explosiveness = 0f;
    public float flammability = 0f;
    public float radioactivity;
    public float charge = 0f;

    public DawneItem(String name, Color color) {
        super(name, color);
    }

    @Override
    public void setStats(){
        stats.addPercent(Stat.temperature, temperature);
        stats.addPercent(Stat.explosiveness, explosiveness);
        stats.addPercent(Stat.flammability, flammability);
        stats.addPercent(Stat.radioactivity, radioactivity);
        stats.addPercent(Stat.charge, charge);
    }
}
