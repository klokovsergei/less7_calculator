package less7_calculator.service;

import less7_calculator.model.ComplexNumber;

public class ComplexNumberService {
    public ComplexNumber createComplexNumber(double a, double b){
        return new ComplexNumber(a, b);
    }
    public static double[] getComplexNumber(ComplexNumber number) {
        return new double[]{number.getActualPart(), number.getImaginaryPart()};
    }
}
