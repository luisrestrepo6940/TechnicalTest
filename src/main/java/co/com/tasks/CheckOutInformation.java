package co.com.tasks;

import co.com.interactions.EnterInformation;
import co.com.interactions.PressButton;
import co.com.userinterface.CheckoutOverview;
import co.com.userinterface.FillOutForm;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CheckOutInformation implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public CheckOutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    @Step("Checkout information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterInformation.information(firstName, FillOutForm.FIRST_NAME),
                EnterInformation.information(lastName, FillOutForm.LAST_NAME),
                EnterInformation.information(postalCode, FillOutForm.POSTAL_CODE)
        );

        actor.attemptsTo(
                PressButton.button(FillOutForm.CONTINUE)
        );

        actor.attemptsTo(
                PressButton.button(CheckoutOverview.FINISH_PURCHASE)
        );
    }

    public static CheckOutInformation information(String firstName, String lastName, String postalCode) {
        return instrumented(CheckOutInformation.class, firstName, lastName, postalCode);
    }

}
