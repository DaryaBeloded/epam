package by.bsu.selenium.action;

import by.bsu.selenium.page.CabinetPage;

public class CabinetPageAction extends AbstractAction{
    public String isSignedIn(){
        CabinetPage cab = new CabinetPage(webDriver);
        cab.signin();
        cab.open();
        return cab.getUsername();
    }


}
