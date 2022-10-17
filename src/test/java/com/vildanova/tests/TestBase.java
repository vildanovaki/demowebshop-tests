package com.vildanova.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.vildanova.config.AppConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    public static AppConfig credentials =
            ConfigFactory.create(AppConfig.class);

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
        RestAssured.baseURI = "https://demowebshop.tricentis.com";

        SelenideLogger.addListener("AllureListener", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
