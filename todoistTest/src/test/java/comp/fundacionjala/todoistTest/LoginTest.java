package comp.fundacionjala.todoistTest;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    @Test
    public void testLogin(){

        TodoistPage todoistPage=new TodoistPage();
        todoistPage.clickOnBtnLogin();
        LoginFrame loginFrame=new LoginFrame().setTxtEmail("es.henrry@gmail.com").setTxtPassword("TodoIst1234");
        HomePage homePage=loginFrame.clickOnBtnLogin();
        assertTrue(homePage.getBtnInboxFilter().isDisplayed());
    }
    
}
