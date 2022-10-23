package com.vildanova.pages;

import io.qameta.allure.Step;

import static com.vildanova.tests.TestBase.credentials;

public class LoginAsnPasswordPage {

    static String login, password;

    @Step("Прочитать логин и пароль через owner")
    public void getInformationAboutLoginAndPassword() {
        login = credentials.login();
        password = credentials.password();
    }
}
