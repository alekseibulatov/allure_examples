package ru.hh.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            headerPromo = $(".bloko-header-promo-3");

    private String
            headerPromoText = "Работа найдется для каждого";

    @Step("Открываем главную страницу сайта https://hh.ru")
    public MainPage openPage() {
        open("/");

        return this;
    }

    @Step("Провека наличия текста в хеадер промо")
    public MainPage checkTextHeaderPromo() {
        headerPromo.shouldBe(Condition.text(headerPromoText));

        return this;
    }
}
