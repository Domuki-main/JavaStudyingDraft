package Java20200401.Demo13;

import java.util.Arrays;

public class Demo2Arrays {

    public static void main(String[] args) {

        String str = "asiudhuealofu8eoaie";

        char[] c = str.toCharArray();

        System.out.println(Arrays.toString(c));

        Arrays.sort(c);

        System.out.println(Arrays.toString(c));

        for (int i = c.length - 1; i >= 0; i--){

            System.out.print(c[i]);

        }

    }

}
