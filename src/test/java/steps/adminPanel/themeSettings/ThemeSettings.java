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
    SelenideElement setting_DisplayButtonWishList = $(By.id("settings.abt__ut2.product_list.button_wish_list_view.desktop"));
    SelenideElement setting_DisplayButtonComparisonList = $(By.id("settings.abt__ut2.product_list.button_compare_view.desktop"));
    SelenideElement setting_DisplayButtonsWhenHoveringMouse = $(By.id("settings.abt__ut2.product_list.hover_buttons_w_c_q.desktop"));
    SelenideElement setting_ShowYouSave = $(By.id("settings.abt__ut2.product_list.show_you_save.desktop"));
    SelenideElement setting_ShowProductCode = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_sku.desktop']");
    SelenideElement setting_DisplayAvailabilityStatus = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_amount.desktop']");
    SelenideElement setting_ShowQuantityChanger = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_qty.desktop']");
    SelenideElement setting_ShowAddToCartButton = $("select[id='settings.abt__ut2.product_list.products_multicolumns.show_button_add_to_cart.desktop']");
    SelenideElement setting_AdditionalProductInformation = $("select[id='settings.abt__ut2.product_list.products_multicolumns.grid_item_bottom_content.desktop']");
    SelenideElement setting_ShowAdditionalInformationOnHover = $("input[id='settings.abt__ut2.product_list.products_multicolumns.show_content_on_hover.desktop']");
    SelenideElement setting_ShowBrandLogo = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_brand_logo.desktop"));
    SelenideElement setting_ShowStandardImageGallery_Grid = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_gallery.desktop"));
    SelenideElement setting_SwitchProductImageWhenHovering = $(By.id("settings.abt__ut2.product_list.products_multicolumns.enable_hover_gallery.desktop"));


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

                case "Отображать кнопку \"Добавить в список сравнения\" ":
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

                case "Отображать кнопки \"Быстрый просмотр, Добавить в избранное, Добавить в список сравнения\" при наведении на ячейку товара":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_DisplayButtonsWhenHoveringMouse.isSelected()) {
                            setting_DisplayButtonsWhenHoveringMouse.click();
                        }
                    } else {
                        if (!setting_DisplayButtonsWhenHoveringMouse.isSelected()) {
                            setting_DisplayButtonsWhenHoveringMouse.click();
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

                case "Отображать дополнительную информацию при наведении":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ShowAdditionalInformationOnHover.isSelected()) {
                            setting_ShowAdditionalInformationOnHover.click();
                        }
                    } else {
                        if (!setting_ShowAdditionalInformationOnHover.isSelected()) {
                            setting_ShowAdditionalInformationOnHover.click();
                        }
                    }
                    break;

                case "Отображать логотип бренда":
                    if (value.equalsIgnoreCase("n")) {
                        if (setting_ShowBrandLogo.isSelected()) {
                            setting_ShowBrandLogo.click();
                        }
                    } else {
                        if (!setting_ShowBrandLogo.isSelected()) {
                            setting_ShowBrandLogo.click();
                        }
                    }
                    break;

                case "Отображать стандартную галерею изображений":
                    setting_ShowStandardImageGallery_Grid.selectOptionContainingText(value);
                    break;

                case "Переключать изображение товара при движении мышки":
                    setting_SwitchProductImageWhenHovering.selectOptionContainingText(value);
                    break;
            }
        }
    }
}