package starter.lichess.screenplay.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import starter.lichess.screenplay.pages.Rook;
import starter.lichess.screenplay.utils.HoverOverAndClick;

import static starter.lichess.screenplay.pages.Learn.*;
import static starter.lichess.screenplay.pages.Rook.ROOK;
import static starter.lichess.screenplay.pages.Rook.STAR;

public class Tutorial extends UIInteractionSteps {

    private Actor actor;
    private WebDriver driver;

    @Step
    public Performable start() {
        String password = SystemEnvironmentVariables.createEnvironmentVariables().getValue("PASSWORD");

        return Task.where("{0} logs in to lichess",
                Open.url("https://lichess.org/login"),
                Enter.theValue("helenarodcal").into("[name='username']"),
                Enter.theValue(password).into("[name='password']").thenHit(Keys.ENTER),
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
                HoverOverAndClick.on(find(ROOK)),
                HoverOverAndClick.on(find(STAR))
                );
    }

}
