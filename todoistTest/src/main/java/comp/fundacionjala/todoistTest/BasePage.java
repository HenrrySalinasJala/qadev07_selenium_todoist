package comp.fundacionjala.todoistTest;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    Actions action;

    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public boolean webElementExists(WebElement webElement) {
        boolean exists;
        try {
            webElement.isEnabled();
            exists = true;
        } catch (StaleElementReferenceException e) {
            exists = false;
        }
        return exists;
    }
}
