class Vehicle {
    private double weight;
    private double length;
    Vehicle(double weight, double length){
        this.weight = weight;
        this.length = length;
    }
    public double calculateWeight(){ return weight;}
    public double calculateLength(){ return length;}
    public void setWeight(double weight){ if(weight>0){this.weight = weight;}}
    public void setLength(double length){ if(length>0){this.length = length;}}
}
class Car extends Vehicle {
    Car(double weight, double length){
        super(weight,length);
    }
}
class Boat extends Vehicle {
    Boat(double weight, double length){
        super(weight,length);
    }
}
class Truck extends Vehicle {
    private Trailor trailor = new Trailor();
    Truck(double weight, double length){
        super(weight,length);
    }
    public void setTrailorWeight(double weight) { if(weight>0){ trailor.setweight(weight);}}
    public void setTrailorLength(double length) { if(length>0){ trailor.setlength(length);}}
    public void attachTrailor(){
        setWeight(calculateWeight()+trailor.getWeight());
        setLength(calculateLength()+trailor.getLength());
    }
    public void detachTrailor(){
        setWeight(calculateWeight()-trailor.getWeight());
        setLength(calculateLength()-trailor.getLength());
    }

}
class Trailor{
    private double weight = 20;
    private double length = 20;
    public double getWeight() { return weight;}
    public double getLength() { return length;}
    public void setweight(double weight) {this.weight = weight;}
    public void setlength(double length) {this.length = length;}
}
public class Main {
    public static void main(String [] args){
        double weight = 12;
        double length = 25;
        Vehicle car = new Car(weight,length);
        System.out.println("the length of the car is " + car.calculateLength());
        System.out.println("the weight of the car is " + car.calculateWeight());
        Truck tr = new Truck(weight,length);
        tr.setTrailorLength(30);
        tr.setTrailorWeight(30);
        tr.attachTrailor();
        System.out.println("The length after attaching the tailor " + tr.calculateLength());
        System.out.println("The weight after attaching the tailor " + tr.calculateWeight());
        tr.detachTrailor();
        System.out.println("The length after detaching the tailor " + tr.calculateLength());
        System.out.println("The weight after detaching the tailor " + tr.calculateWeight());
    }
}