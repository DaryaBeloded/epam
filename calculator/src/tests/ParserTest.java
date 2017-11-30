package tests;
import com.company.parse.Parser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dasha on 22.10.2017.
 */
public class ParserTest {
    @Test
    public void parseRegexTest(){
        Parser parser = new Parser();
        String[] actual = parser.parse("-5.95");
        String[] expected = null;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void parseRegexTest2(){
        Parser parser = new Parser();
        String[] actual = parser.parse("5.95*-598");
        String[] expected = null;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void parseRegexTest3(){
        Parser parser = new Parser();
        Double actual = Double.parseDouble(parser.parse("5.95+15.8")[0]);
        double expected = 5.95;
        Assert.assertEquals(actual.doubleValue(), expected, 0.1);
    }
    @Test
    public void parseRegexTest4(){
        Parser parser = new Parser();
        Double actual = Double.parseDouble(parser.parse("5.95+15.8")[1]);
        double expected = 15.8;
        Assert.assertEquals(actual.doubleValue(), expected, 0.1);
    }
    @Test
    public void getSignTest(){
        Parser parser = new Parser();
        String actual = parser.getSignFromString("5.95+15.8");
       String expected = "+";
        Assert.assertEquals(actual, expected);
    }
}
