package Location;

import Obstacle.Vampire;
import Game.Player;

public class Forest extends BattleLoc{

    public Forest(Player player){
        super(player,"Orman",new Vampire(),"firewood",3);
    }

}
