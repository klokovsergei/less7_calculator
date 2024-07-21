package less7_calculator.service;

import less7_calculator.model.ComplexNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static less7_calculator.service.ComplexNumberService.getComplexNumber;

public class CalculatorService {
    private final static Map<String, Calculable> operations = new HashMap<>();
    static {
        operations.put("+", args -> {
            double[] x = getComplexNumber(args[0]);
            double[] y = getComplexNumber(args[1]);
            return new ComplexNumber(x[0] + y[0], x[1] + y[1]);
        });
        operations.put("-", args -> {
            double[] x = getComplexNumber(args[0]);
            double[] y = getComplexNumber(args[1]);
            return new ComplexNumber(x[0] - y[0], x[1] - y[1]);
        });
        operations.put("/", args -> divide(args[0], args[1]));
    }

    public static ComplexNumber calculate(String operator, ComplexNumber... number) {

        if (operations.containsKey(operator))
            return operations.get(operator).calculate(number[0], number[1]);
        else
            throw new RuntimeException("Операция не реализована или не поддерживается");
//        return new ComplexNumber(0D,0D);
    }

    public static Set<String> getOperation(){
        return operations.keySet();
    }

    public static ComplexNumber divide(ComplexNumber... args){
        double[] x = getComplexNumber(args[0]);
        double[] y = getComplexNumber(args[1]);
        double actualPart = (x[0]*y[0] + x[1]*y[1]) / (Math.pow(y[0], 2) + Math.pow(y[1], 2));
        double imaginaryPart = (x[1]*y[0] - x[0]*y[1]) / (Math.pow(y[0], 2) + Math.pow(y[1], 2));
        return new ComplexNumber(actualPart, imaginaryPart);
    }
}
interface Calculable{
    ComplexNumber calculate(ComplexNumber ...args);
}
