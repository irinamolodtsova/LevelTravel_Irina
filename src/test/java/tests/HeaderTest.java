package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import components.HeaderComponent;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.open;


@Tag("level_travel")
public class HeaderTest extends BaseTest {

    HeaderComponent header = new HeaderComponent();


    @BeforeEach
    void beforeEach() {
        open("https://level.travel/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @DisplayName("Проверка доступных Header Icon на главной странице")
    @Test
    void checkMainPageHeaderIconsTest() {
        header.contactUsIconExists()
                .servicesIconExists()
                .helpIconExists()
                .loginDoesNotExists()
                .myListDoesNotExists();
    }

    @CsvFileSource(resources = "/servicesAvailableList.csv")
    @ParameterizedTest(name = "Проверка доступных опций в выпадающем списке Сервисы")
    void checkAvailableServiceTest(String hotTours, String lowPriceCalendar, String howToFind, String giftCert, String offers, String superCashback) {
        header.servicesHover()
                .checkServices(hotTours)
                .checkServices(lowPriceCalendar)
                .checkServices(howToFind)
                .checkServices(giftCert)
                .checkServices(offers)
                .checkServices(superCashback);
    }

    @CsvFileSource(resources = "/helpAvailableList.csv")
    @ParameterizedTest(name = "Проверка доступных опций в выпадающем списке Помощь")
    void checkAvailableHelpTest(String aboutCompany, String openCountries, String faq, String review, String press, String offers, String contacts) {
        header.helpHover()
                .checkHelp(aboutCompany)
                .checkHelp(openCountries)
                .checkHelp(faq)
                .checkHelp(review)
                .checkHelp(press)
                .checkHelp(offers)
                .checkHelp(contacts);
    }

    @DisplayName("Проверка открытия модального окна при нажатии Напишите нам")
    @Test
    void contactUsTest() {
        header.contactUsClick()
                .contactUsModelWindowExists();
    }
}
