package starter.lichess;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestBase {

    @Managed(driver="chrome")
    WebDriver oneBrowser;
    @Managed(driver="edge")
    WebDriver secondBrowser;

    public Actor learner = Actor.named("learner");
    public Actor host = Actor.named("host");
    public Actor guest = Actor.named("Anonymous");

    @BeforeEach
    void setUp() {
        learner.can(BrowseTheWeb.with(oneBrowser));
        host.can(BrowseTheWeb.with(oneBrowser));
        guest.can(BrowseTheWeb.with(secondBrowser));
    }

    @AfterEach
    void tearDown() {
        OnStage.drawTheCurtain();
    }
}
