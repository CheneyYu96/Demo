package migoTest;

import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner cin = new Scanner(System.in);
        if(cin.hasNext()){
            a = cin.nextInt();
            b = cin.nextInt();
        }
        System.out.print(a/2+a%2+" "+a/2);
    }
}
