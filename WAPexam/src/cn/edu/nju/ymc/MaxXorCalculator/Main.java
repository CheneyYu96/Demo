package cn.edu.nju.ymc.MaxXorCalculator;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/5/27.
 */
public class Main {

    int number;

    long[] array;

    long maxValue;

    /**
     * initialize the variables by data from console
     */
    private void readFromConsole(){
        Scanner cin = new Scanner(System.in);

        if(cin.hasNext()){
            number = cin.nextInt();
        }
        array = new long[number];

        for(int num = 0; num < number; num++){
            if(cin.hasNext()){
                array[num] = cin.nextLong();
            }
        }
    }

    /**
     * loop through all the situations to find the max value
     */
    private void getMaxValue(){
        maxValue = array[0];
        for(int preIndex = -1; preIndex<number; preIndex++){
            for(int sufIndex = preIndex+1; sufIndex<=number;sufIndex++){
                long maxTmp = getPrefixValue(preIndex)^getSuffixCValue(sufIndex);
                if(maxTmp>maxValue){
                    maxValue = maxTmp;
                }
            }
        }
        System.out.println(maxValue);
    }

    /**
     * calculate the xor value in prefix array
     * @param preIndex
     * @return
     */
    private long getPrefixValue(int preIndex){
        long result = 0;
        for(int index = 0; index<=preIndex;index++){
            result = result^array[index];
        }
        return result;
    }

    /**
     * calculate the xor value in suffix array
     * @param sufIndex
     * @return
     */
    private long getSuffixCValue(int sufIndex){
        long result = 0;
        for(int index = sufIndex; index<number;index++){
            result = result^array[index];
        }
        return result;
    }

    /**
     * called to execute the program
     */
    private void execute(){
        readFromConsole();
        getMaxValue();
    }

    public static void main(String[] args) {
        Main calculator = new Main();
        calculator.execute();
    }

}
