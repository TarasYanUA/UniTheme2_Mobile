package hooks;

import com.codeborne.selenide.*;
import org.assertj.core.api.SoftAssertions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class DriverHooks {
    public static final String BASIC_URL = "https://abd-0fa456d9f9.demos.abt.team/admin.php?dispatch=administration.view";

    public DriverHooks() {super();}

    @Before()
    public void prepareBrowser() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 12 Pro");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);   // Устанавливаем созданный драйвер как текущий драйвер для Selenide
        open(BASIC_URL);
        Configuration.timeout = 2000; //Общая задержка
        Configuration.screenshots = true; //делаем скриншоты при падении

        SoftAssertions softAssertions = new SoftAssertions();
        CollectAssertMessages.setSoftAssertions(softAssertions);

        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
        if ($(".cm-notification-close").isDisplayed())
            $(".cm-notification-close").click();
        Selenide.sleep(1000);
    }

    @After
    public void closerBrowser() {
        SoftAssertions softAssertions = CollectAssertMessages.getSoftAssertions();
        try {
            softAssertions.assertAll();
        } catch (AssertionError e) {
            System.out.println("\nОшибки в asserts:");
            System.out.println(e.getMessage());
        }
        closeWebDriver();
    }
}