package comp.fundacionjala.todoistTest.Login;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodoistPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private TodoistPage todoistPage;

    private HomePage homePage;

    private TodoistPage indexPage;

    @Before
    public void setUp() {
        todoistPage = new TodoistPage();
        todoistPage.clickOnBtnLogin();
        homePage = new LoginFrame().setTxtEmail("es.henrry@gmail.com")
                                    .setTxtPassword("TodoIst1234")
                                    .clickOnBtnLogin();
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }

    @Test
    public void testLogOut() {
        indexPage = homePage.getToolBar()
                            .clickOnBtnSettingsIcon()
                            .clickOnBtnLogOutOptionMenu();
        assertTrue(indexPage.getImgLogo().isDisplayed());
    }
}
