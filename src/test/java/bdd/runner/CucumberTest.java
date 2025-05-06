package bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.estacionamento.smartparking.SmartParkingApplication; // Importando a classe principal

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bdd.steps", "bdd.runner"}, // Referências aos steps e runners
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
@SpringBootTest(classes = SmartParkingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberTest {
}
