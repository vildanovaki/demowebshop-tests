package com.vildanova.pages;

import static com.codeborne.selenide.Selenide.$;

public class CountProductsPage {

    String countOfProducts;
    int length;
    static int parse;

    public void getCountOfProductsInBasket(){
        countOfProducts = $("#topcartlink").$(".cart-qty").text();
        length = countOfProducts.length();
        countOfProducts = countOfProducts.substring(1, length-1);
        parse = Integer.parseInt(countOfProducts);
    }
}
