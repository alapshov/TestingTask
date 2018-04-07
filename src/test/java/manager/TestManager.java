package manager;

import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;

import java.util.List;

public class TestManager {
    private int count;
    private Boolean flag = true;
    private HomePage homePage;


    public TestManager(HomePage homePage) {
        this.homePage = homePage;
    }

    /**
     * Поверка количества товаров
     *
     * @param count
     */
    public void checkedCountProduct(int count) {
        this.count = homePage
                .getMarketPage()
                .getProductPage()
                .setProductList()
                .getProductList()
                .size();

        if (this.count != count) {
            Assert.fail("Количетсво товаров не верное");
        }

    }

    /**
     * Получить первый по списку продукт
     *
     * @return
     */
    public String getFirstProduct() {
        return homePage
                .getMarketPage()
                .getProductPage()
                .setProductList()
                .getProductList()
                .get(0)
                .findElement(By.cssSelector("div.n-snippet-cell2__title"))
                .getAttribute("textContent");
    }

    /**
     * Найти и проверить, что наименование товара соответствует запомненному значению
     *
     * @param firstProduct
     * @return
     */
    public void chekedFirstProductForSearch(String firstProduct) {

        if (!getFirstProduct().contains(firstProduct)) {
            Assert.fail("Наименование товара не соотвествует запомненому");
        }

    }

    /**
     * Проверяем сортировку цен
     *
     * @param listPrice
     */
    public void chekedSortlListPrice(List<Integer> listPrice) {

        for (int i = 0; i < listPrice.size()-1; i++){
            if(listPrice.get(i) > listPrice.get(i+1)){
                Assert.fail("Сортировка по цене работает не верно");
            }
        }

    }
}
