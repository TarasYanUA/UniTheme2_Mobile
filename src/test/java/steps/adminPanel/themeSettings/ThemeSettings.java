package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ThemeSettings {
    public ThemeSettings() {
        super();
    }

    SelenideElement themeSectionsOnPage_DownloadedAddons = $x("//tr[@id='addon_abt__unitheme2']//button[@class='btn dropdown-toggle']");
    SelenideElement themeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.settings']");

    @Given("Переходим на страницу \"UniTheme2 -- Настройки темы\", вкладка {string}")
    public void navigateTo_ThemeSettings(String tabName) {
        themeSectionsOnPage_DownloadedAddons.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        sleep(1000);
        themeSettings.click();
        $x("//div[contains(@class, 'tabs')]//a[text()='" + tabName + "']").click();
    }


    //Вкладка "Списки товаров"
    SelenideElement setting_DecolorizeOutOfStockProducts = $("input[id='settings.abt__ut2.product_list.decolorate_out_of_stock_products']");
    SelenideElement setting_PriceDisplayFormat = $(By.id("settings.abt__ut2.product_list.price_display_format"));
    SelenideElement setting_PriceAtTheTop = $("input[id='settings.abt__ut2.product_list.price_position_top']");
    SelenideElement setting_EmptyStarsOfProductRating = $("input[id='settings.abt__ut2.product_list.show_rating']");
    SelenideElement setting_CommonValueOfProductRating = $("input[id='settings.abt__ut2.product_list.show_rating_num']");
    SelenideElement setting_DisplayCartStatus = $(By.id("settings.abt__ut2.product_list.show_cart_status"));
    SelenideElement setting_DisplayStatusesForButtons = $(By.id("settings.abt__ut2.product_list.show_favorite_compare_status"));
    SelenideElement setting_DisplayButtonWishList = $(By.id("settings.abt__ut2.product_list.button_wish_list_view.mobile"));
    SelenideElement setting_DisplayButtonComparisonList = $(By.id("settings.abt__ut2.product_list.button_compare_view.mobile"));
    SelenideElement setting_ShowYouSave = $(By.id("settings.abt__ut2.product_list.show_you_save.mobile"));

    //Настройки для вида списка товаров "Сетка"
    SelenideElement setting_ProductIconWidth = $(By.id("settings.abt__ut2.product_list.products_multicolumns.image_width.mobile"));
    SelenideElement setting_ProductIconHeight = $(By.id("settings.abt__ut2.product_list.products_multicolumns.image_height.mobile"));
    SelenideElement setting_NumberOfLinesInProductName = $(By.id("settings.abt__ut2.product_list.products_multicolumns.lines_number_in_name_product.mobile"));
    SelenideElement setting_ShowProductCode = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_sku.mobile']");
    SelenideElement setting_ShowAvailabilityStatus = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_amount.mobile']");
    SelenideElement setting_ShowQuantityChanger = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_qty.mobile']");
    SelenideElement setting_ShowAddToCartButton = $("select[id='settings.abt__ut2.product_list.products_multicolumns.show_button_add_to_cart.mobile']");
    SelenideElement setting_AdditionalProductInformation = $("select[id='settings.abt__ut2.product_list.products_multicolumns.grid_item_bottom_content.mobile']");
    SelenideElement setting_ShowStandardImageGallery_Grid = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_gallery.mobile"));

    //Настройки для вида списка товаров с шаблоном "Мелкие элементы"
    SelenideElement smallItems_NumberOfLinesInProductName = $(By.id("settings.abt__ut2.product_list.small_items.lines_number_in_name_product.mobile"));
    SelenideElement smallItems_ShowProductCode = $(By.id("settings.abt__ut2.product_list.small_items.show_sku.mobile"));
    SelenideElement smallItems_ShowAvailabilityStatus = $(By.id("settings.abt__ut2.product_list.small_items.show_amount.mobile"));
    SelenideElement smallItems_ShowQuantityChanger = $(By.id("settings.abt__ut2.product_list.small_items.show_qty.mobile"));
    SelenideElement smallItems_ShowAddToCartButton = $(By.id("settings.abt__ut2.product_list.small_items.show_button_add_to_cart.mobile"));

    //Настройки для вида списка товаров с шаблоном "Скроллер"
    SelenideElement scroller_NumberOfLinesInProductName = $(By.id("settings.abt__ut2.product_list.products_scroller.lines_number_in_name_product.mobile"));
    SelenideElement scroller_AvailabilityStatus = $(By.id("settings.abt__ut2.product_list.products_scroller.show_amount.mobile"));
    SelenideElement scroller_QuantityChanger = $(By.id("settings.abt__ut2.product_list.products_scroller.show_qty.mobile"));
    SelenideElement scroller_AddToCartButton = $(By.id("settings.abt__ut2.product_list.products_scroller.show_button_add_to_cart.mobile"));


    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки темы:")
    public void setThemeSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Обесцвечивать товары, которых нет в наличии" -> setCheckboxState(setting_DecolorizeOutOfStockProducts, value);
                case "Формат отображения цен" -> setting_PriceDisplayFormat.selectOptionContainingText(value);
                case "Отображать цену вверху" -> setCheckboxState(setting_PriceAtTheTop, value);
                case "Отображать пустые звёзды рейтинга товара" -> setCheckboxState(setting_EmptyStarsOfProductRating, value);
                case "Отображать общее значение рейтинга товара" -> setCheckboxState(setting_CommonValueOfProductRating, value);
                case "Отображать кнопку \"Добавить в избранное\"" -> setCheckboxState(setting_DisplayButtonWishList, value);
                case "Отображать кнопку \"Добавить в список сравнения\"" -> setCheckboxState(setting_DisplayButtonComparisonList, value);
                case "Отображать \"Вы экономите\"" -> setting_ShowYouSave.scrollIntoCenter().selectOptionContainingText(value);

                //Настройки для вида списка товаров "Сетка"
                case "Ширина иконки товара" -> setting_ProductIconWidth.setValue(value);
                case "Высота иконки товара" -> setting_ProductIconHeight.setValue(value);
                case "Количество строк в названии товара" -> setting_NumberOfLinesInProductName.scrollIntoCenter().selectOptionContainingText(value);
                case "Отображать код товара" -> setCheckboxState(setting_ShowProductCode, value);
                case "Отображать статус наличия" -> setCheckboxState(setting_ShowAvailabilityStatus, value);
                case "Отображать модификатор количества" -> setCheckboxState(setting_ShowQuantityChanger, value);
                case "Отображать кнопку \"Купить\"" -> setting_ShowAddToCartButton.selectOptionContainingText(value);
                case "Дополнительная информация о товаре" -> setting_AdditionalProductInformation.selectOptionContainingText(value);
                case "Отображать стандартную галерею изображений" -> setting_ShowStandardImageGallery_Grid.selectOptionContainingText(value);

                //Настройки для вида списка товаров с шаблоном "Мелкие элементы"
                case "Мелкие элементы, Количество строк в названии товара" -> smallItems_NumberOfLinesInProductName.scrollIntoCenter().selectOptionContainingText(value);
                case "Мелкие элементы, Отображать код товара" -> setCheckboxState(smallItems_ShowProductCode, value);
                case "Мелкие элементы, Отображать статус наличия" -> setCheckboxState(smallItems_ShowAvailabilityStatus, value);
                case "Мелкие элементы, Отображать модификатор количества" -> setCheckboxState(smallItems_ShowQuantityChanger, value);
                case "Мелкие элементы, Отображать кнопку \"Купить\"" -> smallItems_ShowAddToCartButton.selectOptionContainingText(value);

                // Настройки для вида списка товаров с шаблоном "Скроллер"
                case "Скроллер, Количество строк в названии товара" -> scroller_NumberOfLinesInProductName.scrollIntoCenter().selectOptionContainingText(value);
                case "Скроллер, Отображать статус наличия" -> setCheckboxState(scroller_AvailabilityStatus, value);
                case "Скроллер, Отображать модификатор количества" -> setCheckboxState(scroller_QuantityChanger, value);
                case "Скроллер, Отображать кнопку \"Купить\"" -> scroller_AddToCartButton.selectOptionContainingText(value);

                default -> System.out.println("Неизвестная настройка: " + setting);
            }
        }
    }
}