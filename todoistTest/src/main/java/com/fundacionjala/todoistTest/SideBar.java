package com.fundacionjala.todoistTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SideBar extends BasePage {

    @FindBy(id = "filter_inbox")
    private WebElement btnInboxFilter;

    @FindBy(xpath = "//a[@class='action sel_add_project' and not(ancestor::div[contains(@style, 'display: none;')])]")
    private WebElement lnkAddProject;

    @FindBy(className = "submit_btn")
    private WebElement btnAddProject;

    @FindBy(className = "sel_richtext_editor")
    private WebElement txtProjectName;

    @FindBy(id = "menu_delete_text")
    private WebElement btnDeleteProjectContextOptionMenu;


    @FindBy(xpath = "//div[@class=\"AmiMenu\"]/descendant::span[text()=\"Edit project\"]")
    private WebElement btnUpdateProjectContextOptionMenu;

    private WebElement lblMenuProjectName;

    @FindBy(css = ".cmp_filter_today")
    private WebElement imgToday;

    public WebElement getBtnInboxFilter() {
        return btnInboxFilter;
    }

    public SideBar clickOnLnkAddProject() {
        wait.until(visibilityOf(lnkAddProject));
        lnkAddProject.click();
        return this;
    }

    public ProjectContainer clickOnBtnAddProject() {
        if (btnAddProject.isDisplayed() && btnAddProject.isEnabled()) {
            btnAddProject.click();
        }
        return new ProjectContainer();
    }

    public SideBar setTxtProjectName(String projectName) {
        txtProjectName.clear();
        txtProjectName.sendKeys(projectName);
        return this;
    }

    public SideBar locateProjectByName(String projectName) {
        String xpath = new StringBuilder().append("//ul[@id='project_list']/descendant::span[text()='")
                .append(projectName)
                .append("']").toString();
        lblMenuProjectName = driver.findElement(By.xpath(xpath));
        return this;
    }

    public String getLblMenuProjectName() {
        return lblMenuProjectName.getText();
    }

    public SideBar openProjectContextMenu() {
        try {
            action.contextClick(lblMenuProjectName);
            action.build().perform();
        } catch (StaleElementReferenceException e) {

        } catch (NoSuchElementException e) {

        }
        return this;
    }

    public DeleteAlert clickOnBtnDeleteProjectContextOptionMenu() {
        btnDeleteProjectContextOptionMenu.click();
        return new DeleteAlert();
    }

    public SideBar clickOnBtnUpdateProjectContextOptionMenu() {
        btnUpdateProjectContextOptionMenu.click();
        return this;
    }


    public ProjectContainer clickOnImgToday() {
        imgToday.click();
        return new ProjectContainer();
    }
    public WebElement getLblProjectName(){
        return lblMenuProjectName;
    }
}
