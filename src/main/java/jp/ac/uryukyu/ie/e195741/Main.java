package jp.ac.uryukyu.ie.e195741;

public class Main {
    public static void main(String[] args){
        int check = 0;
        Numbers enemyNum = new Numbers("enemy");
        Numbers selfNum = new Numbers("player");
        GameMaster game = new GameMaster(enemyNum.getNumber(),selfNum.getNumber());
        while (check != 3){
            check = game.start();
        }
        System.out.println("All Hit");



    }
}
