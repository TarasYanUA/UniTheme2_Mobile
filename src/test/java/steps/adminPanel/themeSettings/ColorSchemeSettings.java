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
        themeSectionsOnPage_DownloadedAddons.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        sleep(1000);
        themeSectionsOnPage_DownloadedAddons.click();
        colorSchemeSettings.click();
        fieldOfActiveColorScheme.click();
        activeColorScheme.click();
        sleep(2000);
        $x("//div[contains(@class, 'tabs')]//a[text()='" + tabName + "']").click();
    }


    //Вкладка "Общие"
    SelenideElement setting_General_RoundCornersForElements = $(By.id("settings.abt__ut2.general.use_rounding"));
    SelenideElement setting_General_RoundCornersOfBlocks = $(By.id("settings.abt__ut2.general.use_rounding_blocks"));
    SelenideElement setting_General_DisplayHeadersInCapitalLetters = $(By.id("settings.abt__ut2.general.use_titles_uppercase"));
    SelenideElement setting_General_ButtonsStyle = $(By.id("settings.abt__ut2.general.buttons.style"));
    SelenideElement setting_General_DisplayTextInCapitalLetters = $(By.id("settings.abt__ut2.general.buttons.use_text_uppercase"));
    SelenideElement setting_General_AddShadow = $(By.id("settings.abt__ut2.general.buttons.use_shadow"));
    SelenideElement setting_General_AddBulk = $(By.id("settings.abt__ut2.general.buttons.use_gradient"));
    SelenideElement setting_General_CartIcon = $(By.id("settings.abt__ut2.general.buttons.use_icon_cart"));


    //Вкладка "Списки товаров"
    SelenideElement setting_FrameType = $(By.id("settings.abt__ut2.product_list.show_grid_border"));
    SelenideElement setting_ProductLists_MaskForProductImages = $(By.id("settings.abt__ut2.product_list.mask_images_gallery"));
    SelenideElement setting_ProductLists_ElementsAlignment = $(By.id("settings.abt__ut2.product_list.use_elements_alignment"));
    SelenideElement setting_ProductLists_ExpandGridItemOnHover = $(By.id("settings.abt__ut2.product_list.extend_grid_item_on_hover"));
    SelenideElement setting_ProductLists_FontWeightForProductName = $(By.id("settings.abt__ut2.product_list.grid-list.product_name_font_weight"));


    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки цветосхемы:")
    public void setColorSchemeSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                //Вкладка "Общие"
                case "Скруглить углы для элементов интерфейса" -> setting_General_RoundCornersForElements.selectOptionContainingText(value);
                case "Скруглить углы блоков, окон, баннеров" -> setCheckboxState(setting_General_RoundCornersOfBlocks, value);
                case "Отображать заголовки заглавными буквами" -> setCheckboxState(setting_General_DisplayHeadersInCapitalLetters, value);
                case "Кнопки, Стиль" -> setting_General_ButtonsStyle.selectOptionContainingText(value);
                case "Кнопки, Отображать текст заглавными буквами" -> setCheckboxState(setting_General_DisplayTextInCapitalLetters, value);
                case "Кнопки, Отображать тень" -> setCheckboxState(setting_General_AddShadow, value);
                case "Кнопки, Добавить объем" -> setCheckboxState(setting_General_AddBulk, value);
                case "Кнопки, Иконка Корзины" -> setting_General_CartIcon.selectOptionContainingText(value);

                //Вкладка "Списки товаров"
                case "Тип обрамления товара в сетке" -> setting_FrameType.selectOptionContainingText(value);
                case "Добавить фон/маску для изображений товара" -> setCheckboxState(setting_ProductLists_MaskForProductImages, value);
                case "Использовать выравнивание элементов в товарной сетке" -> setCheckboxState(setting_ProductLists_ElementsAlignment, value);
                case "Эффект увеличения ячейки при наведении" -> setCheckboxState(setting_ProductLists_ExpandGridItemOnHover, value);
                case "Насыщенность шрифта для названия товара" -> setting_ProductLists_FontWeightForProductName.selectOptionContainingText(value);

                default -> throw new IllegalArgumentException("Неизвестная настройка: " + setting);
            }
        }
    }
}