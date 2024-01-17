package co.com.tasks;

import co.com.interactions.EnterInformation;
import co.com.interactions.PressButton;
import co.com.questions.CheckApplicationAccess;
import co.com.userinterface.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("inicia sesion el usuario {0} registrado")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterInformation.information(username, LoginPage.USER_NAME),
                EnterInformation.information(password, LoginPage.PASSWORD),
                PressButton.button(LoginPage.LOGIN_BUTTON)
        );

        actor.attemptsTo(
                Ensure.that(CheckApplicationAccess.applicationAccess().answeredBy(actor)).isEqualTo("Products")
        );
    }

    public static Login authenticating(String username, String password) {
        return instrumented(Login.class, username, password);
    }

}
