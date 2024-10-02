package steps.adminPanel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class LayoutPage {
    public LayoutPage(){super();}

    public static String blockID;


    SelenideElement button_SettingsOfTemplate = $("a[id^='sw_case_settings_']");
    SelenideElement button_SaveBlockProperties = $("input[name='dispatch[block_manager.update_block]']");
    SelenideElement popupWindow = $(".ui-dialog-title");
    SelenideElement button_SaveLayoutSettings = $("input[name='dispatch[block_manager.grid.update]']");
    SelenideElement setting_UseDelayedLoadingOfSection = $("input[id^='elm_grid_abt__ut2_use_lazy_load']");

    //Настройки блока товаров
    SelenideElement blockTemplate = $("select[id$='_products_template']");
    SelenideElement checkbox_ShowItemNumber = $("input[id$='_products_properties_item_number']");
    SelenideElement field_NumberOfColumnsInList = $("input[id$='_products_properties_number_of_columns']");
    SelenideElement setting_LoadingType = $("select[id$='_products_properties_abt__ut2_loading_type']");
    SelenideElement tabOfBlock_Content = $("li[id^='block_contents_'] a");
    SelenideElement setting_Filling = $("select[id$='_content_items_filling']");
    SelenideElement field_Limit = $("input[id$='_content_items_properties_items_limit']");
    SelenideElement tabOfBlock_BlockSettings = $("li[id^='block_settings_']");
    SelenideElement checkbox_HideAddToCartButton = $("input[id$='_products_properties_hide_add_to_cart_button']");


    @Given("Переходим во вкладку {string}, что на странице 'Макеты'")
    public void navigateTo_LayoutTab(String tabName) {
        $x("//ul[@class='nav nav-tabs']//a[text()='" + tabName + "']").click();
    }

    @Given("Выключаем LazyLoad в секции с блоком {string}")
    public void disableLazyLoadFromSection(String blockName) {
        SelenideElement layoutProperties = $("div[data-ca-block-name='" + blockName + "'] ~ div[class*='grid-control-menu'] div[class*='bm-action-properties']");
        executeJavaScript("arguments[0].scrollIntoView(true);", layoutProperties);
        executeJavaScript("arguments[0].click();", layoutProperties);

        $(".ui-dialog-title").shouldBe(Condition.exist);
        if(setting_UseDelayedLoadingOfSection.isSelected())
            setting_UseDelayedLoadingOfSection.click();
        button_SaveLayoutSettings.click();
    }

    @Given("Получаем ID блока {string}")
    public void getBlockID(String blockName) {
        sleep(2000);
        blockID = $("div[title='" + blockName + "'] small[data-ca-block-manager='block_id']").getText().trim().split("#")[1];
        System.out.println("ID блока '" + blockName + "': " + blockID);
    }

    @And("Переходим в настройки блока {string}")
    public void navigateToBlockSettings(String blockName) {
        SelenideElement blockProperties = $("div[data-ca-block-name='" + blockName + "']").$(".bm-action-properties");
        executeJavaScript("arguments[0].scrollIntoView(true);", blockProperties);
        executeJavaScript("arguments[0].click();", blockProperties);
        popupWindow.shouldBe(Condition.exist);
    }

    @And("Выбираем шаблон блока {string} и нажимаем кнопку 'Настройки'")
    public void selectTemplateForBlock(String templateName) {
        blockTemplate.selectOptionContainingText(templateName);
        sleep(2000);
        button_SettingsOfTemplate.click();
    }

    @And("Устанавливаем настройки блока:")
    public void setBlockSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Показать номер элемента":
                    if (value.equalsIgnoreCase("n")) {
                        if (checkbox_ShowItemNumber.isSelected()) {
                            checkbox_ShowItemNumber.click();
                        }
                    } else {
                        if (!checkbox_ShowItemNumber.isSelected()) {
                            checkbox_ShowItemNumber.click();
                        }
                    }
                    break;

                case "Количество колонок в списке":
                    field_NumberOfColumnsInList.click();
                    field_NumberOfColumnsInList.clear();
                    field_NumberOfColumnsInList.setValue(value);
                    break;

                case "Тип загрузки":
                    setting_LoadingType.selectOptionContainingText(value);
                    break;

                case "Заполнение":
                    tabOfBlock_Content.click();
                    setting_Filling.selectOptionContainingText(value);
                    break;

                case "Макс. число элементов":
                    field_Limit.click();
                    field_Limit.clear();
                    field_Limit.setValue(value);
                    break;

                case "Спрятать кнопку добавления":
                    tabOfBlock_BlockSettings.click();
                    if (value.equalsIgnoreCase("n")) {
                        if (checkbox_HideAddToCartButton.isSelected()) {
                            checkbox_HideAddToCartButton.click();
                        }
                    } else {
                        if (!checkbox_HideAddToCartButton.isSelected()) {
                            checkbox_HideAddToCartButton.click();
                        }
                    }
                    break;

                default:
                    System.out.println("Неизвестная настройка: " + setting);
                    break;
            }
        }
    }

    @Then("Сохраняем настройки блока")
    public void saveBlockSettings() {
        button_SaveBlockProperties.click();
    }
}