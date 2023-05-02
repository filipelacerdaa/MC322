import java.util.*;
import java.util.Iterator;

public class Insurer {
    private String name;
    private String phone;
    private String email;
    private String address;

    private List<Client> clients;
    private List<Accident> accidents;

    // Constructor of the class
    public Insurer(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;

        this.clients = new ArrayList<Client>();
        this.accidents = new ArrayList<Accident>();
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

    // Add a new client
    public boolean addClient(Client client) {
        if (this.clients.contains(client)) {
            return false;
        }

        this.clients.add(client);
        return true;
    }

    // Remove client by name
    public boolean removeClient(String clientName) {
        Client client;

        Iterator<Client> iterator = this.clients.iterator();

        while (iterator.hasNext()) {
            client = (Client) iterator.next();

            if (client.getName().equals(clientName)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    // List all the clients from a passed type
    public void listClients(String type) {
        boolean empty = true;

        for (Client client: this.clients) {
            if ((type.equals("NP") && client instanceof ClientNP) ||
                (type.equals("LP") && client instanceof ClientLP)) {
                System.out.println(String.format("\n%s", client.toString(0)));
                empty = false;
            }
        }

        if (empty) {
            System.out.println("\nNo clients of this type!");
        }
    }

    // Add a new accident
    public boolean addAccident(Accident accident) {
        if (this.accidents.contains(accident)) {
            return false;
        }

        this.accidents.add(accident);
        return true;
    }

    // View accident by client name
    public boolean viewAccident(String clientName) {
        Accident accident;

        Iterator<Accident> iterator = this.accidents.iterator();

        while (iterator.hasNext()) {
            accident = (Accident) iterator.next();

            if (accident.getClient().getName().equals(clientName)) {
                System.out.println(accident.toString());
                return true;
            }
        }

        return false;
    }

    // List all accidents
    public void listAccidents() {
        if (this.accidents.size() == 0) {
            System.out.println("\nNo accidents registered!");
        }

        for (Accident accident: this.accidents) {
            System.out.println(accident.toString());
        }
    }

    // Represent the insurer object as a string
    public String toString(int tab) {
        String space = "│  ".repeat(tab);

        return String.format(
            "Insurer\n%s├─ Name: %s\n%s├─ Phone: %s\n%s├─ Email: %s\n%s└─ Address: %s",
            space, this.name, space, this.phone, space, this.email, space, this.address
        );
    }
}
