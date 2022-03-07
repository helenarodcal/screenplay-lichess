package starter.lichess.screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LandingPage {

    public static final Target PAIRING_OPTIONS_TABLE =
            Target.the("pairing options table").locatedBy(".lobby__app__content");
    public static final Target PLAY_WITH_FRIEND_BUTTON =
            Target.the("play with a friend button").locatedBy(".config_friend");
}
