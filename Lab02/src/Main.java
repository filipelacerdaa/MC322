public class Main {
    public static void main(String[] args) {
        Accident accident = new Accident(
            "15/12/2001", "Unicamp"
        );

        System.out.println(accident.getID());

        Client client = new Client(
            "Filipe Client", "047.426.981-77", "15/12/2001", "Unicamp", 21
        );

        System.out.println(client.validateSecurityNum());

        Insurer insurer = new Insurer(
            "Filipe Insurer", "19999281609", "lacerdaa.filipe@gmail.com", "Unicamp"
        );

        System.out.println(insurer.getAddress());

        Vehicle vehicle = new Vehicle(
            "AAA0A00", "Renault", "Kwid"
        );

        System.out.println(vehicle.getPlate());
        vehicle.setPlate("BBB0B00");
        System.out.println(vehicle.getPlate());
    }
}
