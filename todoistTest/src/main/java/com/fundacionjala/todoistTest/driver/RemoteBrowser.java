package com.fundacionjala.todoistTest.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.fundacionjala.todoistTest.PropertiesInfo.getInstance;

public class RemoteBrowser implements IDriver {

    private URL url;

    private DesiredCapabilities caps;

    public WebDriver initDriver() {
        caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, getInstance().getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, getInstance().getBrowserVersion());
        caps.setCapability(CapabilityType.PLATFORM, getInstance().getPlatform());
        caps.setCapability("name", "example remote test");
        caps.setCapability("timeZone","La Paz");
        String sauceUrl = new StringBuilder().append("http://")
                .append(getInstance().getSauceUser())
                .append(":")
                .append(getInstance().getSauceKey())
                .append("@ondemand.saucelabs.com:80/wd/hub").toString();
        try {
            url = new URL(sauceUrl);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(url, caps);
    }
}
