package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Locator;

public interface Locators {
    String input = "//input[@name='%s']";
    String mainMenuItem = "//a[contains(@class, 'oxd-main-menu-item')]//span[contains(.,'%s')]";
    String btn = "//button[contains(.,'%s')]";
    String switchBtn = "//span[contains(@class, 'oxd-switch-input')]";
    String tabMenuItem = "//a[contains(.,'%s')]";
    String userAccountBtn = "//span[@class='oxd-userdropdown-tab']//p";
    String logoutBtn = "//a[contains(., 'Logout')]";





}
