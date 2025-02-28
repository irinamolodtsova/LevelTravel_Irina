package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.JenkinsProperties.*;

public class BaseTest {

    @Step("Open Main Page")

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://level.travel/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

        Configuration.browser = getBrowser();
        Configuration.browserVersion = getBrowserVersion();
        Configuration.browserSize = getBrowserSize();
        Configuration.remote = getServer();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
