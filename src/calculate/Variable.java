package calculate;

public class Variable implements Formula {

    private double value;
    private String name;
    public Variable(String name, double value) {
        this.value = value;
        this.name = name;
    }
    public void set(double value) {
        this.value = value;
    }

    public double get() {
        return this.value;
    }

    @Override
    public double asValue() {
        return this.value;
    }

    @Override
    public String asString() {
        return this.name;
    }
}