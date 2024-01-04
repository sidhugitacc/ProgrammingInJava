import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Vehicle {
    String licensePlate;

    Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

class ParkingSpot {
    boolean isOccupied;
    Vehicle vehicle;

    ParkingSpot() {
        this.isOccupied = false;
    }

    void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}

class ParkingLot {
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    ParkingLot(int capacity) {
        for (int i = 0; i < capacity; i++) {
            parkingSpots.add(new ParkingSpot());
        }
    }

    void parkVehicleInFirstAvailableSpot(Vehicle vehicle) {
        parkingSpots.stream()
                .filter(spot -> !spot.isOccupied)
                .findFirst()
                .ifPresent(spot -> spot.parkVehicle(vehicle));
    }

    void removeVehicle(String licensePlate) {
        parkingSpots.stream()
                .filter(spot -> spot.isOccupied && spot.vehicle.licensePlate.equals(licensePlate))
                .findFirst()
                .ifPresent(spot -> spot.removeVehicle());
    }

    List<ParkingSpot> getAvailableSpots() {
        return parkingSpots.stream()
                .filter(spot -> !spot.isOccupied)
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        Vehicle car1 = new Vehicle("KL25FD4564");
        Vehicle car2 = new Vehicle("KA54GD6766");

        parkingLot.parkVehicleInFirstAvailableSpot(car1);
        parkingLot.parkVehicleInFirstAvailableSpot(car2);

        System.out.println("Available spots: " + parkingLot.getAvailableSpots().size());

        parkingLot.removeVehicle("TN54G5655");

        System.out.println("Available spots after removing a vehicle: " + parkingLot.getAvailableSpots().size());
    }
}
