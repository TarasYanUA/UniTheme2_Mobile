package steps.adminPanel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BasicPageSteps {
    public BasicPageSteps() { super(); }

    BasicPage basicPage = new BasicPage();

    @Given("Переходим на страницу {string}, что на странице 'Темы'")
    public void navigateTo_PageName_FromThemes(String pageName) {
        basicPage.navigateTo_PageName_FromThemes(pageName);
    }

    @Given("Переходим на страницу {string} -- {string}")
    public void navigateTo_SectionOfMainMenu(String mainMenu, String section) {
        basicPage.navigateTo_SectionOfMainMenu(mainMenu, section);
    }

    @And("Переходим в настройки характеристики {string}")
    public void navigateTo_FeaturePage(String featureName) {
        basicPage.navigateTo_FeaturePage(featureName);
    }

    @And("Устанавливаем настройки характеристики:")
    public void setSettingsOfFeature_Brand(DataTable table) {
        basicPage.setSettingsOfFeature_Brand(table);
    }

    @And("Задаём описание для характеристики")
    public void addDescriptionToFeature() {
        basicPage.addDescriptionToFeature();
    }

    @Then("Сохраняем выбранные настройки")
    public void saveSettings_SaveButtonOnTop() {
        basicPage.saveSettings_SaveButtonOnTop();
    }

    @Then("Сохраняем настройки характеристики")
    public void saveSettings_Feature() {
        basicPage.saveSettings_Feature();
    }

    @Given("Переходим на страницу 'Настройки', раздел {string}")
    public void navigateTo_CsCartSettings(String section) {
        basicPage.navigateTo_CsCartSettings(section);
    }

    @Given("Переходим во вкладку настроек CS-Cart {string}")
    public void navigateTo_TabOfCsCartSettings(String tabName) {
        basicPage.navigateTo_TabOfCsCartSettings(tabName);
    }

    @Then("Сохраняем настройки налога")
    public void saveTaxSettings() {
        basicPage.saveTaxSettings();
    }

    @Given("Выключаем модуль с ИД {string}, если модуль включён")
    public void disableAddon(String addonID) {
        basicPage.disableAddon(addonID);
    }
}