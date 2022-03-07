package starter.lichess.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class Token implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String tokenValue = BrowseTheWeb.as(actor).getDriver().manage().getCookieNamed("lila2").getValue();
        System.out.println(tokenValue);
        return tokenValue;
    }


    public static Token value() {
        return new Token();
    }
}
