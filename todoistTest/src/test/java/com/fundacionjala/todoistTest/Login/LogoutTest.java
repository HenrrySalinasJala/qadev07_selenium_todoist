package com.fundacionjala.todoistTest.login;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LogOutPage;
import com.fundacionjala.todoistTest.LoginFrame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = LoginFrame.loginAsPrimaryUser();
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
