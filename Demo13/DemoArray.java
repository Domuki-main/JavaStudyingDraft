package Java20200401.Demo13;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DemoArray {

    //Array class has many static methods for frequently used

    public static void main(String[] args) {

        int[] a1 = {1,23,31,4,52,6,7,3};
        String intstr = Arrays.toString(a1);

        System.out.println(intstr);
        Arrays.sort(a1);

        System.out.println(Arrays.toString(a1));

    }

}
