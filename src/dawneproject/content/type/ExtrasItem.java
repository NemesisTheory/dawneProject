package dawneproject.content.type;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.world.meta.Stat;

// pro name
public class ExtrasItem extends Item {

    // cold stuff TODO add purpose
    public float temperature = 0f;
    public float conductivity = 0f;
    public ExtrasItem(String name, Color color) {
        super(name, color);
    }

    public void setStats(){
        stats.addPercent(Stat.temperature, temperature);
    }
}
