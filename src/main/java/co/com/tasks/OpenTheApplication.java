package co.com.tasks;

import co.com.interactions.OpenApplication;
import co.com.questions.CheckApplicationOpening;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Task {

    private final String url;

    public OpenTheApplication(String url) {
        this.url = url;
    }

    @Override
    @Step("que el usuario {0} ingreso al aplicativo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(OpenApplication.startBrowser(url));
        actor.should(seeThat(CheckApplicationOpening.applicationOpening(), CoreMatchers.equalTo(true)));
    }

    public static OpenTheApplication startApplication(String url) {
        return instrumented(OpenTheApplication.class, url);
    }

}
