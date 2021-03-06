/**
 * Класс описывает шаги сценария
 */
package tests;

import app.Application;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Также;
import org.junit.Assert;


public class MarketTest {
    private Application app = new Application();

    /**
     * @param args
     */
    @Если("^выбрать первый раздел (.*)$")
    public void selectFirstCategory(String args) {
        app.openProductPage(args);

    }

    /**
     * @param args
     */

    @Также("^выбрать второй раздел (.*)$")
    public void selectSecondCategory(String args) {
        app.openProductPage(args);

    }

    @Также("^перейти в расширенный поиск$")
    public void goToextendedSearch() {
        app.openExtendedSearch();
    }


    /**
     * @param arg1
     */
    @Также("^задать параметр поиска от (\\d+) рублей$")
    public void setParemetrSearchRUB(int arg1) {
        app.enterPriceFrom(String.valueOf(arg1));
    }

    /**
     * @param args
     */
    @Также("^выбрать производителя1 (.*)$")
    public void selectManufacturer1(String args) {
        app.enterMaker(args);
    }

    /**
     * @param args
     */
    @Также("^выбрать производителя2 (.*)$")
    public void selectManufacturer2(String args) {
        app.enterMaker(args);

    }

    @Также("^нажать кнопку применить$")
    public void pushApplyExtendedSearch() {
        app.pushApply();
    }

    /**
     * @param arg1
     */

    @Также("^проверить, что элементов на странице (\\d+)$")
    public void checkNumberItems(int arg1) {
       app.checkedCountProduct(arg1);

    }

    @Также("^запомнить первый элемент в списке$")
    public void rememberFirstItemList() {
        app.getFirstProduct();
    }

    @Также("^в поисковую строку ввести запомненное значение$")
    public void enterRemeberedValueInSearchLine() {
        app.searchProduct();

    }

    @Также("^найти и проверить, что наименование товара соответствует запомненному значению$")
    public void searchAndCheckedNameProductInRemeberedValue() {
        app.chechedFirstProduct();

    }

    @Также("^выбрать соритровку по цене$")
    public void selectSortPrice(){
        app.clickSort();
    }

    @Также("^проверить, что элементы на странице отсортированы верно$")
    public void chekedSortPrice() throws InterruptedException {
        app.chekedSortPrice();
    }
}
