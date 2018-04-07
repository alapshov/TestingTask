/**
 * Класс описывает запуск драйвера и работу со страницами
 */
package app;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.cs.A;
import manager.TestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MarketPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Application {

    private static WebDriver driver = null;
    private static HomePage homePage;
    private static TestManager testManager;
    private static String firstProductName;


    @Before
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru");
        homePage = new HomePage(driver);
        testManager = new TestManager(homePage);

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

    /**
     * Нажать применить
     * @return
     */
    public Application pushApply(){
        homePage
                .getMarketPage()
                .getProductPage()
                .pushApply();
        return this;
    }

    /**
     * Проверка количество товаров на странице
     * @param count
     * @return
     */
    public Application checkedCountProduct(int count){
        testManager.checkedCountProduct(count);
        return this;
    }

    /**
     * Получить превый продукт
     * @return
     */
    public Application getFirstProduct(){
        firstProductName = testManager.getFirstProduct();
        return this;
    }

    /**
     * Найти продукт
     * @return
     */
    public Application searchProduct(){
        homePage
                .getMarketPage()
                .getProductPage()
                .headerSearch(firstProductName);
        return this;
    }
    public Application chechedFirstProduct(){
        testManager.chekedFirstProductForSearch(firstProductName);
        return this;
    }

    @After
    public static void quit() {
        driver.quit();
        driver = null;
    }


}
