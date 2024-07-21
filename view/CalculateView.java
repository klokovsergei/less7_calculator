package less7_calculator.view;

import less7_calculator.model.ComplexNumber;
import less7_calculator.service.CalculatorService;
import less7_calculator.service.ComplexNumberService;

import java.util.Scanner;

public class CalculateView {
    ComplexNumberService service = new ComplexNumberService();
    String WELCOME = "Добро пожаловать в калькулятор комплексных чисел.\n";
    String FIRSTLINE = "На данный момент калькулятор поддерживает следующие операции:\n" + CalculatorService.getOperation() +
            "\nДля выхода наберите 'q'.\n";
    public void start(){
        System.out.println(WELCOME);
        String txt = "";
        Scanner scanner = new Scanner(System.in);
        while (!txt.equals("q")){
            System.out.println(FIRSTLINE);
            System.out.print("Выберите операцию над комплексными числами: ");
            txt = scanner.nextLine().toLowerCase();
            System.out.println("Введите первое комплексное число:");
            ComplexNumber number1 = getNumber();
            System.out.println("Введите второе комплексное число:");
            ComplexNumber number2 = getNumber();
            try {
                System.out.println("\n\nРЕЗУЛЬТАТ:\t" + CalculatorService.calculate(txt, number1, number2) + "\n\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Спасибо, что выбрали наше решение для выших вычислений!");
    }

    private ComplexNumber getNumber(){
        Scanner scanner = new Scanner(System.in);
        String txt = "";
        Double a = null;
        Double b = null;
        while (a == null) {
            System.out.print("\t1.Введите действительную часть числа (разделитель '.', например, 0.0): ");
            txt = scanner.nextLine();
            try {
                a = Double.parseDouble(txt);
            } catch (Exception e) { }
        }

        while (b == null) {
            System.out.print("\t2.Введите мнимую часть числа (разделитель '.', например, 0.0): ");
            txt = scanner.nextLine();
            try {
                b = Double.parseDouble(txt);
            } catch (Exception e) { }
        }

        return service.createComplexNumber(a, b);
    }
}
