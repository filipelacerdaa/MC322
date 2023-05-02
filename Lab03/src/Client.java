import java.util.*;

public class Client {
    private String name;
    private String address;

    private List<Vehicle> vehicles;

    // Constructor of the class
    public Client(String name, String address) {
        this.name = name;
        this.address = address;

        this.vehicles = new ArrayList<Vehicle>();
    }

    // Name getter
    public String getName() {
        return this.name;
    }

    // Name setter
    public void setName(String name) {
        this.name = name;
    }

    // Address getter
    public String getAddress() {
        return this.address;
    }

    // Address setter
    public void setAddress(String address) {
        this.address = address;
    }

    // Vehicles getter
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    // Add a new vehicle
    public boolean addVehicle(Vehicle vehicle) {
        if (this.vehicles.contains(vehicle)) {
            return false;
        }

        this.vehicles.add(vehicle);
        return true;
    }

    // Represent the vehicle object as a string
    public String toString(int tab) {
        return String.format(
            "Client %s from the address %s", this.name, this.address
        );
    }
}
