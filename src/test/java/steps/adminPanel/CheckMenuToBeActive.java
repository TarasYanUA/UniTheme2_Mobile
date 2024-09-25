package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import static com.codeborne.selenide.Selenide.$x;

public interface CheckMenuToBeActive {
    default void checkMenuToBeActive(String mainMenu) {
        SelenideElement activeMenu = $x("//a[contains(@class, 'main-menu-1__toggle--active')]" + mainMenu);
        System.out.println("Show me my MENU: " + activeMenu);
        try {
            if (!activeMenu.exists())
                activeMenu.click();
        } catch (ElementNotFound e) {
        }
    }
}