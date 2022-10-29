package com.vildanova.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.vildanova.config.AppConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBaseForDemoWebShop {

    public static AppConfig credentials =
            ConfigFactory.create(AppConfig.class);

    @BeforeAll
    static void configureBaseUrl() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "100.0");
        Configuration.browserSize = System.getProperty("size", "1366x768");

        Configuration.baseUrl = "https://demowebshop.tricentis.com";
        RestAssured.baseURI = "https://demowebshop.tricentis.com";

        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud");
        Configuration.remote = format("https://%s:%s@%s/wd/hub/", credentials.loginAutoCloud(), credentials.passwordAutoCloud(), remoteUrl);

        SelenideLogger.addListener("AllureListener", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
