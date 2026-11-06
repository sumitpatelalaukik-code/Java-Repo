abstract class Vehicle{
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void startEngine(){
       System.out.println(year + " " + brand + " " + model + "'s engine is starting...");
    }

    public abstract void displayInfo();

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

class Car extends Vehicle{
    private int numberOfDoors;
    private boolean isElectric;

    public Car(String brand, String model, int year, int numberOfDoors, boolean isElectric) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.isElectric = isElectric;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n[Car] " + getYear() + " " + getBrand() + " " + getModel() + 
                           " | Doors: " + numberOfDoors + " | Electric: " + isElectric);
    }

    public void honk() {
        System.out.println(getBrand() + " says: Beep beep!\n");
    }
}

class Bike extends Vehicle{
    private int numberOfGears;
    private String bikeType;

    public Bike(String brand, String model, int year, int numberOfGears, String bikeType) {
        super(brand, model, year);
        this.numberOfGears = numberOfGears;
        this.bikeType = bikeType;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Bike] " + getYear() + " " + getBrand() + " " + getModel() +
                           " | Gears: " + numberOfGears + " | Type: " + bikeType);
    }

    public void pedal() {
        System.out.println(getBrand() + " " + getModel() + " is being pedaled.\n");
    }
}

class Truck extends Vehicle{
    private double payloadCapacityTons;

    public Truck(String brand, String model, int year, double payloadCapacityTons) {
        super(brand, model, year);
        this.payloadCapacityTons = payloadCapacityTons;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Truck] " + getYear() + " " + getBrand() + " " + getModel() + 
                           " | Payload Capacity: " + payloadCapacityTons + " tons");
    }

    public void dumpCargo() {
        System.out.println(getBrand() + " truck is tilting its bed to dump cargo.\n");
    }
}

class VehicleManagement{
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2023, 4, false);
        Bike bike = new Bike("Giant", "Escape", 2022, 21, "Road");
        Truck truck = new Truck("Ford", "F-150", 2023, 1.5);

        car.displayInfo();
        car.startEngine();
        car.honk();

        bike.displayInfo();
        bike.startEngine();
        bike.pedal();

        truck.displayInfo();
        truck.startEngine();
        truck.dumpCargo();

        Vehicle v1 = new Car("Tesla", "Model 3", 2023, 4, true);
        Vehicle v2 = new Bike("Trek", "Marlin", 2023, 18, "Mountain");
        Vehicle v3 = new Truck("Volvo", "VNL", 2023, 20.0);

        Vehicle[] vehicles = {v1, v2, v3};
        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.startEngine();
        }
    }
}