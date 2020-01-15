package jp.ac.uryukyu.ie.e195741;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameMasterTest {

    @Test
    void numberCheck() {
        List<Integer> zero = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int tmp = 0; tmp <= 3; tmp++) { zero.add(0); }
        for (int tmp = 1; tmp <= 3; tmp++) { target.add(tmp); }
        for (int tmp = 3; tmp >= 1; tmp--) { num.add(tmp); }
        GameMaster gameMaster = new GameMaster(zero,zero);
        int num_eat = gameMaster.numberCheck(target,num);
        System.out.println("EAT期待値 -> 1 , EAT結果 -> "+num_eat);
    }
}