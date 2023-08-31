package co.com.questions;

import co.com.userinterface.CheckoutComplete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CheckConfirmationMessage implements Question<String> {
    public String confirmationMessage;

    public CheckConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutComplete.THANK_YOU_ORDER.resolveFor(actor).getText();
    }

    public static CheckConfirmationMessage getMessage(String confirmationMessage) {
        return new CheckConfirmationMessage(confirmationMessage);
    }
}
