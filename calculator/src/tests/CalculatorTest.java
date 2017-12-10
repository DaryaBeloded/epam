package tests;
import com.company.entity.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dasha on 22.10.2017.
 */
public class CalculatorTest {
    @Test
    public void calculateTest(){
        Calculator calc = new Calculator("5.95");
        Double actual = calc.calculate();
        Double expected = null;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void calculateTest2(){
        Calculator calc = new Calculator("5.95_59.6");
        Double actual = calc.calculate();
        Double expected = null;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void calculateSumTest(){
        Calculator calc = new Calculator("5.95+3.57");
        Double actual = calc.calculate();
        Double expected = 9.52;
        Assert.assertEquals(expected.doubleValue(), actual.doubleValue(),0.1);
    }
    @Test
    public void calculateDiffTest(){
        Calculator calc = new Calculator("5.95-3.57");
        Double actual = calc.calculate();
        Double expected = 2.38;
        Assert.assertEquals(expected.doubleValue(), actual.doubleValue(),0.01);
    }
    @Test
    public void calculateMultTest(){
        Calculator calc = new Calculator("5.95*3.57");
        Double actual = calc.calculate();
        Double expected = 9.52;
        Assert.assertEquals(expected.doubleValue(), actual.doubleValue(),0.1);
    }
    @Test
    public void calculateDivTest(){
        Calculator calc = new Calculator("5.95/3.57");
        Double actual = calc.calculate();
        Double expected = 1.67;
        Assert.assertEquals(expected.doubleValue(), actual.doubleValue(),0.01);
    }
    @Test
    public void calculateDivTest2(){
        Calculator calc = new Calculator("5.95/0");
        Double actual = calc.calculate();
        Double expected = null;
        Assert.assertEquals(expected, actual);
    }

}
