package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import comp.fundacionjala.todoistTest.Factory.IPage;
import comp.fundacionjala.todoistTest.Task.ITaskForm;
import comp.fundacionjala.todoistTest.Task.TaskForm;

public class TodayPage extends BasePage implements ITaskForm,IPage{

    @FindBy(css = "li.add_task>a.action")
    private WebElement lnkAddTask;

    public TodayPage() {

    }

    public TaskForm clickOnLnkTodayAddTask() {
        lnkAddTask.click();
        return new TaskForm();
    }

    public ProjectContainer createTask(String taskName) {
        return clickOnLnkTodayAddTask().createTask(taskName).clickOnLnkCancelTask();
    }
}
