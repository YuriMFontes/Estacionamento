package com.estacionamento.bdd.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VagaSteps {
    private Response response;

    @Given("a API de vagas está disponível")
    public void apiDisponivel() {
        baseURI = "http://localhost";
        port = 8080;
        System.out.println("API de vagas disponível em " + baseURI + ":" + port);
    }

    @When("eu envio uma requisição POST para \"/vagas\" com os dados válidos")
    public void envioRequisicaoPostValida() {
        String json = """
            {
                "numero": "A001",
                "ocupada": false
            }
        """;
        response = given().header("Content-Type", "application/json").body(json).when().post("/vagas");
        System.out.println("Requisição POST enviada com dados: " + json);
    }

    @When("eu envio uma requisição POST para \"/vagas\" com dados inválidos")
    public void envioRequisicaoPostInvalida() {
        String json = """
            {
                "numero": "",
                "ocupada": null
            }
        """;
        response = given().header("Content-Type", "application/json").body(json).when().post("/vagas");
        System.out.println("Requisição POST enviada com dados inválidos: " + json);
    }

    @When("eu envio uma requisição GET para \"/vagas\"")
    public void envioRequisicaoGet() {
        response = when().get("/vagas");
        System.out.println("Requisição GET enviada para /vagas");
    }

    @Then("o status code da resposta deve ser {int}")
    public void validaStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
        System.out.println("Verificado o status code: " + statusCode);
    }

    @Then("o corpo da resposta deve conter o campo {string}")
    public void corpoDeveConterCampo(String campo) {
        response.then().body("$", hasKey(campo));
        System.out.println("Verificado que o corpo da resposta contém o campo: " + campo);
    }

    @Then("o corpo da resposta deve conter a lista de vagas")
    public void corpoDeveConterLista() {
        response.then().body("size()", greaterThanOrEqualTo(0));
        System.out.println("Verificado que o corpo da resposta contém a lista de vagas.");
    }
}
