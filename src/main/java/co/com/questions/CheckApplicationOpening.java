package co.com.questions;

import co.com.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CheckApplicationOpening implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return HomePage.HOME_PAGE.resolveFor(actor).isVisible();
    }

    public static CheckApplicationOpening applicationOpening() {
        return new CheckApplicationOpening();
    }

}
