package com.fundacionjala.todoistTest.Login;

import org.junit.Before;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LogOutPage;
import com.fundacionjala.todoistTest.LoginFrame;
import com.fundacionjala.todoistTest.TodoistPage;

import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private HomePage homePage;

    private TodoistPage indexPage;

    @Before
    public void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }

    @Test
    public void testLogOut() {
        LogOutPage logOutPage;
        logOutPage = homePage.getToolBar()
                .clickOnBtnSettingsIcon()
                .clickOnBtnLogOutOptionMenu();
        assertTrue(logOutPage.getImgLogo().isDisplayed());
    }
}
