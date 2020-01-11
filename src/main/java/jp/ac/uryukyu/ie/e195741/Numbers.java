package jp.ac.uryukyu.ie.e195741;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    private List<Integer> numbers = new ArrayList<Integer>();
    private  String name;

    public Numbers(String name) {
        this.name = name;
        if (name == "enemy") {
            for (int i = 0; i <= 9; i++) {
                numbers.add(i);
            }
            Collections.shuffle(numbers);
            for (;numbers.size() > 3;){
                numbers.remove(1);
            }
        }
        else if(name == "player"){
            System.out.println("重複しない三桁の数字を入力してください");
            Scanner scan = new Scanner(System.in);
            String preset = scan.next();
            for (int i = 0; i < preset.length();i++ ){
                numbers.add(Integer.parseInt(preset.substring(i,i+1)));
            }
        }
    }
    public List<Integer> getNumber(){
        return this.numbers;
    }
}
