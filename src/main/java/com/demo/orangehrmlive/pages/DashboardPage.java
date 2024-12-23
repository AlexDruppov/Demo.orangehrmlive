package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
public class DashboardPage implements Locators {
    private Page page;
    public DashboardPage(Page page) {
        this.page = page;
    }
    private String tabTitle = "//div[@class='oxd-topbar-header-title']//h6";
    private String userName = "//p[@class='oxd-userdropdown-name']";

    public void checkTabTitle(String value){
        String actualvalue = page.locator(tabTitle).textContent();
        Assertions.assertEquals(value, actualvalue);
        System.out.println(actualvalue);
        System.out.println(value);
    }
    public void getuserNameValue(String value){
        String actualvalue = page.locator(userName).textContent();
        Assertions.assertEquals(value, actualvalue);
        System.out.println(actualvalue);
    }
    public PIMPage menuItemClick(String type) {
        page.click(String.format(mainMenuItem, type));
        return new PIMPage(page);
    }
}
