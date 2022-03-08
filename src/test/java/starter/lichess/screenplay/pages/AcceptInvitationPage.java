package starter.lichess.screenplay.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AcceptInvitationPage extends PageObject {
    public static final Target ACCEPT_INVITE_BUTTON =
            Target.the("accept invitation button").locatedBy(".accept button");

}
