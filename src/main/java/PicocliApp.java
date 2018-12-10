import picocli.CommandLine.Option;

import java.math.BigDecimal;

public class PicocliApp {

    @Option(names = "-w",description = "type your weight")
    private BigDecimal mass;
    @Option(names = "-h", description = "type your height")
    private BigDecimal height;


    public void run() {
        BMICalculator bmiCalculator = new BMICalculator(mass, height);
       System.out.println("Your BMI is: "+bmiCalculator.calculate()+", which means that you're " + bmiCalculator.interpret());

    }
}