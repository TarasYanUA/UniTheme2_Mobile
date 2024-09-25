package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import static com.codeborne.selenide.Selenide.*;

public class BasicPage implements CheckMenuToBeActive {
    public BasicPage(){super();}


    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");
    SelenideElement section_Themes = $("a[href*='dispatch=themes.manage'].main-menu-1__link");
    SelenideElement menuOf_WebsiteThemes = $(".actions-menu__dropdown-toggle");
    SelenideElement section_Layouts = $(".actions-menu__dropdown-item-wrapper a[href$='block_manager.manage']");
    SelenideElement mainMenu_Products = $("a[href*='dispatch=products.manage'] .main-menu-1__link-content");

    SelenideElement button_SavePopUpWindow = $(".ui-dialog-content input[value='Сохранить']");
    SelenideElement button_Save = $(".btn.btn-primary.cm-submit");
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
        String mainMenuIs = "//span[contains(@class, 'main-menu-1__link-content')][text()='" + mainMenu + "']";
        SelenideElement sectionIs = $x("//span[contains(@class, 'main-menu-2__link-content')][text()='" + section + "']");

        mobile_MainMenu.click();
        checkMenuToBeActive(mainMenuIs);
    }
}