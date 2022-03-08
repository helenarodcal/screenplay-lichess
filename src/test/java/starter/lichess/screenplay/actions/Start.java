package starter.lichess.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.Keys;
import starter.lichess.screenplay.pages.LandingPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.lichess.screenplay.pages.LandingPage.PRACTICE_LINK;
import static starter.lichess.screenplay.pages.PracticeCentrePage.*;
import static starter.lichess.screenplay.pages.PracticeCentrePage.RESET_PROGRESS;

public class Start implements Performable {

    public static Performable tutorial() {
        return instrumented(Start.class);
    }

    @Override
    @Step("{0} starts the tutorial")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PRACTICE_LINK).afterWaitingUntilEnabled(),
                ResetTutorialProgress(),
                Click.on(ONGOING_TUTORIAL),
                Click.on(START_BUTTON)
        );
    }

    private Performable ResetTutorialProgress() {
        return Task.where("{0} resets progress",
                Navigate.to("https://lichess.org/learn#/"),
                Check.whether(WebElementQuestion.the(RESET_PROGRESS),
                        WebElementStateMatchers.isPresent()).andIfSo(Click.on(RESET_PROGRESS))
        );
    }
}
