package Java20200401;

import java.util.ArrayList;

public class Demo7ArrayList {

    /*
    array's length cannot be changed
    but length of array list can be changed

    ArrayList<E>, what's the meaning of <E>
    the type of all data in array list

    creating:
        ArrayList();


    notice: for array list, you cannot get reference when you try to print it
     */

    public static void main(String[] args) {

        /*
        I created an arrayList named al which inside is full of String type data
         */
        ArrayList<String> al = new ArrayList<>();

        System.out.println(al); // []

        /*
        the way to add new data to list
         */
        al.add("1");
        al.add("2");
        al.add("3");

        System.out.println(al);

        /*
        other common usages
            1. add  add(E e), the type of the data you wanna add must same as the type of list
            2. get  get(int index)
            3. delete remove(int index)
            4. length size(): return the amount of data in list
         */
        System.out.println(al.get(1));

        al.remove(1);
        System.out.println(al);

        System.out.println(al.size());

        /*
        if you wanna store the data in basic type(like int, double) you need use wrapper class corresponding to the type
         */
        /*
        basic type  wrapper class
        byte        Byte
        short       Short
        int         Integer
        long        Long
        flout       Flout
        double      Double
        char        Character
        boolean     Boolean
         */
        ArrayList<Integer> al2 = new ArrayList<>();

        al2.add(1);
        al2.add(2);
        al2.add(3);
        al2.add(4);
        al2.add(5);

        System.out.println(al2);

    }

}
