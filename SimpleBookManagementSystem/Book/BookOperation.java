package Book;

import History.History;
import User.User;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import System.Counter;
import History.*;

public class BookOperation {



    public static Book[] bookImport(){

        int count = 0;
        String str;
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            while((str = br.readLine())!=null){
                count++;//读取一行加一个换行再读取下一行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Book[] books = new Book[count-1];


        try {
            FileReader fr = new FileReader("data.txt");//read the txt
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            String str2;
            while((str2 = br.readLine())!=null){
                sb.append(str2+"\n");//读取一行加一个换行再读取下一行
            }

            //Book[] bookList = new Book[count];

            String st1 = sb.toString();//最后把stringBuilder转化为string，可以理解为总信息流
            //System.out.println(st);
            String st2 = st1.replace("BookName\tAuthor\tClassify\tIdentity\tAmount\n","");

            //System.out.println(st2);

            String[] s2 = st2.split("\n");//create a array which split by "\n"把信息流按换行进行分解成个人信息流

            if(!(s2[0].equals(""))) {
                for (int j = 0; j < s2.length; j++) {

                    String[] s3 = s2[j].split("\t");//create a array which split by "\t"把个人信息流分解各个参数流
                    books[j] = new Book();
                    books[j].setBookName(s3[0]);
                    books[j].setAuthor(s3[1]);
                    books[j].setClassify(s3[2]);
                    books[j].setIdentity(s3[3]);
                    books[j].setAmount(Integer.parseInt(s3[4]));

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;

    }//把文件中原始的总信息流分配到内存中的书列表//error exclude



    public static void addBook(Book[] bookList){//add the book

        Scanner sc = new Scanner(System.in);

        String bookName;
        String author;
        String classify;
        String identity;
        int amount;

        System.out.println("what's name of the book: ");
        bookName = sc.nextLine();

        System.out.println("what's author of the book: ");
        author = sc.nextLine();

        System.out.println("what's classify of the book: ");
        classify = sc.nextLine();

        System.out.println("what's identity of the book: ");
        identity = sc.nextLine();
        while(BookSearch.bookIdentityExisting(bookList, identity)){
            System.out.println("the identity already existed, please try other one");
            identity = sc.nextLine();
        }

        System.out.println("what's amount of the book: ");
        amount = Integer.parseInt(sc.nextLine());

        int sum = bookList.length + 1;
        System.out.println(Counter.arrayCounter(bookList));
        Book[] lastBookList = new Book[sum];

        for(int i = 0; i < bookList.length; i++){

            lastBookList[i] = bookList[i];

        }
        lastBookList[bookList.length] = new Book();
        lastBookList[bookList.length].setBookName(bookName);
        lastBookList[bookList.length].setAuthor(author);
        lastBookList[bookList.length].setClassify(classify);
        lastBookList[bookList.length].setIdentity(identity);
        lastBookList[bookList.length].setAmount(amount);

        bookListSaver(lastBookList);

    }//error exclude



    public static void changeBook(int number, Book[] bookList){

        Scanner sc = new Scanner(System.in);
        System.out.println("which information of this book you wanna change? \n" +
                "\t1.name\n\t2.author\n\t3.classify\n\t4.identity\n\t5.amount");
        switch (sc.nextLine()){
            case "1": bookList[number].setBookName(sc.nextLine());break;
            case "2": bookList[number].setAuthor(sc.nextLine());break;
            case "3": bookList[number].setClassify(sc.nextLine());break;
            case "4": bookList[number].setIdentity(sc.nextLine());break;
            case "5": bookList[number].setAmount(Integer.parseInt(sc.nextLine()));break;
            default: break;
        }

        bookListSaver(bookList);

    }



    public static void deleteBook(int number, Book[] bookList){//delete the book

        bookList[number] = bookList[bookList.length-1];

        Book[] newBookList = new Book[bookList.length-1];

        for (int i = 0; i < newBookList.length; i++) {
            newBookList[i] = bookList[i];
        }

        bookListSaver(newBookList);
    }



    public static void bookListSaver(Book[] bookList){//error exclude

        try {
            PrintWriter output = new PrintWriter("data.txt");
            output.println("BookName\tAuthor\tClassify\tIdentity\tAmount");
            for(int i = 0; i < bookList.length; i++){

                if(bookList[i] != null)
                    output.println(bookList[i].toString());
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }//把内存中的书列表写回文件



    public static void bookListPrinter(Book[] bookList){

        for(int i = 0; i < bookList.length; i++){

            System.out.println(bookList.toString());

        }

    }//打印书列表



    public static void bookPrinter(int number, Book[] bookList){

        System.out.println(bookList[number].getBookName()+"\t"+bookList[number].getAuthor()+"\t"+bookList[number].getClassify()
                +"\t"+bookList[number].getIdentity()+"\t"+bookList[number].getAmount());

    }//打印书信息



    public static void bookPrinter(int[] resultIndex, Book[] bookList){

        for (int i = 0; i < resultIndex.length; i++) {

            System.out.println(bookList[resultIndex[i]].toString());

        }

    }//打印书信息



    public static void bookLender(User user, Book[] bookList){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd//HH:mm:ss");
        //first, change the data
        System.out.println("which book you want to lend? ");
        int number = BookSearch.nameSearching(bookList);
        if(number != -1) {
            System.out.println("How many? ");
            int amount = sc.nextInt();

            String state = "LEND";

            if ((bookList[number].getAmount() - amount) < 0)
                System.out.println("the amount you wanna learn is not enough");
            else {
                bookList[number].setAmount(bookList[number].getAmount() - amount);
                bookListSaver(bookList);
                History history = new History(user.getUsername(), bookList[number].getBookName(), df.format(new Date()), state, amount);
                HistoryOperation.addHistory(history, HistoryOperation.historyImport());
            }
        }

    }



    public static void bookReturn(User user, Book[] bookList){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd//HH:mm:ss");
        //first, change the data
        System.out.println("which book you want to return? ");
        int number = BookSearch.nameSearching(bookList);
        System.out.println("How many? ");
        int amount = sc.nextInt();
        String state = "RETURN";

        bookList[number].setAmount(bookList[number].getAmount() + amount);
        bookListSaver(bookList);
        History history = new History(user.getUsername(), bookList[number].getBookName(), df.format(new Date()), state, amount);
        HistoryOperation.addHistory(history, HistoryOperation.historyImport());


    }


}
