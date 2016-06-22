package comp.fundacionjala.todoistTest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import comp.fundacionjala.todoistTest.Task.ITaskForm;
import comp.fundacionjala.todoistTest.Task.TaskForm;
import java.util.concurrent.TimeUnit;

public class ToolBar extends BasePage implements ITaskForm {

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

    @FindBy(css = ".icon.fixed_pos.cmp_light_add_task")
    private WebElement quickAddTaskIcon;

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

    public LogOutPage clickOnBtnLogOutOptionMenu() {
        btnLogOutOptionMenu.click();
        return new LogOutPage();
    }

    public TaskForm clickOnQuickAddTaskIcon() {
        quickAddTaskIcon.click();
        return new TaskForm();
    }

    public ProjectContainer createTask(String taskName) {
        return clickOnQuickAddTaskIcon().createTask(taskName);
    }
}
