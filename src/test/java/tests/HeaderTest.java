package tests;

import components.Header;
import helpers.Attach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("level_travel")
public class HeaderTest {

    Header header = new Header();

    MainPage mainpage = new MainPage();

    @BeforeEach
    void beforeEach() {
        mainpage.openPage();
        sleep(2000);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
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

    @DisplayName("Проверка открытии модального окна при нажатии Напишите нам")
    @Test
    void contactUsTest() {
        header.contactUsClick()
                .contactusModelWindowExists();
    }
}
