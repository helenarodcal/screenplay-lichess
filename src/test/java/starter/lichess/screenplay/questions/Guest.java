package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static starter.lichess.screenplay.pages.PlayPage.ONLINE_OPPONENT;

public class Guest implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ONLINE_OPPONENT.resolveFor(actor).isVisible();
    }

    public static Guest isOnline() {
        return new Guest();
    }
}

