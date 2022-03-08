package starter.lichess.screenplay.utils;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HoverOverAndClick extends UIInteractionSteps implements Performable {
    private final Target elementLocator;

    public HoverOverAndClick(Target elementLocator) {
        this.elementLocator = elementLocator;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = elementLocator.resolveFor(actor).getElement();
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public static Performable on(Target elementLocator) {
        return instrumented(HoverOverAndClick.class, elementLocator);
    }

}
