package Java20200401;

import java.util.Random;
import java.util.Scanner;

public class Demo6GuessNumber {

    public static void main(String[] args) {

        //1. create a random number which cannot be changed
        //2. tell the number you guessed
        //3. judgement
        //4. trying loop, while true

        Random r = new Random();
        int n = 100;
        int in = 0;
        int number = r.nextInt(n) + 1;
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("guess what:");
            in = sc.nextInt();

            if (in > number) {
                System.out.println("too big");
            } else if (in < number) {
                System.out.println("too small");
            } else {
                System.out.println("game over");
                break;
            }

        }

    }

}
