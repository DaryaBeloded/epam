package by.bsu.selenium.action;

import by.bsu.selenium.page.FirstPlacePage;

public class FirstPlacePageAction extends AbstractAction {

    public boolean isDisplayedVoice(){
        FirstPlacePage fp = new FirstPlacePage(webDriver);
        fp.open();
        return fp.isDisplayedVoice();
    }
}
