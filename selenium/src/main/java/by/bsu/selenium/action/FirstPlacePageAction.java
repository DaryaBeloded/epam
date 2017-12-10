package by.bsu.selenium.action;

import by.bsu.selenium.page.FirstPlacePage;
import by.bsu.selenium.page.MainPage;

public class FirstPlacePageAction extends AbstractAction {

    public boolean isDisplayedVoice(){
        FirstPlacePage fp = new FirstPlacePage(webDriver);
        fp.open();
        return fp.isDisplayedVoice();
    }
}
