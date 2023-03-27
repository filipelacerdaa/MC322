import java.util.Random;


public class Accident {
    private int id;
    private String date;
    private String address;

    // Constructor of the class
    public Accident(String date, String address) {
        int lower = 100000;
        int upper = 999999;

        Random generator = new Random();

        // Generate a random number with exactly 6 digits
        this.id = generator.nextInt(upper - lower) + lower;
        this.date = date;
        this.address = address;
    }

    // ID getter
    public int getID() {
        return this.id;
    }

    // Date getter
    public String getDate() {
        return this.date;
    }

    // Date setter
    public void setDate(String date) {
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
}
