package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import starter.lichess.screenplay.pages.InviteAFriendPage;

import static starter.lichess.screenplay.pages.InviteAFriendPage.CHALLENGE_URL;

public class Challenge implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return CHALLENGE_URL.resolveFor(actor).getValue();
    }


    public static Challenge url() {
        return new Challenge();
    }
}
