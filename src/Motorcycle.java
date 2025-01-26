public class Motorcycle extends Vehicle {

    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println(getName() +"(Motorcycle)" + ": Both wheels repaired");
    }

    @Override
    public int getFixTime() {
        return 3;
    }
}
