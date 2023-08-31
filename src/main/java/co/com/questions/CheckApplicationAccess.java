package co.com.questions;

import co.com.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CheckApplicationAccess implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.SESSION_STARTED.resolveFor(actor).getText();
    }

    public static CheckApplicationAccess applicationAccess() {
        return new CheckApplicationAccess();
    }
}
