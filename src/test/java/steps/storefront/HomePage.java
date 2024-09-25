package steps.storefront;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    SelenideElement flyMenu_button = $(".ut2-icon-outline-menu");
    SelenideElement flyMenu_Logout = $("a[href*='dispatch=auth.logout']");
    SelenideElement flyMenu_button_ViewDetails_SecondLevel = $(".ut2-lsl.active .ty-float-right");

    @Given("Разавторизоваться на витрине")
    public void logoutOnStorefront() {
        flyMenu_button.click();
        executeJavaScript("arguments[0].click();", flyMenu_Logout);
    }

    @And("Переходим на страницу категории {string} {string} \\(mobile)")
    public void navigateTo_CategoryPage__mobile(String mainCategory, String subCategory) {
        flyMenu_button.click();
        $(".ut2-lfl.ty-menu-item__" + mainCategory + " strong").click();
        $x("//strong[text()='" + subCategory + "']").click();
        flyMenu_button_ViewDetails_SecondLevel.click();
    }
}