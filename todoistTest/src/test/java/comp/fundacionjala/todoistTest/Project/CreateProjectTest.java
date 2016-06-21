package comp.fundacionjala.todoistTest.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertTrue;

public class CreateProjectTest {

    private HomePage homePage;

    private String projectName = "project test";

    @Before
    public void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
    }

    @Test
    public void testCreateProject() {
        homePage.getSideBar()
                .clickOnLnkAddProject()
                .setTxtProjectName(projectName)
                .clickOnBtnAddProject();
        assertTrue(homePage.getProjectContainer().getLnkProjectName().isDisplayed());
    }

    @After
    public void tearDown() {
        homePage.getSideBar()
                .locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
    }
}
