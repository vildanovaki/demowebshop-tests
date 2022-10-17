package com.vildanova.pages;

import static com.vildanova.tests.TestBase.credentials;

public class LoginAsnPasswordPage {

    static String login, password;

    public void getInformationAboutLoginAndPassword() {
        login = credentials.login();
        password = credentials.password();
    }
}
