package by.bsu.selenium.page;

import by.bsu.selenium.constant.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{
    private final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(id="from_name")
    private WebElement fromInput;

    @FindBy(name = ElementName.TO)
    private WebElement toInput;

    @FindBy(css = "ul.ui-autocomplete>li>a")
    private WebElement toUl;

    @FindBy(id="departure_date")
    private WebElement dateInput;

    @FindBy(css = "table.ui-datepicker-calendar>tbody>tr>td>a")
    private WebElement date;

    @FindBy(xpath = ElementXPath.BUTTON)
    private WebElement button;

    @FindBy(css="div.js-cabinet>a")
    private WebElement mytick;

    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[3]/a[2]")
    private WebElement mytick1;

    @FindBy(id="email_login")
    private WebElement login;

    @FindBy(id="pass_login")
    private WebElement passw;

    @FindBy(xpath="//*[@id=\"login_popup\"]/div[5]/form/div[2]/div/input")
    private WebElement in;

    @FindBy(css="label[data-uil='oneway']")
    private WebElement oneway;

    @FindBy(xpath = "//*[@id=\"current-lang\"]")
    private WebElement swapLang;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[4]/div/div/div[4]/a")
    private WebElement swapLangBt;

    @FindBy(xpath = "//*[@id=\"country_chosen\"]")
    private WebElement select;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[1]/h1/span")
    private WebElement h1;

    @FindBy(xpath = "//*[@id=\"page\"]/main/div/div/aside/div[1]/div/ol/li[1]/a")
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
