package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoistPage extends BasePage {

    private static String BASE_URL = "https://.en.todoist.com";

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/div/ul/li[3]/a")
    private WebElement btnLogin;

    @FindBy(name = "GB_frame")
    private WebElement parentLoginFrame;

    @FindBy(id = "GB_frame")
    private WebElement loginFrame;

    @FindBy(className = "logo")
    private WebElement imgLogo;

    public TodoistPage() {
        goTo(BASE_URL);
    }

    public void goTo(String url) {

        if (!url.equals(driver.getCurrentUrl())) {
            driver.navigate().to(url);
        }
    }

    public LoginFrame clickOnBtnLogin() {
        btnLogin.click();
        driver.switchTo().frame(parentLoginFrame);
        driver.switchTo().frame(loginFrame);
        return new LoginFrame();
    }

    public WebElement getImgLogo() {
        return imgLogo;
    }
}
