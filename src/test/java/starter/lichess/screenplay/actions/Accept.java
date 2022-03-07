package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Accept implements Performable {
    private final String invitationUrl;

    public Accept(String invitationUrl) {
        this.invitationUrl = invitationUrl;
    }

    public static Performable invitationOf(Actor invitingActor) {

        return instrumented(Accept.class, invitingActor.recall("invite url"));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(invitationUrl)
        );
    }

}
