package extension;

import calculate.Formula;

public class Sum extends VariadicOperator{

    public Sum(Formula... formulas) {
        super(formulas);
    }


    public char symbol(){
        return '+';
    }

    public double initialValue() {
        return 0;
    }

    public double cumulativeValue(double accumulator, double value) {
        return accumulator + value;
    }

}
