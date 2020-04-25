package Java20200401.Demo16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class FrequentlyUsedMethodInVectorClass {

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add("mango");
        al.add("apple");
        al.add("pear");
        al.add("banana");


        Vector v = new Vector();
        System.out.println(v);

        //add
        v.add("alex");
        v.add(1, "oliver");
        v.add(1);
        System.out.println(v);

        v.addAll(al);
        System.out.println(v);

        //delete
        //v.remove("oliver");
        v.remove(1);
        System.out.println(v);
        v.remove("1");
        System.out.println(v);

        //length
        System.out.println(v.size());

        Vector v2 = new Vector();
        v2.add(1);
        v2.add(2);
        v2.add(3);

        System.out.println("index of 1 is: " + v2.indexOf(1));
    }

}
