package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }
    public DashboardPage clickLoginBtn(String type) {
        page.click(String.format(btn, type));
        return new DashboardPage(page);
    }
    public void menuItemClick(String type) {
        page.click(mainMenuItem);
    }
}
