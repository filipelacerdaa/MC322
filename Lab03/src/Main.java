import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private static List<Accident> accidents = new ArrayList<Accident>();

    private static List<ClientLP> clientsLP = new ArrayList<ClientLP>();
    private static List<ClientNP> clientsNP = new ArrayList<ClientNP>();

    private static List<Insurer> insurers = new ArrayList<Insurer>();
    private static List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {
        String command;

        // Create Insurer object
        Insurer insurer = new Insurer(
            "Seguradora LTDA", "+5519999999999", "seguradora@dominio.com", "Lev Landau 487"
        );

        insurers.add(insurer);

        // Create ClientNP object
        ClientNP clientNP = new ClientNP(
            "Filipe", "Tórtima 777", "047.426.981-77",
            "male", "undergraduate", "B",
            convertDate("15/12/2001"), convertDate("18/02/2019")
        );

        clientsNP.add(clientNP);

        // Create ClientLP object
        ClientLP clientLP = new ClientLP(
            "Unicamp", "Lev Landau 381", "67.157.081/0001-09", convertDate("18/02/2019")
        );

        clientsLP.add(clientLP);

        // Create first Vehicle object
        Vehicle vehicleA = new Vehicle(
            "REK0F72", "Renault", "Kwid", 2021
        );

        vehicles.add(vehicleA);

        // Create second Vehicle object
        Vehicle vehicleB = new Vehicle(
            "REK0F73", "Renault", "Kwid", 2022
        );

        vehicles.add(vehicleB);

        // Create first Accident object
        Accident accidentA = new Accident(
            convertDate("30/04/2021"), "Albert Einstein 440", insurer, clientNP, vehicleA
        );

        accidents.add(accidentA);

        // Create second Accident object
        Accident accidentB = new Accident(
            convertDate("15/06/2021"), "Albert Einstein 600", insurer, clientLP, vehicleB
        );

        accidents.add(accidentB);

        // Validate CPF of each ClientNP
        for (ClientNP client: clientsNP) {
            if (client.validateCPF()) {
                System.out.println(
                    String.format("CPF %s is valid", client.getCPF())
                );

            } else {
                System.out.println(
                    String.format("CPF %s is invalid", client.getCPF())
                );
            }            
        }

        // Validate CNPJ of each ClientLP
        for (ClientLP client: clientsLP) {
            if (client.validateCNPJ()) {
                System.out.println(
                    String.format("CNPJ %s is valid", client.getCNPJ())
                );

            } else {
                System.out.println(
                    String.format("CNPJ %s is invalid", client.getCNPJ())
                );
            }            
        }

        // Add clients and accidents to insurer
        insurer.addClient(clientNP);
        insurer.addClient(clientLP);

        for (Accident accident: accidents) {
            insurer.addAccident(accident);
        }

        while (true) {
            showMenu();
            command = readString();

            if (command.charAt(0) == '0') {
                // 0. Exit
                break;

            } else if (command.charAt(0) == '1') {
                // 1. List clients
                System.out.print("Enter 'NP' or 'LP' to choose the client type: ");
                command = readString();

                if (command.equals("LP") || command.equals("NP")) {
                    insurer.listClients(command);
                } else {
                    System.out.println("\nInvalid input!");
                }

            } else if (command.charAt(0) == '2') {
                // 2. List accidents
                insurer.listAccidents();

            } else if (command.charAt(0) == '3') {
                // 3. View accident
                System.out.print("Enter the client name to find the accident: ");
                command = readString();

                if (!insurer.viewAccident(command)) {
                    System.out.println("\nNo accidents registered to this client name!");
                }

            } else if (command.charAt(0) == '4') {
                // 4. Remove client
                System.out.print("Enter the client name: ");
                command = readString();

                if (!insurer.removeClient(command)) {
                    System.out.println("\nNo registered client with this name!");
                } else {
                    System.out.println("\nRemoved client!");
                }

            } else {
                // Invalid input
                System.out.println("\nInvalid input!");
            }
        }

        System.out.println("\nSee you later!");

        scanner.close();
    }

    // Show the main menu
    public static void showMenu() {
        System.out.println("\n--- System Menu ---\n");
        System.out.println("1. List clients");
        System.out.println("2. List accidents");
        System.out.println("3. View accident");
        System.out.println("4. Remove client\n");
        System.out.print("Enter the operation or 0 to exit: ");
    }

    // Read a input from keyboard
    public static String readString() {
        String string = scanner.nextLine();

        return string;
    }

    // Convert a date as a string to a Date object
    public static Date convertDate(String dateString) {
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
