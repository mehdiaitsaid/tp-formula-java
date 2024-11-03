import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.analyze(args).asValue());

    }
     public Formula analyze(String[] tokens){
         Stack<Formula> stack = new Stack<>();


         for (String token : tokens){
             this.analyzeToken(token, stack);
         }
         return stack.pop();

     }
     public void analyzeToken(String token , Stack<Formula> stack){


         if (token.equals("+")){
             this.analyzeSum(stack);

         } else if (token.equals("*")){
             this.analyzeProduct(stack);

         }else {
             this.analyzeinit(token, stack);
         }

     }

    public void analyzeSum(Stack<Formula> stack){
        Formula constant1 = stack.pop();
        Formula constant2 = stack.pop();
        stack.push(new Constant(constant1.asValue() + constant2.asValue()));

    }
    public void analyzeProduct(Stack<Formula> stack){
        Formula constant1 = stack.pop();
        Formula constant2 = stack.pop();
        stack.push(new Constant(constant1.asValue() * constant2.asValue()));

    }
    public void analyzeinit(String token ,Stack<Formula> stack){
        try {
            stack.push(new Constant(Double.parseDouble(token)));
        } catch (NumberFormatException e) {
            System.out.println("Invalid Doubl input");
        }

    }


}
interface Formula {
    public double asValue();

    public String asString();


}


class Constant implements Formula{

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


class VariadicOperator implements Formula {
    private Formula[] formula;

    Operator operator;
    public VariadicOperator(Operator operator, Formula... formula) {
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


interface Operator {
     double initialValue();
     char symbol();
     double cumulativeValue(double accumulator, double value);
}
class Sum implements Operator {


//    public Sum(Formula... formula) {
//        super(formula);
//    }

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

class Product implements Operator  {
//    public Product(Formula... formula) {
//        super(formula);
//    }

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
