package by.bsu.selenium.action;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// This code will implement TestNG listeners
@Listeners(by.bsu.selenium.action.Listener.class)

public class MainPageActionTest {
    private MainPageAction main;

//    private final String FROM = "Минск, Беларусь";
    private final String TO = "Вена Интернешнл, Австрия";
    private final String LG = "Австрия";
    private final String LOGIN = "dariabeloded@gmail.com";
    private final String PASS= "1234567890";

    @BeforeMethod
    public void setUp() {
        main = new MainPageAction();

        main.initDriver();
    }

    @Test
    public void testFindTicket() throws Exception {
        Assert.assertTrue(main.findTicket(TO));
    }

    @Test
    public void popapTest(){
        Assert.assertTrue(main.popap());
    }

    @Test
    public void swapLangTest(){
        Assert.assertEquals("Cheap tickets online", main.lang(LG));
    }

    @Test
    public void signInTest(){
        main.signIn(LOGIN, PASS);
    }

    @Test
    public void goToFirstPlaceTest(){
        Assert.assertTrue(main.first());
    }

    @AfterMethod
    public void stopBrowser() {
        main.closeDriver();
    }
}
