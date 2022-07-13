package Items;

public abstract class Weapons {


    private String name;
    private int ID;
    private int damage;
    private int price;

    public Weapons(String name, int ID, int damage, int price) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getPrice() {
        return this.price;
    }
}
