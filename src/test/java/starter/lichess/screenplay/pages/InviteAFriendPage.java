package starter.lichess.screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;

public class InviteAFriendPage {
    public static final Target BLACK_SET =
            Target.the("select the black set").locatedBy(".color-submits__button.black");

    public static final Target CHALLENGE_URL =
            Target.the("challenge url").locatedBy("#challenge-id");
}
