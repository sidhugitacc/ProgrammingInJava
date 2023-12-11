package lab4.parkingsystem;

public class Car implements Vehicle {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public void park() {
        System.out.println("Car with license plate " + licensePlate + " has been parked.");
    }

    @Override
    public void leave() {
        System.out.println("Car with license plate " + licensePlate + " has left the parking lot.");
    }
}
