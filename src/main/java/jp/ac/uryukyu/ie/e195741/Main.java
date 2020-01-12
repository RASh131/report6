package jp.ac.uryukyu.ie.e195741;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        int turn_num = rand.nextInt(1);
        int check = 0;

        System.out.println(turn_num);
        Numbers enemyNum = new Numbers("enemy");
        Numbers selfNum = new Numbers("player");
        GameMaster game = new GameMaster(enemyNum.getNumber(),selfNum.getNumber());
        while (check != 3){
            check = game.start(turn_num);
            turn_num += 1;
        }
        System.out.println("All Hit! " + game.getName() + "の勝利");



    }
}
