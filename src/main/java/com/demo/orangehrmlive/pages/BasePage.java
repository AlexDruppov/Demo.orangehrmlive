package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage implements Locators{
    protected Page page;
    public BasePage(Page page) {
        this.page = page;
    }
    String deleteProfileBtn = "//button//i[@class='oxd-icon bi-trash']";
    String confirmDeleteBtn = "//button[contains(@class, 'oxd-button--label-danger')]";
    String toasterItem = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']";
    String toaster = "//p[contains(., '%s')]";
    public void fillInput(String type, String value) {
        page.fill(String.format(input, type), value);
    }
    public void clickBtn(String type) {
        page.waitForSelector(String.format(btn, type)).click();
        page.waitForTimeout(1000);
    }
    public void enterDropValue(String type, String value){
        page.click(String.format(dropDawn, type));
        page.click(String.format(dropDawnValue, value));
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
        String actualValue = page.waitForSelector(String.format(tableRow, column, row)).textContent();
        Assertions.assertEquals(row, actualValue);
    }
    public void clickMenuItem(String menuItem) {
        page.click(String.format(tabMenuItem, menuItem));
    }
    public <T extends BasePage> T navigateTo(Class<T> pageClass, String menuItem) {
        clickMenuItem(menuItem);
        try {
            return pageClass.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + pageClass.getName(), e);
        }
    }
    public String getFirstWord(String value) {
        String[] words = value.split("\\s+");
        return words.length > 0 ? words[0] : "";
    }
    public void clickDeleteProfileBtn(){
        page.click(deleteProfileBtn);
        page.click(confirmDeleteBtn);
    }
    public void noRecordsFoundToaster(){
        String text = page.locator(toasterItem).textContent();
        Assertions.assertEquals("No Records Found", text);
        System.out.println(text);
    }
    public void toasterVisibility(String value) {
        page.locator(String.format(toaster, value)).isVisible();
        String text = page.locator(String.format(toaster, value)).textContent();
        Assertions.assertEquals(value, text);
        System.out.println(text);
    }
    public String attachFile(){
        page.setInputFiles(fileAttachBtn, Paths.get("build/file/1596734766622.pdf"));
        page.locator(fileInput).isVisible();
        String value = page.locator(fileInput).textContent();
        return value;
    }
    public void checkFile(String value) {
        String actualValue = page.locator(fileTitle).textContent().trim();
        Assertions.assertEquals(value, actualValue);
    }
    public void saveAttachedFile(){
        page.click(attachBlockSaveBtn);
    }
    public void saveCustomFile(){
        page.click(customBlockSaveBtn);
    }
    public String fillTextArea(String type, String value){
        page.fill(String.format(textArea, type), value);
        String text = page.locator(String.format(textArea, type)).inputValue();
        return text;
    }
}
