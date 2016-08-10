package water;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yuminchen on 16/4/20.
 */
public class Main {
    int[][] timeTable = new int[7][7];

    int sum = 0;

    ArrayList<int[]> list = new ArrayList<>();

    int[] order = new int[7];

    int[] isUsed = new int[7];
    /**
     * read what inputs from console
     * build the time table
     */
    public void readInput(){
        Scanner cin = new Scanner(System.in);
        for (int i = 0;i < 7;i++){
            for (int j = 0;j < 7;j++){
                if(cin.hasNext()){
                    timeTable[i][j] = cin.nextInt();
                }
            }
        }

    }

    public void backTrak(int n){
        if(n>6){
            sum++;
            int[] tmp = new int[7];
            for (int i = 0; i < 7 ;i++){
                tmp[i] = order[i]+1;
            }
            list.add(tmp);

        }
        else {
            for (int i = 0; i<7;i++){
                order[n] = i;
                if(isUsed[i]==0&&timeTable[i][n]==1){
                    isUsed[i] = 1;
                    backTrak(n+1);
                    isUsed[i] = 0;
                }

            }


        }

    }




    public static void main(String[] args) {
        Main main = new Main();
        main.readInput();
        main.backTrak(0);
        System.out.println(main.sum);
        for (int n = 0; n < main.sum; n++) {
            int[] tmp = main.list.get(n);
            for (int i = 0; i < 6; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.print(tmp[6]);
            System.out.println();
        }

    }
}
