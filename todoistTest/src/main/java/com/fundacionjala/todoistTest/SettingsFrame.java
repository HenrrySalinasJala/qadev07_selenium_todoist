package com.fundacionjala.todoistTest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SettingsFrame extends BasePage {

    @FindBy(xpath = "//*[@id=\"user_info\"]/dl[2]/dd/span")
    private WebElement lblEmail;

    @FindBy(xpath = "//ul[@id='tabs']/descendant::a[text()='Account']")
    private WebElement tabAccount;

    @FindBy(className = "cmp_small_close")
    private WebElement imgCloseSettingsWindow;
    
    public SettingsFrame clickOnTabAccount() {
        
        try {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            tabAccount.click();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        
        return this;
    }

    public String getLblEmail() {
        String email = "";
        try {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            email = lblEmail.getText();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return email;
    }

    public HomePage closeSettingsWindow() {
        driver.switchTo().defaultContent();
        imgCloseSettingsWindow.click();
        return new HomePage();
    }
}
