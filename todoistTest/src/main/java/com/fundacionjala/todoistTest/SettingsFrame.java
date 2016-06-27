package com.fundacionjala.todoistTest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.todoistTest.driver.DriverManager.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.todoistTest.driver.DriverManager.IMPLICIT_WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SettingsFrame extends BasePage {

    @FindBy(xpath = "//*[@id=\"user_info\"]/dl[2]/dd/span")
    private WebElement lblEmail;

    @FindBy(xpath = "//ul[@id='tabs']/descendant::a[text()='Account']")
    private WebElement tabAccount;

    @FindBy(className = "cmp_small_close")
    private WebElement imgCloseSettingsWindow;
    
    public SettingsFrame clickOnTabAccount() {
        
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            tabAccount.click();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        
        return this;
    }

    public String getLblEmail() {
        String email = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            email = lblEmail.getText();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return email;
    }

    public HomePage closeSettingsWindow() {
        driver.switchTo().defaultContent();
        imgCloseSettingsWindow.click();
        return new HomePage();
    }
}
