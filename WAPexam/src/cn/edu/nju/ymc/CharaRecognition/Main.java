package cn.edu.nju.ymc.CharaRecognition;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/5/27.
 */
public class Main {
    int row;
    int column;
    int number;

    Matrix[] matrices;
    int minPixels = 0;

    /**
     * initialize the variables by data from console
     */
    private void readFromConsole(){

        Scanner cin = new Scanner(System.in);

        if(cin.hasNext()){
            row = cin.nextInt();
        }
        if(cin.hasNext()){
            column = cin.nextInt();
        }
        if(cin.hasNext()){
            number = cin.nextInt();
        }

        // fill up matrices
        matrices = new Matrix[number];
        for(int num = 0; num < number; num++){
            matrices[num] = new Matrix(row,column);

            for(int r = 0; r < row; r++){

                if(cin.hasNext()) {
                    String ch = cin.next();

                    for(int c = 0; c < column; c++){
                        if(ch.charAt(c)=='1'){
                            matrices[num].values[r][c] = 1;
                        }
                        else {
                            matrices[num].values[r][c] = 0;
                        }
                    }

                }
            }
        }

    }

    /**
     * to calculate the result
     *
     * first get the lower bounds of min number of pixels needed
     * for we need log2(number of matrices) pixels to present at least
     *
     * if not able to meet the need, add 1 to minPixels and try again
     */
    private void calculateMinPixels(){

        // find lower bounds of minPixels from number
        for(int tmp = number-1;tmp > 0;tmp = tmp/2){
            minPixels++;
        }

        // if the previous min pixels can't meet the need, add the value to test
        while (!addOneToTest()&&minPixels<=row*column){
            minPixels++;
        }


    }

    private boolean addOneToTest(){
        int[] indexBuf = new int[minPixels];
        for (int index = 0; index < row*column-minPixels+1; index++) {
            indexBuf[0] = index;
            if(identifible(minPixels, indexBuf)){
                System.out.println(minPixels);
                return true;
            }
        }
        return false;
    }

    /**
     * recursion method
     *
     * to loop through all the situations
     * @param nowPixels
     * @param lastIndex
     * @return
     */
    private boolean identifible(int nowPixels,int[] lastIndex){
        // judge if these locations can identify matrices
        if(nowPixels==1){
            Location[] locations = new Location[minPixels];
            for(int index = 0; index < minPixels; index++){
                locations[index] = new Location(lastIndex[index]/column,lastIndex[index]%column);
            }
            return isAllMatrixDiffer(locations);
        }
        else {
            for(int index = lastIndex[minPixels-nowPixels]+1;index < row*column; index++){
                lastIndex[minPixels-nowPixels+1] = index;
                return identifible(nowPixels-1,lastIndex);
            }
            return false;
        }
    }

    /**
     * judge if the situation meet the need
     * @param locations
     * @return
     */
    private boolean isAllMatrixDiffer(Location[] locations){
        for(int firstIndex = 0; firstIndex < number; firstIndex++){
            for (int nextIndex = firstIndex+1; nextIndex < number; nextIndex++){
                if(!matrices[firstIndex].isDifferFrom(matrices[nextIndex],locations)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * called to execute the program
     */
    private void execute(){
        readFromConsole();
        calculateMinPixels();
    }

    public static void main(String[] args){
        Main recognition = new Main();
        recognition.execute();
    }

    class Matrix{

        int row;
        int column;
        int[][] values;

        public Matrix(int row,int column) {
            this.row = row;
            this.column = column;
            values = new int[row][column];
        }


        /**
         * to check if the locations can identify the character
         * @param otherOne
         * @param locations
         * @return
         */
        public boolean isDifferFrom(Matrix otherOne,Location ... locations){

            int length = locations.length;
            Location location;

            for(int index = 0; index < length; index++){
                location = locations[index];
                if(values[location.row][location.column]!=otherOne.values[location.row][location.column]){
                    return true;
                }
            }

            return  false;
        }
    }

    class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
