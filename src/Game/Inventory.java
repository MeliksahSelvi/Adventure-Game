package Game;

import Items.Armors;
import Items.Pacavra;
import Items.Weapons;
import Items.Yumruk;

public class Inventory {

    private boolean water;
    private boolean food;
    private boolean firewood;
    private boolean item;
    private Weapons weapon;
    private Armors armor;

    public Inventory(){
        this.weapon=new Yumruk();
        this.armor=new Pacavra();
        this.water=false;
        this.food=false;
        this.firewood=false;
        this.item=false;
    }

    public Weapons getWeapon(){
        return this.weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return this.armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public boolean getWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean getFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean getFirewood() {
        return this.firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean getItem() {
        return this.item;
    }

    public void setItem(boolean item) {
        this.item = item;
    }

}
