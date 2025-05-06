package bdd.steps;

import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.spring.CucumberContextConfiguration;
import com.estacionamento.smartparking.SmartParkingApplication; // Importando a classe principal

@CucumberContextConfiguration
@SpringBootTest(classes = SmartParkingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {
}
