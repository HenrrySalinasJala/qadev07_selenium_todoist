package com.fundacionjala.todoistTest.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;

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
                .clickOnBtnAddProject();
        homePage.getSideBar().locateProjectByName(expectedProjectNameUpdated);
        assertEquals("The project should be renamed",expectedProjectNameUpdated, homePage.getSideBar().getLblMenuProjectName());
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
