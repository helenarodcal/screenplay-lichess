package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.Keys;

public class StartTutorial implements Performable{

    @Override
    @Step("{0} logs in to lichess")
    public <T extends Actor> void performAs(T actor) {
        String password = SystemEnvironmentVariables.createEnvironmentVariables().getValue("PASSWORD");

        actor.attemptsTo(Open.url("https://lichess.org/login"));
        actor.attemptsTo(Enter.theValue("helenarodcal").into("[name='username']"));
        actor.attemptsTo(Enter.theValue(password).into("[name='password']").thenHit(Keys.ENTER));
    }

}
