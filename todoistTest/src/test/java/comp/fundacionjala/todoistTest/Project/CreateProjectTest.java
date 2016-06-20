package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateProjectTest {

    private HomePage homePage;
    private String projectName="project test";

    @Before
    public void setUp() {
        homePage = LoginFrame.login("es.henrry@gmail.com", "TodoIst1234");
    }

    @Test
    public void testCreateProject() {
        homePage.clickOnLnkAddProject().setTxtProjectName(projectName).clickOnBtnAddProject();
        assertTrue(homePage.getLnkProjectName().isDisplayed());
    }
    @After
    public void tearDown(){
        homePage.locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
    }
}
