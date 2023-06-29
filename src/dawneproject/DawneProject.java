package dawneproject;

import mindustry.mod.*;
import dawneproject.content.*;
public class DawneProject extends Mod{

    public DawneProject() {}

    @Override
    public void loadContent(){
        DawneItems.load();
        DawneLiquids.load();
        DawneBlocks.load();    
        DawnePlanets.load();
    }
}
