package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }
    String errorLabel = "//p[contains(@class ,'oxd-alert-content-text')]";
    String usernameRequiredLabel = "//label[contains(., 'Username')]/../../span";
    String passwordRequiredLabel = "//label[contains(., 'Password')]/../../span";
    public DashboardPage clickLoginBtn(String type) {
        page.click(String.format(btn, type));
        return new DashboardPage(page);
    }
    public void checkErrorMassage(){
        String actual = page.locator(errorLabel).textContent();
        Assertions.assertEquals("Invalid credentials", actual);
        System.out.println(actual);
    }
    public void checkUsernameRequiredLabel(){
        String actual = page.locator(usernameRequiredLabel).textContent();
        Assertions.assertEquals("Required", actual);
    }
    public void checkPasswordRequiredLabel(){
        String actual = page.locator(passwordRequiredLabel).textContent();
        Assertions.assertEquals("Required", actual);
    }
}
