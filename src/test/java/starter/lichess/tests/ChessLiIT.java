package starter.lichess.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.lichess.screenplay.actions.Tutorial;
import starter.lichess.screenplay.questions.TutorialProgress;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class ChessLiIT {

    @Managed()
    private WebDriver browser;

    @Steps
    Tutorial tutorial;

    @Test
    public void whenPlayingTheFirstTutorial() {
        Actor actor = new Actor("chess player");
        actor.can(BrowseTheWeb.with(browser));

//        actor.attemptsTo(new StartTutorial());
        actor.attemptsTo(tutorial.start());
        actor.should(seeThat("tutorial 1 is not marked done",TutorialProgress.isFinished(), is(false)));
        actor.attemptsTo(tutorial.complete());
        actor.should(seeThat("tutorial 1 is marked done",
                WebElementQuestion.the(".progress a:nth-child(1) .stars"), WebElementStateMatchers.isPresent()
        ));

    }

}
