import java.util.ArrayList;
import java.util.List;

import javax.naming.event.ObjectChangeListener;

public class Car {
    
    //car's attributes
    private int maxPassengers;
    private ArrayList<Passenger> passengers;
    
    //for printing purposes
    public int ID;


    /**
     * constructor for car
     * @param ID
     * @param maxPassengers
     */
    public Car(int ID, int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<Passenger>(maxPassengers);
        this.ID = ID;
    }

    /* accessor method for max passengers */
    public int getMaxPassengers() {
        return maxPassengers;
    }
    /* accessor method for seats remaining */
    public int seatsRemaining() {
        return maxPassengers - passengers.size();
    }

    /**
     * adds passenger to car and returns boolean
     * @param person
     * @return boolean added
     */
    public boolean addPassenger(Passenger person) {
        boolean added = false;

        if (maxPassengers - passengers.size() != 0) {
            passengers.add(person);
            added = true;
            System.out.println("Passenger " + person.getName() + " added to car " + ID);
        }
        else {
            added = false;
            System.out.println("Error: could not add passenger to this car.");
        }
        return added;
    }
    
    /**
     * removes passenger from car and returns boolean 
     * @param person
     * @return boolean removed
     */
    public boolean removePassenger(Passenger person) {
        boolean removed = false;

        if (passengers.contains(person)) {
            passengers.remove(person);
            removed = true;
            System.out.println("Passenger " + person.getName() + " removed from car " + ID);
        }
        else {
            removed = false;
            System.out.println("Error: could not remove passenger from this car.");
        }
        return removed;
    }

    /**
     * prints all passengers in car, or if a car is empty
     */
     public void printManifest() {
        if (passengers.size() == 0) {
            System.out.println("Car " + ID + " is empty.");
        }
        else {
            System.out.println("Car " + ID + " contains: ");
            for(Passenger p: passengers) {
                System.out.println(p.getName());
            }
        }
     }

/**
 * main method
 * @param args
 */
public static void main(String[] args) {
    Car myCar = new Car(1, 10);
    Passenger Uma = new Passenger("Uma");
    Passenger Maya = new Passenger("Maya");
    Passenger Scarlett = new Passenger("Scarlett");
    myCar.addPassenger(Uma);
    myCar.addPassenger(Maya);
    myCar.addPassenger(Scarlett);
    
    myCar.removePassenger(Scarlett);
    myCar.printManifest();
}

}