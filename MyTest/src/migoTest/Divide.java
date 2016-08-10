package migoTest;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class Divide {
    public void execute(){
        Scanner cin = new Scanner(System.in);
        int total = 0;
        if(cin.hasNext()){
            total = cin.nextInt();
        }
        int dividor = total%8;
        int ans = total/8;
        int[] result = new int[ans+1];
        for(int i = 0;i<ans;i++)
        {
            result[i] = 8;
        }
        result[ans] = dividor;
        boolean isOver = false;
        for(int k = 0; k<8;k++) {
            for (int i = ans - 1; i >= 0; i--) {
                if(result[i]-result[ans]==1){
                    isOver = true;
                    break;
                }
                result[i]--;
                result[ans]++;
                if (result[ans] == result[i]) {
                    isOver = true;
                    break;
                }
            }
            if(isOver){
                break;
            }
        }

        for(int i = 0; i<ans+1;i++){
            System.out.println(result[i]);
        }
    }
    public static void main(String[] args) {
        Divide divide = new Divide();
        divide.execute();
    }
}
