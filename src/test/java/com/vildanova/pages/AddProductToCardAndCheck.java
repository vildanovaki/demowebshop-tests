package com.vildanova.pages;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.vildanova.pages.AuthorizationCookiePage.cookie;
import static com.vildanova.pages.CountProductsPage.parse;
import static com.vildanova.helpers.Specs.requestAddProductToCardAndCheck;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AddProductToCardAndCheck {

    @Step("Добавить товар в корзину и проверить количество в ней после добавления")
    public void addOneProductToCardAndCheck(){
        Response response =
                given()
                        .spec(requestAddProductToCardAndCheck
                                .cookie(String.valueOf(cookie)))
                        .when()
                        .post("/addproducttocart/details/31/1")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("("+(parse+1)+")"))
                        .log().all()
                        .extract().response();
    }
}
