package com.sanduna.service;

import com.sanduna.dao.Coins;
import com.sanduna.dao.Transactions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CoinbaseServiceTest {

    public static String BASE_URL = "http://localhost:8080";

    @Test
    public void addCoin() {
        RestAssured.baseURI = BASE_URL;
        given().urlEncodingEnabled(false)
                .body(new Coins(1L, "BTC", 8000.0, "Bitcoin"))
                .contentType(ContentType.JSON)
                .post("/coins")
                .then()
                .statusCode(200);
    }


    @Test
    public void getAllCoins() {
        given().when().get(BASE_URL+"/coins").
                then().statusCode(200);
    }

    @Test
    public void updateCoin() {
        given().urlEncodingEnabled(false)
                .body(new Coins(1L, "BTC", 8000.0, "Bitcoin"))
                .contentType(ContentType.JSON)
                .put(BASE_URL+"/coins")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBuyCoin() {
        given().urlEncodingEnabled(false)
                .body(new Transactions(1L, "BTC", 5L, "BUY", 10L))
                .contentType(ContentType.JSON)
                .post(BASE_URL+"/buy")
                .then()
                .statusCode(200);
    }

    @Test
    public void testSellCoin() {
        given().urlEncodingEnabled(false)
                .body(new Transactions(1L, "BTC", 5L, "SELL", 8L))
                .contentType(ContentType.JSON)
                .post(BASE_URL+"/sell")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUpdateCoinTransaction() {
        given().urlEncodingEnabled(false)
                .body(new Transactions(1L, "BTC", 6L, "SELL", 8L))
                .contentType(ContentType.JSON)
                .post(BASE_URL+"/update")
                .then()
                .statusCode(200);
    }

//    @Test
//    public void testCancelTransaction() {
//        given().urlEncodingEnabled(false)
//                .body(new Transactions(1L, "BTC", 6L, "SELL", 8L))
//                .contentType(ContentType.JSON)
//                .delete(BASE_URL+"/crypto/cancel")
//                .then()
//                .statusCode(200);
//    }

    @Test
    public void testGetAllTransactions() {
        given().when()
                .get(BASE_URL+"/transactions")
                .then()
                .statusCode(200);
    }

}