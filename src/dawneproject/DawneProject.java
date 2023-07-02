package dawneproject;

import arc.struct.*;
import mindustry.mod.*;
import dawneproject.content.*;
public class DawneProject extends Mod{

    public DawneProject() {}

    @Override
    public void loadContent(){
        DawneItems.load();
        DawneLiquids.load();
        DawneStatusEffects.load();
        DawneBlocks.load();
        DawneUnitTypes.load();
        DawnePlanets.load();
    }
}
