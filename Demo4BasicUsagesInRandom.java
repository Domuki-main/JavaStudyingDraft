package Java20200401;

import java.util.Random;

public class Demo4BasicUsagesInRandom {

    /*
    Class Random being used to create random values

     1. import package
     2. instantiate
        Random r = new Random();
     3. using
        int num = r.nextInt(); the result can be negative and positive

     */


    public static void main(String[] args) {

        Random r = new Random();

        /*
        first usage without parameter "int n"
         */
        int num1 = r.nextInt();

        /*
        second usage
         */
        int num2 = r.nextInt(3); // num2: [0, 3)
//        means 0 ~ 2
    }

}
