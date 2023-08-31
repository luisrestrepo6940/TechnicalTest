package co.com.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static Target USER_NAME = Target.the("username").locatedBy("//div[@class='form_group']//input[@id='user-name']");
    public static final Target PASSWORD = Target.the("password").locatedBy("//div[@class='form_group']//input[@id='password']");
    public static final Target LOGIN_BUTTON = Target.the("loginButton").locatedBy("//input[@id='login-button']");
    public static final Target SESSION_STARTED = Target.the("sessionStarted").locatedBy("//span[@class='title']");
    public static final Target ERROR_MESSAGE = Target.the("errorMessage").locatedBy("//div[@class='form_group']//input[@class='error-message-container error']");
}
