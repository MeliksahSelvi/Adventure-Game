package Character;

public abstract class Character {

    private String name;
    private int ID;
    private int damage;
    private int health;
    private int money;

    public Character(String name,int ID,int damage,int health,int money){
        this.name=name;
        this.ID=ID;
        this.damage=damage;
        this.health=health;
        this.money=money;
    }

    public int getID() {
        return this.ID;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName(){
        return this.name;
    }

}
