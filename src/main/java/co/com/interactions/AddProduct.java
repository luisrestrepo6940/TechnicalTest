package co.com.interactions;

import co.com.userinterface.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Interaction {

    protected String productPosition;

    public AddProduct(String productPosition) {
        this.productPosition = productPosition;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.addToCart(productPosition))
        );
    }

    public static AddProduct buyProduct(String productPosition) {
        return instrumented(AddProduct.class, productPosition);
    }

}
