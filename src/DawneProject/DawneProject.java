package DawneProject;

import mindustry.mod.*;
import DawneProject.content.*;
public class DawneProject extends Mod{

    public DawneProject() {}

    @Override
    public void loadContent(){
        DawneItems.load();
        DawneBlocks.load();
    }
}