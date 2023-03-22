package ru.hh.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.hh.helpers.Attach;
import ru.hh.web.pages.MainPage;
import ru.hh.web.pages.SearchPage;

public class TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPageTests = new SearchPage();

    @Step("Выполняем настройку запуска")
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browser = System.getProperty("browserName", "chrome");
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://hh.ru";
        Configuration.remote = System.getProperty("remoteURL");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Step("Загрузка Attachments")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
