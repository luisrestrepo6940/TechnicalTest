package co.com.questions;

import co.com.userinterface.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CheckQuantityProducts implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return ShoppingCartPage.QUANTITY_PRODUCTS.resolveFor(actor).getText();
    }

    public static CheckQuantityProducts quantityProducts() {
        return new CheckQuantityProducts();
    }
}
