package com.fundacionjala.todoistTest.login;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testLogin() {
        HomePage homePage;
        homePage = LoginFrame.loginAsPrimaryUser();
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }
}
