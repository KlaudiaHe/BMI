import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static java.lang.Math.abs;

public class BMICalculator implements IndexCalculator {

    private BigDecimal mass;
    private BigDecimal height;

    private static final double[] bmiRanges = {15.0, 16.0, 18.5, 25, 30, 35, 40, 45, 50, 60};
    private static final String[] bmiInterpretations = {"very severely underweight", "severely underweight", "underweight", "normal (healthy weight)", "overweight", "obese class I (moderately obese)", "obese class II (severely obese)", "obese class III (very severely obese)", "obese class IV (morbidly obese)", "obese class V (super obese)", "obese class VI (hyper obese)"};


    public BMICalculator (BigDecimal mass, BigDecimal height) {
        if ((mass.compareTo(BigDecimal.ZERO) > 0) && ((height.compareTo(BigDecimal.ZERO) > 0))) {
            this.mass = mass;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Invalid value");
        }
    }


    @Override
    public String calculate() {
        BigDecimal index;
        BigDecimal heightByHundred= height.divide(BigDecimal.valueOf(100));
        BigDecimal squareHeight= heightByHundred.multiply(heightByHundred);
            index = (mass.divide(squareHeight, 2, RoundingMode.CEILING));
            //a.divide(b, 2, RoundingMode.HALF_UP)
        return index.toString();
    }

    @Override
    public String interpret(){
        double bmi = (Double.parseDouble(calculate()));
        int index= abs(Arrays.binarySearch(bmiRanges, bmi) + 1);
        return bmiInterpretations[index];
    }


    public static void main(String[] args) {
        BMICalculator bmiCalculator = new BMICalculator(BigDecimal.valueOf(53), BigDecimal.valueOf(165));
        System.out.println(bmiCalculator.calculate());
    }
}

/*
fajne Sebastiana
   @Override
    public void interpret(){
        interpret(Double.parseDouble(calculate()));
    }


    public String interpret(double bmi) {
       return bmiInterpretations[Math.abs(Arrays.binarySearch(bmiRanges, bmi) + 1)];
    }

 */

