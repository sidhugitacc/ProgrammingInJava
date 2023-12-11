package lab4;


import lab4.parkingsystem.Car;
import lab4.parkingsystem.ParkingLot;
import lab4.parkingsystem.Vehicle;

public class ParkingSystem {
    public static void main(String[] args) {
        
        ParkingLot parkingLot = new ParkingLot(5);

        
        Vehicle car1 = new Car("ABC123");
        Vehicle car2 = new Car("XYZ789");

        
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        
        System.out.println("Available parking spots: " + parkingLot.getAvailableSpots());

        
        parkingLot.leaveSpot(car1);
        parkingLot.leaveSpot(car2);

        
        System.out.println("Available parking spots: " + parkingLot.getAvailableSpots());
    }
}
