package Java20200401.Demo12;

public class Test {

    static int num1 = 1;
    int num2 = 2;

    /**
     * member method
     */
    public void method(){

        System.out.println("this is a member method");
        System.out.println(num1);
        System.out.println(num2);
        /*
        both static and non-static variables can be used in member method
         */

    }

    /**
     * static method
     */
    public static void method2(){

        System.out.println("this is a static method");
        System.out.println(num1);
        //System.out.println(num2);
        /*
        only static variables can be used in static method
         */

    }

    public static void main(String[] args) {

        Student s1 = new Student("Bob", 16, "201435");

        s1.setLocation("nmmm");

        Student s2 = new Student("Alex", 16, "201434");

        System.out.println(s2.getLocation());


        Test t = new Test();

        t.method();
        t.method2();

        //Test.method();
        // bcz it's not static method, it cannot be used without calling.
        Test.method2();

        //method();
        method2();
        //for the static method which is in same class as main method can be used directly



        Person one = new Person();
        Person two = new Person();
        /*
        static always have priority over others
         */
        /*
        when executing the class first time, the static block will be acted only once.
         */

    }

}
