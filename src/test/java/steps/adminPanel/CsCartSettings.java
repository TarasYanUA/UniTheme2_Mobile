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
    SelenideElement setting_QuickView = $("input[id*='field___enable_quick_view']");

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
                //Вкладка "Внешний вид"
                case "Показывать цены с налогом на страницах категорий и товаров":
                    setCheckboxState(setting_DisplayPricesWithTaxesOnCategoryAndProductPages, value);
                    break;

                case "Включить быстрый просмотр":
                    setCheckboxState(setting_QuickView, value);
                    break;


                //Вкладка "Оформление заказа"
                case "Расчет налога по":
                    setting_TaxCalculationMethodBasedOn.selectOptionContainingText(value);
                    break;


                //Страница "Настройки -- Налоги"
                case "Цена включает налог":
                    setCheckboxState(setting_priceIncludesTax, value);
                    break;

                default:
                    System.out.println("Неизвестная настройка: " + setting);
                    break;
            }
        }
    }
}