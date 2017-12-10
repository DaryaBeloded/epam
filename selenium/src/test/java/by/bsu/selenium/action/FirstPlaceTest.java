package by.bsu.selenium.action;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstPlaceTest {
    private FirstPlacePageAction main;

    @BeforeMethod
    public void setUp() {
        main = new FirstPlacePageAction();

        main.initDriver();
    }

    @Test
    public void popapTest(){
        Assert.assertTrue(main.isDisplayedVoice());
    }

    @AfterMethod
    public void stopBrowser() {
        main.closeDriver();
    }
}
