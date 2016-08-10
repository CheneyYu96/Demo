package migoTest;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class Allocation {

    public void readFromConsole(){
        int number = 0;
        Scanner cin = new Scanner(System.in);
        if(cin.hasNext()){
            number = cin.nextInt();
        }
        for(int index = 0; index<number ;index++){
            int water = cin.nextInt();
            int container = cin.nextInt();
            System.out.println(calculateTypes(container,water,water));
        }
    }

    public int calculateTypes(int container,int water,int bounds){
        if(water == 0){
            return 1;
        }
        if(container==1){
            return 1;
        }

        int totalNumber = 0;
        if(water%container==0){
            for(int i = water; i >= water/container;i--){
                if(i>bounds){
                    continue;
                }
                totalNumber+=calculateTypes(container-1,water-i,i);
            }
        }
        else {
            for (int i = water; i > water / container; i--) {
                if(i>bounds){
                    continue;
                }
                totalNumber += calculateTypes(container - 1, water - i,i);
            }
        }

        return totalNumber;
    }

    public static void main(String[] args) {
        Allocation allocation = new Allocation();
        allocation.readFromConsole();
    }
}
