package History;

import java.io.*;

public class HistoryOperation {



    public static void historySaver(History[] history){//save the history

        try {
            PrintWriter output = new PrintWriter("recording.txt");
            output.println("UserName\tBookName\tDate\tState\tAmount");
            for(int i = 0; i < history.length; i++){

                if(history[i] != null)
                    output.println(history[i].toString());
            }

            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



    public static History[] historyImport() {

        int count = 0;
        String str;
        try {
            FileReader fr = new FileReader("recording.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                count++;//读取一行加一个换行再读取下一行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        History[] histories = new History[count-1];


        try {
            FileReader fr = new FileReader("recording.txt");//read the txt

            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            String str2;
            while ((str2 = br.readLine()) != null) {
                sb.append(str2 + "\n");//读取一行加一个换行再读取下一行
            }

            //Book[] bookList = new Book[count];

            String st1 = sb.toString();//最后把stringBuilder转化为string，可以理解为总信息流
            //System.out.println(st);
            String st2 = st1.replace("UserName\tBookName\tDate\tState\tAmount\n","");

            String[] s2 = st2.split("\n");//create a array which split by "\n"把信息流按换行进行分解成个人信息流

            if(!(s2[0].equals(""))) {
                for (int j = 0; j < s2.length; j++) {

                    String[] s3 = s2[j].split("\t");//create a array which split by "\t"把个人信息流分解各个参数

                    histories[j] = new History();
                    histories[j].setUserLend(s3[0]);
                    histories[j].setBookLend(s3[1]);
                    histories[j].setDate(s3[2]);
                    histories[j].setState(s3[3]);
                    histories[j].setAmount(Integer.parseInt(s3[4]));

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return histories;
    }



    public static void addHistory(History history, History[] histories){

        int sum = histories.length + 1;
        History[] historiesList = new History[sum];

        for(int i = 0; i < histories.length; i++){

            historiesList[i] = histories[i];

        }
        historiesList[histories.length] = new History();
        historiesList[histories.length].setUserLend(history.getUserLend());
        historiesList[histories.length].setBookLend(history.getBookLend());
        historiesList[histories.length].setDate(history.getDate());
        historiesList[histories.length].setState(history.getState());
        historiesList[histories.length].setAmount(history.getAmount());

        historySaver(historiesList);

    }



    public static void displayHistoryList(History[] histories){

        for (int i = 0; i < histories.length; i++){

            System.out.println(histories[i].toString());

        }

    }



    public static void displayHistoryList(History[] histories, int[] resultIndex){

        for (int i = 0; i < resultIndex.length; i++){

            System.out.println(histories[resultIndex[i]].toString());

        }

    }


    public static void displayHistory(History[] histories, int Index){

        System.out.println(histories[Index].toString());

    }


}
