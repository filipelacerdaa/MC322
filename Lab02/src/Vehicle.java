public class Vehicle {
    private String plate;
    private String brand;
    private String model;

    // Constructor of the class
    public Vehicle(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    // Plate getter
    public String getPlate() {
        return this.plate;
    }

    // Plate setter
    public void setPlate(String plate) {
        this.plate = plate;
    }

    // Brand getter
    public String getBrand() {
        return this.brand;
    }

    // Brand setter
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Model getter
    public String getModel() {
        return this.model;
    }

    // Model setter
    public void setModel(String model) {
        this.model = model;
    }
}
