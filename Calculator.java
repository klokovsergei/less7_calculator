package less7_calculator;

import less7_calculator.model.ComplexNumber;
import less7_calculator.service.Calculable;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final static Map<String, Calculable> operations = new HashMap<>();
    public static void main(String[] args) {
        ComplexNumber number = new ComplexNumber(-1.0, -8D);
        System.out.println(number);
    }
}
