package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class BasicPage implements CheckMenuToBeActive {
    public BasicPage(){super();}

    SelenideElement button_Save_OnTop = $(".btn.btn-primary.cm-submit");
    SelenideElement button_Save_OnTop_Other = $(".nav__actions-btn-save");
    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");
    public static SelenideElement sideBar = $(".sidebar-toggle");
    SelenideElement menuOf_WebsiteThemes = $(".actions-menu__dropdown-toggle");
    SelenideElement menuOf_Settings = $(By.id("administration"));
    SelenideElement featureSetting_showInProductList = $("input[id='elm_feature_display_on_catalog_18']");


    @Given("Переходим на страницу {string}, что на странице 'Темы'")
    public void navigateTo_PageName_FromThemes(String pageName) {
        menuOf_WebsiteThemes.click();
        $x("//ul[@id='tools_list_actions_menu']//span[text()='" + pageName + "']").click();
    }

    @Given("Переходим на страницу {string} -- {string}")
    public void navigateTo_SectionOfMainMenu(String mainMenu, String section) {
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

    @Given("Переходим на страницу 'Настройки', раздел {string}")
    public void navigateTo_CsCartSettings (String section) {
        mobile_MainMenu.click();
        executeJavaScript("arguments[0].scrollIntoView(true);", menuOf_Settings);
        executeJavaScript("arguments[0].click();", menuOf_Settings);
        $x("//div[text()='" + section + "']").click();
    }

    @Given("Переходим во вкладку настроек CS-Cart {string}")
    public void navigateTo_TabOfCsCartSettings (String tabName) {
        sideBar.click();
        $x("//div[@class='sidebar-row']//a[text()='" + tabName + "']").click();
    }

    @Then("Сохраняем настройки налога")
    public void saveTaxSettings() {
        button_Save_OnTop_Other.click();
    }
}