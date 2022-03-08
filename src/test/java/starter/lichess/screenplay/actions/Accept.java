package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.lichess.screenplay.pages.AcceptInvitationPage.ACCEPT_INVITE_BUTTON;

public class Accept implements Performable {
    private final String invitationUrl;

    public Accept(String invitationUrl) {
        this.invitationUrl = invitationUrl;
    }

    public static Performable invitationOf(Actor invitingActor) {
        return instrumented(Accept.class, invitingActor.recall("invite url").toString());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(invitationUrl);
        actor.attemptsTo(
                Open.url(invitationUrl),
                Click.on(ACCEPT_INVITE_BUTTON)
        );
    }

}
