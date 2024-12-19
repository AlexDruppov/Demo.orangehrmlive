package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;

public class PIMPage extends BasePage {
    public PIMPage(Page page) {
        super(page);
    }
    public void addEmployee(String type){
        page.click(String.format(btn, type));
    }
}
