

public class Passenger {
    
    private String name;

    /* constructor for passenger class */
    public Passenger(String name) {
        this.name = name;
    }

    /* accessor for passenger's name */
    public String getName() {
        return this.name;
    }

     /**
     * adds passenger to car
     * @param car
     * @param passenger
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this) == false) {
            System.out.println("Try another car.");
        }
    }

    /**
     * removes passenger from car
     * @param car
     * @param passenger
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this) == false) {
            System.out.println("Check your ticket!");
        }
    }


    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        
        Passenger passenger1 = new Passenger("Sofia");
        Passenger passenger2 = new Passenger("Delia");
        Car aCar = new Car(2, 5);
        passenger1.boardCar(aCar);
        passenger2.boardCar(aCar);
        passenger1.getOffCar(aCar);
        passenger1.getOffCar(aCar);

    }
}
