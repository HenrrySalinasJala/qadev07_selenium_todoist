package comp.fundacionjala.todoistTest.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {

    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
