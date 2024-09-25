package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasicPage implements CheckMenuToBeActive {
    public BasicPage(){super();}

    SelenideElement button_Save_OnTop = $(".btn.btn-primary.cm-submit");
    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");

    SelenideElement section_Themes = $("a[href*='dispatch=themes.manage'].main-menu-1__link");
    SelenideElement menuOf_WebsiteThemes = $(".actions-menu__dropdown-toggle");
    SelenideElement section_Layouts = $(".actions-menu__dropdown-item-wrapper a[href$='block_manager.manage']");
    SelenideElement featureSetting_showInProductList = $("input[id='elm_feature_display_on_catalog_18']");

    SelenideElement button_Save_PopUpWindow = $(".ui-dialog-content input[value='Сохранить']");
    SelenideElement menu_Settings = $("#administration");

    @Given("Переходим на страницу \"Веб-сайт -- Темы -- Макеты\", вкладка {string}")
    public void navigateTo_LayoutPage(String tabName) {
        mobile_MainMenu.click();
        section_Themes.click();
        menuOf_WebsiteThemes.click();
        section_Layouts.click();
        $x("//a[text()='" + tabName + "']").click();
    }

    @Given("Переходим на страницу {string} -- {string}")
    public void navigateToSection_Features(String mainMenu, String section) {
        String menuElement = "//span[contains(@class, 'main-menu-1__link-content')][text()='" + mainMenu + "']";
        SelenideElement sectionElement = $x("//span[contains(@class, 'main-menu-2__link-content')][text()='" + section + "']");

        mobile_MainMenu.click();
        checkMenuToBeActive(menuElement);
        sectionElement.click();
    }

    @And("Переходим в настройки характеристики {string}")
    public void navigateTo_FeaturePage(String featureName) {
        $x("//a[contains(@href, 'feature_id=')][text()='" + featureName + "']").click();
    }

    @And("Устанавливаем настройки характеристики Бренд:")
    public void setSettingsOfFeature_Brand(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for(List<String> row: rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Показывать в списке товаров":
                    if(value.equalsIgnoreCase("n")){
                        if(featureSetting_showInProductList.isSelected())
                            featureSetting_showInProductList.click();
                    } else {
                        if(!featureSetting_showInProductList.isSelected())
                            featureSetting_showInProductList.click();
                    }
                    break;
            }
        }
    }

    @Then("Сохраняем выбранные настройки")
    public void saveSettings_SaveButtonOnTop() {
        button_Save_OnTop.click();
    }
}