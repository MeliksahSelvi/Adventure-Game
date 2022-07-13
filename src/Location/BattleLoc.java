package Location;

import Game.Player;
import Items.*;
import Obstacle.*;

import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private int obsCount;
    private Weapons[] weaponList={new Pistol(),new Sword(),new Gun()};
    private Armors[] armorList={new LigthArmor(),new MiddleArmor(),new HeavyArmor()};

    public BattleLoc(Player player, String locName,Obstacle obstacle,String award,int maxObstacle) {
        super(player, locName);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
        this.obsCount=this.obstacleNumber();
    }

    @Override
    public boolean onLocation(){

        if(this.getAward().equals("food") && this.getPlayer().getInventory().getFood()){
            System.out.println("Bu Bolgeyi Zaten Yendiniz!");
            return true;
        }
        else if(this.getAward().equals("firewood") && this.getPlayer().getInventory().getFirewood()){
            System.out.println("Bu Bolgeyi Zaten Yendiniz!");
            return true;
        }
        else if(this.getAward().equals("water") && this.getPlayer().getInventory().getWater()){
            System.out.println("Bu Bolgeyi Zaten Yendiniz!");
            return true;
        }
        else if(this.getAward().equals("item") && this.getPlayer().getInventory().getItem()){
            System.out.println("Bu Bolgeyi Zaten Yendiniz!");
            return true;
        }
        else{

            int number=this.getObsCount();

            System.out.println("Suan Buradasiniz :"+this.getLocName());
            System.out.println("Dikkatli Olun.Burada "+this.getObsCount()+" tane "+this.obstacle.getName()+" yasiyor!");


            for(int i=1;i<=number;i++){

                System.out.print("Savasmak Icin 'S' Kacmak Icin 'K' Giriniz :");
                String fightOrRun=input.nextLine().toUpperCase();

                if(fightOrRun.equals("S")){

                    if(!this.versus()){
                        return false;
                    }

                    System.out.println("Caniniz :"+this.getPlayer().getHealth()+"\n");
                    System.out.println("Kalan Canavar Sayisi :"+(this.getObsCount()));
                }

                else if(fightOrRun.equals("K")){
                    return true;
                }
            }

            if(this.getObsCount()==0){
                System.out.println("Tebrikler.Bu Bolgedeki Tum "+this.getObstacle().getName()+" Temizlendi!");

                if(this.award.equals("food")){
                    this.getPlayer().getInventory().setFood(true);
                }
                else if(this.award.equals("firewood")){
                    this.getPlayer().getInventory().setFirewood(true);
                }
                else if(this.award.equals("water")){
                    this.getPlayer().getInventory().setWater(true);
                }
                else if(this.award.equals("item")){
                    this.getPlayer().getInventory().setItem(true);
                }
            }
            return true;
        }
    }

    public boolean versus(){

        super.getPlayer().printInfo();
        this.getObstacle().obstacleInfo();

        Random ra=new Random();
        int random=ra.nextInt(101);
        boolean first=false;

        if(random>0 && random<51){
            first=true;//ilk heromuzun vurması için bu aralıkta olması gerek.
        }

        int snakePrize=ra.nextInt(201);
        while(true){

            if(first){//ilk vuran heromuz değilse hakkını pas geçer.önceliği canavara verir
                System.out.println("Siz Vurdunuz!");
                this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                this.afterHit();

                if(this.getObstacle().getHealth()<=0){
                    System.out.println(this.getObstacle().getName()+" Oldu!");
                    this.getObstacle().setHealth(this.getObstacle().getMaxHealth());

                    if(this.getObstacle().getName().equals("Yilan")){

                        if(snakePrize>0 && snakePrize<7){//tufek kazanma

                            System.out.println("Odul Olarak Tufek Kazandiniz.");
                            this.getPlayer().getInventory().setWeapon(this.weaponList[2]);
                        }
                        else if(snakePrize>6 && snakePrize<16){//kilic kazanma

                            System.out.println("Odul Olarak Kilic Kazandiniz.");
                            if(this.weaponList[1].getDamage()>this.getPlayer().getInventory().getWeapon().getDamage()){
                                this.getPlayer().getInventory().setWeapon(this.weaponList[1]);
                            }
                        }
                        else if(snakePrize>15 && snakePrize<31){//tabanca kazanma

                            System.out.println("Odul Olarak Tabanca Kazandiniz.");
                            if(this.weaponList[0].getDamage()>this.getPlayer().getInventory().getWeapon().getDamage()){
                                this.getPlayer().getInventory().setWeapon(this.weaponList[0]);
                            }
                        }
                        else if(snakePrize>30 && snakePrize<37){//agir zirh kazanma

                            System.out.println("Odul Olarak Agir Zirh Kazandiniz.");
                            this.getPlayer().getInventory().setArmor(this.armorList[2]);
                        }
                        else if(snakePrize>36 && snakePrize<46){//orta zirh

                            System.out.println("Odul Olarak Orta Zirh Kazandiniz.");
                            if(this.armorList[1].getBlock()>this.getPlayer().getInventory().getArmor().getBlock()){
                                this.getPlayer().getInventory().setArmor(this.armorList[1]);
                            }
                        }
                        else if(snakePrize>45 && snakePrize<61){//hafif zirh

                            System.out.println("Odul Olarak Hafif Zirh Kazandiniz.");
                            if(this.armorList[0].getBlock()>this.getPlayer().getInventory().getArmor().getBlock()){
                                this.getPlayer().getInventory().setArmor(this.armorList[0]);
                            }
                        }
                        else if(snakePrize>60 && snakePrize<71){//10 para

                            System.out.println("Odul Olarak 10 Para Kazandiniz.");
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
                        }
                        else if(snakePrize>70 && snakePrize<86){//5 para

                            System.out.println("Odul Olarak 5 Para Kazandiniz.");
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
                        }
                        else if(snakePrize>85 && snakePrize<111){// 1 para

                            System.out.println("Odul Olarak 1 Para Kazandiniz.");
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
                        }
                        else{
                            System.out.println("Odul Kazanamadiniz.");
                        }
                        //110 ve 200 arasını kontrol etmiyoruz %45 ihtimal hiçbir ödül olmaması durumu sağlandı.

                        int snakeDmg=ra.nextInt(4)+3;
                        this.getObstacle().setDamage(snakeDmg);
                    }
                    else{
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getPrize());
                    }

                    this.setObsCount(this.getObsCount()-1);
                    return true;
                }
            }
            first=true;//öteki döngüde heromuzun vurmasını sağlar.

            System.out.println(this.getObstacle().getName()+ " Vurdu");

            int obsDmg=this.getObstacle().getDamage()-this.getPlayer().getBlock();

            if(obsDmg>0){
                this.getPlayer().setHealth(this.getPlayer().getHealth()-obsDmg);
                this.afterHit();
            }

            if(this.getPlayer().getHealth()<0){
                System.out.println("Siz Oldunuz!");
                break;
            }
        }

        return false;
    }

    public void afterHit(){
        System.out.println("Caniniz :"+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+ " Cani :"+this.getObstacle().getHealth()+"\n");
    }

    public int obstacleNumber(){

        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return this.obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return this.maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int getObsCount() {
        return this.obsCount;
    }

    public void setObsCount(int obsCount) {
        this.obsCount = obsCount;
    }
}
