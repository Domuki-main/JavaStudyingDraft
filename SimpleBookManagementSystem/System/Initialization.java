package System;

import User.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Initialization {



    public static void CreatingFiles() throws IOException {

        boolean firstTime = true;

        System.out.println("Initialization");

        //创建数据文件夹，用于储存书本信息
        String f1="data.txt";

        File fdata = new File(f1);

        if(fdata.exists()){

            System.out.println("\tFile "+f1+" already exists");

            firstTime = false;

        }else {

            fdata.createNewFile();//creating true file in hardware

            PrintWriter pw = new PrintWriter(f1);

            pw.println("BookName\tAuthor\tClassify\tIdentity\tAmount");

            pw.close();

            System.out.println("\tSystem---> File "+f1+" was created successfully");

        }

        //创建用户文件夹，用于储存用户信息
        String f2="user.txt";

        File fuser = new File(f2);

        if(fuser.exists()){

            System.out.println("\tFile "+f2+" already exists");

            firstTime = false;

        }else {
            fuser.createNewFile();
            System.out.println("\tSystem---> File "+f2+" was created successfully");

        }

        //创建操作记录文件夹，储存用户操作记录
        String f3="recording.txt";

        File frecording = new File(f3);

        if(frecording.exists()){

            System.out.println("\tFile "+f3+" already exists");

            firstTime = false;

        }else {

            frecording.createNewFile();

            PrintWriter pw = new PrintWriter(f3);

            pw.println("UserName\tBookName\tDate\tState\tAmount");

            pw.close();

            System.out.println("\tSystem---> File "+f3+" was created successfully");
        }

        System.out.println("Initialization has been done!");

        if(firstTime == true) InitialRegister();//if its first time to use this program第一次运行程序注册默认为超级管理员

    }//初始化创建文件夹txt



    public static void InitialRegister() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        PrintWriter output = new PrintWriter("user.txt");

        System.out.println("welcome to use this idiot library management system, so you are the administrator by default.\n" +
                "you need set your username and password");
        System.out.println("your name? ");
        String username = sc.nextLine();
        System.out.println("your password? ");
        String password = sc.nextLine();

        User firstUser = new User(username, password, "Super_Administer");
        output.println("Username\tPassword\tIdentity");
        output.println(firstUser.toString());
        output.close();

    }//初始化登录默认超级管理员，用户分为：1.普通用户2.管理员3.超级管理员


}
