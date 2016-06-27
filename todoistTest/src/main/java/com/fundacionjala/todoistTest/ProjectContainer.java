package com.fundacionjala.todoistTest;

import com.fundacionjala.todoistTest.factory.FactoryPage;
import com.fundacionjala.todoistTest.factory.IPage;
import com.fundacionjala.todoistTest.factory.PageGenerator;
import com.fundacionjala.todoistTest.factory.TodayPage;
import com.fundacionjala.todoistTest.task.TaskForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProjectContainer extends BasePage {

    @FindBy(className = "project_link")
    private WebElement lnkProjectName;

    @FindBy(css = "div.controller.actions.pe_controller>a.action")
    private WebElement lnkAddTask;

    @FindBy(className = "cancel")
    private WebElement lnkCancelTask;

    private TodayPage todayPage;

    public ProjectContainer() {
        todayPage = new TodayPage();
    }

    public WebElement getLnkProjectName() {
        return lnkProjectName;
    }

    public TaskForm clickOnLnkAddTask() {
        wait.until(visibilityOf(lnkAddTask));
        lnkAddTask.click();
        return new TaskForm();
    }

    public IPage loadPage(FactoryPage factoryPage) {
        PageGenerator pageGenerator = new PageGenerator();
        return pageGenerator.generatePage(factoryPage);
    }

    public TodayPage getTodayPage() {
        return todayPage;
    }

    public ProjectContainer clickOnLnkCancelTask() {
        lnkCancelTask.click();
        return new ProjectContainer();
    }

    public boolean isProjectNameDisplayed() {
        return lnkProjectName.isDisplayed();
    }
}
