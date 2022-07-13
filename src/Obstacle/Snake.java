package Obstacle;

import java.util.Random;

public class Snake extends Obstacle{

    public Snake(){
        super("Yilan",4,randomDmg(),12,0);
    }

    public static int randomDmg(){

        Random ra=new Random();
        return (ra.nextInt(4)+3);
    }
}
