public class Insurer {
    private String name;
    private String phone;
    private String email;
    private String address;

    // Constructor of the class
    public Insurer(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Name getter
    public String getName() {
        return this.name;
    }

    // Name setter
    public void setName(String name) {
        this.name = name;
    }
    
    // Phone getter
    public String getPhone() {
        return this.phone;
    }

    // Phone setter
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Email getter
    public String getEmail() {
        return this.email;
    }

    // Email setter
    public void setEmail(String email) {
        this.email = email;
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
