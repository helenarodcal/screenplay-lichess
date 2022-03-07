package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import starter.lichess.screenplay.pages.TutorialPage;
import starter.lichess.screenplay.utils.HoverOverAndClick;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.lichess.screenplay.pages.TutorialPage.ROOK;
import static starter.lichess.screenplay.pages.TutorialPage.STAR;

public class Complete implements Performable {

    public static Performable tutorial() {
        return instrumented(Complete.class);
    }

    @Override
    @Step("{0} starts the tutorial")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                HoverOverAndClick.on(ROOK),
                HoverOverAndClick.on(STAR)
        );
    }

}
