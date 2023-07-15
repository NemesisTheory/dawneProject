package dawneproject.content.world.blocks.power;

import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.meta.*;

public class ThermonuclearReactor extends NuclearReactor {
    public float minEfficiency = 0f;
    public Attribute attribute = Attribute.heat;

    public ThermonuclearReactor(String name){
        super(name);
        noUpdateDisabled = true;
    }
    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return tile.getLinkedTilesAs(this, tempTiles).sumf(other -> other.floor().attributes.get(attribute)) > minEfficiency;
    }

}
