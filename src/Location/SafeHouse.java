package Location;

import Character.*;
import Game.Player;

public class SafeHouse extends NormalLoc{

    private static boolean isWin;

    public SafeHouse(Player player) {
        super(player,"Guvenli Ev");
        isWin=false;
    }

    @Override
    public boolean onLocation(){

        System.out.println("Guvenli Ev'e Hosgeldiniz.");
        System.out.println("Sagliginiz Tamamen Yenilenecek.");
        this.getPlayer().setHealth(this.getPlayer().getMaxHealth());

        if(this.getPlayer().getInventory().getWater()
        && this.getPlayer().getInventory().getFirewood()
        && this.getPlayer().getInventory().getFood()
        && this.getPlayer().getInventory().getItem())
        {
            System.out.println("Oyunu Kazandiniz!");
            isWin=true;
        }
        return true;
    }

    public static boolean getIsWin() {
        return isWin;
    }
}
