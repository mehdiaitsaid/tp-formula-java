package strategy;

public interface Operator {
    double initialValue();
    char symbol();
    double cumulativeValue(double accumulator, double value);
}
