package comp.fundacionjala.todoistTest.Login;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodoistPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private TodoistPage todoistPage;
    private HomePage homePage;
    @Test
    public void testLogin() {

        todoistPage= new TodoistPage();
        todoistPage.clickOnBtnLogin();
        homePage = new LoginFrame().setTxtEmail("es.henrry@gmail.com")
                .setTxtPassword("TodoIst1234")
                .clickOnBtnLogin();
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }
}
