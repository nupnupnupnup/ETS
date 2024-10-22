import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String destination;
    private double distance;
    private double costPerKm;
    private List<String> passengers;
    private int minPassengers;

    public Trip(String destination, double distance, double costPerKm, int minPassengers) {
        this.destination = destination;
        this.distance = distance;
        this.costPerKm = costPerKm;
        this.passengers = new ArrayList<>();
        this.minPassengers = minPassengers;
    }

    public double calculateTotalCost() {
        return distance * costPerKm;
    }

    public void addPassenger(String name) {
        passengers.add(name);
    }

    public void printPassengerList() {
        System.out.println("Daftar Penumpang:");
        for (String passenger : passengers) {
            System.out.println("- " + passenger);
        }
    }

    public boolean cancelTrip() {
        if (passengers.size() < minPassengers) {
            System.out.println("Trip dibatalkan.");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trip trip = new Trip("Bali", 100.0, 5000, 3);
        trip.addPassenger("Alda");
        trip.addPassenger("Aldo");

        trip.printPassengerList();

        if (!trip.cancelTrip()) {
            double totalCost = trip.calculateTotalCost();
            System.out.println("Total biaya: " + totalCost);
        }
    }
}