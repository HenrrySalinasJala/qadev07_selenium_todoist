package com.fundacionjala.todoistTest;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    protected Actions action;

    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, DriverManager.WAIT_TIME);
    }

    public boolean webElementExists(WebElement webElement) {
        boolean exists;
        try {
            webElement.isEnabled();
            exists = true;
        } catch (StaleElementReferenceException e) {
            exists = false;
        }
        return exists;
    }
}
