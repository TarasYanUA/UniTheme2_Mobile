package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import java.util.List;
import static com.codeborne.selenide.Selenide.$;

public class ThemeSettings_Product {
    SelenideElement setting_CustomBlockID = $(By.id("settings.abt__ut2.products.custom_block_id"));
    SelenideElement setting_ProductImageWidth = $(By.id("settings.abt__ut2.products.view.image_width.mobile"));
    SelenideElement setting_ProductImageHeight = $(By.id("settings.abt__ut2.products.view.image_height.mobile"));
    SelenideElement setting_ShowQuantityChanger = $(By.id("settings.abt__ut2.products.view.show_qty.mobile"));
    SelenideElement setting_ShowProductCode = $(By.id("settings.abt__ut2.products.view.show_sku.mobile"));
    SelenideElement setting_ShowProductFeatures = $(By.id("settings.abt__ut2.products.view.show_features.mobile"));
    SelenideElement setting_FeaturesInTwoColumns = $(By.id("settings.abt__ut2.products.view.show_features_in_two_col.mobile"));
    SelenideElement setting_ShowShortDescription = $(By.id("settings.abt__ut2.products.view.show_short_description.mobile"));
    SelenideElement setting_ShowYouSave = $(By.id("settings.abt__ut2.products.view.show_you_save.mobile"));
    SelenideElement setting_ShowStickyBlockAddToCart = $(By.id("settings.abt__ut2.products.view.show_sticky_panel_add_to_cart.mobile"));
    SelenideElement setting_ShowProductBrand = $(By.id("settings.abt__ut2.products.view.show_brand_format.mobile"));
    SelenideElement setting_AppearanceOfImageGallery = $(By.id("settings.abt__ut2.products.view.thumbnails_gallery_format.mobile"));
    SelenideElement setting_ShowShareButtons = $(By.id("settings.abt__ut2.products.addon_social_buttons.view.mobile"));


    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки темы, вкладка 'Товар':")
    public void setThemeSettings_ProductPage(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "ID пользовательского блока" -> setting_CustomBlockID.setValue(value);
                case "Ширина изображения товара" -> setting_ProductImageWidth.setValue(value);
                case "Высота изображения товара" -> setting_ProductImageHeight.setValue(value);
                case "Отображать модификатор количества" -> setCheckboxState(setting_ShowQuantityChanger, value);
                case "Отображать код товара" -> setCheckboxState(setting_ShowProductCode, value);
                case "Отображать характеристики товара" -> setCheckboxState(setting_ShowProductFeatures, value);
                case "Отображать характеристики в две колонки" -> setCheckboxState(setting_FeaturesInTwoColumns, value);
                case "Отображать краткое описание" -> setCheckboxState(setting_ShowShortDescription, value);
                case "Отображать \"Вы экономите\"" -> setting_ShowYouSave.selectOptionContainingText(value);
                case "Отображать липкий блок Купить" -> setting_ShowStickyBlockAddToCart.selectOptionContainingText(value);
                case "Отображать информацию о бренде товара" -> setting_ShowProductBrand.selectOptionContainingText(value);
                case "Внешний вид галереи изображений" -> setting_AppearanceOfImageGallery.selectOptionContainingText(value);
                case "Отображать кнопки социальных сетей" -> setCheckboxState(setting_ShowShareButtons, value);
            }
        }
    }
}
