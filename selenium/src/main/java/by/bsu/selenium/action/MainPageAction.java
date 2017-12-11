package by.bsu.selenium.action;

import by.bsu.selenium.page.FirstPlacePage;
import by.bsu.selenium.page.MainPage;

public class MainPageAction extends AbstractAction {

    public boolean findTicket(String to){
        MainPage ticket = new MainPage(webDriver);
        ticket.open();
        ticket.findTicket(to);
//        String resultFrom = ticket.getFromInput().getAttribute("value");
        String resultTo = ticket.getToInput().getAttribute("value");
        return to.equalsIgnoreCase(resultTo);
    }

    public boolean popap(){
        MainPage ticket = new MainPage(webDriver);
        ticket.open();
        return ticket.popapIsDisplayed();
    }

    public String lang(String lg){
        MainPage lang = new MainPage(webDriver);
        lang.open();
        lang.swapLanguage(lg);
        return lang.geth1();
    }

    public void signIn(String login, String pass){
        MainPage signin = new MainPage(webDriver);
        signin.open();
        signin.signIn(login, pass);
//        return signin.getUsername();
    }

    public boolean first(){
        MainPage pg = new MainPage(webDriver);
        FirstPlacePage fp = new FirstPlacePage(webDriver);
        pg.open();
        pg.goToFirstPlace();
        return fp.isDisplayedPlace();
    }



}
