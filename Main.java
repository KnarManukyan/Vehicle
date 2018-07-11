class Vehicle {
    private double weight;
    private double length;
    Vehicle(double weight, double length){
        this.weight = weight;
        this.length = length;
    }
    public double calculateWeight(){ return weight;}
    public double calculateLength(){ return length;}
    public void setWeight(double weight){ if(weight>0){ this.weight = weight;}}
    public void setLength(double length){ if(length>0){ this.length = length;}}
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
    private Trailer trailer = new Trailer();
    Truck(double weight, double length){
        super(weight,length);
    }
    public void setTrailerWeight(double weight) { if(weight>0){ trailer.setweight(weight);}}
    public void setTrailerLength(double length) { if(length>0){ trailer.setlength(length);}}
    public void attachTrailer(){
        setWeight(calculateWeight()+trailer.getWeight());
        setLength(calculateLength()+trailer.getLength());
    }
    public void detachTrailer(){
        setWeight(calculateWeight()-trailer.getWeight());
        setLength(calculateLength()-trailer.getLength());
    }

}
class Trailer{
    private double weight = 20;
    private double length = 20;
    public double getWeight() { return weight;}
    public double getLength() { return length;}
    public void setweight(double weight) { this.weight = weight;}
    public void setlength(double length) { this.length = length;}
}
public class Main {
    public static void main(String [] args){
        double weight = 12;
        double length = 25;
        double trailerlength = 30;
        double trailerweight = 30;
        Vehicle car = new Car(weight,length);
        System.out.println("the length of the car is " + car.calculateLength());
        System.out.println("the weight of the car is " + car.calculateWeight());
        Truck tr = new Truck(weight,length);
        tr.setTrailerLength(trailerlength);
        tr.setTrailerWeight(trailerweight);
        tr.attachTrailer();
        System.out.println("The length after attaching the trailer " + tr.calculateLength());
        System.out.println("The weight after attaching the trailer " + tr.calculateWeight());
        tr.detachTrailer();
        System.out.println("The length after detaching the trailer " + tr.calculateLength());
        System.out.println("The weight after detaching the trailer " + tr.calculateWeight());
    }
}