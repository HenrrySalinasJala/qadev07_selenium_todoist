package comp.fundacionjala.todoistTest.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import comp.fundacionjala.todoistTest.BasePage;
import java.util.List;

public class Task extends BasePage {

    private WebElement taskList;

    @FindBy(xpath = "//span[text()=\"Delete task\" and not(ancestor::div[contains(@style, 'display: none;')])]")
    private WebElement btnDeleteTask;

    @FindBy(css = "div.alert_holder.gb_iframe_html a.amibutton.amibutton_red")
    private WebElement btnConfirmDelete;

    @FindBy(xpath = "//span[text()=\"Edit task\" and not(ancestor::div[contains(@style, 'display: none;')])]")
    private WebElement btnEditTask;

    public void getTaskList() {
        taskList = driver.findElement(By.cssSelector(".items.day_list.ul_today"));
        wait.until(ExpectedConditions.visibilityOf(taskList));
    }

    public List<WebElement> getTasksByName(String taskName) {
        getTaskList();
        List<WebElement> tasks = taskList.findElements(By.xpath(".//span[text()='" + taskName + "']"));
        return tasks;
    }

    public boolean taskExists(String taskName) {
        boolean exists = false;
        String taskXpath = new StringBuilder().append(".//span[text()='").append(taskName).append("']").toString();
        try {
            getTaskList();
            WebElement task = taskList.findElement(By.xpath(taskXpath));
            if (task.isDisplayed()) {
                exists = true;
            }
        } catch (StaleElementReferenceException e) {
            exists = false;
        }
        return exists;
    }

    public void deleteTask(String taskName) {
        String taskXpath = new StringBuilder().append(".//span[text()='").append(taskName).append("']").toString();
        getTaskList();
        WebElement task = taskList.findElement(By.xpath(taskXpath));
        action.contextClick(task)
                .build()
                .perform();
        clickOnBtnDeleteTask().clickOnBtnConfirmDelete();
    }

    public Task clickOnBtnDeleteTask() {
        btnDeleteTask.click();
        return this;
    }

    public Task clickOnBtnConfirmDelete() {
        btnConfirmDelete.click();
        return this;
    }

    public void updateTaskName(String taskName,String newTaskName) {
        String taskXpath = new StringBuilder().append(".//span[text()='").append(taskName).append("']").toString();
        getTaskList();
        WebElement task = taskList.findElement(By.xpath(taskXpath));
        action.contextClick(task)
                .build()
                .perform();
        TaskForm taskForm=clickOnBtnEditTask();
        taskForm.setTxtTaskName(newTaskName)
                .clickOnBtnAddTask();



    }

    public TaskForm clickOnBtnEditTask() {
        btnEditTask.click();
        return new TaskForm();

    }
}
