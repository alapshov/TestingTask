/**
 * Класс описывает запуск драйвера и работу со страницами
 */
package app;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MarketPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Application {

    private static WebDriver driver = null;
    private static HomePage homePage;
    private static MarketPage marketPage;
    private static ProductPage productPage;


    @Before
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru");
        homePage = new HomePage(driver);

    }

    /**
     * Открыть маркет
     * @return
     */
    public Application openMarket(){
        homePage
                .marketClick();
        return this;
    }


    /**
     * Открыть страницус продуктами
     *
     * @param category
     * @return
     */
    public Application openProductPage(String category) {
        homePage
                .getMarketPage()
                .menuClick(category);

        return this;
    }

    /**
     * Открыть расширенный поиск
     * @return
     */
    public Application openExtendedSearch(){
        homePage
                .getMarketPage()
                .getProductPage()
                .extendedSearchClick();
        return this;
    }

    /**
     * Ввести цену "от" в фильтр
     *
     * @param price
     * @return
     */
    public Application enterPriceFrom(String price) {
        homePage
                .getMarketPage()
                .getProductPage()
                .enterPriceFrom(price);

        return this;
    }

    /**
     * Выбрать производителя
     *
     * @param maker
     * @return
     */

    public Application enterMaker(String maker) {
        homePage
                .getMarketPage()
                .getProductPage()
                .selectMaker(maker);
        return this;
    }

    public Application pushApply(){
        homePage
                .getMarketPage()
                .getProductPage()
                .pushApply();
        return this;
    }

    /**
     * Получить количество продуктов
     *
     * @return
     */

    private int getCountProduct() {

        return homePage
                .getMarketPage()
                .getProductPage()
                .setProductList()
                .getProductList()
                .size();
    }


    @After
    public static void quit() {
        driver.quit();
        driver = null;
    }


}
