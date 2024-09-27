package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CsCartSettings {
    public CsCartSettings(){super();}

    //Вкладка "Внешний вид"
    SelenideElement setting_DisplayPricesWithTaxesOnCategoryAndProductPages = $(By.id("field___show_prices_taxed_clean_116"));

    //Вкладка "Оформление заказа"
    SelenideElement setting_TaxCalculationMethodBasedOn = $(By.id("field___tax_calculation_179"));


    @And("Устанавливаем настройки CS-Cart:")
    public void устанавливаемНастройкиCSCart(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for(List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                //Вкладка "Внешний вид"
                case "Показывать цены с налогом на страницах категорий и товаров":
                    if(value.equalsIgnoreCase("n")) {
                        if(setting_DisplayPricesWithTaxesOnCategoryAndProductPages.isSelected())
                            setting_DisplayPricesWithTaxesOnCategoryAndProductPages.click();
                    } else {
                        if(!setting_DisplayPricesWithTaxesOnCategoryAndProductPages.isSelected())
                            setting_DisplayPricesWithTaxesOnCategoryAndProductPages.click();
                    }
                    break;


                //Вкладка "Оформление заказа"
                case "Расчет налога по":
                    setting_TaxCalculationMethodBasedOn.selectOptionContainingText(value);
                    break;
            }
        }
    }
}
