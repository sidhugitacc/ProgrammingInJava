class Domain implements Runnable {
    private String domainName;
    private boolean isParked;

    public Domain(String domainName) {
        this.domainName = domainName;
        this.isParked = false;
    }

    public String getDomainName() {
        return domainName;
    }

    public boolean isParked() {
        return isParked;
    }

    public void parkDomain() {
        System.out.println("Domain " + domainName + " has been parked.");
        isParked = true;
    }

    @Override
    public void run() {
        parkDomain();
    }
}

public class lab5 {
    public static void main(String[] args) {

        Domain domain1 = new Domain("vehicle1");
        Domain domain2 = new Domain("vehicle2");

        Thread thread1 = new Thread(domain1);
        Thread thread2 = new Thread(domain2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nDomain Parking Status:");
        System.out.println(domain1.getDomainName() + ": " + (domain1.isParked() ? "Parked" : "Not Parked"));
        System.out.println(domain2.getDomainName() + ": " + (domain2.isParked() ? "Parked" : "Not Parked"));
    }
}

