package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
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
    SelenideElement chooseFirstProduct = $(".ut2-gl__body .product-title");


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

    public void logoutOnStorefront() {
        flyMenu_button.click();
        executeJavaScript("arguments[0].click();", flyMenu_Logout);
    }

    public void selectLanguage(String lang_RuEnAr) {
        $("a[id*='_wrap_language_']").hover().click();
        $(".ty-select-block__list-item a[data-ca-name='" + lang_RuEnAr + "']").click();
    }

    public void scrollTo_Block() {
        blockWithProducts.scrollIntoCenter();
    }

    public void scrollTo_CssSelector(String selector) {
        $(selector).scrollIntoCenter();
    }

    public void openBlockTab(String tabName) {
        if (!$$x("//span[@class='ty-tabs__span'][text()='" + tabName + "']").isEmpty())
            $x("//span[@class='ty-tabs__span'][text()='" + tabName + "']").click();
        else
            $x("//span[@class='ty-tabs__span'][text()='On Sale']").click();
        sleep(2000);
    }

    public void clickButton_ShowMore__makeScreenshot(String screenshot) {
        int num = 1;
        while (true) {
            ElementsCollection buttons = $$("span[id*='ut2_load_more_block_" + blockID + "']");
            if (!buttons.isEmpty() && buttons.first().isDisplayed()) {
                SelenideElement button_ShowMore = buttons.first(); // Берем первый элемент из списка
                button_ShowMore.scrollIntoCenter();
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

    public void takeScreenshot(String screenshotName) {
        Selenide.sleep(1500);
        screenshot(screenshotName);
    }

    public void navigateTo_CategoryPage(String mainCategory, String subCategory) {
        flyMenu_button.click();
        $(".ut2-lfl.ty-menu-item__" + mainCategory + " strong").click();
        $x("//strong[text()='" + subCategory + "']").click();
        if (flyMenu_button_ViewDetails_SecondLevel.exists())
            flyMenu_button_ViewDetails_SecondLevel.click();
    }

    public void navigateTo_CategoryTemplate(String templateName) {
        switch (templateName) {
            case "Сетка" -> {
                categoryTemplate_Grid.click();
                UtilsStorefront.waitForSpinnerDisappear();
                sleep(1000);
            }
            case "Список без опций" -> {
                categoryTemplate_ListWithoutOptions.click();
                UtilsStorefront.waitForSpinnerDisappear();
                sleep(1000);
            }
            case "Компактный список" -> {
                categoryTemplate_CompactList.click();
                UtilsStorefront.waitForSpinnerDisappear();
                sleep(1000);
            }

            default -> throw new IllegalArgumentException("Неизвестный шаблон: " + templateName);
        }
        $("div[style='display: block;']").shouldBe(Condition.disappear, Duration.ofSeconds(8));
        sleep(3000);
    }

    public void scrollBelowOfPage(int value) {
        Selenide.executeJavaScript("window.scrollBy(0, " + value + ");");
    }

    public void navigateTo_ProductPage(String productName) {
        mobileSearchIcon.click();
        field_Search.setValue(productName);
        field_Search.pressEnter();
        chooseFirstProduct.shouldBe(Condition.enabled, Duration.ofSeconds(8)).click();
    }

    public void openVerticalMenuWithButton() {
        $(".ut2-icon-view_cozy").scrollIntoCenter().click();
    }

    public void closeVerticalMenu() {
        $(".top-menu-grid-vertical .ut2-icon-baseline-close").click();
    }
}