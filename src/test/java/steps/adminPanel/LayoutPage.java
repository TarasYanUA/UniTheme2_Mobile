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
    public LayoutPage() {
        super();
    }

    public static String blockID;


    SelenideElement button_SettingsOfTemplate = $("a[id^='sw_case_settings_']");
    SelenideElement button_SaveBlockProperties = $("input[name='dispatch[block_manager.update_block]']");
    SelenideElement popupWindow = $(".ui-dialog-title");
    SelenideElement button_SaveLayoutSettings = $("input[name='dispatch[block_manager.grid.update]']");
    SelenideElement setting_UseDelayedLoadingOfSection = $("input[id^='elm_grid_abt__ut2_use_lazy_load']");
    SelenideElement button_CreateNewBlock = $("#opener_block_type_list");


    //Настройки блока товаров
    SelenideElement blockTemplate = $("select[id$='_products_template']");
    SelenideElement checkbox_ShowItemNumber = $("input[id$='_products_properties_item_number']");
    SelenideElement field_NumberOfColumnsInList = $("input[id$='_products_properties_number_of_columns']");
    SelenideElement setting_LoadingType = $("select[id$='_products_properties_abt__ut2_loading_type']");
    SelenideElement setting_ShowPrice = $("input[id$='_products_properties_show_price']");
    SelenideElement setting_EnableQuickView = $("input[id$='_products_properties_enable_quick_view']");
    SelenideElement setting_DoNotScrollAutomatically = $("input[id$='_products_properties_not_scroll_automatically']");
    SelenideElement setting_ItemQuantity_Mobile = $("input[id*='_products_properties_item_quantity_mobile']");
    SelenideElement setting_OutsideNavigation = $("input[id$='_products_properties_outside_navigation']");
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
        sleep(2000);
        setting_UseDelayedLoadingOfSection.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        if (setting_UseDelayedLoadingOfSection.isSelected())
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

    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки блока:")
    public void setBlockSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Показать номер элемента":
                    setCheckboxState(checkbox_ShowItemNumber, value);
                    break;

                case "Количество колонок в списке":
                    field_NumberOfColumnsInList.setValue(value);
                    break;

                case "Тип загрузки":
                    setting_LoadingType.selectOptionContainingText(value);
                    break;

                case "Показывать цену":
                    setCheckboxState(setting_ShowPrice, value);
                    break;

                case "Включить быстрый просмотр":
                    setCheckboxState(setting_EnableQuickView, value);
                    break;

                case "Не прокручивать автоматически":
                    setCheckboxState(setting_DoNotScrollAutomatically, value);
                    break;

                case "Количество элементов (мобильный)":
                    setting_ItemQuantity_Mobile.setValue(value);
                    break;

                case "Внешняя навигация":
                    setting_OutsideNavigation.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
                    setCheckboxState(setting_OutsideNavigation, value);
                    break;

                // Настройки вкладки "Контент"
                case "Заполнение":
                    tabOfBlock_Content.click();
                    setting_Filling.selectOptionContainingText(value);
                    break;

                case "Макс. число элементов":
                    field_Limit.setValue(value);
                    break;

                // Настройки вкладки "Настройки блока"
                case "Спрятать кнопку добавления":
                    tabOfBlock_BlockSettings.click();
                    setCheckboxState(checkbox_HideAddToCartButton, value);
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

    @Given("Переходим на страницу {string}, что на странице 'Макеты'")
    public void navigateTo_BlocksPage(String pageName) {
        BasicPage.sideBar.click();
        $x("//a[text()='" + pageName + "']").click();
    }

    @And("Создаём блок с шаблоном {string}")
    public void createNewBlock(String blockTemplate) {
        button_CreateNewBlock.click();
        $("strong[title='" + blockTemplate +"']").click();
        $("input[name='block_data[description][name]']").setValue("111 Контакты (ручное наполнение)");
        button_SettingsOfTemplate.click();
        sleep(1000);
        SelenideElement setting_ShowContentInSidebar = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_open_right_panel]']");
        if(setting_ShowContentInSidebar.isSelected())
            setting_ShowContentInSidebar.click();
        SelenideElement setting_DisplayRequestCallButton = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_show_call_request_button]']");
        if(!setting_DisplayRequestCallButton.isSelected())
            setting_DisplayRequestCallButton.click();
        SelenideElement setting_DisplayButtonsOnSocialNetworks = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_show_social_buttons]']");
        if(!setting_DisplayButtonsOnSocialNetworks.isSelected())
            setting_DisplayButtonsOnSocialNetworks.click();
        $("li[id*='block_contents_']").click();
        $("input[name='block_data[content][phone_1]']").setValue("+380938941111");
        $("input[name='block_data[content][phone_2]']").setValue("+380938942222");
        $("input[name='block_data[content][phone_3]']").setValue("+380938943333");
        $("input[name='block_data[content][email]']").setValue("myemail@ukr.net");
        $("textarea[name='block_data[content][working_hours]']").setValue("from 9 a.m. to 8 p.m. every day except Saturday");
        $("textarea[name='block_data[content][address]']").setValue("Юридична адреса. 03026, м. Київ, шосе Столичне 103 корп. 1, пов. 9");
        button_SaveBlockProperties.click();
    }

    @Given("Получаем ID блока {string} на странице 'Блоки'")
    public void getBlockIDFrom_BlocksPage(String blockName) {
        blockID = $x("//input[@value='" + blockName + "']/../span/small").getText().trim().split("#")[1];
        System.out.println("ID блока '" + blockName + "': " + blockID);
    }
}