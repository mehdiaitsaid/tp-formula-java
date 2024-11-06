package calculate;

import calculate.Formula;

public interface AbstractFormulaFactory {

    Formula createConstant(double value);
    Formula createProduct(Formula... formulas);
    Formula createSum(Formula... formulas);


}
