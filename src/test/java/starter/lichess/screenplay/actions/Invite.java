package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import starter.lichess.screenplay.questions.Challenge;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.lichess.screenplay.pages.InviteAFriendPage.BLACK_SET;
import static starter.lichess.screenplay.pages.LandingPage.PLAY_WITH_FRIEND_BUTTON;

public class Invite implements Performable {
    public static Performable aFriend() {
        return instrumented(Invite.class);
    }

    @Override
    @Step("{0} invites a friend to play")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PLAY_WITH_FRIEND_BUTTON),
                Click.on(BLACK_SET),
                RememberThat.theValueOf("invite url").isAnsweredBy(
                        Challenge.url()
                ));
    }
}
