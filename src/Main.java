import calculate.AbstractFormulaFactory;
import calculate.Calculator;
import extension.ExtensionFormulaFactory;
import strategy.StrategyFormulaFactory;

public class Main {
    public static void main(String[] args) {


        AbstractFormulaFactory extensionFormulaFactory = new ExtensionFormulaFactory();
        AbstractFormulaFactory strategyFormulaFactory = new StrategyFormulaFactory();


        Calculator calculator = new Calculator(extensionFormulaFactory);
        System.out.println(calculator.analyze(args).asValue());

    }
}
