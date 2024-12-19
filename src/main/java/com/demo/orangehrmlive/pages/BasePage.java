package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;

public class BasePage implements Locators{
    Page page;
    public BasePage(Page page) {
        this.page = page;
    }
    public void fillInput(String type, String value) {
        page.fill(String.format(input, type), value);
    }




}
