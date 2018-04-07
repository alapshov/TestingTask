package tests;

import app.Application;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;

public class PreHistory {

    @Если("^перейти на яндекс маркет$")
    public void goToYandexMarket() {
        new Application().openMarket();

    }

}
