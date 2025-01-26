import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class Garage {

    private int time = 0;
    private ArrayList<Vehicle> vehicles;
    private Protocol_Garage protocolGarage;

    public Garage(Protocol_Garage protocolGarage, ArrayList<Vehicle> vehicles) {
        this.protocolGarage = protocolGarage;
        this.vehicles = vehicles;
    }

    public void start() {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (vehicles.size() == 0) {
                    System.out.println("All vehicals have been repaired. Garage is empty.");
                    exit(1);
                }
                tick();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    public void tick() {
        time++;
        if (time == vehicles.get(0).getFixTime()) {
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            Vehicle vehicle = vehicles.get(0);
            vehicle.fixed();
            protocolGarage.fixed(vehicle.getName());
            System.out.println(timeStamp);
            vehicles.remove(0);
            time = 0;
        }
    }
}
