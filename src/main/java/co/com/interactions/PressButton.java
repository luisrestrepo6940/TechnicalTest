package co.com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PressButton implements Interaction {
    protected Target button;

    public PressButton(Target button) {
        this.button = button;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(button)
        );
    }

    public static PressButton button(Target target) {
        return instrumented(PressButton.class, target);
    }

}
