package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static starter.lichess.screenplay.pages.TutorialPage.STEP_COMPLETED;

public class TutorialProgress implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(STEP_COMPLETED).answeredBy(actor).isPresent();

//        return WebElementQuestion.the(".progress a:nth-child(1) .stars").answeredBy(actor).isPresent();
    }

    public static TutorialProgress isFinished() {
        return new TutorialProgress();
    }
}
