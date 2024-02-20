import java.util.ArrayList;

public class Train {

    //attributes it will need
    private FuelType fuelType;
    private ArrayList<Car> cars;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;
    private Engine engine;

    /**
     * Train constructor
     * @param fuelType
     * @param fuelCapacity
     * @param nCars
     * @param passengerCapacity
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
        
        //new creations
        this.cars = new ArrayList<Car>(nCars);
        //creates empty cars
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(i, passengerCapacity));
        }
        this.engine = new Engine(fuelType, fuelCapacity);


    }

    /* accessor for engine */
    public Engine getEngine() {
        return this.engine;
    }

    /* accessor for car at index in ArrayList */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /* returns total capacity of train */
    public int getMaxCapacity() {
        return this.passengerCapacity * nCars;
    }

    /* returns seats remaining in total */
    public int seatsRemaining() {
        int space = 0;
        for (Car car: cars) {
            space += car.seatsRemaining();
        }
        return space;
    }

    /* prints each passenger in all cars */
    public void printManifest() {
        for (Car car: cars) { //print out every passenger in each car
            car.printManifest();
        }
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 200, 5, 10);

        Passenger passenger1 = new Passenger("Sofia");
        Passenger passenger2 = new Passenger("Delia");
        Passenger passenger3 = new Passenger("Zoe");
        Passenger passenger4 = new Passenger("Sarah");
        Passenger passenger5 = new Passenger("Kate");
        Passenger passenger6 = new Passenger("Uma");
        Passenger passenger7 = new Passenger("Maya");

        myTrain.getCar(1).addPassenger(passenger1);
        myTrain.getCar(1).addPassenger(passenger2);
        myTrain.getCar(2).addPassenger(passenger3);
        myTrain.getCar(2).addPassenger(passenger4);
        myTrain.getCar(3).addPassenger(passenger5);
        myTrain.getCar(3).addPassenger(passenger6);
        myTrain.getCar(4).addPassenger(passenger7);

        myTrain.getCar(4).removePassenger(passenger7);
        
        myTrain.printManifest();
        System.out.println("Seats remaining: " + myTrain.seatsRemaining());
        
}
}