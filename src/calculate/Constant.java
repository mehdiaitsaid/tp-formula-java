package calculate;

public class Constant implements Formula{

    private double value;
    @Override
    public double asValue() {
        return this.value;
    }

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return null;
    }
}
