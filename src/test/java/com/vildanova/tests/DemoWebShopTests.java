package com.vildanova.tests;

import com.vildanova.pages.*;
import org.junit.jupiter.api.Test;

public class DemoWebShopTests extends TestBase {

    LoginAsnPasswordPage loginAsnPasswordPage = new LoginAsnPasswordPage();
    AuthorizationCookiePage authorizationCookiePage = new AuthorizationCookiePage();
    OpenPage openPage = new OpenPage();
    CountProductsPage countProductsPage = new CountProductsPage();
    AddProductToCardAndCheck addProductToCardAndCheck = new AddProductToCardAndCheck();

    @Test
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
