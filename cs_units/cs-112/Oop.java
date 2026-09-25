
import java.util.ArrayList;

public class Oop{
    public static void main(String[] args){
        Car testCar = new Car();
        Car testCar2 = new Car("Red", "Toyota");
        String[] stuff = {"Keys", "Wallet"};
        Car testCar3 = new Car("Blue", "Honda", false, stuff, 9.8);


        System.out.println(testCar.Make + " "+ testCar.Color);
        System.out.println(testCar2.Make + " " + testCar.Color);

        System.out.println(testCar3.Make);
        System.out.println(testCar3.Color);
        System.out.println(testCar3.getFuel());
        System.out.println(testCar3.getStuff());
    }
}



class Vehicle{
    private ArrayList<String> stuffInside = new ArrayList<>();
    private double Fuel;

    public String Color;
    public String Make;
    public boolean Running;



    public Vehicle(){
        this.Color = "Red";
        this.Make = "Unkown";
        this.Running = false;
        this.stuffInside.add("Keys");
        this.Fuel = 10.5;
    }

    public Vehicle(String color, String make, boolean  running, String[] stuff, double fuel ) {
        this.Color = color;
        this.Make = make;
        this.Running = running;
        this.Fuel = fuel;
        this.updateStuff(stuff);
    }

    
    public ArrayList<String> getStuff(){
        return this.stuffInside;
    }

    public double getFuel(){
        return this.Fuel;
    }


    public void updateFuel(double amount){
        this.Fuel = amount;
    }

    public void updateStuff(String[] stuff){
        for (String item : stuff){
            this.stuffInside.add(item);
        }
    }
}


class Car extends Vehicle{
    public Car(){
        this.Color = "Blue";
        this.Make = "Ford F-150";
    }


    public Car(String color, String make){
        this.Color = color;
        this.Make = make;
    }

    public Car(String color, String make, boolean running, String[] stuffInside, double fuel){
        super(color, make, running, stuffInside, fuel);
    }

}