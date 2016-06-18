package comp.fundacionjala.todoistTest;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver=DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);

    }

}
