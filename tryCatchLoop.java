import java.util.InputMismatchException;
import java.util.Scanner;

public class tryCatchLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum, a, b = 0;

        while (true) {

            b++;

            try {

                a = sc.nextInt();

                break;

            } catch (InputMismatchException e) {

                System.out.println("not available");

                sc = new Scanner(System.in);
                //when Scanner is in inputing situation, the system'll add "\n" or "\r" in the end of the content when pressing the Enter key.
                //if don't create new Scanner, the program will become endless loop...

            } finally {

                System.out.println(b);

            }

        }

    }

}



