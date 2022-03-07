package starter.lichess.screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://lichess.org/login")
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD =
            Target.the("username field").locatedBy("[name='username']");
    public static final Target PASSWORD_FIELD =
            Target.the("username field").locatedBy("[name='password']");
}
