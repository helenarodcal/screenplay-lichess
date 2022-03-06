package starter.lichess.screenplay.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class Rook extends PageObject {
    public static final By ROOK = By.cssSelector(".rook.white");
    public static final By STAR = By.cssSelector(".apple");
}
