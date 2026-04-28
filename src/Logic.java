public class Logic implements Operations{

    private double result = 0.00;

    @Override
    public void add(double num1, double num2) {
        result = num1 + num2;
    }
    @Override
    public void subtract(double num1, double num2) {
        result =  num1 - num2;
    }

    @Override
    public void multiply(double num1, double num2) {
        result = num1 * num2;
    }
    @Override
    public void divide(double num1, double num2) {
        if(num2 == 0 || num1 == 0){
            result= 0;
        }
        result = num1 / num2;
    }

    @Override
    public double getResult(){
        return result;
    }
}
