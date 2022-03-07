package starter.lichess;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestBase {

    @Managed
    private static WebDriver oneBrowser;
    private static WebDriver secondBrowser;

    public static Actor host = Actor.named("host");
    public static Actor guest = Actor.named("Anonymous");

    @BeforeAll
    static void setUp() {
        host.can(BrowseTheWeb.with(oneBrowser));
        guest.can(BrowseTheWeb.with(secondBrowser));
    }

}
