package day1;

public class BasicCalculator {

    public int add(Integer... numbers){
        int sum = 0;
        for (Integer i:numbers){
            sum += i;
        }

        return sum;
    }

    public int multiply(Integer... numbers){
        int prod = 1;
        for (Integer i:numbers){
            prod *= i;
        }

        return prod;
    }
}
