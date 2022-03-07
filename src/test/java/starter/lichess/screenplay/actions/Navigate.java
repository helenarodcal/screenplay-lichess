package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Performable {

    private final String url;

    public Navigate(String url) {
        this.url = url;
    }

    public static Performable to(String url) {
        return instrumented(Navigate.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(Open.url(url));
    }
}
