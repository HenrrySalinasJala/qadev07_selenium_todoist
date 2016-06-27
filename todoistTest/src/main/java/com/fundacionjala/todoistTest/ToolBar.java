package com.fundacionjala.todoistTest;

import com.fundacionjala.todoistTest.task.ITaskForm;
import com.fundacionjala.todoistTest.task.TaskForm;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.todoistTest.DriverManager.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.todoistTest.DriverManager.IMPLICIT_WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ToolBar extends BasePage implements ITaskForm {

    @FindBy(id = "gear_holder")
    private WebElement btnSettingsIcon;

    @FindBy(xpath = "//span[text()='Todoist Settings']")
    private WebElement btnTodoistSettingsOptionMenu;

    @FindBy(xpath = "//div[@class='AmiMenu']/descendant::span[text()='Log out']")
    private WebElement btnLogOutOptionMenu;

    @FindBy(className = "GB_frame")
    private WebElement settingsParentFrame;

    @FindBy(id = "GB_frame")
    private WebElement settingsFrame;

    @FindBy(css = ".icon.fixed_pos.cmp_light_add_task")
    private WebElement quickAddTaskIcon;

    public ToolBar clickOnBtnSettingsIcon() {

        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            btnSettingsIcon.click();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return this;
    }

    public SettingsFrame clickOnBtnTodoistSettingsOptionMenu() {
        SettingsFrame settings = new SettingsFrame();
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            btnTodoistSettingsOptionMenu.click();
            driver.switchTo().frame(settingsParentFrame);
            driver.switchTo().frame(settingsFrame);
            return settings;
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
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
