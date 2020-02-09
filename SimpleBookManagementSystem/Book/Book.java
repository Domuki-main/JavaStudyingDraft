package Book;

public class Book {

    private String bookName;

    private String author;

    private String classify;

    private String identity;

    private int amount;

    public Book(String bookName, String author, String classify, String identity, int amount){

        this.bookName = bookName;

        this.author = author;

        this.classify = classify;

        this.identity = identity;

        this.amount = amount;

    }

    public Book(){

        this.bookName = bookName;

        this.author = author;

        this.classify = classify;

        this.identity = identity;

        this.amount = amount;

    }

    @Override //Object中内置的类，用来格式化打印user的信息
    public String toString() {

        return bookName + "\t" + author + "\t" + classify + "\t" + identity + "\t" + amount;

    }

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getClassify(){
        return classify;
    }

    public void setClassify(String classify){
        this.classify = classify;
    }

    public String getIdentity(){
        return identity;
    }

    public void setIdentity(String identity){
        this.identity = identity;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

}
