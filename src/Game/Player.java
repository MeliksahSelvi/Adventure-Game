package Game;


public class Player {

    private Inventory inventory;
    private String nickName;
    private String charName;
    private int damage;
    private int health;
    private int maxHealth;
    private int money;


    public Player(String nickName,String charName,int damage,int health,int money) {
        this.nickName = nickName;
        this.charName=charName;
        this.damage=damage;
        this.health=health;
        this.maxHealth=health;
        this.money=money;
        this.inventory=new Inventory();
    }

    public void printInfo(){
        System.out.println("\nOyuncu Degerleri");
        System.out.println("Nick = "+this.getNickName()
                +"\t,Karakter = "+this.getCharName()
                +"\t,Silah = "+this.getInventory().getWeapon().getName()
                +"\t,Hasar = "+this.getTotalDamage()
                +"\t,Zirh = "+this.getInventory().getArmor().getName()
                +"\t,Dodge = "+this.getBlock()
                +"\t,Saglik = "+this.getHealth()
                +"\t,Para = "+this.getMoney());
        System.out.println("--------------------------");
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getTotalDamage() {
        return this.damage+this.getInventory().getWeapon().getDamage();
    }

    public int getHealth() {
        return this.health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {

        if(health<0){
            this.health=0;
        }
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return this.charName;
    }

    public int getBlock() {
        return this.getInventory().getArmor().getBlock();
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
