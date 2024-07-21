package less7_calculator;

import less7_calculator.model.ComplexNumber;
import less7_calculator.view.CalculateView;

public class Calculator {
    public static void main(String[] args) {
        ComplexNumber number = new ComplexNumber(-1.0, -8D);
        System.out.println(number);

        new CalculateView().start();
    }
}
