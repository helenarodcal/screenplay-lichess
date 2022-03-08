package starter.lichess.screenplay.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://lichess.org/")
public class LandingPage extends PageObject {
    public static final Target PRACTICE_LINK =
            Target.the("practice link").located(By.cssSelector("#topnav section > a[href='/practice']"));
    public static final String PAIRING_OPTIONS_TABLE = ".lobby__app__content";
//    public static final Target PAIRING_OPTIONS_TABLE =
//            Target.the("pairing options table").locatedBy(".lobby__app__content");
    public static final Target PLAY_WITH_FRIEND_BUTTON =
            Target.the("play with a friend button").locatedBy(".config_friend");
}
