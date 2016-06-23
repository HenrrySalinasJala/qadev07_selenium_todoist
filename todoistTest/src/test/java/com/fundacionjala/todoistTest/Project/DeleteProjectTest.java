package com.fundacionjala.todoistTest.Project;

import org.junit.Before;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;
import com.fundacionjala.todoistTest.SideBar;

import static org.junit.Assert.assertFalse;

public class DeleteProjectTest {

    private HomePage homePage;

    private String projectName = "To Test";

    @Before
    public void setUp() {
        homePage = LoginFrame.loginAsPrimaryUser();
        homePage.getSideBar()
                .clickOnLnkAddProject()
                .setTxtProjectName(projectName)
                .clickOnBtnAddProject();
    }

    @Test
    public void testDeleteProject() {
        SideBar sideBar=homePage.getSideBar();
        sideBar.locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
        assertFalse("The project should be deleted",homePage.webElementExists(sideBar.getLblProjectName()));
    }
}
