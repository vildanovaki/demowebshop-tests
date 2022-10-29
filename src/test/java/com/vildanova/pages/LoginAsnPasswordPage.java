package com.vildanova.pages;

import io.qameta.allure.Step;

import static com.vildanova.base.TestBaseForDemoWebShop.credentials;

public class LoginAsnPasswordPage {

    public static String login;
    public static String password;

    @Step("Прочитать логин и пароль через owner")
    public void getInformationAboutLoginAndPassword() {
        login = credentials.login();
        password = credentials.password();
    }
}
