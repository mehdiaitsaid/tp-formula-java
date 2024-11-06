package extension;

import calculate.AbstractFormulaFactory;
import calculate.Constant;
import calculate.Formula;

public class ExtensionFormulaFactory implements AbstractFormulaFactory {

    public Formula createConstant(double value){
        return new Constant(value);
    }

    public Formula createProduct(Formula... formulas){
        return  new Product(formulas);
    }
    public Formula createSum(Formula... formulas){
        return  new Sum(formulas);
    }
}
