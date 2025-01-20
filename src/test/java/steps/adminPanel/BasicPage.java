package steps.adminPanel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class BasicPage implements CheckMenuToBeActive {
    public BasicPage(){super();}

    SelenideElement button_Save_OnTop = $(".btn.btn-primary.cm-submit");
    SelenideElement button_Save_OnTop_Other = $(".nav__actions-btn-save");
    SelenideElement button_Save_Feature = $(".buttons-container-picker input[name='dispatch[product_features.update]']");
    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");
    public static SelenideElement sideBar = $(".sidebar-toggle");
    SelenideElement menuOf_WebsiteThemes = $(".actions-menu__dropdown-toggle");
    SelenideElement menuOf_Settings = $(By.id("administration"));

    //Настройки характеристик
    SelenideElement featureSetting_ShowOnTheFeaturesTab = $(By.id("elm_feature_display_on_product_18"));
    SelenideElement featureSetting_ShowInProductList = $(By.id("elm_feature_display_on_catalog_18"));
    SelenideElement featureSetting_ShowInHeaderOnTheProductDetailsPage = $(By.id("elm_feature_display_on_header_18"));
    SelenideElement feature_HardDrive_ShowInHeaderOnTheProductDetailsPage = $(By.id("elm_feature_display_on_header_23"));
    SelenideElement field_FeatureDescription_HardDrive = $("label[for='elm_feature_description_23']");
    SelenideElement button_Html_HardDrive = $(".re-button.re-html.re-button-icon");
    SelenideElement field_HtmlDescriptionOfFeature = $(".cm-skip-check-item.open");


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
        $x("//a[text()='" + featureName + "']").click();
    }

    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }
    @And("Устанавливаем настройки характеристики:")
    public void setSettingsOfFeature_Brand(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for(List<String> row: rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Показывать во вкладке «Характеристики» карточки товара" -> setCheckboxState(featureSetting_ShowOnTheFeaturesTab, value);
                case "Показывать в списке товаров" -> setCheckboxState(featureSetting_ShowInProductList, value);
                case "Показывать в заголовке карточки товара" -> setCheckboxState(featureSetting_ShowInHeaderOnTheProductDetailsPage, value);
                case "Жесткий диск, Показывать в заголовке карточки товара" -> setCheckboxState(feature_HardDrive_ShowInHeaderOnTheProductDetailsPage, value);

                default -> System.out.println("Неизвестная настройка: " + setting);
            }
        }
    }

    @And("Задаём описание для характеристики")
    public void addDescriptionToFeature() {
        field_FeatureDescription_HardDrive.scrollIntoCenter().click();
        button_Html_HardDrive.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        field_HtmlDescriptionOfFeature.setValue("Для характеристики, которая просто позволяет указать какое-нибудь дополнительное свойство товара. Например, у футболок это может быть \"Ткань\". Если вы создадите фильтр по этой характеристике, покупатели увидят, что она есть, и смогут легко найти по ней нужный товар.");
    }

    @Then("Сохраняем выбранные настройки")
    public void saveSettings_SaveButtonOnTop() {
        button_Save_OnTop.click();
    }

    @Then("Сохраняем настройки характеристики")
    public void saveSettings_Feature() {
        button_Save_Feature.click();
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

    @Given("Выключаем модуль с ИД {string}, если модуль включён")
    public void disableAddon(String addonID) {
        if(!$(By.id(addonID)).find(By.xpath(".//a[contains(text(), 'Включить')]")).exists()) {
            $(By.id(addonID)).find(By.xpath(".//span[contains(@class, 'cs-icon--type-cog')]")).scrollIntoCenter().click(); // шестерёнка модуля
            $(By.id(addonID)).find(By.xpath(".//a[@data-ca-event='ce.update_object_status_callback']")).click(); // кнопка "Выкл."
            sleep(8000);
        }
    }
}