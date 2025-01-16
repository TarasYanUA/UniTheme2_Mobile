package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CsCartSettings {
    public CsCartSettings() {
        super();
    }

    //Вкладка "Внешний вид"
    SelenideElement setting_DisplayPricesWithTaxesOnCategoryAndProductPages = $(By.id("field___show_prices_taxed_clean_116"));
    SelenideElement setting_ShowNumberOfAvailableProducts = $(By.id("field___in_stock_field_146"));
    SelenideElement setting_DisplayMiniThumbnailImagesAsGallery = $(By.id("field___thumbnails_gallery_147"));
    SelenideElement setting_DisplayProductDetailsInTabs = $(By.id("field___product_details_in_tab_288"));

    //Вкладка "Оформление заказа"
    SelenideElement setting_TaxCalculationMethodBasedOn = $(By.id("field___tax_calculation_179"));

    //Страница "Настройки -- Налоги"
    SelenideElement setting_priceIncludesTax = $x("//input[@type='checkbox'][@name='tax_data[7][price_includes_tax]']");


    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected || !isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки CS-Cart:")
    public void setCsCartSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                // Вкладка "Внешний вид"
                case "Показывать цены с налогом на страницах категорий и товаров" ->
                        setCheckboxState(setting_DisplayPricesWithTaxesOnCategoryAndProductPages, value);
                case "Показывать количество доступных товаров" -> setCheckboxState(setting_ShowNumberOfAvailableProducts, value);
                case "Показывать мини-иконки в виде галереи" -> setCheckboxState(setting_DisplayMiniThumbnailImagesAsGallery, value);
                case "Показывать информацию о товаре во вкладках" -> setCheckboxState(setting_DisplayProductDetailsInTabs, value);

                // Вкладка "Оформление заказа"
                case "Расчет налога по" ->
                        setting_TaxCalculationMethodBasedOn.selectOptionContainingText(value);

                // Страница "Настройки -- Налоги"
                case "Цена включает налог" ->
                        setCheckboxState(setting_priceIncludesTax, value);

                default ->
                        throw new IllegalArgumentException("Неизвестная настройка: " + setting);
            }
        }
    }
}