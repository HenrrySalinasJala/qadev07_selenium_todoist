package comp.fundacionjala.todoistTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolBar extends BasePage{

    @FindBy(id = "gear_holder")
    private WebElement btnSettingsIcon;

    @FindBy(xpath = "/html/body/div[15]/table/tbody/tr[7]/td/div/span")
    private WebElement btnTodoistSettingsOptionMenu;

    @FindBy(xpath = "/html/body/div[15]/table/tbody/tr[17]/td/div/span")
    private WebElement btnLogOutOptionMenu;

    @FindBy(className = "GB_frame")
    private WebElement settingsParentFrame;

    @FindBy(id = "GB_frame")
    private WebElement settingsFrame;

    public ToolBar clickOnBtnSettingsIcon() {

        try {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            btnSettingsIcon.click();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return this;
    }

    public SettingsFrame clickOnBtnTodoistSettingsOptionMenu() {
        SettingsFrame settings = new SettingsFrame();
        try {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            btnTodoistSettingsOptionMenu.click();
            driver.switchTo().frame(settingsParentFrame);
            driver.switchTo().frame(settingsFrame);
            return settings;
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return settings;
    }
    public TodoistPage clickOnBtnLogOutOptionMenu() {
        btnLogOutOptionMenu.click();
        return new TodoistPage();
    }
}
