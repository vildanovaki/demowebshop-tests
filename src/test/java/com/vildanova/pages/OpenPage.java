package com.vildanova.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class OpenPage {

    @Step("Открыть главную страницу")
    public void openMainPage(){
        open("");
    }
}
