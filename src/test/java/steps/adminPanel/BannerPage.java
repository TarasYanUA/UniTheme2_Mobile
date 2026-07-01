package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BannerPage {
    SelenideElement button_PlusBanner = $(".nav__actions-adv-buttons a");
    SelenideElement button_AddAdvancedBanner = $("a[href*='dispatch=banners.add&type=abt__ut2']");
    SelenideElement button_CreateBanner = $("a[data-ca-dispatch='dispatch[banners.update]']");
    SelenideElement field_BannerName = $(By.id("elm_banner_name"));
    SelenideElement setting_BannerBlockSettings_VerticalAlignment = $(By.id("elm_banner_abt__ut2_content_valign"));
    SelenideElement setting_BannerBlockSettings_HorizontalAlignment = $(By.id("elm_banner_abt__ut2_content_align"));
    SelenideElement setting_ContentOnFullWidth = $(By.id("elm_banner_abt__ut2_content_full_width"));
    SelenideElement field_BannerTitle = $(By.id("elm_banner_abt__ut2_title"));
    SelenideElement setting_ObjectInside_DisplayedObject = $(By.id("elm_banner_abt__ut2_object"));
    SelenideElement setting_ObjectInside_Template = $(By.id("elm_banner_abt__ut2_products_template"));
    SelenideElement setting_ObjectInside_ColumnsForGrid = $(By.id("elm_banner_abt__ut2_products_grid_columns"));
    SelenideElement setting_ObjectInside_ColumnsForSmallElements = $(By.id("elm_banner_abt__ut2_products_small_items_columns"));
    SelenideElement setting_ObjectInside_ColumnsForThumbnails = $(By.id("elm_banner_abt__ut2_products_links_thumb_columns"));
    SelenideElement setting_ObjectInside_RowsForSmallElements = $(By.id("elm_banner_abt__ut2_products_small_items_rows"));
    SelenideElement setting_ObjectInside_RowsForThumbnails = $(By.id("elm_banner_abt__ut2_products_links_thumb_rows"));
    SelenideElement setting_ObjectInside_ProductPicker = $("a[data-ca-external-click-id='opener_picker_object_picker_advanced_elm_banner_abt__ut2_products_list']");
    SelenideElement field_searchProduct = $(".sidebar-field input[name='q']");
    SelenideElement button_SearchProduct = $("input[value='Найти']");
    SelenideElement checkboxOfProduct = $("input[name='add_products_ids[]']");
    SelenideElement button_AddSelectedProducts = $("input[value='Добавить товары']");
    SelenideElement button_AddSelectedProductsAndClose = $("input[value='Добавить товары и закрыть']");
    SelenideElement checkbox_BannerBackground_BackgroundColor = $(By.id("elm_banner_abt__ut2_background_color_use"));
    SelenideElement colorPicker_BannerBackground_BackgroundColor = $("#overlay_abt__ut2_background_color .sp-replacer");
    SelenideElement printColorCode_BannerBackground = $("#overlay_abt__ut2_background_color .sp-input");
    SelenideElement button_BannerBackground_ChooseColor = $("#overlay_abt__ut2_background_color .sp-choose");


    @And("Создаём новый баннер с товарами: {string}, {string}, {string}, {string}, {string}")
    public void createNewAdvancedBannerWithProducts(String bannerName,
                                                    String template,
                                                    String columns,
                                                    String rows,
                                                    String backgroundColor) {
        if (rows.isEmpty())
            rows = null;

        if (!$x("//a[text()='" + bannerName + "']").exists()) {
            UtilsAdmPanel.closeAllNotifications();
            button_PlusBanner.click();
            button_AddAdvancedBanner.click();
            field_BannerName.setValue(bannerName);
            setting_BannerBlockSettings_VerticalAlignment.selectOptionByValue("center");
            setting_BannerBlockSettings_HorizontalAlignment.selectOptionByValue("center");
            UtilsAdmPanel.setCheckboxState(setting_ContentOnFullWidth, "y");

            field_BannerTitle.setValue(bannerName);
            setting_ObjectInside_DisplayedObject.selectOptionByValue("products");
            setting_ObjectInside_Template.selectOptionByValue(template);
            sleep(500);

            SelenideElement selectColumns = switch (template) {
                case "grid_items" -> setting_ObjectInside_ColumnsForGrid;
                case "small_items" -> setting_ObjectInside_ColumnsForSmallElements;
                case "links_thumb" -> setting_ObjectInside_ColumnsForThumbnails;
                default -> throw new IllegalArgumentException("Unknown banner template for columns: " + template);
            };
            selectColumns.selectOptionByValue(columns);

            if (rows != null) {
                SelenideElement selectRows = switch (template) {
                    case "small_items" -> setting_ObjectInside_RowsForSmallElements;
                    case "links_thumb" -> setting_ObjectInside_RowsForThumbnails;
                    default -> throw new IllegalArgumentException("Unknown banner template for rows: " + template);
                };
                selectRows.selectOptionByValue(rows);
            }

            selectProductsForBanner();
            executeJavaScript("arguments[0].scrollIntoView(true);", checkbox_BannerBackground_BackgroundColor);
            executeJavaScript("arguments[0].click();", checkbox_BannerBackground_BackgroundColor);
            executeJavaScript("arguments[0].click();", colorPicker_BannerBackground_BackgroundColor);
            printColorCode_BannerBackground.setValue(backgroundColor);
            button_BannerBackground_ChooseColor.click();
            executeJavaScript("arguments[0].click();", button_CreateBanner);
            sleep(2000);
        }
    }

    public void selectProductsForBanner() {
        executeJavaScript("arguments[0].scrollIntoView(true);", setting_ObjectInside_ProductPicker);
        executeJavaScript("arguments[0].click();", setting_ObjectInside_ProductPicker);
        UtilsAdmPanel.waitForVisibilityOfPopupWindow();

        String[] products = {
                "adizero Rush Shoes",
                "Apple - iPhone 5c 32GB Cell Phone",
                "Apple iPad 2",
                "X-Box 360",
                "GoPro - Hero3",
                "Samsung NX200"
        };
        for (String product : products) {
            field_searchProduct.setValue(product);
            button_SearchProduct.click();
            sleep(500);
            if (checkboxOfProduct.exists()) {
                checkboxOfProduct.click();
                executeJavaScript("arguments[0].scrollIntoView(true);", button_AddSelectedProducts);
                executeJavaScript("arguments[0].click();", button_AddSelectedProducts);
            }
        }
        executeJavaScript("arguments[0].click();", button_AddSelectedProductsAndClose);
        UtilsAdmPanel.waitForPopupWindowDisappear();
    }
}