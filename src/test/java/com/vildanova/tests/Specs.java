package com.vildanova.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.vildanova.filters.CustomLogFilter.customLogFilter;
import static com.vildanova.pages.LoginAsnPasswordPage.login;
import static com.vildanova.pages.LoginAsnPasswordPage.password;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestAuthorizationCookie = with()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .body("Email=" + login + "&Password=" + password + "&RememberMe=false")
            .log().all();

    public static ResponseSpecification responseAuthorizationCookie = new ResponseSpecBuilder()
            .expectStatusCode(302)
            .build();

    public static RequestSpecification requestAddProductToCardAndCheck = with()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .body("addtocart_31.EnteredQuantity=1")
            .log().all();

    public static ResponseSpecification responseStatusCodeTwuHundred = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
