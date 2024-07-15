package less7_calculator.service;

import less7_calculator.model.ComplexNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorService {
    private final static Map<String, Calculable> operations = new HashMap<>();
    static {
        operations.put("+", args -> {
            double[] x = args[0].getComplexNumber();
            double[] y = args[1].getComplexNumber();
            return new ComplexNumber(x[0] + y[0], x[1] + y[1]);
        });
        operations.put("-", args -> new ComplexNumber(0D,0D));
        operations.put("/", args -> new ComplexNumber(0D,0D));
    }

    private static double calculate() {
        double operand1 = Double.parseDouble(prompt("Enter first number: "));
        String operator = prompt("Enter math operation (+ - /): ");
        double operand2 = Double.parseDouble(prompt("Enter second number: "));


        if (operations.containsKey(operator))
            return operations.get(operator).calculate(operand1, operand2);
        else
            throw new RuntimeException("Операция не реализована или не поддерживается");
    }
    private static String prompt(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
interface Calculable{
    ComplexNumber calculate(ComplexNumber ...args);
}
