package starter.lichess.screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Learn {
    public static final Target RESET_PROGRESS = Target.the("reset progress option in sidebar")
            .locatedBy(".learn__side-home .actions .confirm");
    public static final Target ONGOING_TUTORIAL = Target.the("ongoing tutorial link")
            .located(By.cssSelector("a[class='stage ongoing']"));
    public static final Target START_BUTTON = Target.the("let's start button")
            .locatedBy(".next");
}
