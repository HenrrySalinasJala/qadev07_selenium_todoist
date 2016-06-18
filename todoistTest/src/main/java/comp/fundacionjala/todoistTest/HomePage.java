package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    @FindBy(id = "filter_inbox")
    private WebElement btnInboxFilter;
    @FindBy(xpath = "//*[@id=\"project_list_man\"]/div[1]/a")
    private WebElement lnkAddProject;
    @FindBy(className = "submit_btn")
    private WebElement btnAddProject;
    @FindBy(className = "sel_richtext_editor")
    private WebElement txtNewProjectName;
    @FindBy(className = "project_link")
    private WebElement lnkProjectName;
    
    public WebElement getBtnInboxFilter() {
        return btnInboxFilter;
    }

    public HomePage clickOnLnkAddProject() {
        if(lnkAddProject.isDisplayed() && lnkAddProject.isEnabled()){
            lnkAddProject.click();
        }
        return this;
    }
    public HomePage clickOnBtnAddProject() {
        if(btnAddProject.isDisplayed() && btnAddProject.isEnabled()){
            btnAddProject.click();
        }
        return this;
    }

    public HomePage setTxtNewProjectName(String projectName) {
        txtNewProjectName.clear();
        txtNewProjectName.sendKeys(projectName);
        return this;
    }

    public WebElement getLnkProjectName() {
        return lnkProjectName;
    }
}
