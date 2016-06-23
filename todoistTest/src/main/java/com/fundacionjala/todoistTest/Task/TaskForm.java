package com.fundacionjala.todoistTest.Task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fundacionjala.todoistTest.BasePage;
import com.fundacionjala.todoistTest.ProjectContainer;

public class TaskForm extends BasePage {

    @FindBy(css = ".richtext_editor.sel_richtext_editor")
    private WebElement txtTaskName;

    @FindBy(css = ".cmp_priority4.form_action_icon.menu_icon")
    private WebElement priorityIcon;

    @FindBy(css = "div.AmiMenu.priority_menu img.cmp_priority1")
    private WebElement imgPriority1;

    @FindBy(css = "div.AmiMenu.priority_menu img.cmp_priority2")
    private WebElement imgPriority2;

    @FindBy(css = "div.AmiMenu.priority_menu img.cmp_priority3")
    private WebElement imgPriority3;

    @FindBy(css = "div.AmiMenu.priority_menu img.cmp_priority4")
    private WebElement imgPriority4;

    @FindBy(css = "a.amibutton.amibutton_red.submit_btn")
    private WebElement btnAddTask;

    @FindBy(className = "cancel")
    private WebElement lnkCancelTask;

    public TaskForm setTxtTaskName(String taskName) {
        txtTaskName.clear();
        txtTaskName.sendKeys(taskName);
        return this;
    }

    public TaskForm clickOnPriorityIcon() {
        priorityIcon.click();
        return this;
    }

    public TaskForm clickOnImgPriority1() {
        imgPriority1.click();
        return this;
    }

    public TaskForm clickOnImgPriority2() {
        imgPriority2.click();
        return this;
    }

    public TaskForm clickOnImgPriority3() {
        imgPriority3.click();
        return this;
    }

    public TaskForm clickOnImgPriority4() {
        imgPriority4.click();
        return this;
    }

    public ProjectContainer clickOnBtnAddTask() {
        btnAddTask.click();
        return new ProjectContainer();
    }

    public ProjectContainer createTask(String taskName) {
        return setTxtTaskName(taskName)
                .clickOnPriorityIcon()
                .clickOnImgPriority3()
                .clickOnBtnAddTask();
    }
}
