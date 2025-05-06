package com.estacionamento.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EstacionamentoStepDefinitions {

    @Given("o sistema está online")
    public void oSistemaEstaOnline() {
        // Lógica para garantir que o sistema está online
        System.out.println("Sistema está online");
    }

    @When("o usuário tenta reservar uma vaga")
    public void oUsuarioTentaReservarUmaVaga() {
        // Lógica de tentativa de reserva
        System.out.println("Usuário tentando reservar vaga");
    }

    @Then("a vaga será reservada com sucesso")
    public void aVagaSeráReservadaComSucesso() {
        // Lógica para verificar se a vaga foi reservada
        System.out.println("Vaga reservada com sucesso");
    }
}
