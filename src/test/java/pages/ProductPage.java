/**
 * Класс описывает старницу продуктов *
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProductPage {


    private WebDriver driver;
    private List<WebElement> productList;
    private List<WebElement> priceElements;
    private List<Integer> listPrice = new ArrayList<Integer>();

    /**
     * Получаем список продуктов
     *
     * @return
     */
    public List<WebElement> getProductList() {
        return productList;
    }

    /**
     * Получаем список цен
     *
     * @return
     */
    public List<Integer> getListPrice() {
        return listPrice;
    }


    /**
     * Инициализируем драйвер в конструкторе
     *
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Открыть расширенный поиск
     *
     * @return
     */
    public ProductPage extendedSearchClick() {
        driver.findElement(By.linkText("Перейти ко всем фильтрам")).click();
        return this;
    }

    /**
     * Ввод фильтра
     *
     * @param price
     */
    public ProductPage enterPriceFrom(String price) {
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys(price);
        return this;
    }


    /**
     * Выбор производителя
     *
     * @param maker
     * @return
     */
    public ProductPage selectMaker(String maker) {

        if (!maker.contains("нет")) {
            WebElement makerFilterElement = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div"));
            List<WebElement> checkBoxElements;
            checkBoxElements = makerFilterElement.findElements(By.cssSelector("label.checkbox__label"));
            String a = checkBoxElements.get(1).getText();
            for (WebElement checkBoxElement : checkBoxElements) {
                if (checkBoxElement.getAttribute("textContent").contains(maker)) {
                    checkBoxElement.click();
                }

            }

        }
        return this;
    }

    public ProductPage pushApply() {

        driver.findElement(By.linkText("Показать подходящие")).click();
        return this;
    }

    /**
     * получаем список продуктов
     *
     * @return
     */
    public ProductPage setProductList() {
        productList = driver.findElements(By.cssSelector("div.n-snippet-cell2"));
        return this;
    }

    /**
     * Поиск
     *
     * @param searchText
     * @return
     */

    public ProductPage headerSearch(String searchText) {

        driver.findElement(By.id("header-search")).sendKeys(searchText);
        driver.findElement(By.cssSelector("span.search2__button")).click();
        return this;
    }

    /**
     * Сортировка по цене
     *
     * @return
     */
    public ProductPage cliсkFilterByPrice() {
        driver.findElement(By.linkText("по цене")).click();
        return this;
    }

    /**
     * Считывает цены в список
     *
     * @return
     */
    public ProductPage listPrice() throws InterruptedException {
        Thread.sleep(5000);
        priceElements = driver.findElements(By.cssSelector("div.n-snippet-cell2__main-price div.price"));
        for (WebElement priceElement : priceElements) {
           String s = priceElement.getAttribute("textContent")
                    .replace("\u20BD", "")
                    .replaceAll(" ","");
           listPrice.add(Integer.parseInt(s.substring(0,s.length()-1)));
        }
        return this;
    }

}
