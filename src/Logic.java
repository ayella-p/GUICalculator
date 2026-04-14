public class Logic implements Operations{
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if(num2 == 0 || num1 == 0){
            return 0;
        }
        return num1 / num2;
    }
}
