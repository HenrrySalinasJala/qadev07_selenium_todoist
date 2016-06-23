package comp.fundacionjala.todoistTest.Driver;

public class DriverFactory {

    public IDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            return new Chrome();
        } else if (browser.equals("firefox")) {
            return new Firefox();
        } else {
            return null;
        }
    }
}
