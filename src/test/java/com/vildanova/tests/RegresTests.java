package com.vildanova.tests;

import com.vildanova.base.TestBaseRegres;
import com.vildanova.lombok.request.SuccessRegRequest;
import com.vildanova.lombok.request.UnsuccessRegRequest;
import com.vildanova.lombok.request.UpdInfUsersRequest;
import com.vildanova.lombok.response.LombokResourceData;
import com.vildanova.lombok.response.SingleUserData;
import com.vildanova.models.SingleUserDataModel;
import org.junit.jupiter.api.Test;

import static com.vildanova.helpers.Specs.responseStatusCodeTwuHundred;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegresTests extends TestBaseRegres {

    public static SuccessRegRequest successRegRequest = new SuccessRegRequest();
    public static UnsuccessRegRequest unsuccessRegRequest = new UnsuccessRegRequest();
    public static UpdInfUsersRequest updInfUsersRequest = new UpdInfUsersRequest();

    @Test
    void successfulRegistration() {
        given()
                .contentType(JSON)
                .body(successRegRequest)
                .when()
                .post("/api/register")
                .then()
                .spec(responseStatusCodeTwuHundred)
                .body("id", is(4), "token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void unsuccessfulRegistration() {
        given()
                .contentType(JSON)
                .body(unsuccessRegRequest)
                .when()
                .post("/api/register")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @Test
    void updateInformationAboutUser() {
        given()
                .contentType(JSON)
                .body(updInfUsersRequest)
                .when()
                .put("/api/users/2")
                .then()
                .spec(responseStatusCodeTwuHundred)
                .body("name", is("morpheus"));
    }

    @Test
    void userNotFound() {
        given()
                .get("/api/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    void listOfResourcesWithLombook() {
        LombokResourceData response =
                get("/api/unknown")
                        .then()
                        .extract().response().as(LombokResourceData.class);

        assertEquals("fuchsia rose", response.getData().get(1).getName());
        assertEquals(1, response.getPage());
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", response.getSupport().getText());

    }

    @Test
    void singleUserWithLombook() {
        SingleUserData response =
                get("/api/users/2")
                        .then()
                        .extract().response().as(SingleUserData.class);

        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
    }

    @Test
    void singleUserWithModel() {
        SingleUserDataModel response =
                get("/api/users/2")
                        .then()
                        .extract().response().as(SingleUserDataModel.class);

        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
    }

    @Test
    void listOfResourcesWithGroovy() {
        LombokResourceData response =
                get("/api/unknown")
                        .then()
                        .body("data.findAll{it.name}.name.flatten()", hasItem("cerulean"))
                        .body("data.findAll{it.year>2004}.year.flatten()", hasItem(2005))
                        .extract().as(LombokResourceData.class);

        assertEquals("fuchsia rose", response.getData().get(1).getName());
        assertEquals(1, response.getPage());
    }
}
