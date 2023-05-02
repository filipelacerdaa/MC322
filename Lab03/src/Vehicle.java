public class Vehicle {
    private String plate;
    private String brand;
    private String model;

    private int manufactureYear;

    // Constructor of the class
    public Vehicle(String plate, String brand, String model, int manufactureYear) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;

        this.manufactureYear = manufactureYear;
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

    // Manufacture year getter
    public int getManufactureYear() {
        return this.manufactureYear;
    }

    // Manufacture year setter
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    // Represent the vehicle object as a string
    public String toString() {
        return String.format(
            "Vehicle %s %s (%d) with plate %s",
            this.brand, this.model, this.manufactureYear, this.plate
        );
    }
}
