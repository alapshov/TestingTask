/**
 * Опиисывает страницу Маркет
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPage {
    private WebDriver driver;


    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }


    public MarketPage(WebDriver driver){
        this.driver = driver;
    }

    public MarketPage menuClick(String linktext){
        driver.findElement(By.partialLinkText(linktext)).click();
        return this;
    }

}
