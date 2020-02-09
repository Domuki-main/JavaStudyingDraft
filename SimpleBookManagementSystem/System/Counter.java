package System;

import Book.Book;
import History.History;
import User.User;

public class Counter {

    public static int arrayCounter(User[] userList){
        int count  = 1;

        for(int j = 1; j < userList.length; j++) {
            if (userList[j] == null) break;
            count++;
        }

        return count;
    }


    public static int arrayCounter(Book[] bookList){
        int count  = 0;

        for(int j = 0; j < bookList.length; j++) {
            if (bookList[j] == null) break;
            count++;
        }

        return count;
    }


    public static int arrayCounter(History[] histories){
        int count  = 0;

        for(int j = 1; j < histories.length; j++) {
            if (histories[j] == null) break;
            count++;
        }

        return count;
    }


    public static int arrayIndexAmountCounter(History[] histories, String userName){

        int amount = 0;

        for (int i = 0; i < histories.length; i++){

            if(userName.equals(histories[i].getUserLend())){

                amount++;

            }

        }

        return amount;
    }



    public static int arrayIndexAmountCounter(Book[] bookList, String bookName){

        int amount = 0;

        for (int i = 0; i < bookList.length; i++){

            if(bookName.equals(bookList[i].getBookName())){

                amount++;

            }

        }

        return amount;
    }

}
