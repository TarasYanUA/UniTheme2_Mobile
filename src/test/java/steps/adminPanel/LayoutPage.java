package steps.adminPanel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static steps.adminPanel.UtilsAdmPanel.setCheckboxState;

public class LayoutPage {
    public LayoutPage() {
        super();
    }

    public static String blockID;
    public static String sectionID;
    public static String blockStatus;
    public static String blockAvailability;

    SelenideElement button_SaveBlockProperties = $("input[name='dispatch[block_manager.update_block]']");
    SelenideElement popupWindow = $(".ui-dialog-title");
    SelenideElement button_SaveLayoutSettings = $("input[name='dispatch[block_manager.grid.update]']");
    SelenideElement setting_UseDelayedLoadingOfSection = $("input[id^='elm_grid_abt__ut2_use_lazy_load']");
    SelenideElement button_CreateNewBlock = $("#opener_block_type_list");
    SelenideElement blockTab_CreateNewBlock = $("li[id*='create_new_blocks_']");
    SelenideElement field_blockName = $("input[name='block_data[description][name]']");
    SelenideElement blockTemplate = $("select[name='block_data[properties][template]']");

    //Настройки блока товаров
    SelenideElement button_SettingsOfTemplate = $("a[id^='sw_case_settings_']");
    SelenideElement checkbox_ShowItemNumber = $("input[id$='_products_properties_item_number']");
    SelenideElement field_NumberOfColumnsInList = $("input[id$='_products_properties_number_of_columns']");
    SelenideElement setting_LoadingType = $("select[id$='_products_properties_abt__ut2_loading_type']");
    SelenideElement setting_ShowPrice = $("input[id$='_products_properties_show_price']");
    SelenideElement setting_DoNotScrollAutomatically = $("input[id$='_products_properties_not_scroll_automatically']");
    SelenideElement setting_ItemQuantity_Mobile = $("input[id*='_products_properties_item_quantity_mobile']");
    SelenideElement setting_OutsideNavigation = $("input[id$='_products_properties_outside_navigation']");
    SelenideElement tabOfBlock_Content = $("li[id^='block_contents_'] a");
    SelenideElement setting_Filling = $("select[id$='_content_items_filling']");
    SelenideElement field_Limit = $("input[id$='_content_items_properties_items_limit']");
    SelenideElement tabOfBlock_BlockSettings = $("li[id^='block_settings_']");
    SelenideElement checkbox_HideAddToCartButton = $("input[id$='_products_properties_hide_add_to_cart_button']");
    SelenideElement checkbox_OpenMenuWithButton = $("input[id*='menu_properties_open_on_sticky_panel_button']");


    public void saveLayoutSettings() {
        button_SaveLayoutSettings.click();
        sleep(1500);
    }

    public void navigateTo_LayoutTab(String tabName) {
        $x("//ul[@class='nav nav-tabs']//a[text()='" + tabName + "']").click();
    }

    public void disableLazyLoadFromSection(String blockName) {
        SelenideElement layoutProperties = $("div[data-ca-block-name='" + blockName + "'] ~ div[class*='grid-control-menu'] div[class*='bm-action-properties']");
        executeJavaScript("arguments[0].scrollIntoView(true);", layoutProperties);
        executeJavaScript("arguments[0].click();", layoutProperties);
        popupWindow.shouldBe(Condition.exist);
        sleep(2000);
        setting_UseDelayedLoadingOfSection.scrollIntoCenter();
        UtilsAdmPanel.setCheckboxState(setting_UseDelayedLoadingOfSection, "n");

        if (!$("input[id*='show_on_phone'][checked='checked']").exists())
            $("label[for*='show_on_phone']").click();
        saveLayoutSettings();
    }

    public void getBlockID(String blockName) {
        blockID = $("div[title='" + blockName + "'] small[data-ca-block-manager='block_id']").getText().trim().split("#")[1];
        System.out.println("ID блока '" + blockName + "': " + blockID);
    }

    public void getSectionID(String blockName) {
        sectionID = $x("//div[contains(@title, '" + blockName + "')]/../..").getAttribute("id");
        System.out.println("ID секции: " + sectionID);
    }

    public void getBlockStatusAndBlockAvailability(String blockName) {
        blockStatus = $("div[data-ca-block-name='" + blockName + "']").getAttribute("data-ca-status");
        blockAvailability = $("div[data-ca-block-name='" + blockName + "']").getAttribute("data-ca-device-availability-phone");
    }

    public void navigateToBlockSettings(String blockName) {
        SelenideElement blockProperties = $("div[data-ca-block-name='" + blockName + "']").$(".bm-action-properties");
        executeJavaScript("arguments[0].scrollIntoView(true);", blockProperties);
        executeJavaScript("arguments[0].click();", blockProperties);
    }

    public void selectTemplateForBlock(String templateName) {
        blockTemplate.selectOptionContainingText(templateName);
        sleep(3000);
        if (button_SettingsOfTemplate.exists())
            button_SettingsOfTemplate.click();
    }

