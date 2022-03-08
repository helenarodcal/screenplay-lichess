package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.lichess.screenplay.pages.PlayPage;

public class Play implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return PlayPage.CHESS_BOARD.resolveFor(actor).getElement().isDisplayed();
    }

    public static Play hasStarted() {
        return new Play();
    }
}

