package com.fundacionjala.todoistTest.factory;

import com.fundacionjala.todoistTest.BasePage;
import com.fundacionjala.todoistTest.ProjectContainer;
import com.fundacionjala.todoistTest.task.ITaskForm;
import com.fundacionjala.todoistTest.task.TaskForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodayPage extends BasePage implements ITaskForm, IPage {

    @FindBy(css = "li.add_task>a.action")
    private WebElement lnkAddTask;

    public TaskForm clickOnLnkTodayAddTask() {
        lnkAddTask.click();
        return new TaskForm();
    }

    public ProjectContainer createTask(String taskName) {
        return clickOnLnkTodayAddTask().createTask(taskName).clickOnLnkCancelTask();
    }
}
