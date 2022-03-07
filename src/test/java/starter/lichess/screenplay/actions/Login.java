package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.Keys;
import starter.lichess.screenplay.pages.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.lichess.screenplay.pages.LoginPage.*;

public class Login implements Performable {
    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable as(String username) {
       return instrumented(Login.class, username,
                //TODO: find the password for the specific user
                SystemEnvironmentVariables.createEnvironmentVariables().getValue("PASSWORD"));
    }

    @Override
    @Step("{0} logs into the app")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn().the(LoginPage.class),
//                Open.url("https://lichess.org/login"),
                Enter.theValue(username).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD).thenHit(Keys.ENTER));
    }
}
