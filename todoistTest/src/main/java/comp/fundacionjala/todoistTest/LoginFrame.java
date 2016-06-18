package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFrame extends BasePage {
    @FindBy(id = "email")
    private WebElement txtEmail;
    @FindBy(id = "password")
    private WebElement txtPassword;
    @FindBy(xpath = "/html/body/div[1]/div/form/dl/dd[3]/a")
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
    public static HomePage login(String email, String password){

            TodoistPage todoistPage =new TodoistPage();
        LoginFrame loginFrame= todoistPage.clickOnBtnLogin();
            //if (!dashboard.getUserNameText().equals(username)){
                return loginFrame.setTxtEmail(email).setTxtPassword(password).clickOnBtnLogin();
            //}

            //return dashboard;
    }
}
