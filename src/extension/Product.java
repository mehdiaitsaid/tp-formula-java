package extension;

import calculate.Formula;

public class Product extends VariadicOperator{


    public Product(Formula... formulas) {
        super(formulas);
    }

    public char symbol(){
        return '*';
    }

    public double initialValue() {
        return 1;
    }

    public double cumulativeValue(double accumulator, double value) {
        return accumulator * value;
    }

}
