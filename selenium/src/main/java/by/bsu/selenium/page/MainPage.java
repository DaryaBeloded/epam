package by.bsu.selenium.page;

import by.bsu.selenium.constant.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{
    private final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(id=ElementId.FROM_INPUT)
    private WebElement fromInput;

    @FindBy(name = ElementName.TO)
    private WebElement toInput;

    @FindBy(css = ElementCss.TO_UL)
    private WebElement toUl;

    @FindBy(id = ElementId.DATE_INPUT)
    private WebElement dateInput;

    @FindBy(css = ElementCss.DATE)
    private WebElement date;

    @FindBy(xpath = ElementXPath.BUTTON)
    private WebElement button;

    @FindBy(css=ElementCss.MY_TICK)
    private WebElement mytick;

    @FindBy(xpath=ElementXPath.MY_TICK1)
    private WebElement mytick1;

    @FindBy(id=ElementId.LOGIN)
    private WebElement login;

    @FindBy(id=ElementId.PASS)
    private WebElement passw;

    @FindBy(xpath=ElementXPath.LOG_IN)
    private WebElement in;

    @FindBy(css=ElementCss.ONE_WAY)
    private WebElement oneway;

    @FindBy(id = ElementId.CURR_LANG)
    private WebElement swapLang;

    @FindBy(xpath = ElementXPath.SWAP_LANG_BT)
    private WebElement swapLangBt;

    @FindBy(id = ElementId.CHOSE_COUNTRY)
    private WebElement select;

    @FindBy(css=ElementCss.H1)
    private WebElement h1;

    @FindBy(css=ElementCss.FIRST)
    private WebElement first;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void open() {
        webDriver.navigate().to(PageURL.AVIA_PAGE);
        LOGGER.info(LogMessage.AVIA_OPENED);
    }

    public void goToFirstPlace() {
        ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+first.getLocation().getY()+");");
        first.click();
    }

    public void findTicket(String to){
        oneway.click();
//        fromInput.clear();
//        fromInput.sendKeys(from);
        toInput.clear();
        toInput.sendKeys(to);
        System.out.println(toUl.getText());
        toUl.click();
//        dateInput.sendKeys(date);
        dateInput.click();
        date.click();
        button.submit();
        LOGGER.info(LogMessage.AVIA_PERFORMED);
    }

    public void signIn(String email, String pass) {
        mytick.click();
        login.clear();
        login.sendKeys(email);
        passw.clear();
        passw.sendKeys(pass);
        in.submit();
//        mytick1.click();
        LOGGER.info(LogMessage.SIGN_IN_OPENED);

    }

    public boolean popapIsDisplayed(){
        mytick.click();
        WebElement popap = webDriver.findElement(By.cssSelector("div.popup_login"));
        return popap.isDisplayed();
    }

    public void swapLanguage(String lang){
        swapLang.click();
        select.click();
        WebElement changeLang = webDriver.findElement(By.xpath("//*[@id=\"country_chosen\"]/div/div/input"));
        changeLang.sendKeys(lang);
        swapLangBt.click();
        LOGGER.info(LogMessage.LANG_SWAP);

    }

    public WebElement getFromInput() {
        return fromInput;
    }

    public String geth1() {
        return h1.getText();
    }

    public WebElement getToInput() {
        return toInput;
    }

    public WebElement getDateInput() {
        return dateInput;
    }
}
