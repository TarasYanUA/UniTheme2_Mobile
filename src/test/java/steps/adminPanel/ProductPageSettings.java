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

    SelenideElement field_ProductName = $(By.id("product_description_product"));

    private void closeNotificationIfPresent() {
        if (!closeNotification.isEmpty())
            closeNotification.get(0).click();
    }

    @Given("Переходим на страницу товара {string}")
    public void navigateTo_ProductPage(String productName) {
        searchFieldOfProduct.setValue(productName);
        sleep(3000);
        anyProduct.click();
        closeNotificationIfPresent();
    }

    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected || !isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки товара:")
    public void setProductSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Название товара":
                    field_ProductName.setValue(value);
                    break;

                default:
                    System.out.println("Неизвестная настройка: " + setting);
                    break;
            }
        }
    }

    @Then("Сохраняем настройки товара")
    public void saveProductPage() {
        button_SaveProduct.click();
    }
}