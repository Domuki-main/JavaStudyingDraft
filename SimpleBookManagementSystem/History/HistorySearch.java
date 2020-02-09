package History;

import java.util.Scanner;

import System.Counter;

public class HistorySearch {

    public static void userNameSearchPrint(History[] histories){

        Scanner sc = new Scanner(System.in);

        boolean state = false;

        System.out.println("username?");

        String userName = sc.nextLine();

        int arrayIndexAmount = Counter.arrayIndexAmountCounter(histories, userName);

        String index = "";

        for (int i = 0; i < histories.length; i++){

            if(userName.equals(histories[i].getUserLend())){

                index = index + i + "\t";

                state = true;

            }

        }

        if(state == true) {

            String[] resultIndexString = index.split("\t");

            int[] resultIndex = new int[arrayIndexAmount];

            for (int i = 0; i < histories.length; i++) {

                resultIndex[i] = Integer.parseInt(resultIndexString[i]);

            }

            HistoryOperation.displayHistoryList(HistoryOperation.historyImport(), resultIndex);

        }else{

            System.out.println("no existed name");
        }

    }

    public static int userNameSearch(History[] histories){

        Scanner sc  = new Scanner(System.in);
        boolean state = false;
        int number = 0;
        System.out.println("name? ");
        String userName = sc.nextLine();

        for(int i = 0; i < Counter.arrayCounter(histories); i++){

            if(userName.equals(histories[i].getUserLend())){
                HistoryOperation.displayHistory(histories, i);
                number = i;
                state = true;
            }

        }

        if (state == false){
            System.out.println("no existing name");
            return -1;
        }else return number;


    }

}
