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
    @Parameters({"30,  180, very severely underweight",
            "24,  125, severely underweight",
            "30,  130, underweight",
            "27,  120, normal (healthy weight)",
            "40,  120, overweight",
            "50,  120, obese class I (moderately obese)",
            "55,  120, obese class II (severely obese)",
            "60,  120, obese class III (very severely obese)",
            "70,  120, obese class IV (morbidly obese)",
            "80,  120 , obese class V (super obese)",
            "120, 120, obese class VI (hyper obese)"})
    public void interpretTest(BigDecimal weight, BigDecimal height, String label){
        BMICalculator bmiCalculator = new BMICalculator(weight, height);
        assertEquals(label, bmiCalculator.interpret());
    }
} //hehe a chcialas tego uniknąć;
