import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigDecimal weight = BigDecimal.valueOf(0);
        BigDecimal height = BigDecimal.valueOf(0);

        Scanner input = new Scanner(System.in);
        while (weight.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("Please input your weight in kg: ");
            try {
                weight = input.nextBigDecimal();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid");
            }
        }

        while (height.compareTo(BigDecimal.ZERO)== 0){
            System.out.println("Please input your height in cm: ");
            try {
                height = input.nextBigDecimal();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid value");
            }
        }

        try {
            BMICalculator bmiCalculator = new BMICalculator(weight, height);
            System.out.println("Your BMI is: "+bmiCalculator.calculate()+", which means that you're " + bmiCalculator.interpret()+".");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
         //   System.exit(-1);
        }
    }
}