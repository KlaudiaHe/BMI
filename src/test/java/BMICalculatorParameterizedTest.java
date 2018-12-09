import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BMICalculatorParameterizedTest {

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1, 170",
            "  1,  -1",
            "  0, 120",
            " 50,  -1"})
    public void IllegalArgumentsTest(BigDecimal weight, BigDecimal height){
        new BMICalculator(weight, height);
    }

    @Test
    @Parameters({" 60, 170",
            "  45,  150",
            "  67, 185",
            " 100,  200"})
    public void validArgumentsTest(BigDecimal weight, BigDecimal height){
        new BMICalculator(weight, height);   //tu poprzez konstruktor daje argumenty, i calculate sobie już zassie;

    }

    @Test
    @Parameters({"40, 120, 27.78",
            "50, 120, 34.73", "53, 165, 19.47"})
    public void calculateTest(BigDecimal weight, BigDecimal height, String expectedIndex){
        BMICalculator bmiCalculator = new BMICalculator(weight, height);
        assertEquals(expectedIndex, bmiCalculator.calculate());
    }



    @Test
    @Parameters({"10, very severely underweight",
            "15.5, severely underweight",
            "17, underweight"})
    public void interpretTest(double bmi, String label){
        BMICalculator bmiCalculator = new BMICalculator();
        assertEquals(label, bmiCalculator.interpret(bmi));
    }
}