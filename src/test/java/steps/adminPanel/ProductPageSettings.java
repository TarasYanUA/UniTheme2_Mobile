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
    SelenideElement field_Name = $(By.id("product_description_product"));
    SelenideElement field_Price = $(By.id("elm_price_price"));
    SelenideElement field_ListPrice = $(By.id("elm_list_price"));
    SelenideElement field_InStock = $(By.id("elm_in_stock"));
    SelenideElement setting_ZeroPriceAction = $(By.id("elm_zero_price_action"));
    SelenideElement field_UnitName = $(By.id("elm_product_unit_name"));
    SelenideElement field_UnitsInProduct = $(By.id("elm_product_units_in_product"));
    SelenideElement field_PricePerUnit = $(By.id("elm_product_show_price_per_x_units"));
    SelenideElement setting_OutOfStockActions = $(By.id("elm_out_of_stock_actions"));
    SelenideElement fieldName_ShortDescription = $(By.cssSelector("label[for='elm_product_short_descr']"));
    SelenideElement field_ShortDescription = $(By.id("redactor-uuid-1"));
    SelenideElement fieldName_PromoText = $(By.cssSelector("label[for='elm_product_promo_text']"));
    SelenideElement field_PromoText = $(By.id("redactor-uuid-2"));

    //Вкладка товара "Бонусные баллы"
    SelenideElement tab_RewardPoints = $(".content__tabs-navigation #reward_points");
    SelenideElement setting_AllowPaymentByPoints = $(By.id("pd_is_pbp"));

    //Вкладка товара "Оптовые скидки"
    SelenideElement tab_QuantityDiscounts = $(By.id("qty_discounts"));
    SelenideElement field_Quantity = $("#box_add_qty_discount .cm-value-decimal");
    SelenideElement field_Value = $("#box_add_qty_discount .cm-numeric");


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
                case "Название" -> field_Name.setValue(value);
                case "Цена" -> field_Price.setValue(value);
                case "Рекомендованная цена" -> field_ListPrice.setValue(value);
                case "В наличии" -> field_InStock.setValue(value);
                case "Действие при нулевой цене" -> setting_ZeroPriceAction.selectOptionContainingText(value);
                case "Название единицы" -> field_UnitName.setValue(value);
                case "Единиц в товаре" -> field_UnitsInProduct.setValue(value);
                case "Цена за X единиц" -> field_PricePerUnit.setValue(value);
                case "Действие при отсутствии товара в наличии" -> setting_OutOfStockActions.selectOptionContainingText(value);
                case "Краткое описание" -> {
                    fieldName_ShortDescription.scrollIntoCenter().click();
                    field_ShortDescription.setValue(value);
                }
                case "Промо-текст" -> {
                    fieldName_PromoText.scrollIntoCenter().click();
                    field_PromoText.setValue(value);
                }

                //Вкладка товара "Бонусные баллы"
                case "Бонусные баллы, Разрешить оплату баллами" -> {
                    executeJavaScript("window.scrollTo(0, 0);");
                    tab_RewardPoints.click();
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_AllowPaymentByPoints.isSelected())
                            setting_AllowPaymentByPoints.click();
                    } else {
                        if (!setting_AllowPaymentByPoints.isSelected())
                            setting_AllowPaymentByPoints.click();
                    }
                }

                //Вкладка товара "Оптовые скидки"
                case "Оптовые скидки, Кол-во" -> {
                    executeJavaScript("window.scrollTo(0, 0);");
                    tab_QuantityDiscounts.click();
                    field_Quantity.setValue(value);
                }
                case "Оптовые скидки, Значение" -> field_Value.setValue(value);

                default -> System.out.println("Неизвестная настройка: " + setting);
            }
        }
    }

    @Then("Сохраняем настройки товара")
    public void saveProductPage() {
        button_SaveProduct.click();
    }
}