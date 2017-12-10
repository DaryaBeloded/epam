package by.bsu.selenium.action;

import by.bsu.selenium.page.CabinetPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CabinetPageActionTest {
    private CabinetPageAction cab;
    private final String LOGIN = "dariabeloded@gmail.com";
    private final String PASS= "1234567890";
    private final String NAME= "Beloded Darya";


    @BeforeMethod
    public void setUp() {
        cab = new CabinetPageAction();

        cab.initDriver();
    }

    @Test
    public void isSigned() throws Exception {
        MainPageAction pg = new MainPageAction();
        pg.initDriver();
        pg.signIn(LOGIN, PASS);

        Assert.assertEquals(NAME , cab.isSignedIn());
    }

    @AfterMethod
    public void stopBrowser() {
        cab.closeDriver();
    }
}
