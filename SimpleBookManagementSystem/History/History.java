package History;

public class History {

    private String userLend;

    private String bookLend;

    private String date;

    private String state;

    private int amount;


    public History(String userLend, String bookLend, String date, String state, int amount) {

        this.userLend = userLend;

        this.bookLend = bookLend;

        this.date = date;

        this.state = state;

        this.amount = amount;

    }

    public History() {

        this.userLend = userLend;

        this.bookLend = bookLend;

        this.date = date;

        this.state = state;

        this.amount = amount;


    }


    @Override
    public String toString() {
        return userLend + "\t" + bookLend + "\t" + date + "\t" + state + "\t" +amount;
    }

    public String getUserLend() {
        return userLend;
    }

    public void setUserLend(String userLend) {
        this.userLend = userLend;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBookLend() {
        return bookLend;
    }

    public void setBookLend(String bookLend) {
        this.bookLend = bookLend;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
