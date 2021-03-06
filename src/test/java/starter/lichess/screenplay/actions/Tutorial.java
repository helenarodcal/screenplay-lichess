package starter.lichess.screenplay.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.lichess.screenplay.utils.HoverOverAndClick;

import static starter.lichess.screenplay.pages.PracticeCentrePage.*;
import static starter.lichess.screenplay.pages.TutorialPage.ROOK;
import static starter.lichess.screenplay.pages.TutorialPage.STAR;

public class Tutorial extends UIInteractionSteps {

    private Actor actor;
    private WebDriver driver;

    @Step
    public Performable start() {

        return Task.where("{0} starts one tutorial",
                Login.as("helenarodcal"),
                ResetTutorialProgress(),
                Click.on(ONGOING_TUTORIAL),
                Click.on(START_BUTTON)
        );
    }

    private Performable ResetTutorialProgress() {
        return Task.where("{0} resets progress",
                Open.url("https://lichess.org/learn#/"),
                Check.whether(WebElementQuestion.the(RESET_PROGRESS),
                        WebElementStateMatchers.isPresent()).andIfSo(Click.on(RESET_PROGRESS))
        );
    }

    @Step
    public Performable complete() {
        return Task.where("{0} completes the ongoing tutorial",
//                HoverOverTarget.over(ROOK).then(Click.on(ROOK).afterWaitingUntilEnabled())
                HoverOverAndClick.on(ROOK),
                HoverOverAndClick.on(STAR)
                );
    }

}
