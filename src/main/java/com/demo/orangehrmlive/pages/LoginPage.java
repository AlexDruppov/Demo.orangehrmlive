package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }
    String errorItem = "//p[contains(@class ,'oxd-alert-content-text')]";
    public DashboardPage clickLoginBtn(String type) {
        page.click(String.format(btn, type));
        return new DashboardPage(page);
    }
    public void checkErrorMassage(){
        String actual = page.locator(errorItem).textContent();
        Assertions.assertEquals("Invalid credentials", actual);
        System.out.println(actual);
    }
}