    public void setBlockSettings(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Показать номер элемента" -> setCheckboxState(checkbox_ShowItemNumber, value);
                case "Количество колонок в списке" -> field_NumberOfColumnsInList.setValue(value);
                case "Тип загрузки" -> setting_LoadingType.selectOptionContainingText(value);
                case "Показывать цену" -> setCheckboxState(setting_ShowPrice, value);
                case "Не прокручивать автоматически" -> setCheckboxState(setting_DoNotScrollAutomatically, value);
                case "Количество элементов (мобильный)" -> setting_ItemQuantity_Mobile.setValue(value);
                case "Внешняя навигация" -> {
                    setting_OutsideNavigation.scrollIntoCenter();
                    setCheckboxState(setting_OutsideNavigation, value);
                }

                // Настройки вкладки "Контент"
                case "Заполнение" -> {
                    tabOfBlock_Content.click();
                    setting_Filling.selectOptionContainingText(value);
                }
                case "Макс. число элементов" -> field_Limit.setValue(value);

                // Настройки вкладки "Настройки блока"
                case "Спрятать кнопку добавления" -> {
                    tabOfBlock_BlockSettings.click();
                    setCheckboxState(checkbox_HideAddToCartButton, value);
                }
                case "Открывать это меню кнопкой" -> {
                    tabOfBlock_BlockSettings.click();
                    setCheckboxState(checkbox_OpenMenuWithButton, value);
                }

                default -> throw new IllegalArgumentException("Неизвестная настройка: " + setting);
            }
        }
    }

    public void saveBlockSettings() {
        button_SaveBlockProperties.click();
        sleep(1500);
    }

    public void navigateTo_BlocksPage(String pageName) {
        BasicPage.sideBar.click();
        $x("//a[text()='" + pageName + "']").click();
    }

    public void createBlock_ContactsManualFilling(String blockTemplate) {
        button_CreateNewBlock.click();
        $("strong[title='" + blockTemplate + "']").click();
        field_blockName.setValue("111 Контакты (ручное наполнение)");
        button_SettingsOfTemplate.click();
        sleep(1000);
        SelenideElement setting_ShowContentInSidebar = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_open_right_panel]']");
        UtilsAdmPanel.setCheckboxState(setting_ShowContentInSidebar, "n");
        SelenideElement setting_DisplayRequestCallButton = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_show_call_request_button]']");
        UtilsAdmPanel.setCheckboxState(setting_DisplayRequestCallButton, "y");
        SelenideElement setting_DisplayButtonsOnSocialNetworks = $("input[type='checkbox'][name='block_data[properties][abt__ut2__block_contacts_show_social_buttons]']");
        UtilsAdmPanel.setCheckboxState(setting_DisplayButtonsOnSocialNetworks, "y");
        $("li[id*='block_contents_']").click();
        $("input[name='block_data[content][phone_1]']").setValue("+380938941111");
        $("input[name='block_data[content][phone_2]']").setValue("+380938942222");
        $("input[name='block_data[content][phone_3]']").setValue("+380938943333");
        $("input[name='block_data[content][email]']").setValue("myemail@ukr.net");
        $("textarea[name='block_data[content][working_hours]']").setValue("from 9 a.m. to 8 p.m. every day except Saturday");
        $("textarea[name='block_data[content][address]']").setValue("Юридична адреса. 03026, м. Київ, шосе Столичне 103 корп. 1, пов. 9");
        saveBlockSettings();
    }

    public void getBlockIDFrom_BlocksPage(String blockName) {
        blockID = $x("//input[@value='" + blockName + "']/../span/small").getText().trim().split("#")[1];
        System.out.println("ID блока '" + blockName + "': " + blockID);
    }

    public void createNewBlock(String status, String blockType, String blockName) {
        String blockTypeAsName = "Auto: " + blockType;
        String fullBlockName = "Auto: " + blockName;
        if (!$("div[title='" + blockTypeAsName + "']").exists() &&
                !$("div[title='" + fullBlockName + "']").exists()) {
            String layout = "div[id='" + sectionID + "'] ";
            SelenideElement buttonPlus = $(layout + ".cs-icon--type-plus");
            executeJavaScript("var evt = new MouseEvent('mouseover', { bubbles: true, cancelable: true, view: window });" +
                    " arguments[0].dispatchEvent(evt);", buttonPlus);
            executeJavaScript("arguments[0].click();", buttonPlus);
            $(layout + ".bm-action-add-block").shouldBe(Condition.clickable).click();
            $(".ui-dialog-titlebar").shouldBe(Condition.visible);
            if (status.equalsIgnoreCase("новый"))
                blockTab_CreateNewBlock.click();
            $("strong[title='" + blockType + "']").scrollIntoCenter().click();
            if (blockName.equals("")) {
                field_blockName.setValue(blockTypeAsName);
            } else {
                field_blockName.setValue(fullBlockName);
            }
            button_SaveBlockProperties.click();
        }
    }

    public void setBlock_OpenOnclickDropdownList() {
        tabOfBlock_Content.click();
        $("select[name='block_data[content][abt__ut2_block_id]']").selectOptionContainingText("#" + blockID);
        button_SaveBlockProperties.click();
    }

    public void activateBlock(String blockName) {
        if (!blockStatus.equalsIgnoreCase("active")) {
            SelenideElement buttonActive = $("div[data-ca-block-name='" + blockName + "']").$(".bm-action-switch");
            executeJavaScript("arguments[0].scrollIntoView(true);", buttonActive);
            executeJavaScript("arguments[0].click();", buttonActive);
            sleep(2000);
        }
    }

    public void setAvailabilityForMobile() {
        if (!blockAvailability.equalsIgnoreCase("true")) {
            $(".btn-group-checkbox__label .cs-icon--type-mobile-phone").scrollIntoCenter().click();
            executeJavaScript("window.scrollTo(0, 0);");
        }
    }
}