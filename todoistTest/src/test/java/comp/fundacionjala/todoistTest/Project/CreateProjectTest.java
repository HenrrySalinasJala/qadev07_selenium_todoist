package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.BaseTest;
import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateProjectTest extends BaseTest{

    private HomePage homePage;
    private String projectName="project test";

    @Before
    public void setUpTest() {
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
    public void tearDownTest(){
        homePage.getSideBar()
                .locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
    }
}
