package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private final SelenideElement CONTACT_US = $("[data-testid = 'HEADER_CONTACT_US_TEST_ID']"),
            SERVICES = $("[data-testid = 'HEADER_SERVICES_TEST_ID']"),
            HELP = $("[data-testid = 'HEADER_HELP_TEST_ID']"),
            MY_LIST = $("[data-testid = 'HEADER_MY_LIST_TEST_ID']"),
            LOGIN = $("[data-testid = 'HEADER_LOGIN_TEST_ID']"),
            SERVICES_DROPDOWN = $$(".HeaderMenuDropdown_dropdown__04614").get(0),
            HELP_DROPDOWN = $$(".HeaderMenuDropdown_dropdown__04614").get(1),
            CONTACT_US_MODAL = $("[data-testid = 'CONTACT_US_MODAL_TEST_ID']");


    @Step("Check ContactUs icon exists")
    public Header contactUsIconExists() {
        CONTACT_US.should(Condition.exist);
        return this;
    }

    @Step("Check Services icon exists")
    public Header servicesIconExists() {
        SERVICES.should(Condition.exist);
        return this;
    }

    @Step("Check Help icon exists")
    public Header helpIconExists() {
        HELP.should(Condition.exist);
        return this;
    }

    @Step("Check My list icon exists")
    public Header myListIconExists() {
        MY_LIST.should(Condition.exist);
        return this;
    }

    @Step("Check Login icon exists")
    public Header loginIconExists() {
        LOGIN.should(Condition.exist);
        return this;
    }

    @Step("Check My list icon should not exists")
    public Header myListDoesNotExists() {
        MY_LIST.shouldNot(Condition.exist);
        return this;
    }

    @Step("Check Login icon exists")
    public Header loginDoesNotExists() {
        LOGIN.shouldNot(Condition.exist);
        return this;
    }

    @Step("Click Contact us")
    public Header contactUsClick() {
        CONTACT_US.click();
        return this;
    }

    @Step("Check Contact Us Model window exists")
    public Header contactusModelWindowExists() {
        CONTACT_US_MODAL.should(Condition.exist);
        return this;
    }

    @Step("Hover Services")
    public Header servicesHover() {
        SERVICES.hover();
        return this;
    }

    @Step("Hover Help")
    public Header helpHover() {
        HELP.hover();
        return this;
    }

    @Step("Check Available Services Dropdown")
    public Header checkServices(String value) {
        SERVICES_DROPDOWN.shouldHave(text(value));
        return this;

    }

    @Step("Check Available Help Dropdown")
    public Header checkHelp(String value) {
        HELP_DROPDOWN.shouldHave(text(value));
        return this;

    }


}
