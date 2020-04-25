package Java20200401.Demo15;

public class CircleTest {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle(10);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        c1.setRadius(288);
        System.out.println(c1.toString());

    }

}
