package strategy;

import calculate.Formula;

public class Sum implements Operator {




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
