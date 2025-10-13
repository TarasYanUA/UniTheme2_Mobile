package steps.storefront;

import io.cucumber.java.en.And;

public class CategoryPageSteps {
    public CategoryPageSteps() {super();}

    CategoryPage categoryPage = new CategoryPage();

    @And("Переходим на шаблон {string} страницы категории")
    public void navigateTo_CategoryTemplate(String templateName) {
        categoryPage.navigateTo_CategoryTemplate(templateName);
    }

    @And("Переходим на страницу товара {string}")
    public void navigateTo_ProductPage(String productName) {
        categoryPage.navigateTo_ProductPage(productName);
    }

    @And("Открываем Горизонтальный фильтр {string} и выбираем фильтр, сделав два скриншота {string} и {string}")
    public void openHorizontalFilterAndSelectFilter(String filterName, String screen01, String screen02) {
        categoryPage.openHorizontalFilterAndSelectFilter(filterName, screen01, screen02);
    }

    @And("Открываем Горизонтальный фильтр Цена, ставим цену {string} и делаем два скриншота {string} и {string}")
    public void openHorizontalFilterPrice(String price, String screen01, String screen02) {
        categoryPage.openHorizontalFilterPrice(price, screen01, screen02);
    }
}
