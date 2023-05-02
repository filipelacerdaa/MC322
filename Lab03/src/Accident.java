import java.util.*;
import java.util.Random;


public class Accident {
    private final int id;
    private Date date;
    private String address;

    private Insurer insurer;
    private Client client;
    private Vehicle vehicle;

    // Constructor of the class
    public Accident(Date date, String address, Insurer insurer, Client client, Vehicle vehicle) {
        int lower = 100000;
        int upper = 999999;

        Random generator = new Random();

        // Generate a random number with exactly 6 digits
        this.id = generator.nextInt(upper - lower) + lower;
        this.date = date;
        this.address = address;

        this.insurer = insurer;
        this.client = client;
        this.vehicle = vehicle;
    }

    // ID getter
    public int getID() {
        return this.id;
    }

    // Date getter
    public Date getDate() {
        return this.date;
    }

    // Date setter
    public void setDate(Date date) {
        this.date = date;
    }

    // Address getter
    public String getAddress() {
        return this.address;
    }

    // Address setter
    public void setAddress(String address) {
        this.address = address;
    }

    // Insurer getter
    public Insurer getInsurer() {
        return this.insurer;
    }

    // Insurer setter
    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    // Client getter
    public Client getClient() {
        return this.client;
    }

    // client setter
    public void setClient(Client client) {
        this.client = client;
    }

    // Vehicle getter
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    // Vehicle setter
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Represent the accident object as a string
    public String toString() {
        return String.format(
            "\nAccident in %s - %s\n├─ %s\n├─ %s\n└─ %s",
            this.address, this.date, this.insurer.toString(1),
            this.client.toString(1), this.vehicle.toString()
        );
    }
}
