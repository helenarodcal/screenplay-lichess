package starter.lichess;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TheMemory;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.lichess.screenplay.actions.Accept;
import starter.lichess.screenplay.questions.Challenge;
import starter.lichess.screenplay.questions.Guest;
import starter.lichess.screenplay.actions.Invite;
import starter.lichess.screenplay.actions.Login;
import starter.lichess.screenplay.pages.LandingPage;
import starter.lichess.screenplay.questions.Play;
import starter.lichess.screenplay.questions.Token;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static starter.lichess.screenplay.pages.InviteAFriendPage.BLACK_SET;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenPlayingChess extends TestBase {

    @Managed()
    private WebDriver browser;

    @Test
    public void whenWeInviteAFriendToPlay() {

        host.attemptsTo(
//                Login.as("helenarodcal"),
//                Invite.aFriend()
                Open.url("https://lichess.org/"),
                Invite.aFriend()
        );
        host.should(seeThat(TheMemory.withKey("invite url").isPresent()));
        guest.attemptsTo(
                Accept.invitationOf(host)
        );
        host.should(
                eventually(seeThat(Play.hasStarted(), is(true))),
                eventually(seeThat(Guest.isOnline(), is(true)))
        );
    }

    @Test
    void printingAuthToken() {
        host.attemptsTo(
                Login.as("helenarodcal"),
                Wait.until(
                        WebElementQuestion.the(LandingPage.PAIRING_OPTIONS_TABLE),
                        WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(5).seconds()
        );

        host.should(seeThat(Token.value(), is(not(nullValue()))));
    }
}
