package bdd.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VagaSteps {

    private Response response;

    @Given("a API de vagas está disponível")
    public void apiDisponivel() {
        baseURI = "http://localhost";  // URL base do servidor da API
        port = 8080;                  // Porta da API
        System.out.println("API de vagas está disponível em: " + baseURI + ":" + port);
    }

    @When("eu envio uma requisição POST para \"/vagas\" com os dados válidos")
    public void envioRequisicaoPost() {
        String jsonBody = """
            {
              "numero": "A001",
              "ocupada": false
            }
        """;

        response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("/vagas");

        System.out.println("Requisição POST enviada: " + jsonBody);
    }

    @Then("o status code da resposta deve ser 201")
    public void validaStatusCode() {
        response.then().statusCode(201);
        System.out.println("Status code da resposta: " + response.statusCode());
    }

    @Then("o corpo da resposta deve conter o campo {string}")
    public void validaCampoResposta(String campo) {
        response.then().body("$", hasKey(campo));
        System.out.println("Campo esperado no corpo da resposta: " + campo);
    }
}
