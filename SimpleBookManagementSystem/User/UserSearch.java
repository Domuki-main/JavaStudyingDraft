package User;

import java.util.Scanner;
import System.Counter;

public class UserSearch {



    public static int nameSearching(User[] userList) {

        Scanner sc = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("name? ");
        String userName = sc.nextLine();
        for (int i = 0; i < Counter.arrayCounter(userList); i++) {

            if (userName.equals(userList[i].getUsername())) {
                number = i;
                state = true;
            }

        }

        if (state == false) {
            System.out.println("there's no " + userName + " in user file");
            return -1;
        } else return number;
    }



    public static boolean repeatName(User[] userList, String userName){

        boolean state = true;

        for (int i = 0; i < Counter.arrayCounter(userList); i++) {

            if (userName.equals(userList[i].getUsername())) {
                state = false;
            }

        }

        return state;
    }



}
