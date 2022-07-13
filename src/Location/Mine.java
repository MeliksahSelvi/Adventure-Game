package Location;

import Game.Player;
import Obstacle.Snake;


public class Mine extends BattleLoc{

    public Mine(Player player){
        super(player,"Maden",new Snake(),"item",5);
    }
}
