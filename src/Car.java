public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println(getName() + "(Car)" + ": Engine repaired.");
    }

    @Override
    public int getFixTime() {
        return 5;
    }

    public static Car build(String model) {
        return new Car(model);
    }

}
