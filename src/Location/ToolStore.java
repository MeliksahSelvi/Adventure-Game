package Location;


import java.util.Scanner;
import Game.Player;
import Items.*;

public class ToolStore extends NormalLoc{

    private Weapons[] weaponList={new Pistol(),new Sword(),new Gun()};
    private Armors[] armorList={new LigthArmor(),new MiddleArmor(),new HeavyArmor()};

    public ToolStore(Player player) {
        super(player,"Pazar");
    }

    @Override
    public boolean onLocation(){

        this.menu();
        return true;
    }
    public void menu(){

        int secim;

        while(true){

            System.out.println("\nPazara Hosgeldiniz.");
            System.out.println("============");
            System.out.println("1-Silahlar");
            System.out.println("2-Zirhlar");
            System.out.println("Cikmak Icin 0'a Basiniz.");
            System.out.print("Seciminiz:");
            secim=input.nextInt();

            if(secim==0){
                break;
            }

            System.out.println("\nParaniz :"+this.getPlayer().getMoney()+"\n");

            switch (secim){

                case 1:

                    for(Weapons weapons:this.weaponList){
                        System.out.println(weapons.getID()+"-"+weapons.getName()
                        +"\tHasar : "+weapons.getDamage()+"\tFiyati : "+weapons.getPrice());
                    }

                    System.out.println("\nAna Menuye Donmek Icin 0'a Basiniz.");
                    System.out.print("Seciminiz :");
                    secim=input.nextInt();

                    if(secim!=0)
                        buy("Silah",secim);

                    break;

                case 2:

                    for(Armors armors:this.armorList){
                        System.out.println(armors.getID()+"-"+armors.getName()
                        +"\tSavusturma : "+armors.getBlock()+"\tFiyati : "+armors.getPrice());
                    }

                    System.out.println("\nAna Menuye Donmek Icin 0'a Basiniz.");
                    System.out.print("Seciminiz:");
                    secim=input.nextInt();

                    if(secim!=0)
                        buy("Zirh",secim);

                    break;

                default:
                    System.out.println("Yanlis Secim Yaptiniz!");
                    break;
            }
        }
    }
    public void buy(String itemGroup,int ID){

        if(itemGroup.equals("Silah")){

            for(Weapons weapons:weaponList){

                if(ID==weapons.getID()){

                    if(this.getPlayer().getMoney()>=weapons.getPrice()){

                        System.out.println("Satin Alma Islemi Basarili.\n");

                        System.out.println("Eski Silahiniz :"+this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(weapons);
                        System.out.println("Yeni Silahiniz :"+this.getPlayer().getInventory().getWeapon().getName());

                        this.getPlayer().setMoney(this.getPlayer().getMoney()-weapons.getPrice());
                        System.out.println("\nKalan Paraniz :"+this.getPlayer().getMoney());
                    }
                    else{
                        System.out.println("Paraniz Yetersiz!");
                    }
                }
            }
        }

        else if(itemGroup.equals("Zirh")) {

            for(Armors armors:armorList){

                if(ID==armors.getID()){

                    if(this.getPlayer().getMoney()>=armors.getPrice()){

                        System.out.println("Satin Alma Islemi Basarili.\n");

                        System.out.println("Eski Zirhiniz :"+this.getPlayer().getInventory().getArmor().getName());
                        this.getPlayer().getInventory().setArmor(armors);
                        System.out.println("Yeni Zirhiniz :"+this.getPlayer().getInventory().getArmor().getName());

                        this.getPlayer().setMoney(this.getPlayer().getMoney()-armors.getPrice());
                        System.out.println("\nKalan Paraniz :"+this.getPlayer().getMoney());
                    }
                    else{
                        System.out.println("Paraniz Yetersiz!");
                    }
                }
            }
        }

        else {
            System.out.println("Yanlis Secim!");
        }
    }
}
