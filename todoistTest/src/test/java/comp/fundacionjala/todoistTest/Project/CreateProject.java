package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateProject {
    private HomePage homePage;
@Before
public void setUp(){
    homePage=LoginFrame.login("es.henrry@gmail.com","TodoIst1234");
}
    @Test
    public void testCreateProject(){
        homePage.clickOnLnkAddProject().setTxtNewProjectName("example 1").clickOnBtnAddProject();
        assertTrue(homePage.getLnkProjectName().isDisplayed());
    }
}
