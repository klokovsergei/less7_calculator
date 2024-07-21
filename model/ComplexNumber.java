package less7_calculator.model;

public class ComplexNumber {
    private double actualPart;
    private double imaginaryPart;
    public ComplexNumber(double actualPart, double imaginaryPart){
        this.actualPart = actualPart;
        this.imaginaryPart = imaginaryPart;
    }
    public ComplexNumber(ComplexNumber number){
        this.actualPart = number.getActualPart();
        this.imaginaryPart = number.getImaginaryPart();
    }

    public double getActualPart() {
        return actualPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        String operator = " + " + imaginaryPart + "i";
        if (imaginaryPart < 0)
            operator = " - " + -imaginaryPart + "i";
        return actualPart + operator;
    }
}
