package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {


    @Step("Open Main page")
    public MainPage openPage() {
        open("https://level.travel/");
        return this;
    }


}
