package ru.hh.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public SelenideElement
            headerPromo = $(".bloko-header-promo-3"),
            blokoHeader = $(".bloko-header-1_lite"),
            qrCode = $(".footer-mobile-banner-qr-code--eHrP3ykySgVonlzfRteG");

    public String
            headerPromoText = "Работа найдется для каждого",
            blokoHeaderText = "Скачайте приложение";

    @Step("Открываем главную страницу сайта https://hh.ru")
    public MainPage openPage() {
        open("/");

        return this;
    }

    @Step("Проверка наличия текста  {text} в элементе {element}")
    public MainPage checkTextElement(SelenideElement element, String text) {
        element.shouldBe(Condition.text(text));

        return this;
    }

    @Step("Проверка видимости QR кода на главной странице ")
    public MainPage checkQrCodeAppVisible() {
        qrCode.shouldBe(Condition.visible);

        return this;
    }
}
