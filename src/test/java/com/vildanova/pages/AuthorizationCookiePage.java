package com.vildanova.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.vildanova.tests.Specs.requestAuthorizationCookie;
import static com.vildanova.tests.Specs.responseAuthorizationCookie;
import static io.restassured.RestAssured.given;

public class AuthorizationCookiePage {

    public static Cookie cookie;
    String authorizationCookie;

    @Step("Прочитать куки клиента")
    public AuthorizationCookiePage getAuthorizationCookie(){
        authorizationCookie =
                given()
                        .spec(requestAuthorizationCookie)
                        .when()
                        .post("/login")
                        .then()
                        .spec(responseAuthorizationCookie)
                        .extract()
                        .cookie("NOPCOMMERCE.AUTH");
        return this;
    }

    @Step("Открыть минимальный контент")
    public AuthorizationCookiePage openMinimalContent(){
        open("/Themes/DefaultClean/Content/images/logo.png");
        return this;
    }

    @Step("Вставить куки в браузер")
    public void setCookieToBrowser(){
        cookie = new Cookie("NOPCOMMERCE.AUTH", authorizationCookie);
        getWebDriver().manage().addCookie(cookie);
    }
}
