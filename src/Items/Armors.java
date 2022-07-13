package Items;

public abstract class Armors {

    private String name;
    private int ID;
    private int block;
    private int price;

    public Armors(String name,int ID,int block,int price){
        this.name=name;
        this.ID=ID;
        this.block=block;
        this.price=price;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public int getBlock() {
        return this.block;
    }

    public int getPrice() {
        return this.price;
    }
}
