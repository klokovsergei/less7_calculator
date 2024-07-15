package less7_calculator.model;

public class ComplexNumber {
    private double actualPart;
    private double imaginaryPart;
    public ComplexNumber(double actualPart, double imaginaryPart){
        this.actualPart = actualPart;
        this.imaginaryPart = imaginaryPart;
    }
    public ComplexNumber(double[] args){
        this.actualPart = args[0];
        this.imaginaryPart = args[1];
    }

    public double[] getComplexNumber() {
        return new double[]{actualPart, imaginaryPart};
    }

    @Override
    public String toString() {
        String operator = " + i" + imaginaryPart;
        if (imaginaryPart < 0)
            operator = " - i" + -imaginaryPart;
        return actualPart + operator;
    }
}
