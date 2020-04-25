package Java20200401.Demo9;

import java.util.ArrayList;

public class Demo9ArrayListStudent {

    /*
    1. definition 4 student objects
    2. create Student Class, <Student>
    3. according to class then create 4 new student objects
    4. ergodic array set
     */

    public static void main(String[] args) {

        ArrayList<StudentInDemo9> list = new ArrayList<>();

        StudentInDemo9 Anny = new StudentInDemo9("Anny",10);
        StudentInDemo9 Danny = new StudentInDemo9("Danny",10);
        StudentInDemo9 Bob = new StudentInDemo9("Bob",10);
        StudentInDemo9 Potter = new StudentInDemo9("Potter",10);

        list.add(Anny);
        list.add(Danny);
        list.add(Bob);
        list.add(Potter);

        //ergodic
        for (int i = 0; i < list.size(); i++){
            StudentInDemo9 stu = list.get(i);
            System.out.println(stu.getAge()+stu.getName());
        }

    }

}
