package Java20200401.Demo17;

public class SonsClass extends ParentsClass{

    private String identity = "son";

    public SonsClass(String name, String number) {
        super(name, number);
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


    public static void main(String[] args) {

        ParentsClass p1 = new ParentsClass("alex", "201464");

        System.out.println(p1.getName()+p1.getNumber());

        SonsClass s1 = new SonsClass("bob","203743");

        System.out.println(s1.getName() + " is a " + s1.getIdentity());

    }

}
