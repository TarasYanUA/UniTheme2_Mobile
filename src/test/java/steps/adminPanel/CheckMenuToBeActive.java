package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import static com.codeborne.selenide.Selenide.$x;

public interface CheckMenuToBeActive {
    default void checkMenuToBeActive(String mainMenu) {
        SelenideElement activeMenu = $x("//a[contains(@class, 'main-menu-1__toggle--active')]" + mainMenu);
        SelenideElement myMenu = $x(mainMenu);
        System.out.println(activeMenu);
        try {
            if (!activeMenu.exists())
                myMenu.click();
        } catch (ElementNotFound e) {
        }
    }
}