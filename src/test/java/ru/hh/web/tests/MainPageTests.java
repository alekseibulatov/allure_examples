package ru.hh.web.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


/**
 * @author alekseibulatov (Aleksei Bulatov)
 */


public class MainPageTests extends TestBase {

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная страница сайта загружена ")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void checkingElementsOnMainPage() {
        mainPage.openPage()
                .checkTextHeaderPromo();
    }
    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка видимости QR кода загрузки приложения на главной странице")
    @Tag("ui")
    void checkingQrCodeAppVisible() {
        mainPage.checkTextDownloadApp()
                .checkQrCodeAppVisible();
    }
}
