package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ThemeSettings {
    public ThemeSettings() {
        super();
    }

    SelenideElement themeSectionsOnPage_DownloadedAddons = $x("//tr[@id='addon_abt__unitheme2']//button[@class='btn dropdown-toggle']");
    SelenideElement themeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.settings']");


    @Given("Переходим на страницу \"UniTheme2 -- Настройки темы\", вкладка {string}")
    public void navigateTo_ThemeSettings(String tabName) {
        themeSectionsOnPage_DownloadedAddons.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        themeSettings.click();
        $x("//div[contains(@class, 'tabs')]//a[text()='" + tabName + "']").click();
    }


    //Вкладка "Списки товаров"
    SelenideElement setting_OutOfStockProducts = $("input[id='settings.abt__ut2.product_list.decolorate_out_of_stock_products']");
    SelenideElement setting_PriceDisplayFormat = $(By.id("settings.abt__ut2.product_list.price_display_format"));
    SelenideElement setting_PriceAtTheTop = $("input[id='settings.abt__ut2.product_list.price_position_top']");
    SelenideElement setting_EmptyStarsOfProductRating = $("input[id='settings.abt__ut2.product_list.show_rating']");
    SelenideElement setting_CommonValueOfProductRating = $("input[id='settings.abt__ut2.product_list.show_rating_num']");
    SelenideElement setting_DisplayCartStatus = $(By.id("settings.abt__ut2.product_list.show_cart_status"));
    SelenideElement setting_DisplayStatusesForButtons = $(By.id("settings.abt__ut2.product_list.show_favorite_compare_status"));
    SelenideElement setting_DisplayButtonWishList = $(By.id("settings.abt__ut2.product_list.button_wish_list_view.mobile"));
    SelenideElement setting_DisplayButtonComparisonList = $(By.id("settings.abt__ut2.product_list.button_compare_view.mobile"));
    SelenideElement setting_ShowYouSave = $(By.id("settings.abt__ut2.product_list.show_you_save.mobile"));
    SelenideElement setting_NumberOfLinesInProductName = $(By.id("settings.abt__ut2.product_list.products_multicolumns.lines_number_in_name_product.mobile"));
    SelenideElement setting_ShowProductCode = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_sku.mobile']");
    SelenideElement setting_DisplayAvailabilityStatus = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_amount.mobile']");
    SelenideElement setting_ShowQuantityChanger = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_qty.mobile']");
    SelenideElement setting_ShowAddToCartButton = $("select[id='settings.abt__ut2.product_list.products_multicolumns.show_button_add_to_cart.mobile']");
    SelenideElement setting_AdditionalProductInformation = $("select[id='settings.abt__ut2.product_list.products_multicolumns.grid_item_bottom_content.mobile']");
    SelenideElement setting_ShowStandardImageGallery_Grid = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_gallery.mobile"));


    @And("Устанавливаем настройки темы:")
    public void setThemeSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Формат отображения цен":
                    setting_PriceDisplayFormat.selectOptionContainingText(value);
                    break;

                case "Отображать цену вверху":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_PriceAtTheTop.isSelected()) {
                            setting_PriceAtTheTop.click();
                        }
                    } else {
                        if (!setting_PriceAtTheTop.isSelected()) {
                            setting_PriceAtTheTop.click();
                        }
                    }
                    break;

                case "Отображать пустые звёзды рейтинга товара":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_EmptyStarsOfProductRating.isSelected()) {
                            setting_EmptyStarsOfProductRating.click();
                        }
                    } else {
                        if (!setting_EmptyStarsOfProductRating.isSelected()) {
                            setting_EmptyStarsOfProductRating.click();
                        }
                    }
                    break;

                case "Отображать общее значение рейтинга товара":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_CommonValueOfProductRating.isSelected()) {
                            setting_CommonValueOfProductRating.click();
                        }
                    } else {
                        if (!setting_CommonValueOfProductRating.isSelected()) {
                            setting_CommonValueOfProductRating.click();
                        }
                    }
                    break;

                case "Отображать кнопку \"Добавить в избранное\"":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_DisplayButtonWishList.isSelected()) {
                            setting_DisplayButtonWishList.click();
                        }
                    } else {
                        if (!setting_DisplayButtonWishList.isSelected()) {
                            setting_DisplayButtonWishList.click();
                        }
                    }
                    break;

                case "Отображать кнопку \"Добавить в список сравнения\"":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_DisplayButtonComparisonList.isSelected()) {
                            setting_DisplayButtonComparisonList.click();
                        }
                    } else {
                        if (!setting_DisplayButtonComparisonList.isSelected()) {
                            setting_DisplayButtonComparisonList.click();
                        }
                    }
                    break;

                case "Отображать \"Вы экономите\"":
                    setting_ShowYouSave.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
                    setting_ShowYouSave.selectOptionContainingText(value);
                    break;

                case "Отображать код товара":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ShowProductCode.isSelected()) {
                            setting_ShowProductCode.click();
                        }
                    } else {
                        if (!setting_ShowProductCode.isSelected()) {
                            setting_ShowProductCode.click();
                        }
                    }
                    break;

                case "Отображать статус наличия":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_DisplayAvailabilityStatus.isSelected()) {
                            setting_DisplayAvailabilityStatus.click();
                        }
                    } else {
                        if (!setting_DisplayAvailabilityStatus.isSelected()) {
                            setting_DisplayAvailabilityStatus.click();
                        }
                    }
                    break;

                case "Отображать модификатор количества":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ShowQuantityChanger.isSelected()) {
                            setting_ShowQuantityChanger.click();
                        }
                    } else {
                        if (!setting_ShowQuantityChanger.isSelected()) {
                            setting_ShowQuantityChanger.click();
                        }
                    }
                    break;

                case "Отображать кнопку \"Купить\"":
                    setting_ShowAddToCartButton.selectOptionContainingText(value);
                    break;

                case "Дополнительная информация о товаре":
                    setting_AdditionalProductInformation.selectOptionContainingText(value);
                    break;

                case "Отображать стандартную галерею изображений":
                    setting_ShowStandardImageGallery_Grid.selectOptionContainingText(value);
                    break;
            }
        }
    }
}