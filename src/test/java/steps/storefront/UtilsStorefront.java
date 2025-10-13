package steps.storefront;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UtilsStorefront {

    public static void waitForSpinnerDisappear() {
        $("div#ajax_loading_box[style='display: block;']").shouldBe(Condition.disappear, Duration.ofSeconds(10));
        sleep(1000);
    }
}
