package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import steps.adminPanel.LayoutPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public HomePage() {
        super();
    }

    String blockID = LayoutPage.blockID;


    SelenideElement button_ShowAdminPanel = $(".bp-bottom-button--logo");
    SelenideElement goTo_Storefront = $(".bp-nav__item-text");

    SelenideElement flyMenu_button = $(".ut2-icon-outline-menu");
    SelenideElement flyMenu_Logout = $("a[href*='dispatch=auth.logout']");
    SelenideElement flyMenu_button_ViewDetails_SecondLevel = $(".ut2-lsl.active .ty-float-right");
    SelenideElement button_CloseAdminBottomPanel = $("#bp_off_bottom_panel.bp-close");
    SelenideElement cookie = $(".cm-btn-success");
    SelenideElement notification_close = $(".cm-notification-close");
    SelenideElement blockWithProducts = $("div.ty-mainbox-container.clearfix");
    SelenideElement categoryTemplate_Grid = $(".ut2-icon-products-multicolumns");
    SelenideElement categoryTemplate_ListWithoutOptions = $(".ut2-icon-products-without-options");
    SelenideElement categoryTemplate_CompactList = $(".ut2-icon-short-list");
    SelenideElement mobileSearchIcon = $(".ut2-icon-search");
    SelenideElement field_Search = $(By.id("search_input"));
    SelenideElement chooseFirstProduct = $(".ut2-gl__image");


    @When("Переходим на витрину")
    public void navigateToStorefront_HomePage() {
        button_ShowAdminPanel.click();
        goTo_Storefront.click();
        if (button_CloseAdminBottomPanel.isDisplayed()) {
            button_CloseAdminBottomPanel.click();
        }
        cookie.click();
        if (notification_close.exists())
            notification_close.click();
    }

    @Given("Разавторизоваться на витрине")
    public void logoutOnStorefront() {
        flyMenu_button.click();
        executeJavaScript("arguments[0].click();", flyMenu_Logout);
    }

    @And("Переключаемся на {string} язык интерфейса витрины")
    public void selectLanguage(String lang_RuEnAr) {
        $("a[id*='_wrap_language_']").hover().click();
        $(".ty-select-block__list-item a[data-ca-name='" + lang_RuEnAr + "']").click();
    }

    @And("Скроллимся к блоку товаров")
    public void scrollTo_Block() {
        blockWithProducts.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
    }

    @And("Раскрываем вкладку {string} у блока")
    public void openBlockTab(String tabName) {
        $x("//span[@class='ty-tabs__span'][text()='" + tabName + "']").click();
    }

    @And("Нажимаем кнопку 'Показать ещё' в блоке товаров и делаем скриншоты {string}")
    public void clickButton_ShowMore__makeScreenshot(String screenshot) {
        int num = 1;
        while (true) {
            ElementsCollection buttons = $$("span[id*='ut2_load_more_block_" + blockID + "']");
            if (!buttons.isEmpty() && buttons.first().isDisplayed()) {
                SelenideElement button_ShowMore = buttons.first(); // Берем первый элемент из списка
                button_ShowMore.scrollIntoView(true);
                button_ShowMore.click();
                executeJavaScript("window.scrollBy(0, -500);");
                sleep(5000);
                screenshot(screenshot + num);
                num++;
            } else {
                break;
            }
        }
    }

    @Then("Делаем скриншот {string}")
    public void takeScreenshot(String screenshotName) {
        Selenide.sleep(1500);
        screenshot(screenshotName);
    }

    @And("Переходим на страницу категории {string} {string}")
    public void navigateTo_CategoryPage(String mainCategory, String subCategory) {
        flyMenu_button.click();
        $(".ut2-lfl.ty-menu-item__" + mainCategory + " strong").click();
        $x("//strong[text()='" + subCategory + "']").click();
        if (flyMenu_button_ViewDetails_SecondLevel.exists())
            flyMenu_button_ViewDetails_SecondLevel.click();
    }

    @And("Переходим на шаблон {string} страницы категории")
    public void navigateTo_CategoryTemplate(String templateName) {
        switch (templateName) {
            case "Сетка" -> categoryTemplate_Grid.click();
            case "Список без опций" -> categoryTemplate_ListWithoutOptions.click();
            case "Компактный список" -> categoryTemplate_CompactList.click();
            default -> throw new IllegalArgumentException("Неизвестный шаблон: " + templateName);
        }
        $("div[style='display: block;']").shouldBe(Condition.disappear, Duration.ofSeconds(8));
        sleep(1000);
    }


    @And("Скроллимся вниз по странице на {int} px")
    public void scrollBelowOfPage(int value) {
        Selenide.executeJavaScript("window.scrollBy(0, " + value + ");");
    }

    @And("Переходим на страницу товара {string}")
    public void navigateTo_ProductPage(String productName) {
        mobileSearchIcon.click();
        field_Search.setValue(productName);
        field_Search.sendKeys(Keys.ENTER);
        chooseFirstProduct.click();
    }
}