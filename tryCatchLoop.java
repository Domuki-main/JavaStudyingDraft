
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

                //e.getMessage();

                /*
                 * e.toString();             获得异常种类和错误信息
                 *
                 * e.getMessage();           获得错误信息
                 *
                 * e.printStackTrace();      在控制台打印出异常种类，错误信息和出错位置等
                 */

                System.out.println("not available");

                sc = new Scanner(System.in);
                //扫描器在输入内容按回车键时,系统默认在输入内容后面加了(\n 或\r),不重新创建扫描器对象的话会陷入死循环

            } finally {

                System.out.println(b);

            }

        }

    }

}



