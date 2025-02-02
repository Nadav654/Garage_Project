import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class DB {

    private ArrayList<Vehicle> vehicles;
    public enum Type {
        MOTORCYCLE,
        CAR,
        TRUCK
    };
    private HashMap<Type, PriorityQueue<Vehicle>> vehicleQueueMap;

    public DB() {
        //vehicles = new ArrayList<>();
        vehicleQueueMap = new HashMap<>();
        vehicleQueueMap.put(Type.MOTORCYCLE, new PriorityQueue<>());
        vehicleQueueMap.put(Type.CAR, new PriorityQueue<>());
        vehicleQueueMap.put(Type.TRUCK, new PriorityQueue<>());
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public HashMap<Type, PriorityQueue<Vehicle>> getVehicleQueueMap() {
        return vehicleQueueMap;
    }

    public void addVehicleMap(Type type, Vehicle vehicle) {
        vehicleQueueMap.get(type).add(vehicle);
    }
}
