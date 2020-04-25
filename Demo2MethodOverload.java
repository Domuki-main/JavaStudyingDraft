package Java20200401;

/*
* for the methods having same functions, cuz the list of parameters isn't same, someone create many different methods
* it's too complex
*
* so you need to do the Overload,
* the name of methods are same but parameters' list
* advantage just remember one name but many different usage in different situation
*
* no related to returning value
* */

public class Demo2MethodOverload {

    public static void main(String[] args) {

        System.out.println(sum(10, 20));



    }

    /**
     *
     * @param a
     * @param b
     * @return sum of a and b
     */
    public static int sum(int a, int b) {
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return sum of a, b and c
     */
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

}
