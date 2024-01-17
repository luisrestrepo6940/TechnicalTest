package co.com.tasks;

import co.com.interactions.PressButton;
import co.com.questions.CheckNameProduct;
import co.com.questions.CheckQuantityProducts;
import co.com.userinterface.ProductsPage;
import co.com.userinterface.ShoppingCartPage;
import co.com.utils.EnumVariablesSesion;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CheckShoppingCart implements Task {

    protected final String quantity;

    public CheckShoppingCart(String quantity) {
        this.quantity = quantity;
    }

    @Override
    @Step("check shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(CheckQuantityProducts.quantityProducts().answeredBy(actor))
                        .isEqualTo(quantity),
                Ensure.that(CheckNameProduct.productName("1").answeredBy(actor))
                        .isEqualTo(Serenity.sessionVariableCalled(EnumVariablesSesion.SESSION_PRODUCT_ONE.getValue())),
                Ensure.that(CheckNameProduct.productName("2").answeredBy(actor))
                        .isEqualTo(Serenity.sessionVariableCalled(EnumVariablesSesion.SESSION_PRODUCT_TWO.getValue()))
        );

        actor.attemptsTo(
                PressButton.button(ProductsPage.SHOPPING_CART)
        );

        actor.attemptsTo(
                PressButton.button(ShoppingCartPage.CHECKOUT)
        );
    }

    public static CheckShoppingCart checkShopping(String quantity) {
        return instrumented(CheckShoppingCart.class, quantity);
    }

}
