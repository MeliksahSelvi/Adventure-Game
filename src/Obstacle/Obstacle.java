package Obstacle;

public abstract class Obstacle {

    private String name;
    private int ID;
    private int damage;
    private int health;
    private int maxHealth;
    private int prize;

    public Obstacle(String name,int ID,int damage,int health,int prize){
        this.name=name;
        this.ID=ID;
        this.damage=damage;
        this.health=health;
        this.maxHealth=health;
        this.prize=prize;
    }

    public void obstacleInfo(){

        System.out.println(this.name+" Degerleri");
        System.out.println("Canavar = "+this.getName()
                +"\t,Saglik = "+this.getHealth()
                +"\t,Hasar = "+this.getDamage()
                +"\t,Odul = "+this.getPrize()+"\n");
        System.out.println("---------------------");

    }

    public String getName() {
        return this.name;
    }

    public int getMaxHealth() {
        return this.maxHealth;
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

    public int getPrize() {
        return this.prize;
    }

    public void setHealth(int health) {

        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
