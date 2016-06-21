package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateProjectTest {

    private HomePage homePage;

    private String projectName = "To Test";

    private String expectedProjectNameUpdated = "To Test Updated";

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
    public void testUpdateProject() {
        homePage.getSideBar()
                .locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnUpdateProjectContextOptionMenu()
                .setTxtProjectName(expectedProjectNameUpdated)
                .clickOnBtnAddProject()
                .locateProjectByName(expectedProjectNameUpdated);
        assertEquals(expectedProjectNameUpdated, homePage.getSideBar().getLblMenuProjectName().getText());
    }

    @After
    public void tearDown() {
        homePage.getSideBar()
                .locateProjectByName(expectedProjectNameUpdated)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
    }
}
