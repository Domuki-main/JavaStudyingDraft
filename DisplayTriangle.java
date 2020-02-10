import javax.swing.*;
import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String[] args){

        /* *
           *   *
           *   *   *
           *   *   *   *
           ....
         */
        Scanner sc = new Scanner(System.in);
        int high = sc.nextInt();

        for (int i = 0; i < high; i++){
            System.out.println();
            for (int j = 0; j <= i; j++){
                System.out.print("*\t");
            }
        }

        /*             *
                   *   *
               *   *   *
           *   *   *   *
           ....
         */
        for (int i = 0; i < high; i++){
            System.out.println();
            for(int j = 0; j <= i; j++){
                if(j == 0)for(int k = 0; k < high-(i + 1); k++)System.out.print("\t");
                System.out.print("*\t");
            }
        }


         /*            *
                   *   *   *
               *   *   *   *   *
           *   *   *   *   *   *   *
           ....
         */
        for (int i = 0; i < high; i++){
            System.out.println();
            for(int j = high; j > i+1; j--){
                System.out.print("\t");
            }
            for(int j = 0; j <= i; j++){
                System.out.print("*\t");
            }
            for(int j = 0; j <= i-1; j++){
                System.out.print("*\t");
            }
        }


        /*             *
                   *       *
               *               *
           *   *   *   *   *   *   *
           ....
         */
        for (int i = 1; i <= high; i++) {
            // 控制打印空格
            System.out.println();
            for (int j = 1; j <= high - i; j++) {
                System.out.print("\t");
            }

            // 控制打印*
            for (int k = 1; k <= 2 * i - 1; k++) {
                // 第一行,最后一行全部打印*
                if (i == 1 || i == high) {
                    System.out.print("*\t");
                } else {
                    // 第一个和最后一个打印*其余打印空格
                    if (k == 1 || k == 2 * i - 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
        }
    }
}
