package extension;

import calculate.Formula;

public abstract class VariadicOperator implements Formula {
    private Formula[] formula;



    public VariadicOperator( Formula... formula) {
        System.out.println("this is extension");
        this.formula = formula;
    }




    public double asValue() {

        double sum = this.initialValue();
        for (Formula f : formula) {
            sum = this.cumulativeValue(sum, f.asValue());
        }
        return sum;
    }
    public String asString() {
        StringBuilder s = new StringBuilder("(");
        boolean isFirst = true;

        for (Formula f : formula) {

            if (isFirst){
                s.append(" ");
                isFirst = false;
            }
            else {
                s.append(" ");
                s.append(this.symbol());
                s.append(" ");
            }

            s.append(f.asString());
        }
        s.append(" )");
        return s.toString();

//        return  "( "+ var1.asString() + " + "+ var2.asString() + " )"  ;
    }

    abstract double initialValue();
    abstract char symbol();
    abstract double cumulativeValue(double accumulator, double value);


}