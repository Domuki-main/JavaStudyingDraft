package Java20200401.Demo15;

import java.text.DecimalFormat;

class Circle{
    private double radius;
    private double area;
    private final double PI = Math.PI;
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(){
        this.radius = 1;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(radius * radius * PI));
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "This is a circle with " + radius + " radius and "
                + df.format(radius * radius * PI) + " area.";
    }

}