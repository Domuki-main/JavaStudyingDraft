package Book;

import java.util.Scanner;

import System.Counter;

public class BookSearch {


    public static void SearchingChoice(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1.name\n2.author\n3.classify\nidentity");

        String number = sc.nextLine();

        switch (number){

            case "1": nameSearching(BookOperation.bookImport());break;

            case "2": authorSearching(BookOperation.bookImport());break;

            case "3": classifySearching(BookOperation.bookImport());break;

            case "4": identitySearching(BookOperation.bookImport());break;

        }

    }



    public static int nameSearching(Book[] bookList){

        Scanner sc  = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("name? ");
        String bookName = sc.nextLine();

        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(bookName.equals(bookList[i].getBookName())){
                BookOperation.bookPrinter(i, bookList);
                number = i;
                state = true;
            }

        }

        if (state == false){
            System.out.println("there's no book like that.");
            return -1;
        }else return number;

    }


    public static void nameSearchingPrint(Book[] bookList){

        Scanner sc  = new Scanner(System.in);

        boolean state = false;

        System.out.println("name? ");

        String bookName = sc.nextLine();

        String index = "";

        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(bookName.equals(bookList[i].getBookName())){

                index = index + i + "";

                state = true;
            }

        }

        String[] resultIndexString = index.split("\t");

        int amount = Counter.arrayIndexAmountCounter(bookList, bookName);

        int[] resultIndex = new int[amount];

        for (int i = 0; i < resultIndex.length; i++){

            resultIndex[i] = Integer.parseInt(resultIndexString[i]);

        }

        if (state == false){

            System.out.println("there's no book like that.");

        }else BookOperation.bookPrinter(resultIndex, bookList);

    }



    public static int authorSearching(Book[] bookList){

        Scanner sc  = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("author? ");
        String author = sc.nextLine();
        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(author.equals(bookList[i].getAuthor())){
                BookOperation.bookPrinter(i, bookList);
                number = i;
                state = true;
            }

        }

        if (state == false){
            System.out.println("there's no author like that.");
            return -1;
        }else return number;

    }



    public static int classifySearching(Book[] bookList){

        Scanner sc  = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("classify? ");
        String classify = sc.nextLine();
        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(classify.equals(bookList[i].getClassify())){
                BookOperation.bookPrinter(i, bookList);
                number = i;
                state = true;
            }

        }

        if (state == false){
            System.out.println("there's no classify like that.");
            return -1;
        }else return number;

    }



    public static int identitySearching(Book[] bookList){

        Scanner sc  = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("identity? ");
        String identity = sc.nextLine();
        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(identity.equals(bookList[i].getIdentity())){
                BookOperation.bookPrinter(i, bookList);
                number = i;
                state = true;
            }

        }

        if (state == false){
            System.out.println("wrong identity number, please try later");
            return -1;
        }else return number;

    }



    public static boolean bookIdentityExisting(Book[] bookList, String identity){

        boolean state = false;

        for(int i = 0; i < Counter.arrayCounter(bookList); i++){

            if(identity.equals(bookList[i].getIdentity())){
                state = true;
            }

        }

        return state;
    }

}
