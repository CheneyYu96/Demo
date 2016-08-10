package migoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class Move {
    int total;
    int[] numbers;
    public void execute(){
        Scanner cin = new Scanner(System.in);
        if(cin.hasNext()){
            total = cin.nextInt();
        }
        numbers = new int[total];
        int sum = 0;
        for(int index = 0; index<total ;index++){
            int number= cin.nextInt();
            sum+=number;
            numbers[index] = number;
        }
        int average = sum/total;
        int times = 0;
        for(int index = 0; index<total ;index++){
            if(numbers[index]<average){
                for(int i = index+1;i<total;i++){
                    if(numbers[i]>average){
                        if(numbers[i]+numbers[index]>2*average){
                            int moveStep = average-numbers[index];
                            numbers[i] -= moveStep;
                            numbers[index] = average;
                            times+=moveStep;
                            break;
                        }
                        else if(numbers[i]+numbers[index]<2*average){
                            int moveStep = numbers[i]-average;
                            numbers[index]+=moveStep;
                            numbers[i] = average;
                            times+=moveStep;
                        }
                        else {
                            times += numbers[i]-average;
                            numbers[i] = numbers[index] = average;
                            break;
                        }
                    }
                }
            }
            else if(numbers[index]>average){
                for(int i = index+1;i<total;i++){
                    if(numbers[i]<average){
                        if(numbers[i]+numbers[index]>2*average){
                            int moveStep = average-numbers[i];
                            numbers[index] -= moveStep;
                            numbers[i] = average;
                            times+=moveStep;
                            break;
                        }
                        else if(numbers[i]+numbers[index]<2*average){
                            int moveStep = numbers[index]-average;
                            numbers[i]+=moveStep;
                            numbers[index] = average;
                            times+=moveStep;
                        }
                        else {
                            times += numbers[index]-average;
                            numbers[i] = numbers[index] = average;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(times);
    }

    public static void main(String[] args) {
        Move move = new Move();
        move.execute();
    }
}
