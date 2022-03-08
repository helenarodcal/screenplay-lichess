package starter.lichess;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.lichess.screenplay.actions.Complete;
import starter.lichess.screenplay.actions.Login;
import starter.lichess.screenplay.actions.Navigate;
import starter.lichess.screenplay.actions.Start;
import starter.lichess.screenplay.pages.LandingPage;
import starter.lichess.screenplay.pages.PracticeCentrePage;
import starter.lichess.screenplay.questions.TutorialProgress;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLearningChess extends TestBase {

    @Test
    void whenPlayingTheFirstTutorial() {

        learner.attemptsTo(
//                Login.as("helenarodcal"),
                Open.browserOn().the(LandingPage.class),
                Start.tutorial()
        );

        learner.should(seeThat(
                "tutorial 1 is not marked done",
                TutorialProgress.isFinished(), is(false)
        ));
        learner.attemptsTo(Complete.tutorial());
        learner.should(seeThat(
                "tutorial 1 is marked done",
                TutorialProgress.isFinished(), is(true)
        ));

    }

}
