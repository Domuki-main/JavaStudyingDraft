package Java20200401.Demo10;

import java.util.ArrayList;

public class Demo10ArrayListPrint {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("apple");
        list.add("banana");
        list.add("grape");

        System.out.println(list);//[apple, banana, grape]

        printArrayList(list);

    }

    public static void printArrayList(ArrayList<String> list){

        //{apple@banana@grape}

        System.out.print("{");
        for (int i = 0; i < list.size(); i++){

            System.out.print(list.get(i));

            if(i == list.size()-1)
                System.out.print("}\n");
            else
                System.out.print("@");
        }

    }

}
