/**
 * Класс описывает старницу яндекс маркет
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    /**
     * Кликнуть ссылку на маркет
     * @param driver
     */
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public HomePage marketClick(){
        driver.findElement(By.linkText("Маркет")).click();
        return this;
    }
    public MarketPage getMarketPage(){
        return new MarketPage(driver);
    }

}
