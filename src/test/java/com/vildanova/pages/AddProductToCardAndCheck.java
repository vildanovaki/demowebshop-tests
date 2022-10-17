package com.vildanova.pages;

import io.restassured.response.Response;
import static com.vildanova.pages.AuthorizationCookiePage.cookie;
import static com.vildanova.pages.CountProductsPage.parse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AddProductToCardAndCheck {

    public void addOneProductToCardAndCheck(){
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body("addtocart_31.EnteredQuantity=1")
                        .cookie(String.valueOf(cookie))
                        .when()
                        .post("/addproducttocart/details/31/1")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("("+(parse+1)+")"))
                        .extract().response();
    }
}