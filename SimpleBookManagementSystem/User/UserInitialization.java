package User;

import java.io.*;
import java.util.Scanner;

import Book.*;
import History.HistoryOperation;
import History.HistorySearch;
import System.Counter;

public class UserInitialization {


    public static User[] UserImport(){

        int count = 0;
        String str;
        try {
            FileReader fr = new FileReader("user.txt");
            BufferedReader br = new BufferedReader(fr);
            while((str = br.readLine())!=null){
                count++;//读取一行加一个换行再读取下一行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User[] userList = new User[count - 1];


        try {
            FileReader fr = new FileReader("user.txt");//read the txt
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            String str2;
            while((str2 = br.readLine())!=null){
                sb.append(str2+"\n");//读取一行加一个换行再读取下一行
            }

            //Book[] bookList = new Book[count];

            String st1 = sb.toString();//最后把stringBuilder转化为string，可以理解为总信息流
            //System.out.println(st);
            String st2 = st1.replace("Username\tPassword\tIdentity\n","");

            //System.out.println(st2);

            String[] s2 = st2.split("\n");//create a array which split by "\n"把信息流按换行进行分解成个人信息流

            if(!(s2[0].equals(""))) {
                for (int j = 0; j < s2.length; j++) {

                    String[] s3 = s2[j].split("\t");//create a array which split by "\t"把个人信息流分解各个参数流
                    userList[j] = new User();
                    userList[j].setUsername(s3[0]);
                    userList[j].setPassword(s3[1]);
                    userList[j].setIdentity(s3[2]);

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return userList;

    }



    public static void Menu() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t1.Login\n\t\t2.Register\n\t\t3.Exit\n\nplease input integer number to choose which function you want:");
        String choice = sc.nextLine();
        while((choice.equals("1")==false) && (choice.equals("2")==false) && (choice.equals("3")==false)){
            System.out.println("wrong number, please try again");
            choice = sc.nextLine();
        }

        switch(choice){
            case "1": judgement(Login(UserImport())); break;
            case "2": Register(UserImport()); break;
            default: break;
        }

    }



    public static void judgement(User user){

        System.out.println("loading...........\n\n\n");

        while(true) {
            if (user.getIdentity().equals("Super_Administer")) {
                superAdministerChoice(user);
            }
            else if (user.getIdentity().equals("Administer")) {
                AdministerChoice(user);
            }
            else {
                NormalChoice(user);
            }
        }
    }



    public static void NormalChoice(User user) {

        Scanner sc = new Scanner(System.in);
        normalUserMenu();

        switch (sc.nextLine()){

            case "1":
                BookOperation.bookLender(user ,BookOperation.bookImport());
                break;//lend, change the amount

            case "2":
                BookOperation.bookReturn(user ,BookOperation.bookImport());
                break;//return, change the amount

            case "3":
                System.exit(0);
                break;//exit

            default:
                break;
        }


    }



    public static void AdministerChoice(User user) {

        Scanner sc = new Scanner(System.in);
        AdministerMenu();
        switch (sc.nextLine()){
            case "1":
                BookOperation.addBook(BookOperation.bookImport());
                break;//add

            case "2":
                BookOperation.deleteBook(BookSearch.identitySearching(BookOperation.bookImport()), BookOperation.bookImport());
                break;//delete

            case "3":
                BookOperation.changeBook(BookSearch.identitySearching(BookOperation.bookImport()), BookOperation.bookImport());
                break;//change

            case "4":
                BookOperation.bookLender(user ,BookOperation.bookImport());
                break;//lend, change the amount

            case "5":
                BookOperation.bookReturn(user ,BookOperation.bookImport());
                break;//return, change the amount

            case "6":
                UserOperation.addUser(UserInitialization.UserImport());
                break;//add user

            case "7":
                UserOperation.deleteUser(UserSearch.nameSearching(UserInitialization.UserImport()), UserInitialization.UserImport(), user);
                break;//delete user

            case "8":
                System.exit(0);
                break;//exit

            default:
                break;
        }


    }



    public static void superAdministerMenu(){

        System.out.println("BOOK MANAGEMENT\n\t1.Add Book\n\t2.Delete Book\n\t3.Change Book\n\t4.Lend Book\n\t5.Return Book" +
                "\nUSER MANAGEMENT\n\t6.Add User\n\t7.Delete User\n\t8.Change Identity\n\t9.Searching\n\t10.Exit");

    }



    public static void superAdministerChoice(User user){

        Scanner sc = new Scanner(System.in);
        superAdministerMenu();
        switch (sc.nextLine()){
            case "1":
                BookOperation.addBook(BookOperation.bookImport());
                break;//add

            case "2":
                BookOperation.deleteBook(BookSearch.identitySearching(BookOperation.bookImport()), BookOperation.bookImport());
                break;//delete

            case "3":
                BookOperation.changeBook(BookSearch.identitySearching(BookOperation.bookImport()), BookOperation.bookImport());
                break;//change

            case "4":
                BookOperation.bookLender(user ,BookOperation.bookImport());
                break;//lend, change the amount

            case "5":
                BookOperation.bookReturn(user ,BookOperation.bookImport());
                break;//return, change the amount

            case "6":
                UserOperation.addUser(UserInitialization.UserImport());
                break;//add user

            case "7":
                UserOperation.deleteUser(UserSearch.nameSearching(UserInitialization.UserImport()), UserInitialization.UserImport(), user);
                break;//delete user

            case "8":
                UserOperation.changeUser(UserSearch.nameSearching(UserInitialization.UserImport()), UserInitialization.UserImport());
                break;//change user

            case "9":
                SearchingMenu();
                break;//exit

            case "10":
                System.exit(0);
                break;//exit

            default:
                break;
        }

    }



    private static void SearchingMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("SYSTEM SEARCHING\n\t1.Book Searching\n\t2.History Searching\n\t<press other key to exit>");

        switch (sc.nextLine()){

            case "1":
                BookSearch.SearchingChoice();break;

            case "2":
                HistorySearch.userNameSearch(HistoryOperation.historyImport());break;

                default: break;

        }

    }



    public static void AdministerMenu(){

        System.out.println("BOOK MANAGEMENT\n\t1.Add Book\n\t2.Delete Book\n\t3.Change Book\n\t4.Lend Book\n\t5.Return Book" +
                "USER MANAGEMENT\n\t6.Add User\n\t7.Delete User\n\t8.Exit");

    }



    public static void normalUserMenu(){

        System.out.println("BOOK MANAGEMENT\n\t1.Lend Book\n\t2.Return Book\n\t3.Exit");

    }



    public static User Login(User[] userList){

        Scanner sc = new Scanner(System.in);
//首先输入用户名和密码
        System.out.print("Username:\t");
        String Username = sc.nextLine();
        System.out.println("Password:\t");
        String Password = sc.nextLine();
//创建一个大数组，把所有用户信息全部调入内存


        boolean state = false;//登陆状态或者是否登陆成功
        int people = 0;
        for(int j = 0; j < Counter.arrayCounter(userList); j++){//把输入的用户名和密码与每一个用户做对比

            if((Username.equals(userList[j].getUsername()))&&(Password.equals(userList[j].getPassword()))) {
                state = true;
                people = j;
            }
        }
        if(state == true){
            System.out.println("login successfully");
        }else{
            System.out.println("your username or password isn't correct. please try again");
            Login(UserImport());
        }

        return userList[people];
    }



    public static void Register(User[] userList) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//输入用户名和密码
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        User newUser = new User(username, password, "Normal");

        if(UserSearch.repeatName(userList, username)) {

            int sum = userList.length + 1;
            System.out.println(Counter.arrayCounter(userList));
            User[] lastUserList = new User[sum];

            for (int i = 0; i < userList.length; i++) {

                lastUserList[i] = userList[i];

            }
            lastUserList[userList.length] = new User();
            lastUserList[userList.length].setUsername(username);
            lastUserList[userList.length].setPassword(password);
            lastUserList[userList.length].setIdentity("Normal");

            UserOperation.userListSaver(lastUserList);

            System.out.println("Register successfully");
        }else{
            System.out.println("you cannot register using same name with others");
        }
        Menu();
    }


}
