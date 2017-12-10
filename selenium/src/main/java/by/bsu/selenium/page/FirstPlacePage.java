package by.bsu.selenium.page;

import by.bsu.selenium.constant.LogMessage;
import by.bsu.selenium.constant.PageURL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPlacePage extends AbstractPage {
    private final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(xpath="//*[@id=\"page\"]/div[1]/div/div[2]/div[1]/div[3]/a/img")
    private WebElement logo;

    @FindBy(xpath="//*[@id=\"button_start_vote\"]")
    private WebElement voice;

    @FindBy(xpath="/html/body/div")
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
