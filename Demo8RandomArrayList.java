package Java20200401;

import java.util.ArrayList;
import java.util.Random;

public class Demo8RandomArrayList {

    /*
    range: 1-33
     */
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < 20; i++){

           int number = r.nextInt(32) + 1;

           al.add(number);

        }

        System.out.println(al);

        for (int i = 0; i < 20; i++){

            System.out.println(al.get(i));

        }

    }

}
