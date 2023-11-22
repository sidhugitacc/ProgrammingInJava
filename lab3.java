public class lab3 {

    public static void main(String[] args) {
        System.out.println("\nParking Details");
        HourlyParking hourlyParking = new HourlyParking("hourlyparking_01", 10.0);
        double hourlyCost = hourlyParking.calculateCost(2);
        System.out.println("\nCost for 2 hours of Hourly Parking: $" + hourlyCost);

        DailyParking dailyParking = new DailyParking("dailyParking_02", 25.0);
        double dailyCost = dailyParking.calculateCost(1);
        System.out.println("Cost for 1 day of Daily Parking: $" + dailyCost);

        dailyParking.displayTotalCost(3);
    }
}

abstract class ParkingProduct {
    protected String productId;
    protected double costPerUnit;

    public ParkingProduct(String productId, double costPerUnit) {
        this.productId = productId;
        this.costPerUnit = costPerUnit;
    }

    public abstract double calculateCost(int units);
}

class HourlyParking extends ParkingProduct {
    public HourlyParking(String productId, double costPerHour) {
        super(productId, costPerHour);
    }

    @Override
    public double calculateCost(int hours) {
        return costPerUnit * hours;
    }
}

final class DailyParking extends ParkingProduct {
    public DailyParking(String productId, double costPerDay) {
        super(productId, costPerDay);
    }

    @Override
    public double calculateCost(int days) {
        return costPerUnit * days;
    }

    public final void displayTotalCost(int days) {
        double totalCost = calculateCost(days);
        System.out.println("Total Cost for " + productId + ": $" + totalCost + "\n");
    }
}
