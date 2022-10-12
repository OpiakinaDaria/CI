package ru.netology.rest;

import io.restassured.http.ContentType;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV3 {
    @Test
    void shouldReturnDemoAccounts(List<Argument>[] equalTo) {
        // Given - When - Then
        // Предусловия
        // Выполняемые действия
        // Проверки
        // специализированные проверки - лучше
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                // специализированные проверки - лучше
                .contentType(ContentType.JSON)
                .body("", hasSize(3))
                .body("enum:[«RUB»,”USD”].currency", equalTo("RUB"), "USD");
                //.body("[0].balance", greaterThanOrEqualTo(0));
    }

}