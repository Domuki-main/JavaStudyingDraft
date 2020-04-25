package Java20200401.Demo12;

public class Student {

    private String name;

    private int age;

    private String matric;

    static String location = "Classroom 001, Library";
    /*
    many objects use one variable when use static.
    change one then all objects will be changed.
     */

    public Student(String name, int age, String matric, String location) {
        this.name = name;
        this.age = age;
        this.matric = matric;
        this.location = location;
    }

    public Student(String name, int age, String matric) {
        this.name = name;
        this.age = age;
        this.matric = matric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
