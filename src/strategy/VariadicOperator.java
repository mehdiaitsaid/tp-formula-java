package strategy;

import calculate.Formula;

public class VariadicOperator implements Formula {
    private Formula[] formula;

    Operator operator;

    public VariadicOperator(Operator operator,  Formula... formula) {
        System.out.println("this is strategy");
        this.operator = operator;
        this.formula = formula;
    }

    public double asValue() {

        double sum = this.operator.initialValue();
        for (Formula f : formula) {
            sum = this.operator.cumulativeValue(sum, f.asValue());
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
                s.append(this.operator.symbol());
                s.append(" ");
            }

            s.append(f.asString());
        }
        s.append(" )");
        return s.toString();

//        return  "( "+ var1.asString() + " + "+ var2.asString() + " )"  ;
    }




}