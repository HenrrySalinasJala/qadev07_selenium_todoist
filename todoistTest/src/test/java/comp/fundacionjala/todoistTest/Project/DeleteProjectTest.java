package comp.fundacionjala.todoistTest.Project;

import org.junit.Before;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertFalse;

public class DeleteProjectTest {

    private HomePage homePage;

    private String projectName = "To Test";

    @Before
    public void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
        homePage.getSideBar()
                .clickOnLnkAddProject()
                .setTxtProjectName(projectName)
                .clickOnBtnAddProject();
    }

    @Test
    public void testDeleteProject() {
        homePage.getSideBar()
                .locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
        assertFalse(homePage.webElementExists(homePage.getSideBar().getLblMenuProjectName()));
    }
}
