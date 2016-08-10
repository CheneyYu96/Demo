package migoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class Add2 {
    List<Integer> result;

    public void readFromConsole(){
        result = new ArrayList<>();
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int firstValue = cin.nextInt();
            int secondValue = cin.nextInt();
            result.add(firstValue+secondValue);
        }

    }
    public void printValue(){
        for(int value : result){
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        // TODO: 16/6/5 test
    }
}
