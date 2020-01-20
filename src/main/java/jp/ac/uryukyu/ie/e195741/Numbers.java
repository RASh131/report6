package jp.ac.uryukyu.ie.e195741;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 数字の生成や設定をするクラス。
 */
public class Numbers {
    private List<Integer> numbers = new ArrayList<Integer>();
    private  String name;
    /**
     * Numbersクラスの引数なしのコンストラクタ
     * 乱数を設定する
     */
    public Numbers() { randNumber(); }
    /**
     * Numbersクラスのコンストラクタ
     * nameでplayerを受け取った時はプレイヤーに数字を入力させ、設定する
     * nameでenemyを受け取った時はNPCの数字をランダムに設定する
     * @param name player or enemy のどちらかを受け取る
     */
    public Numbers(String name) {
        this.name = name;
        if (this.name == "enemy") {
            randNumber();
            System.out.println("相手が数字をセットしました : [?, ?, ?]");
            System.out.println("---------------------");
        }
        else if(this.name == "player"){
            System.out.println("重複しない三桁の数字を入力してください");
            Scanner scan = new Scanner(System.in);
            String preset = scan.next();
            for (int i = 0; i < preset.length();i++ ){
                this.numbers.add(Integer.parseInt(preset.substring(i,i+1)));
            }
            System.out.println("自分の数字をセットしました : "+this.numbers);
        }
    }

    /**
     * 数字を返す
     * @return
     */
    public List<Integer> getNumber(){
        return this.numbers;
    }

    /**
     * 乱数を生成して設定する
     */
    public void randNumber(){
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (;numbers.size() > 3;){
             numbers.remove(1);
        }
    }
}
