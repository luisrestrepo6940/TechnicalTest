package co.com.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverview extends PageObject {

    public static final Target FINISH_PURCHASE = Target.the("finish purchase").locatedBy("//button[@id='finish']");

}
