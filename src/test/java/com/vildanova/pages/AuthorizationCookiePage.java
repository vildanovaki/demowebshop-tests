package com.vildanova.pages;

import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.vildanova.pages.LoginAsnPasswordPage.login;
import static com.vildanova.pages.LoginAsnPasswordPage.password;
import static io.restassured.RestAssured.given;

public class AuthorizationCookiePage {

    static Cookie cookie;
    String authorizationCookie;

    public AuthorizationCookiePage getAuthorizationCookie(){
        authorizationCookie =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body("Email="+login+"&Password="+password+"&RememberMe=false")
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .extract()
                        .cookie("NOPCOMMERCE.AUTH");
        return this;
    }

    public AuthorizationCookiePage openMinimalContent(){
        open("/Themes/DefaultClean/Content/images/logo.png");
        return this;
    }

    public void setCookieToBrowser(){
        cookie = new Cookie("NOPCOMMERCE.AUTH", authorizationCookie);
        getWebDriver().manage().addCookie(cookie);
    }
}
