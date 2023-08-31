package co.com.tasks;

import co.com.interactions.AddProduct;
import co.com.questions.CheckNameProduct;
import co.com.utils.EnumVariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddProductsToShoppingCart implements Task {

    private final int products;

    public AddProductsToShoppingCart(int products) {
        this.products = products;
    }

    @Override
    @Step("el usuario {0} adiciona el producto al carro de compras")
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= products; i++) {
            String productId = String.valueOf(i);
            actor.attemptsTo(
                    AddProduct.buyProduct(productId)
            );
            if (i == 1) {
                Serenity.setSessionVariable(EnumVariablesSesion.SESSION_PRODUCT_ONE.getValue()).to(CheckNameProduct.productName(productId).answeredBy(actor));
            } else {
                Serenity.setSessionVariable(EnumVariablesSesion.SESSION_PRODUCT_TWO.getValue()).to(CheckNameProduct.productName(productId).answeredBy(actor));
            }
        }
    }

    public static AddProductsToShoppingCart addProductCart(int products) {
        return instrumented(AddProductsToShoppingCart.class, products);
    }

}
