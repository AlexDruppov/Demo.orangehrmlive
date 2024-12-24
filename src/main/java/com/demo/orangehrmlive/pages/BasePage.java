package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage implements Locators{
    Page page;
    public BasePage(Page page) {
        this.page = page;
    }
    public void fillInput(String type, String value) {
        page.fill(String.format(input, type), value);
    }
    public void clickBtn(String type) {
        page.click(String.format(btn, type));
        page.waitForTimeout(1000);
    }
    public String createUniqueName(String value) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-ss-SSS");
        String formattedDate = date.format(formatter);
        return value + "_" + formattedDate;
    }
    public void clickTabMenuItem(String label) {
        page.click(String.format(tabMenuItem, label));
    }
    public void logout(){
        page.click(userAccountBtn);
        page.click(logoutBtn);
    }

    public void checkTableRow(String column, String row){
        String actualValue = page.locator(String.format(tableRow, column, row)).textContent();
        Assertions.assertEquals(row, actualValue);
        System.out.println(actualValue);
    }



}
