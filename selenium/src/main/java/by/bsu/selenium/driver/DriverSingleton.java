package by.bsu.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver webDriver;

    private DriverSingleton(){}

    public static WebDriver getWebDriver(){
        if (webDriver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            /*logger.info("Initialized WebDriver. Started Google Chrome Browser.");*/
        }

        return webDriver;
    }

    public static void closeDriver(){
        webDriver.quit();
        webDriver = null;
    }
}
