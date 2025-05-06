package com.estacionamento.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingApiTest {

    @Test
    public void testStatusCode() {
        RestAssured.given()
                .when()
                .get("http://localhost:8080/vagas")
                .then()
                .statusCode(200); // Validar se o status code é 200
    }

    @Test
    public void testResponseBody() {
        String response = RestAssured.given()
                .when()
                .get("http://localhost:8080/vagas")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        System.out.println(response); // Para verificar o conteúdo da resposta

        // Verifique se a resposta contém o campo "numero"
        assertTrue(response.contains("A12"), "A resposta não contém o número da vaga 'A12'.");
        assertTrue(response.contains("A13"), "A resposta não contém o número da vaga 'A13'.");
    }

}
