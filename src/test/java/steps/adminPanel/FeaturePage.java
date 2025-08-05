package steps.adminPanel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;
import static steps.adminPanel.UtilsAdmPanel.setCheckboxState;

public class FeaturePage {
    public FeaturePage() { super(); }

    SelenideElement variationsAsOneProduct = $("label[for=\"elm_feature_purpose_549_group_variation_catalog_item\"] input");
    SelenideElement featureStyle = $(By.id("elm_feature_feature_style_549"));
    SelenideElement filterType = $(By.id("elm_feature_filter_style_549"));
    SelenideElement showOnTheFeaturesTab = $(By.id("elm_feature_display_on_product_18"));
    SelenideElement showInProductList = $(By.id("elm_feature_display_on_catalog_18"));
    SelenideElement colors_showInProductList = $(By.id("elm_feature_display_on_catalog_549"));
    SelenideElement showInHeaderOnTheProductDetailsPage = $(By.id("elm_feature_display_on_header_18"));
    SelenideElement hardDrive_ShowInHeaderOnTheProductDetailsPage = $(By.id("elm_feature_display_on_header_23"));
    SelenideElement hardDrive_FeatureDescription = $("label[for='elm_feature_description_23']");
    SelenideElement hardDrive_Html = $(".re-button.re-html.re-button-icon");
    SelenideElement htmlDescriptionOfFeature = $(".cm-skip-check-item.open");
    SelenideElement save_Feature = $(".buttons-container-picker input[name='dispatch[product_features.update]']");
    SelenideElement save_OnTop = $(".btn.btn-primary.cm-submit");
    SelenideElement tab_Variants = $(By.id("tab_feature_variants_549"));
    SelenideElement button_AddVariantList = $("button.variants-list__btn-add");
    SelenideElement featureColor = $("a[data-ca-external-click-id=\"opener_group549\"]");


    public void setSettingsOfFeature_Brand(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Вариации как один товар" -> variationsAsOneProduct.click();
                case "Внешний вид" -> featureStyle.selectOptionContainingText(value);
                case "Тип фильтра" -> filterType.selectOptionContainingText(value);
                case "Показывать во вкладке «Характеристики» карточки товара" ->
                        setCheckboxState(showOnTheFeaturesTab, value);
                case "Показывать в списке товаров" -> setCheckboxState(showInProductList, value);
                case "Цвет, Показывать в списке товаров" -> setCheckboxState(colors_showInProductList, value);
                case "Показывать в заголовке карточки товара" ->
                        setCheckboxState(showInHeaderOnTheProductDetailsPage, value);
                case "Жесткий диск, Показывать в заголовке карточки товара" ->
                        setCheckboxState(hardDrive_ShowInHeaderOnTheProductDetailsPage, value);

                default -> System.out.println("Неизвестная настройка: " + setting);
            }
        }
    }

    public void addDescriptionToFeature() {
        hardDrive_FeatureDescription.scrollIntoCenter().click();
        hardDrive_Html.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        htmlDescriptionOfFeature.setValue("Для характеристики, которая просто позволяет указать какое-нибудь дополнительное свойство товара. Например, у футболок это может быть \"Ткань\". Если вы создадите фильтр по этой характеристике, покупатели увидят, что она есть, и смогут легко найти по ней нужный товар.");
    }

    public void saveSettings_SaveButtonOnTop() {
        save_OnTop.click();
        sleep(1500);
    }

    public void saveSettings_Feature() {
        save_Feature.click();
    }

    public void setColorIfDefault(String color, String dataColor) {
        String actualColor = "//input[@value='" + color + "']/..";

        if ($x(actualColor + "//div[@style='background-color: rgb(255, 255, 255);']").exists()) {
            $x(actualColor + "//div[@class=\"sp-dd\"]").scrollIntoCenter().click();
            selectColor(dataColor);
        }
    }

    void selectColor(String dataColor) {
        ElementsCollection allPaletteContainers = $$(".sp-palette span[title='" + dataColor + "']");

        if (allPaletteContainers.isEmpty())
            throw new NoSuchElementException("No palette containers found for color: " + dataColor);

        SelenideElement targetColor = $x("//div[contains(@class, 'sp-active')]/..//div[@class='sp-palette-container']//span[@title='" + dataColor + "']");
        targetColor.shouldBe(Condition.clickable, Duration.ofSeconds(8)).click();

        SelenideElement buttonChoose = $x("//div[contains(@class, 'sp-active')]/..//button[@class='sp-choose']");
        buttonChoose.click();
    }

    public void setNewColor(String color, String dataColor) {
        String lastPicker = "//input[@id='feature_value_color_picker_" + findLastColorPickerNumber() + "']/..";
        $x(lastPicker + "//div[@class='sp-dd']").scrollIntoCenter().click();
        selectColor(dataColor);

        SelenideElement fieldName = $x(lastPicker + "/../..//input[contains(@name, '[variant]')]");
        fieldName.setValue(color);

        $x("//tr[@id='extra_feature_549_" + findLastColorPickerNumber() + "']/..//a[@name='add']")
                .click();
    }

    @Nullable
    private String findLastColorPickerNumber() {
        ElementsCollection colorPickers = $$("input[id*='feature_value_color_picker_']");

        return colorPickers.stream()
                .sorted(Comparator.comparing(el -> {
                    String id = el.getAttribute("id");
                    if (id == null || !id.contains("feature_value_color_picker_")) {
                        throw new IllegalStateException("Invalid ID format: " + id);
                    }
                    String numberPart = id.replaceAll(".*feature_value_color_picker_", "");
                    return Long.parseLong(numberPart.split("_")[0]);
                }))
                .reduce((first, second) -> second) // получить последний элемент
                .map(el -> {
                    String id = el.getAttribute("id");
                    assert id != null;
                    return id.replaceAll(".*feature_value_color_picker_", "");
                })
                .orElseThrow(() -> new NoSuchElementException("No elements in colorPickers"));
    }

    public void setMulticolor(String color, String dataColorOne, String dataColorTwo) {
        featureColor.click();
        tab_Variants.click();
        button_AddVariantList.click();

        String lastPicker = "//tbody[@id='box_add_variants_for_existing_549']";

        $x(lastPicker + "//select[contains(@name, '[abt__ut2_color_style]')]")
                .selectOptionByValue("multicolor");

        SelenideElement firstColorPicker = $x(lastPicker + "//div[contains(@class, 'first-color')]//div[@class='sp-dd']");
        firstColorPicker.click();
        selectColor(dataColorOne);

        SelenideElement secondColorPicker = $x(lastPicker + "//div[contains(@class, 'second-color')]//div[@class='sp-dd']");
        secondColorPicker.click();
        selectColor(dataColorTwo);

        SelenideElement fieldName = $x(lastPicker + "//input[contains(@name, '[variant]')]");
        fieldName.setValue(color);

        saveSettings_Feature();
    }

    public void setThumbnail(String name, String imageUrl) {
        featureColor.click();
        tab_Variants.click();
        button_AddVariantList.click();

        String lastPicker = "//tbody[@id='box_add_variants_for_existing_549']";
        SelenideElement fieldName = $x(lastPicker + "//input[contains(@name, '[variant]')]");
        fieldName.setValue(name);

        $x(lastPicker + "//select[contains(@name, '[abt__ut2_color_style]')]")
                .selectOptionByValue("thumbnail");

        SelenideElement button_Url = $x(lastPicker + "//a[contains(@id, 'url_')]");
        button_Url.click();
        Alert alert = webdriver().driver().switchTo().alert();
        alert.sendKeys(imageUrl);
        alert.accept();

        saveSettings_Feature();
    }
}