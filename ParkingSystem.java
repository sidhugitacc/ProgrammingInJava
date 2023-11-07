    
public class ParkingSystem {
    private int carslot;          
    private int bikeslot;  

    
    public ParkingSystem() {
        carslot = 10;              
        bikeslot = 5;       
    }

    
    public ParkingSystem(int carslot, int bikeslot) {
        this.carslot = carslot;
        this.bikeslot = bikeslot;
    }

    
    public void parkCar() {
        if (carslot > 0) {
            System.out.println("Car parked successfully.");
            carslot--;
        } else {
            System.out.println("No car parking spaces available.");
        }
    }

    
    public void parkbike() {
        if (bikeslot > 0) {
            System.out.println("bike parked successfully.");
            bikeslot--;
        } else {
            System.out.println("No bike parking spaces available.");
        }
    }

   
    public void parkVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("car")) {
            parkCar();
        } else if (vehicleType.equalsIgnoreCase("bike")) {
            parkbike();
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    
    public void parkVehicle(String vehicleType, int count) {
        if (vehicleType.equalsIgnoreCase("car")) {
            parkCar(count);
        } else if (vehicleType.equalsIgnoreCase("bike")) {
            parkbike(count);
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    
    public void parkCar(int count) {
        if (carslot >= count) {
            System.out.println(count + " cars parked successfully.");
            carslot -= count;
        } else {
            System.out.println("Insufficient car parking spaces available.");
        }
    }

    
    public void parkbike(int count) {
        if (bikeslot >= count) {
            System.out.println(count + " bike parked successfully.");
            bikeslot -= count;
        } else {
            System.out.println("Insufficient bike parking spaces available.");
        }
    }

    
    public void printAvailableSpaces() {
        System.out.println("Available car parking spaces: " + carslot);
        System.out.println("Available bike parking spaces: " + bikeslot);
    }

    
    public static void main(String[] args) {
        
        ParkingSystem parkingSystem1 = new ParkingSystem();

        
        ParkingSystem parkingSystem2 = new ParkingSystem(15, 8);

        
        parkingSystem1.parkVehicle("car");
        parkingSystem1.parkVehicle("bike");
        parkingSystem1.parkVehicle("car");
        parkingSystem1.parkVehicle("bike");
        parkingSystem1.printAvailableSpaces();

        parkingSystem2.parkVehicle("car", 5);
        parkingSystem2.parkVehicle("bike", 3);
        parkingSystem2.parkVehicle("car", 10);
        parkingSystem2.printAvailableSpaces();
    }
}


