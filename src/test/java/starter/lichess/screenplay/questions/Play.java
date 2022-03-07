package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static starter.lichess.screenplay.pages.PlayPage.CHESS_BOARD;

public class Play implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        return CHESS_BOARD.isVisibleFor(actor);
    }

    public static Play hasStarted() {
        return new Play();
    }
}

