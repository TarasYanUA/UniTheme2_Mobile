package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class CategoryPage {
    public CategoryPage(){super();}

    SelenideElement categoryTemplate_Grid = $(".ut2-icon-products-multicolumns");
    SelenideElement categoryTemplate_ListWithoutOptions = $(".ut2-icon-products-without-options");
    SelenideElement categoryTemplate_CompactList = $(".ut2-icon-short-list");
    SelenideElement mobileSearchIcon = $(".ut2-icon-search");
    SelenideElement field_Search = $(By.id("search_input"));
    SelenideElement chooseFirstProduct = $(".ut2-gl__body .product-title");
    ElementsCollection closeHorizontalFilters = $$("div.cm-horizontal-filters-content.container-opened .ut2-icon-baseline-close");


    public void navigateTo_CategoryTemplate(String templateName) {
        switch (templateName) {
            case "Сетка" -> {
                categoryTemplate_Grid.click();
                UtilsStorefront.waitForSpinnerDisappear();
            }
            case "Список без опций" -> {
                categoryTemplate_ListWithoutOptions.click();
                UtilsStorefront.waitForSpinnerDisappear();
            }
            case "Компактный список" -> {
                categoryTemplate_CompactList.click();
                UtilsStorefront.waitForSpinnerDisappear();
            }

            default -> throw new IllegalArgumentException("Неизвестный шаблон: " + templateName);
        }
    }

    public void navigateTo_ProductPage(String productName) {
        mobileSearchIcon.click();
        field_Search.setValue(productName);
        field_Search.pressEnter();
        chooseFirstProduct.shouldBe(Condition.enabled, Duration.ofSeconds(8)).click();
    }

    public void openHorizontalFilterAndSelectFilter(String filterName, String screen01, String screen02) {
        $x("//div[contains(@class, 'ut2-horizontal-product-filters-dropdown')]//div[text()='" + filterName + "']").click();
        sleep(2000);
        screenshot(screen01);
        $("div.cm-horizontal-filters-content.js_open label[for*='elm_checkbox_']").click();
        UtilsStorefront.waitForSpinnerDisappear();
        screenshot(screen02);
        closeWindowOfHorizontalFilters();
    }

    public void openHorizontalFilterPrice(String price, String screen01, String screen02) {
        $x("//div[contains(@class, 'ut2-horizontal-product-filters-dropdown')]//div[text()='Цена']").click();
        sleep(2000);
        screenshot(screen01);
        $("div.cm-horizontal-filters-content.js_open input[id*='_right']").setValue(price).pressEnter();
        sleep(3000);
        UtilsStorefront.waitForSpinnerDisappear();
        screenshot(screen02);
        closeWindowOfHorizontalFilters();
    }

    void closeWindowOfHorizontalFilters() {
        SelenideElement last = null;
        for (SelenideElement element : closeHorizontalFilters) {
            last = element;
        }
        assert last != null;
        last.click();
    }
}