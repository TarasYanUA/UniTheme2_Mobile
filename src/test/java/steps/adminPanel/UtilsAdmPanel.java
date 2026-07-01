package steps.adminPanel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UtilsAdmPanel {

    public static void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }

    public static void closeAllNotifications() {
        while ($(".cm-notification-close").exists()) {
            $(".cm-notification-close").click();
            sleep(200);
        }
    }

    public static void waitForVisibilityOfPopupWindow() {
        $(".ui-dialog-title").shouldBe(Condition.visible);
    }

    public static void waitForPopupWindowDisappear() {
        $(".ui-dialog-title").shouldBe(Condition.disappear);
    }
}