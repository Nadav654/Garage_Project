import java.util.Scanner;

public class MainScreen  {

    private static Garage garage;
    private static DB garageDB;

    public static void start() {
        garageDB = new DB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for Motorcycle, 2 for Car, 3 for Truck, or 0 to finish:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            System.out.println("Enter name of vehical:");
            String name = scanner.nextLine();

            switch (choice) {
                case 1 -> build(1, name);
                case 2 -> build(2, name);
                case 3 -> build(3, name);
//                case 1 -> db.addVehicle(new Motorcycle(name));
//                case 2 -> db.addVehicle(new Car(name));
//                case 3 -> db.addVehicle(new Truck(name));
                default -> System.out.println("Invalid choice!");
            }
        }
        //garage = new Garage(protocolGarage, db.getVehicles());
        //garage.start();
        garage = new Garage(protocolGarage);
        garage.start(garageDB.getVehicleQueueMap());
    }

    private static Protocol_Garage protocolGarage = new Protocol_Garage() {
        @Override
        public void fixed(String vehicleName) {
            System.out.println("Vehicle(" +vehicleName + ") Has been fixed");
        }
    };

    public static void build(int type, String model) {
        switch (type) {
            case 1 -> garageDB.addVehicleMap(DB.Type.MOTORCYCLE, Motorcycle.build(model));
            case 2 -> garageDB.addVehicleMap(DB.Type.CAR, Car.build(model));
            case 3 -> garageDB.addVehicleMap(DB.Type.TRUCK, Truck.build(model));
        }
    }
}
