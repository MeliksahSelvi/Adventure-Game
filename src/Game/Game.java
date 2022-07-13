package Game;

import Location.*;
import Character.Character;
import Character.Samurai;
import Character.Arrow;
import Character.Knight;
import Obstacle.Snake;


import java.io.OutputStream;
import java.util.Scanner;

public class Game {

    private Player player;
    private Location location;
    private Scanner input=new Scanner(System.in);

    public void start(){

        Character[] charList= {new Samurai(),new Arrow(),new Knight()};

        System.out.println("Macera Oyunumuza Hosgeldiniz.");
        System.out.print("NickName Seciniz :");
        String nickName=input.nextLine();
        System.out.println("Karakterlerimiz\n");

        for(Character character:charList){

            System.out.println("ID = "+character.getID()
                            +"\tIsim = "+character.getName()
                            +"\tSaglik = "+character.getHealth()
                            +"\tHasar = "+character.getDamage()
                            +"\tBaslangic Parasi = "+character.getMoney());
        }

        System.out.print("ID Seciminiz :");
        int secim=input.nextInt();


        for(Character character:charList){

            if(character.getID()==secim){
                this.player=new Player(nickName
                        ,character.getName()
                        ,character.getDamage()
                        ,character.getHealth()
                        ,character.getMoney());
            }
        }
    }

    public void selectLocation(){

        while(true){
            this.player.printInfo();
            System.out.println("\n=========BOLGELER===========");
            System.out.println("1-Guvenli Ev -->Burada Canavar Yoktur.");
            System.out.println("2-Pazar -->Silah Veya Zirh Alabilirsiniz.");
            System.out.println("3-Magara-->Karsina Zombi Cikabilir!");
            System.out.println("4-Orman-->Karsina Vampir Cikabilir!");
            System.out.println("5-Nehir-->Karsina Ayi Cikabilir!");
            System.out.println("6-Maden-->Karsina Yilan Cikabilir!");
            System.out.println("0-Cikis-->Oyun Sonu.");
            System.out.print("Gitmek Istediginiz Lokasyonu Seciniz :");
            int selectLoc=input.nextInt();

            if(selectLoc==0){
                System.out.println("Oyun Bitti.Tekrar Gorusmek Uzere.");
                break;
            }

            switch (selectLoc){

                case 1:
                    this.location=new SafeHouse(this.player);
                    break;

                case 2:

                    this.location=new ToolStore(this.player);
                    break;

                case 3:

                    this.location=new Cave(this.player);
                    break;

                case 4:

                    this.location=new Forest(this.player);
                    break;

                case 5:

                    this.location=new River(this.player);
                    break;

                case 6:

                    this.location=new Mine(this.player);
                    break;

                default:
                    System.out.println("Gecerli Bir Bolge Giriniz!");
                    break;
            }

            if(!this.location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
            if(SafeHouse.getIsWin()){
                break;
            }
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
