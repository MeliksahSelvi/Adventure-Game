package Location;
import Game.Player;
import Obstacle.Bear;

public class River extends BattleLoc{

    public River(Player player){
        super(player,"Nehir",new Bear(),"water",2);
    }
}
