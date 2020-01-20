package jp.ac.uryukyu.ie.e195741;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 数字の宣言や数字の判定をするクラス。
 */
public class GameMaster {
    private List<Integer> enem_num = new ArrayList<Integer>();
    private List<Integer> self_num = new ArrayList<Integer>();
    private String name;
    /**
     * GameMasterクラスのコンストラクタ
     * @param enem 相手の設定した数字
     * @param self 自分の設定した数字
     */
    public GameMaster(List<Integer> enem, List<Integer> self) {
        this.enem_num = enem;
        this.self_num = self;
    }
    /**
     * プレイヤー＆NPCに数字宣言をさせるメソッド
     * @param turn_num どちらのターンか判定するための値
     * @return check いくつEATしたのか値を返す
     */
    public int start(int turn_num){
        int check = 0;
        if (turn_num % 2 == 0) {
            System.out.println("<自分のターン>");
            List<Integer> target_num = new ArrayList<Integer>();
            System.out.println("相手の数字を当ててください");
            Scanner scan = new Scanner(System.in);
            String target = scan.next();
            for (int i = 0; i < target.length(); i++) {
                target_num.add(Integer.parseInt(target.substring(i, i + 1)));
            }
            check = numberCheck(target_num, enem_num);
            this.name = "player";
            System.out.println("---------------------");
            waitMoment(1000);
        }
        else if (turn_num % 2 == 1){
            Numbers numbers = new Numbers();
            System.out.println("<相手のターン>");
            System.out.println("相手が数字を数字を宣言しました : "+numbers.getNumber());
            check = numberCheck(numbers.getNumber(), self_num);
            this.name = "enemy";
            System.out.println("---------------------");
            waitMoment(1500);
        }
        return check;
    }
    /**
     * プレイヤー＆NPCに数字宣言をさせるメソッド
     * @param target_num プレイヤーの場合は指定した値、NPCは乱数
     * @param num プレイヤーの場合はNPC、NPCの場合はプレイヤーの決定した値
     * @return check いくつEATしたのか値を返す
     */
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
    /**
     * 現在のターンのプレイヤーがどちらかを返す
     * @return 名前
     */
    public String getName(){
        return this.name;
    }
    /**
     * 指定された分の長さの遅延を作る
     * @param time 遅延する時間
     */
    public void waitMoment(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
