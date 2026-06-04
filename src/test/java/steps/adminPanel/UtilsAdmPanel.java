package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class UtilsAdmPanel {

    public static void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }

    public static void closeAllNotifications() {
        while (!$$(".cm-notification-close").isEmpty()) {
            $$(".cm-notification-close").first().click();
            sleep(200);
        }
    }
}