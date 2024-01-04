import java.util.Scanner;

interface Vehicle {
    String getLicensePlate();
}

class Car implements Vehicle {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}

class Motorcycle implements Vehicle {
    private String licensePlate;

    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingLot<T extends Vehicle> {
    private T[] parkingSpaces;

    public ParkingLot(int capacity) {
        this.parkingSpaces = (T[]) new Vehicle[capacity];
    }

    public void parkVehicle(T vehicle, int parkingSpot) {
        if (parkingSpot >= 0 && parkingSpot < parkingSpaces.length) {
            if (parkingSpaces[parkingSpot] == null) {
                parkingSpaces[parkingSpot] = vehicle;
                System.out.println(vehicle.getClass().getSimpleName() + " with license plate " +
                        vehicle.getLicensePlate() + " parked at spot " + parkingSpot);
            } else {
                System.out.println("Parking spot " + parkingSpot + " is already occupied.");
            }
        } else {
            System.out.println("Invalid parking spot.");
        }
    }

    public void printParkingLotStatus() {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i] == null) {
                System.out.println("Spot " + i + ": Empty");
            } else {
                System.out.println("Spot " + i + ": " + parkingSpaces[i].getClass().getSimpleName() +
                        " with license plate " + parkingSpaces[i].getLicensePlate());
            }
        }
    }
}

public class lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParkingLot<Car> carParkingLot = new ParkingLot<>(5);

        ParkingLot<Motorcycle> motorcycleParkingLot = new ParkingLot<>(3);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Park a car");
            System.out.println("2. Park a motorcycle");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter car license plate: ");
                    String carLicensePlate = scanner.next();
                    System.out.print("Enter parking spot: ");
                    int carParkingSpot = scanner.nextInt();
                    carParkingLot.parkVehicle(new Car(carLicensePlate), carParkingSpot);
                    break;
                case 2:
                    System.out.print("Enter motorcycle license plate: ");
                    String motorcycleLicensePlate = scanner.next();
                    System.out.print("Enter parking spot: ");
                    int motorcycleParkingSpot = scanner.nextInt();
                    motorcycleParkingLot.parkVehicle(new Motorcycle(motorcycleLicensePlate), motorcycleParkingSpot);
                    break;
                case 3:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\nCar Parking Lot:");
            carParkingLot.printParkingLotStatus();
            System.out.println("\nMotorcycle Parking Lot:");
            motorcycleParkingLot.printParkingLotStatus();
        }
    }
}