package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
public class DashboardPage extends BasePage implements Locators {
    public DashboardPage(Page page) {
        super(page);
    }
    private String tabTitle = "//div[@class='oxd-topbar-header-title']//h6";
    private String userName = "//p[@class='oxd-userdropdown-name']";
    public void checkTabTitle(String value){
        String actualValue = page.locator(tabTitle).textContent();
        Assertions.assertEquals(value, actualValue);
        System.out.println(actualValue);
        System.out.println(value);
    }
    public void getUserNameValue(String value){
        String actualvalue = page.locator(userName).textContent();
        Assertions.assertEquals(value, actualvalue);
        System.out.println(actualvalue);
    }
    public PIMPage menuItemClick(String type) {
        page.click(String.format(mainMenuItem, type));
        return new PIMPage(page);
    }
}
