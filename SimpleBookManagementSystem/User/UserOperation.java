package User;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import System.*;

public class UserOperation {



    public static void addUser(User[] userList){//add the book

        Scanner sc = new Scanner(System.in);

        String userName;
        String password;
        String identity;

        System.out.println("what's name of the user: ");
        userName = sc.nextLine();

        System.out.println("what's password of the user: ");
        password = sc.nextLine();

        System.out.println("what's identity of the user: ");
        identity = sc.nextLine();

        if(UserSearch.repeatName(userList, userName)) {

            int sum = userList.length + 1;
            System.out.println(Counter.arrayCounter(userList));
            User[] lastUserList = new User[sum];

            for (int i = 0; i < userList.length; i++) {

                lastUserList[i] = userList[i];

            }
            lastUserList[userList.length] = new User();
            lastUserList[userList.length].setUsername(userName);
            lastUserList[userList.length].setPassword(password);
            lastUserList[userList.length].setIdentity(identity);


            userListSaver(lastUserList);
        }

    }//error exclude



    public static void changeUser(int number, User[] userList){

        Scanner sc = new Scanner(System.in);
        System.out.println("which information of this book you wanna change? \n" +
                "\t1.userName\n\t2.password\n\t3.identity");
        switch (sc.nextLine()){
            case "1": userList[number].setUsername(sc.nextLine());break;
            case "2": userList[number].setPassword(sc.nextLine());break;
            case "3": userList[number].setIdentity(sc.nextLine());break;
            default: break;
        }

        userListSaver(userList);

    }



    public static void deleteUser(int number, User[] userList, User user){//delete the book

        if(userList[number].getIdentity().equals("Super_Administer"))

            System.out.println("you have no right to operate");

        else {

            userList[number] = userList[userList.length - 1];

            User[] newUserList = new User[userList.length - 1];

            for (int i = 0; i < newUserList.length; i++) {

                newUserList[i] = userList[i];

            }

            userListSaver(newUserList);
        }
    }



    public static void userListSaver(User[] userList){//error exclude

        try {
            PrintWriter output = new PrintWriter("user.txt");
            output.println("Username\tPassword\tIdentity");
            for(int i = 0; i < userList.length; i++){

                if(userList[i] != null)
                    output.println(userList[i].toString());
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }



}
