package Java20200401;

import java.util.Random;

public class Demo5Random1toN {

    //    [1, n)
    public static void main(String[] args) {

//        1. define int values
//        2. using process
//        3. if wanna write 1~10, let [0, 9) add 1 only

        int n = 10, o = 0;
        Random r = new Random();

        while(o < 100){

            System.out.println(r.nextInt(n)+1);
            o++;

        }


    }

}
