package lab4.parkingsystem;
    
public class ParkingLot {
    private int capacity;
    private int occupiedSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSpots = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (occupiedSpots < capacity) {
            vehicle.park();
            occupiedSpots++;
        } else {
            System.out.println("Parking lot is full. Cannot park the vehicle.");
        }
    }

    public void leaveSpot(Vehicle vehicle) {
        vehicle.leave();
        occupiedSpots--;
    }

    public int getAvailableSpots() {
        return capacity - occupiedSpots;
    }
}

