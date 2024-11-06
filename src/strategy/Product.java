package strategy;

import calculate.Formula;

public class Product implements Operator  {


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
