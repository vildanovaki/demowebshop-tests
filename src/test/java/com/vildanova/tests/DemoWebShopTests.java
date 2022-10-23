package com.vildanova.tests;

import com.vildanova.pages.*;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

public class DemoWebShopTests extends TestBase {

    LoginAsnPasswordPage loginAsnPasswordPage = new LoginAsnPasswordPage();
    AuthorizationCookiePage authorizationCookiePage = new AuthorizationCookiePage();
    OpenPage openPage = new OpenPage();
    CountProductsPage countProductsPage = new CountProductsPage();
    AddProductToCardAndCheck addProductToCardAndCheck = new AddProductToCardAndCheck();

    @Test
    @Feature("Проверка добавления товара в корзину")
    void addToCardTest() {
        loginAsnPasswordPage.getInformationAboutLoginAndPassword();

        authorizationCookiePage.getAuthorizationCookie()
                .openMinimalContent()
                .setCookieToBrowser();

        openPage.openMainPage();

        countProductsPage.getCountOfProductsInBasket();

        addProductToCardAndCheck.addOneProductToCardAndCheck();
    }
}
