package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public interface CheckMenuToBeActive {
    default void checkMenuToBeActive(String mainMenu) {
        SelenideElement activeMenu = $x("//a[contains(@class, 'main-menu-1__toggle--active')]" + mainMenu);
        SelenideElement firstMenu = $x(mainMenu);
        try {
            if (!activeMenu.exists()) {
                firstMenu.click();
                sleep(1000);
            }
        } catch (ElementNotFound e) {
        }
    }
}