package comp.fundacionjala.todoistTest.Login;

import org.junit.Before;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LogOutPage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodoistPage;

import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private HomePage homePage;

    private TodoistPage indexPage;

    @Before
    public void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }

    @Test
    public void testLogOut() {
        LogOutPage logOutPage;
        logOutPage = homePage.getToolBar()
                .clickOnBtnSettingsIcon()
                .clickOnBtnLogOutOptionMenu();
        assertTrue(logOutPage.getImgLogo().isDisplayed());
    }
}
