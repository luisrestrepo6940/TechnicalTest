package co.com.tasks;

import co.com.questions.CheckConfirmationMessage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckCompletedOrder implements Task {

    private final String confirmationMessage;

    public CheckCompletedOrder(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    @Override
    @Step("Check complete order")
    public <T extends Actor> void performAs(T actor) {
        Ensure.that(CheckConfirmationMessage.getMessage(confirmationMessage).answeredBy(actor))
                .isEqualTo(confirmationMessage);
    }

    public static CheckCompletedOrder message(String confirmationMessage) {
        return instrumented(CheckCompletedOrder.class, confirmationMessage);
    }

}
