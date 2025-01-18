package com.qa.demo.orangehrmlive.tests.negativeTest.LoginPage;

import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;

import static com.demo.orangehrmlive.constant.Constant.Credentials.PASSWORD;
import static com.demo.orangehrmlive.constant.Constant.Credentials.USERNAME;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginWithWrongUsername() {
        loginPage.fillInput("username", USERNAME+1);
        page.waitForTimeout(2000);
        loginPage.fillInput("password", PASSWORD);
        loginPage.clickBtn("Login");
        loginPage.checkErrorMassage();
    }
    @Test
    public void loginWithWrongPassword() {
        loginPage.fillInput("username", USERNAME);
        loginPage.fillInput("password", PASSWORD+1);
        loginPage.clickBtn("Login");
        loginPage.checkErrorMassage();
    }
    @Test
    public void loginWithoutUsername() {
        loginPage.fillInput("password", PASSWORD);
        loginPage.clickBtn("Login");
        loginPage.checkUsernameRequiredLabel();
    }
    @Test
    public void loginWithoutPassword() {
        loginPage.fillInput("username", USERNAME);
        loginPage.clickBtn("Login");
        loginPage.checkPasswordRequiredLabel();
    }
}
