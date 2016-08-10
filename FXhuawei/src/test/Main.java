package test;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/4/19.
 */
public class Main {
    /**
     * the count of group
     */
    int groupCnt;

    /**
     * path between all points
     */
    int[][] pathes;

    int[] lineNumber;
    int[] blackUsed;
    int[] whiteUsed;
    int[] x1 ;
    int[] y1 ;
    int[] x2 ;
    int[] y2 ;
    int blackNum = 0;
    int whiteNum = 0;

    int[] result;

    /**
     * read what inputs from console
     */
    public void execute(){
        Scanner cin = new Scanner(System.in);
        if (cin.hasNext()){
            groupCnt = cin.nextInt();
        }

        result = new int[groupCnt];
        for(int i = 0; i<groupCnt;i++) {
            if (cin.hasNext()) {
                blackNum = cin.nextInt();
            }
            if (cin.hasNext()) {
                whiteNum = cin.nextInt();
            }

            // initialize the global variable
            pathes = new int[blackNum][whiteNum];
            whiteUsed = new int[whiteNum];
            blackUsed = new int[blackNum];
            lineNumber = new int[blackNum];
            for (int j = 0; j < whiteNum; j++) {
                whiteUsed[j] = 0;

            }
            for (int j = 0; j < blackNum; j++) {
                blackUsed[j] = 0;
                lineNumber[j] = 0;

            }

            int x = 0;
            int y = 0;
            x1 = new int[blackNum];
            y1 = new int[blackNum];
            x2 = new int[whiteNum];
            y2 = new int[whiteNum];

            for (int j = 0; j < blackNum; j++) {
                x = cin.nextInt();
                y = cin.nextInt();
                x1[j] = x;
                y1[j] = y;

            }
            for (int j = 0; j < whiteNum; j++) {
                x = cin.nextInt();
                y = cin.nextInt();
                x2[j] = x;
                y2[j] = y;

            }

            for (int index = 0; index < blackNum; index++) {
                for (int j = 0; j < whiteNum; j++) {
                    if (x1[index] <= x2[j] && y1[index] <= y2[j]) {
                        pathes[index][j] = 1;
                        lineNumber[index]++;

                    } else {
                        pathes[index][j] = 0;
                    }

                }
            }
            // draw the first line
//                int base = 0;
//                int j = 0;
//                for (; base < blackNum; base++) {
//                    if (lineNumber[base] >= 1) {
//                        for (; j < whiteNum; j++) {
//                            if (pathes[base][j] == 1 && blackUsed[base] == 0 && whiteUsed[j] == 0) {
//                                count++;
//                                blackUsed[base] = 1;
//                                whiteUsed[j] = 1;
//                                break;
//                            }
//
//
//                        }
//
//                        break;
//                    }
//
//
//                }
//                if (base != blackNum) {
//
//
//                    // search path
//                    while (true) {
//                        int tmp = -1;
//                        for (int k = 0; k < whiteNum; k++) {
//                            if (pathes[base][k] == 1 &&
//                                    whiteUsed[k] == 0) {
//                                tmp = k;
//                                break;
//                            }
//                        }
//                        boolean isExist = false;
//                        if (tmp >= 0) {
//                            for (int k = 0; k < blackNum; k++) {
//                                if (pathes[k][j] == 1 && blackUsed[k] == 0) {
//                                    blackUsed[k] = 1;
//                                    whiteUsed[tmp] = 1;
//                                    count++;
//                                    base = k;
//                                    j = tmp;
//                                    isExist = true;
//                                    break;
//                                }
//                            }
//                        }
//                        if (tmp == -1 || isExist == false) {
//                            break;
//                        }
//                    }
//                }
//                result[i] = count;
//            }
           getMax(i);
            pathes = null;
            System.gc();
        }
    }

    public void getMax(int i){
        int count = 0;

            for(int index = 0;index<blackNum;index++){
                if(DFS(index)){
                    count++;
                }

            }
        result[i] = count;

    }

    public boolean DFS(int index){
        for(int i = 0 ;i<whiteNum;i++){
            if(pathes[index][i]==1&&whiteUsed[i]==0){
                whiteUsed[i] = 1;
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.execute();

        for(int i = 0; i<main.groupCnt;i++){
            System.out.println(main.result[i]);
        }
    }
}
