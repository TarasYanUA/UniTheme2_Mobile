package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import static com.codeborne.selenide.Selenide.*;

public class BasicPage {
    public BasicPage(){super();}


    SelenideElement mobile_MainMenu = $(".mobile-menu-toggler");
    SelenideElement mobile_ThemeActionsMenu = $(".actions-menu__dropdown-toggle");
    SelenideElement mobile_section_Themes = $("a[href*='dispatch=themes.manage'].main-menu-1__link");
    SelenideElement mobile_sectionLayouts = $(".actions-menu__dropdown-item-wrapper a[href$='block_manager.manage']");

    private final SelenideElement button_SavePopUpWindow = $(".ui-dialog-content input[value='Сохранить']");
    private final SelenideElement button_Save = $(".btn.btn-primary.cm-submit");
    private final SelenideElement menu_Settings = $("#administration");

    @Given("Переходим на страницу \"Веб-сайт -- Темы -- Макеты\", вкладка {string}")
    public void navigateTo_LayoutPage(String tabName) {
        mobile_MainMenu.click();
        mobile_section_Themes.click();
        mobile_ThemeActionsMenu.click();
        mobile_sectionLayouts.click();
        $x("//a[text()='" + tabName + "']").click();
    }
}