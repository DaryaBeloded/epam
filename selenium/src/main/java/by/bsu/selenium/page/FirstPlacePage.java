package by.bsu.selenium.page;

import by.bsu.selenium.constant.ElementCss;
import by.bsu.selenium.constant.ElementId;
import by.bsu.selenium.constant.LogMessage;
import by.bsu.selenium.constant.PageURL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPlacePage extends AbstractPage {
    private final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(css= ElementCss.LOGO)
    private WebElement logo;

    @FindBy(id= ElementId.VOICE)
    private WebElement voice;

    @FindBy(css=ElementCss.VOICE_POPAP)
    private WebElement voicePopap;

    public FirstPlacePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void open() {
        webDriver.navigate().to(PageURL.FIRST_PLACE_PAGE);
        LOGGER.info(LogMessage.FIRSTPLACE_PAGE_OPENED);
    }

    public boolean isDisplayedVoice(){
        voice.click();
        return voicePopap.isDisplayed();
    }

    public boolean isDisplayedPlace() {
        return logo.isDisplayed();
    }

}
