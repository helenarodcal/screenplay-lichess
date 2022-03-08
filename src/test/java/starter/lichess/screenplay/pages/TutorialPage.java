package starter.lichess.screenplay.pages;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;

public class TutorialPage extends UIInteractionSteps {

    public static final Target ROOK =
            Target.the("rook").locatedBy(".rook.white");
    public static final Target STAR =
            Target.the("star").locatedBy(".apple");
    public static final String STEP_COMPLETED =".progress a:nth-child(1) .stars";
}
