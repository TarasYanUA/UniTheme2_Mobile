package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ColorSchemeSettings {
    public ColorSchemeSettings() {
        super();
    }

    SelenideElement themeSectionsOnPage_DownloadedAddons = $x("//tr[@id='addon_abt__unitheme2']//button[@class='btn dropdown-toggle']");
    SelenideElement colorSchemeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.less_settings']");
    SelenideElement fieldOfActiveColorScheme = $("a[id^='sw_select_'][id$='_wrap_currency']");
    SelenideElement activeColorScheme = $x("//div[@class=\"language-wrap\"]//a[contains(.,'CS-Cart')]");


    @Given("Переходим на страницу \"UniTheme2 -- Настройки цветосхемы\", вкладка {string}")
    public void navigateTo_ColorSchemeSettings(String tabName) {
        themeSectionsOnPage_DownloadedAddons.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        colorSchemeSettings.click();
        fieldOfActiveColorScheme.click();
        activeColorScheme.click();
        sleep(2000);
        $x("//div[contains(@class, 'tabs')]//a[text()='" + tabName + "']").click();
    }


    //Вкладка "Списки товаров"
    SelenideElement setting_FrameType = $(By.id("settings.abt__ut2.product_list.show_grid_border"));
    SelenideElement setting_ProductLists_MaskForProductImages = $(By.id("settings.abt__ut2.product_list.mask_images_gallery"));
    SelenideElement setting_ProductLists_ElementsAlignment = $(By.id("settings.abt__ut2.product_list.use_elements_alignment"));
    SelenideElement setting_ProductLists_ExpandGridItemOnHover = $(By.id("settings.abt__ut2.product_list.extend_grid_item_on_hover"));
    SelenideElement setting_ProductLists_FontWeightForProductName = $(By.id("settings.abt__ut2.product_list.grid-list.product_name_font_weight"));


    @And("Устанавливаем настройки цветосхемы:")
    public void setColorSchemeSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Тип обрамления товара в сетке":
                    setting_FrameType.selectOptionContainingText(value);
                    break;

                case "Добавить фон/маску для изображений товара":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ProductLists_MaskForProductImages.isSelected())
                            setting_ProductLists_MaskForProductImages.click();
                    } else {
                        if (!setting_ProductLists_MaskForProductImages.isSelected())
                            setting_ProductLists_MaskForProductImages.click();
                    }
                    break;

                case "Использовать выравнивание элементов в товарной сетке":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ProductLists_ElementsAlignment.isSelected())
                            setting_ProductLists_ElementsAlignment.click();
                    } else {
                        if (!setting_ProductLists_ElementsAlignment.isSelected())
                            setting_ProductLists_ElementsAlignment.click();
                    }
                    break;

                case "Эффект увеличения ячейки при наведении":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ProductLists_ExpandGridItemOnHover.isSelected())
                            setting_ProductLists_ExpandGridItemOnHover.click();
                    } else {
                        if (!setting_ProductLists_ExpandGridItemOnHover.isSelected())
                            setting_ProductLists_ExpandGridItemOnHover.click();
                    }
                    break;

                case "Насыщенность шрифта для названия товара":
                    setting_ProductLists_FontWeightForProductName.selectOptionContainingText(value);
                    break;
            }
        }
    }
}