package comp.fundacionjala.todoistTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "filter_inbox")
    private WebElement btnInboxFilter;

    @FindBy(xpath = "//*[@id=\"project_list_man\"]/div[1]/a")
    private WebElement lnkAddProject;

    @FindBy(className = "submit_btn")
    private WebElement btnAddProject;

    @FindBy(className = "sel_richtext_editor")
    private WebElement txtProjectName;

    @FindBy(className = "project_link")
    private WebElement lnkProjectName;

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

    @FindBy(id = "menu_delete_text")
    private WebElement btnDeleteProjectContextOptionMenu;

    @FindBy(xpath = "//div[@id=\"GB_window\"]/descendant::span[text()=\"Ok\"]")
    private WebElement btnConfirmDelete;

    @FindBy(xpath = "/html/body/div[5]/table/tbody/tr[4]/td/div/span")
    private WebElement btnUpdateProjectContextOptionMenu;

    private WebElement lblMenuProjectName;

    public WebElement getBtnInboxFilter() {
        return btnInboxFilter;
    }

    public HomePage clickOnLnkAddProject() {
        if (lnkAddProject.isDisplayed() && lnkAddProject.isEnabled()) {
            lnkAddProject.click();
        }
        return this;
    }

    public HomePage clickOnBtnAddProject() {
        if (btnAddProject.isDisplayed() && btnAddProject.isEnabled()) {
            btnAddProject.click();
        }
        return this;
    }

    public HomePage setTxtProjectName(String projectName) {
        txtProjectName.clear();
        txtProjectName.sendKeys(projectName);
        return this;
    }

    public WebElement getLnkProjectName() {
        return lnkProjectName;
    }

    public HomePage clickOnBtnSettingsIcon() {

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

    public HomePage locateProjectByName(String projectName) {
        String xpath = new StringBuilder().append("//ul[@id='project_list']/descendant::span[text()='")
                .append(projectName)
                .append("']").toString();
        lblMenuProjectName = driver.findElement(By.xpath(xpath));
        return this;
    }

    public WebElement getLblMenuProjectName() {
        return lblMenuProjectName;
    }

    public HomePage openProjectContextMenu() {
        try {
            action.contextClick(lblMenuProjectName);
            action.build().perform();
        } catch (StaleElementReferenceException e) {

        } catch (NoSuchElementException e) {

        }
        return this;
    }

    public HomePage clickOnBtnDeleteProjectContextOptionMenu() {
        btnDeleteProjectContextOptionMenu.click();
        return this;
    }

    public HomePage clickOnBtnUpdateProjectContextOptionMenu() {
        btnUpdateProjectContextOptionMenu.click();
        return this;
    }

    public HomePage clickOnBtnConfirmDelete() {
        btnConfirmDelete.click();
        return this;
    }

    public TodoistPage clickOnBtnLogOutOptionMenu() {
        btnLogOutOptionMenu.click();
        return new TodoistPage();
    }
}
