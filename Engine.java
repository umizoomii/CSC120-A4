public class Engine {

    //attributes it will need:
    private FuelType f;
    private double currentfuel; 
    private double maxfuel;
    //constructor
    public Engine(FuelType f, double currentfuel){
        this.f = f;
        this.currentfuel = currentfuel;
        this.maxfuel = 200;
    }
   
    /**Accessor for current fuel level */
    public double getCurrentfuel(){
        return this.currentfuel;
    }
    /**Accessor for current fuel level */
    public double getMaxfuel(){
        return this.maxfuel;
    }
     /**Accessor for current fuel level */
     public FuelType getfueltype(){
        return this.f;
    }

    //refuel method
    public void refuel() {
        currentfuel = maxfuel;
        System.out.println("New fuel level: " + currentfuel);
    }

    //go method
    public boolean go() {
        boolean notempty = true;

        currentfuel -= 25;
        System.out.println("Current fuel level: " + currentfuel);
        
        if (currentfuel == 0){
        notempty = false;
        }   
        return notempty; 
    }
    //main
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 150);

        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
       
        myEngine.refuel();
    }
}