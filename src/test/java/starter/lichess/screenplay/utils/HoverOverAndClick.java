package starter.lichess.screenplay.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HoverOverAndClick implements Performable {
    private final WebElement element;

    public HoverOverAndClick(WebElement element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public static Performable on(WebElement element) {
        return instrumented(HoverOverAndClick.class, element);
    }

}
