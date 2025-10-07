package steps.storefront;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    public HomePageSteps() { super(); }

    HomePage homePage = new HomePage();

    @When("Переходим на витрину")
    public void navigateToStorefront_HomePage() {
        homePage.navigateToStorefront_HomePage();
    }

    @Given("Разавторизоваться на витрине")
    public void logoutOnStorefront() {
        homePage.logoutOnStorefront();
    }

    @And("Переключаемся на {string} язык интерфейса витрины")
    public void selectLanguage(String lang_RuEnAr) {
        homePage.selectLanguage(lang_RuEnAr);
    }

    @And("Скроллимся к блоку товаров")
    public void scrollTo_Block() {
        homePage.scrollTo_Block();
    }

    @And("Скроллимся к элементу по css селектору {string}")
    public void scrollTo_CssSelector(String selector) {
        homePage.scrollTo_CssSelector(selector);
    }

    @And("Скроллимся вниз по странице на {int} px")
    public void scrollBelowOfPage(int value) {
        homePage.scrollBelowOfPage(value);
    }

    @And("Раскрываем вкладку {string} у блока")
    public void openBlockTab(String tabName) {
        homePage.openBlockTab(tabName);
    }

    @And("Нажимаем кнопку 'Показать ещё' в блоке товаров и делаем скриншоты {string}")
    public void clickButton_ShowMore__makeScreenshot(String screenshot) {
        homePage.clickButton_ShowMore__makeScreenshot(screenshot);
    }

    @Then("Делаем скриншот {string}")
    public void takeScreenshot(String screenshotName) {
        homePage.takeScreenshot(screenshotName);
    }

    @And("Переходим на страницу категории {string} {string}")
    public void navigateTo_CategoryPage(String mainCategory, String subCategory) {
        homePage.navigateTo_CategoryPage(mainCategory, subCategory);
    }

    @And("Переходим на шаблон {string} страницы категории")
    public void navigateTo_CategoryTemplate(String templateName) {
        homePage.navigateTo_CategoryTemplate(templateName);
    }

    @And("Переходим на страницу товара {string}")
    public void navigateTo_ProductPage(String productName) {
        homePage.navigateTo_ProductPage(productName);
    }

    @And("Открываем Вертикальное меню кнопкой")
    public void openVerticalMenuWithButton() {
        homePage.openVerticalMenuWithButton();
    }

    @And("Закрываем Вертикальное меню")
    public void closeVerticalMenu() {
        homePage.closeVerticalMenu();
    }
}