package by.bsu.selenium.page;

import by.bsu.selenium.constant.ElementCss;
import by.bsu.selenium.constant.ElementXPath;
import by.bsu.selenium.constant.LogMessage;
import by.bsu.selenium.constant.PageURL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CabinetPage extends AbstractPage{
    private final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(css= ElementCss.USER_NAME)
    private WebElement usernameElement;

    public CabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void open() {
        webDriver.navigate().to(PageURL.CABINET_PAGE);
        LOGGER.info(LogMessage.CAB_OPENED);
    }

    public void signin() {
        WebElement in = webDriver.findElement(By.xpath(ElementXPath.MY_TICK1));
        in.click();
    }

    public String getUsername() {
        return usernameElement.getText();
    }

}
