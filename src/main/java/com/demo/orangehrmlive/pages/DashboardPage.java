package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
public class DashboardPage extends BasePage implements Locators {
    public DashboardPage(Page page) {
        super(page);
    }
    private String tabTitle = "//div[@class='oxd-topbar-header-title']//h6";
    public void checkTabTitle(String value){
        String actualValue = page.locator(tabTitle).textContent();
        Assertions.assertEquals(value, actualValue);
    }
    public String getUserNameValue(){
        String name = page.locator(userName).textContent();
        return name;
    }
    public PIMPage menuItemClick(String type) {
        page.click(String.format(mainMenuItem, type));
        return new PIMPage(page);
    }
}
