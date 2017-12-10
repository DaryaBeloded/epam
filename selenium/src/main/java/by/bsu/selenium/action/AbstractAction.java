package by.bsu.selenium.action;

import by.bsu.selenium.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractAction {
    protected WebDriver webDriver;

    public void initDriver(){
        webDriver = DriverSingleton.getWebDriver();
    }

    public void closeDriver(){
        DriverSingleton.closeDriver();
    }
}
