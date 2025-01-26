import java.util.Scanner;

public class MainScreen {

    private static Garage garage;

    public static void start() {
        DB db = new DB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for Motorcycle, 2 for Car, 3 for Truck, or 0 to finish:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            System.out.println("Enter name of vehical:");
            String name = scanner.nextLine();

            switch (choice) {
                case 1 -> db.addVehicle(new Motorcycle(name));
                case 2 -> db.addVehicle(new Car(name));
                case 3 -> db.addVehicle(new Truck(name));
                default -> System.out.println("Invalid choice!");
            }
        }
        garage = new Garage(protocolGarage, db.getVehicles());
        garage.start();
    }

    private static Protocol_Garage protocolGarage = new Protocol_Garage() {
        @Override
        public void fixed(String vehicleName) {
            System.out.println("Vehicle(" +vehicleName + ") Has been fixed");
        }
    };

}
