package ru.hh.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            headerPromo = $(".bloko-header-promo-3"),
            qrCodeText = $(".footer-mobile-banner-qr-code--eHrP3ykySgVonlzfRteG"),
            blokoHeader = $(".bloko-header-1_lite"),
            qrCode = $(".footer-mobile-banner-qr-code--eHrP3ykySgVonlzfRteG");

    private String
            headerPromoText = "Работа найдется для каждого",
            blokoHeaderText = "Скачайте приложение";

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

    @Step("Проверка наличия текста Скачайте приложение")
    public MainPage checkTextDownloadApp() {
        qrCodeText.shouldBe(Condition.text(blokoHeaderText));

        return this;
    }

    @Step("Проверка видимости QR кода ")
    public MainPage checkQrCodeAppVisible() {
        qrCode.shouldBe(Condition.visible);

        return this;
    }

}
