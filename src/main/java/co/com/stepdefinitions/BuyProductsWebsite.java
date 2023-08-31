package co.com.stepdefinitions;

import co.com.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;

public class BuyProductsWebsite {

    protected EnvironmentVariables environmentVariables;

    @Given("the {actor} access to the web site")
    public void accessToTheWebSite(Actor actor) {
        String endpointBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
        actor.wasAbleTo(OpenTheApplication.startApplication(endpointBaseUrl));
    }

    @And("{actor} login with valid {string} and {string}")
    public void loginWithValidUserAndPassword(Actor actor, String username, String password) {
        actor.wasAbleTo(Login.authenticating(username, password));
    }

    @When("{actor} adds {int} products to the cart")
    public void addsProductsToTheCart(Actor actor, int products) {
        actor.wasAbleTo(AddProductsToShoppingCart.addProductCart(products));
    }

    @Then("{actor} can view the {int} products added to the shopping cart")
    public void canViewTheAmountProductsAddedToTheShoppingCart(Actor actor, int quantityProducts) {
        actor.wasAbleTo(CheckShoppingCart.checkShopping(String.valueOf(quantityProducts)));
    }

    @And("{actor} fills out the purchase form {string} {string} {string}")
    public void fillsOutThePurchaseForm(Actor actor, String firstName, String lastName, String postalCode) {
        actor.wasAbleTo(CheckOutInformation.information(firstName, lastName, postalCode));
    }

    @And("{actor} can Checkout until confirmation {string}")
    public void canCheckoutUntilConfirmation(Actor actor, String confirmationMessage) {
        actor.wasAbleTo(CheckCompletedOrder.message(confirmationMessage));
    }

}
