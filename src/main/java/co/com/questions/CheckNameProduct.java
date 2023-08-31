package co.com.questions;

import co.com.userinterface.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CheckNameProduct implements Question<String> {
    public String product;

    public CheckNameProduct(String product) {
        this.product = product;
    }

    @Override
    public String answeredBy(Actor actor) {
        return ProductsPage.getProductName(product).resolveFor(actor).getText();
    }

    public static CheckNameProduct productName(String product) {
        return new CheckNameProduct(product);
    }
}
