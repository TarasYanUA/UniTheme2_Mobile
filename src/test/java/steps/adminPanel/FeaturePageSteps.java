package steps.adminPanel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FeaturePageSteps {
    public FeaturePageSteps() {
        super();
    }

    FeaturePage featurePage = new FeaturePage();

    @And("Устанавливаем настройки характеристики:")
    public void setSettingsOfFeature_Brand(DataTable table) {
        featurePage.setSettingsOfFeature_Brand(table);
    }

    @And("Задаём описание для характеристики")
    public void addDescriptionToFeature() {
        featurePage.addDescriptionToFeature();
    }

    @Then("Сохраняем выбранные настройки")
    public void saveSettings_SaveButtonOnTop() {
        featurePage.saveSettings_SaveButtonOnTop();
    }

    @Then("Сохраняем настройки характеристики")
    public void saveSettings_Feature() {
        featurePage.saveSettings_Feature();
    }

    @And("Переходим во вкладку 'Варианты'")
    public void navigateTo_tabVariants() {
        executeJavaScript("window.scrollTo(0, 0);");
        featurePage.tab_Variants.click();
    }

    @And("Назначаем цвет {string} для цвета по умолчанию {string}, если такой есть")
    public void setColorIfDefault(String color, String dataColor) {
        featurePage.setColorIfDefault(color, dataColor);
    }

    @And("Нажимаем кнопку 'Добавить вариант'")
    public void clickButton_AddVariant() {
        executeJavaScript("window.scrollTo(0, 0);");
        featurePage.button_AddVariantList.click();
    }

    @And("Устанавливаем новый цвет {string} с кодом {string}")
    public void setNewColor(String color, String dataColor) {
        featurePage.setNewColor(color, dataColor);
    }

    @And("Устанавливаем двойной цвет {string} с кодами {string} и {string}")
    public void setMulticolor(String color, String dataColorOne, String dataColorTwo) {
        featurePage.setMulticolor(color, dataColorOne, dataColorTwo);
    }

    @And("Устанавливаем миниатюру {string} с ссылкой {string}")
    public void setThumbnail(String name, String imageUrl) {
        featurePage.setThumbnail(name, imageUrl);
    }
}