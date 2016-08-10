package migoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yuminchen on 16/6/5.
 */
public class ToString {

    List<String> nationNames;
    public void readFromConsole(){
        nationNames = new ArrayList<>();
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            String name;
            if((name=cin.next()).equals("end")){
                break;
            }
            nationNames.add(name);

        }
    }

    public void sort(){
        if(nationNames==null){
            return;
        }
        // bubble sort
        for(int times = 0;times < nationNames.size()-1;times++){
            for(int index = 0; index <nationNames.size()-1-times;index++){
                if(nationNames.get(index).compareTo(nationNames.get(index+1))>0){
                    String replaced = nationNames.get(index);
                    nationNames.set(index,nationNames.get(index+1));
                    nationNames.set(index+1,replaced);
                }
            }
        }

        for(int i = 0; i < nationNames.size() ;i++){
            if(i==nationNames.size()-1){
                System.out.print(nationNames.get(i));
            }
            else {
                System.out.print(nationNames.get(i)+",");
            }
        }
    }

    public static void main(String[] args) {
        ToString test = new ToString();
        test.readFromConsole();
        test.sort();
    }
}
