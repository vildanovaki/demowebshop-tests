package com.vildanova.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CountProductsPage {

    String countOfProducts;
    int length;
    static int parse;

    @Step("Узнать количество товаров в корзине")
    public void getCountOfProductsInBasket(){
        countOfProducts = $("#topcartlink").$(".cart-qty").text();
        length = countOfProducts.length();
        countOfProducts = countOfProducts.substring(1, length-1);
        parse = Integer.parseInt(countOfProducts);
    }
}
