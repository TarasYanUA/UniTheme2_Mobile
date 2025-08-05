package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BasicPage implements CheckMenuToBeActive {
    public BasicPage() {
        super();
    }

    SelenideElement button_Save_OnTop_Other = $(".nav__actions-btn-save");
    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");
    public static SelenideElement sideBar = $(".sidebar-toggle");
    SelenideElement menuOf_WebsiteThemes = $(".actions-menu__dropdown-toggle");
    SelenideElement menuOf_Settings = $(By.id("administration"));


    public void navigateTo_PageName_FromThemes(String pageName) {
        menuOf_WebsiteThemes.click();
        $x("//ul[@id='tools_list_actions_menu']//span[text()='" + pageName + "']").click();
    }

    public void navigateTo_SectionOfMainMenu(String mainMenu, String section) {
        String menuElement = "//span[contains(@class, 'main-menu-1__link-content')][text()='" + mainMenu + "']";
        SelenideElement sectionElement = $x("//span[contains(@class, 'main-menu-2__link-content')][text()='" + section + "']");
        mobile_MainMenu.click();
        checkMenuToBeActive(menuElement);
        sectionElement.click();
    }

    public void navigateTo_FeaturePage(String featureName) {
        $x("//a[text()='" + featureName + "']").click();
    }

    public void navigateTo_CsCartSettings(String section) {
        mobile_MainMenu.click();
        executeJavaScript("arguments[0].scrollIntoView(true);", menuOf_Settings);
        executeJavaScript("arguments[0].click();", menuOf_Settings);
        $x("//div[text()='" + section + "']").click();
    }

    public void navigateTo_TabOfCsCartSettings(String tabName) {
        sideBar.click();
        $x("//div[@class='sidebar-row']//a[text()='" + tabName + "']").click();
    }

    public void saveTaxSettings() {
        button_Save_OnTop_Other.click();
        sleep(1500);
    }

    public void disableAddon(String addonID) {
        if (!$(By.id(addonID)).find(By.xpath(".//a[contains(text(), 'Включить')]")).exists()) {
            $(By.id(addonID)).find(By.xpath(".//span[contains(@class, 'cs-icon--type-cog')]")).scrollIntoCenter().click(); // шестерёнка модуля
            $(By.id(addonID)).find(By.xpath(".//a[@data-ca-event='ce.update_object_status_callback']")).click(); // кнопка "Выкл."
            sleep(11000);
        }
    }
}