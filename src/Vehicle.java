public abstract class Vehicle implements Fixable, Comparable<Vehicle>{
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getFixTime();

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.getFixTime(), other.getFixTime());
    }
}
