public class Truck extends Vehicle {

    public Truck(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println(getName() + "(Truck)" + ": Heavy duty repair completed.");
    }

    @Override
    public int getFixTime() {
        return 10;
    }

    public static Truck build(String model) {
        return new Truck(model);
    }
}
