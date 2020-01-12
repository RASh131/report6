package jp.ac.uryukyu.ie.e195741;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMaster {
    private List<Integer> enem_num = new ArrayList<Integer>();
    private List<Integer> self_num = new ArrayList<Integer>();
    private String name;

    public GameMaster(List<Integer> enem, List<Integer> self) {
        this.enem_num = enem;
        this.self_num = self;
    }
    public int start(int turn_num){
        int check = 0;
        if (turn_num % 2 == 0) {
            List<Integer> target_num = new ArrayList<Integer>();
            System.out.println("相手の数字を当ててください");
            Scanner scan = new Scanner(System.in);
            String target = scan.next();
            for (int i = 0; i < target.length(); i++) {
                target_num.add(Integer.parseInt(target.substring(i, i + 1)));
            }
            check = numberCheck(target_num, enem_num);
            this.name = "player";
        }
        else if (turn_num % 2 == 1){
            List<Integer> target_num = new ArrayList<Integer>();
            Numbers numbers = new Numbers();
            System.out.println("相手が数字を数字を宣言しました : "+numbers.getNumber());
            check = numberCheck(numbers.getNumber(), self_num);
            this.name = "enemy";
        }
        return check;
    }
    public int numberCheck(List<Integer> target_num, List<Integer> num){
        int eat = 0;
        int bite = 0;
        for(int pointa=0 ; pointa < num.size() ; pointa++) {
            if (target_num.get(pointa) == num.get(pointa)) {
                eat += 1;
            } else if (num.contains(target_num.get(pointa))) {
                bite += 1;
            }
        }
        System.out.println("EAT :"+eat+"  BITE :"+bite);
        return eat;
    }
    public String getName(){
        return this.name;
    }
}
