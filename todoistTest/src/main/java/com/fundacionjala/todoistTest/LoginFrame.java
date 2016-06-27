package com.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFrame extends BasePage {

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//dd[@class='submit']//a[@class='amibutton amibutton_red sel_login']")
    private WebElement btnLogin;

    public LoginFrame setTxtEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
        return this;
    }

    public LoginFrame setTxtPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public HomePage clickOnBtnLogin() {
        btnLogin.click();
        return new HomePage();
    }

    public static HomePage login(String email, String password) {
        String lblEmail;
        TodoistPage todoistPage = new TodoistPage();
        SettingsFrame settingsFrame = new HomePage().getToolBar().clickOnBtnSettingsIcon()
                .clickOnBtnTodoistSettingsOptionMenu();
        lblEmail = settingsFrame.clickOnTabAccount().getLblEmail();

        if (!lblEmail.equals(email)) {

            LoginFrame loginFrame = todoistPage.clickOnBtnLogin();
            return loginFrame.setTxtEmail(email).setTxtPassword(password).clickOnBtnLogin();
        } else {
            return settingsFrame.closeSettingsWindow();
        }
    }

    public static HomePage loginAsPrimaryUser() {
        final String username = PropertiesInfo.getInstance().getEmail();
        final String password = PropertiesInfo.getInstance().getPassword();
        return login(username, password);
    }
}
