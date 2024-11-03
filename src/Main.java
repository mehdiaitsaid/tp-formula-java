public class Main {
    public static void main(String[] args) {

        Variable x = new Variable("x", 2.5);
        Variable y = new Variable("y", 4);
        Variable z = new Variable("z", 7);
        Variable w = new Variable("w", 2);
        Formula formula = new Sum(x, new Product(y, new Sum(x, y, z, w)));
        System.out.println(formula.asString()); // "(x+(y*(x+y+x+y+z+w))"
        System.out.println(formula.asValue()); // "28.5"
        x.set(5);
        System.out.println(formula.asValue()); // "41.0"

    }

}
interface Formula {
    public double asValue();

    public String asString();


}

class Variable implements Formula {

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


abstract class VariadicOperator implements Formula {
    private Formula[] formula;


    public VariadicOperator(Formula... formula) {
        this.formula = formula;
    }

    abstract double initialValue();
    abstract char symbol();
    abstract double cumulativeValue(double accumulator, double value);


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

}
class Sum extends VariadicOperator {


    public Sum(Formula... formula) {
        super(formula);
    }

    char symbol(){
        return '+';
    }

    double initialValue() {
        return 0;
    }

    double cumulativeValue(double accumulator, double value) {
        return accumulator + value;
    }




}

class Product extends VariadicOperator {
    public Product(Formula... formula) {
        super(formula);
    }

    char symbol(){
        return '*';
    }

    double initialValue() {
        return 1;
    }

    double cumulativeValue(double accumulator, double value) {
        return accumulator * value;
    }


}
