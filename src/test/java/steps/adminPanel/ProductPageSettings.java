package steps.adminPanel;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProductPageSettings {

    SelenideElement button_SaveProduct = $(".cm-product-save-buttons");
    ElementsCollection closeNotification = $$(".cm-notification-close");
    SelenideElement searchFieldOfProduct = $("input[form='search_filters_form']");
    SelenideElement anyProduct = $(".products-list__image");

    // Вкладка товара "Общее"
    SelenideElement field_ProductName = $(By.id("product_description_product"));
    SelenideElement field_Price = $(By.id("elm_price_price"));
    SelenideElement field_ListPrice = $(By.id("elm_list_price"));
    SelenideElement field_InStock = $(By.id("elm_in_stock"));
    SelenideElement setting_ZeroPriceAction = $(By.id("elm_zero_price_action"));
    SelenideElement field_UnitName = $(By.id("elm_product_unit_name"));
    SelenideElement field_UnitsInProduct = $(By.id("elm_product_units_in_product"));
    SelenideElement field_PricePerUnit = $(By.id("elm_product_show_price_per_x_units"));
    SelenideElement setting_OutOfStockActions = $(By.id("elm_out_of_stock_actions"));
    SelenideElement setting_ProductTemplate = $(By.id("elm_details_layout"));
    SelenideElement fieldName_ShortDescription = $(By.cssSelector("label[for='elm_product_short_descr']"));
    SelenideElement field_ShortDescription = $(By.id("redactor-uuid-1"));
    SelenideElement fieldName_PromoText = $(By.cssSelector("label[for='elm_product_promo_text']"));
    SelenideElement field_PromoText = $(By.id("redactor-uuid-2"));


    void closeNotificationIfPresent() {
        if (!closeNotification.isEmpty())
            closeNotification.get(0).click();
    }

    @Given("Переходим на страницу редактирования товара {string}")
    public void navigateTo_ProductPage(String productName) {
        searchFieldOfProduct.setValue(productName);
        sleep(3000);
        anyProduct.click();
        closeNotificationIfPresent();
    }

    @And("Устанавливаем настройки товара:")
    public void setProductSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Название товара" -> field_ProductName.setValue(value);

                default -> System.out.println("Неизвестная настройка: " + setting);
            }
        }
    }

    @Then("Сохраняем настройки товара")
    public void saveProductPage() {
        button_SaveProduct.click();
    }
}