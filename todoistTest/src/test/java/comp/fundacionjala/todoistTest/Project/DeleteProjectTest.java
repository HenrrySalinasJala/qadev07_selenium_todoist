package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteProjectTest {

    private HomePage homePage;
    private String projectName = "To Test";

    @Before
    public void setUp() {

        homePage = LoginFrame.login("es.henrry@gmail.com", "TodoIst1234");
        homePage.clickOnLnkAddProject()
                .setTxtProjectName(projectName)
                .clickOnBtnAddProject();
    }

    @Test
    public void testDeleteProject() {
        homePage.locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
        assertFalse(homePage.webElementExists(homePage.getLblMenuProjectName()));
    }
}
