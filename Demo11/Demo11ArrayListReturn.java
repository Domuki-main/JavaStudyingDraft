package Java20200401.Demo11;

import java.util.ArrayList;
import java.util.Random;

public class Demo11ArrayListReturn {

    /*
    1. create a array set
    2. random number nextInt
    3. loop 20 times, put numbers into arrayList
    4. definition a method to choose the number being required
    5. judgement the amount of small set
     */

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < 20; i++){
            int num = r.nextInt(100)+1;
            list.add(num);
        }

        ArrayList<Integer> smallList = getSmallList(list);
        System.out.println(smallList);
        System.out.println("amount: " + smallList.size());

    }

    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list){

        ArrayList<Integer> smallList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            int num =list.get(i);
            if(num % 2 == 0){
                smallList.add(num);
            }
        }

        return smallList;
    }

}
