package com.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TodoistPage extends BasePage {

    @FindBy(xpath = "//ul[@id='top_menu']//a[@class='sel_login']")
    private WebElement btnLogin;

    @FindBy(name = "GB_frame")
    private WebElement parentLoginFrame;

    @FindBy(id = "GB_frame")
    private WebElement loginFrame;

    public TodoistPage() {
        goTo(PropertiesInfo.getInstance().getUrl());
    }

    public void goTo(String url) {

        if (!url.equals(driver.getCurrentUrl())) {
            driver.navigate().to(url);
        }
    }

    public LoginFrame clickOnBtnLogin() {
        wait.until(visibilityOf(btnLogin));
        btnLogin.click();
        driver.switchTo().frame(parentLoginFrame);
        driver.switchTo().frame(loginFrame);
        return new LoginFrame();
    }
}
