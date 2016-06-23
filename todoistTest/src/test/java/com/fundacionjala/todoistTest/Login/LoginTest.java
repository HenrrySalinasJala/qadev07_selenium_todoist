package com.fundacionjala.todoistTest.Login;

import com.fundacionjala.todoistTest.HomePage;
import org.junit.Test;

import com.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testLogin() {
        HomePage homePage;
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
        assertTrue(homePage.getSideBar().getBtnInboxFilter().isDisplayed());
    }
}
