package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/resources/features/BuyProducts.feature"},
        glue = {"co/com/stepdefinitions"}
)
public class TestRunnerBuyProducts {}
