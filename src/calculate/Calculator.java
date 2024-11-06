package calculate;

import strategy.Operator;

import java.util.Stack;

public class Calculator {

    AbstractFormulaFactory  abstractFormulaFactory;

    public Calculator(AbstractFormulaFactory abstractFormulaFactory) {
        this.abstractFormulaFactory = abstractFormulaFactory;
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
             this.analyzeSum( stack);

         } else if (token.equals("*")){
             this.analyzeProduct(stack);

         }else {
             this.analyzeinit(token, stack);
         }

     }

    public void analyzeSum(Stack<Formula> stack){
        Formula constant1 = stack.pop();
        Formula constant2 = stack.pop();
        stack.push(this.abstractFormulaFactory.createConstant(this.abstractFormulaFactory.createSum(constant1, constant2 ).asValue()));
    }

    public void analyzeProduct(Stack<Formula> stack){
        Formula constant1 = stack.pop();
        Formula constant2 = stack.pop();
        stack.push(this.abstractFormulaFactory.createConstant(this.abstractFormulaFactory.createProduct(constant1, constant2 ).asValue()));
    }

    public void analyzeinit(String token ,Stack<Formula> stack){
        try {
            stack.push(this.abstractFormulaFactory.createConstant(Double.parseDouble(token)));
        } catch (NumberFormatException e) {
            System.out.println("Invalid Doubl input");
        }

    }


}














