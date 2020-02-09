package User;

public class User {

    private String username;

    private String password;

    private String identity;

    public User(String username, String password, String identity){

        this.username = username;

        this.password = password;

        this.identity = identity;

    }

    public User(){

        this.username = username;

        this.password = password;

        this.identity = identity;

    }


    @Override //Object中内置的类，用来格式化打印user的信息
    public String toString() {

        return username + "\t" + password + "\t" + identity;

    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setIdentity(String identity){
        this.identity = identity;
    }

    public String getIdentity(){
        return identity;
    }

}
