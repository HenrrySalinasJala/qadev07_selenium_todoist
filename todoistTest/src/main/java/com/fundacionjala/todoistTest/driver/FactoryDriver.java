package com.fundacionjala.todoistTest.driver;

import org.openqa.selenium.WebDriverException;

public final class FactoryDriver {

    public static final String CHROME = "chrome";

    public static final String FIREFOX = "firefox";

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        if (CHROME.equals(browser)) {
            return new Chrome();
        } else if (FIREFOX.equals(browser)) {
            return new Firefox();
        } else {
            throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
