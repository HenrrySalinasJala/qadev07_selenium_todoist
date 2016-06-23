package com.fundacionjala.todoistTest;

import java.util.concurrent.TimeUnit;

import com.fundacionjala.todoistTest.driver.FactoryDriver;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static final int WAIT_TIME = 30;

    public static final int IMPLICIT_WAIT_TIME = 15;

    public static final int IMPLICIT_FAIL_WAIT_TIME = 4;

    public static final String BROWSER = "chrome";

    private static String driverPath = ".\\lib\\";

    private static DriverManager instance;

    private WebDriver driver;

    private DriverManager() {
        initWebDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initWebDriver() {
        driver = FactoryDriver.getDriver(BROWSER).initDriver();

        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}