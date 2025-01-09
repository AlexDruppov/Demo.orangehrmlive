package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RecruitmentPage extends BasePage {
    public RecruitmentPage(Page page){
        super(page);
    }
    String recruitmentValue = "//div[label[text()='%s']]//following-sibling::div//p";
    String fileAttachBtn = "//input[@class='oxd-file-input']";
    String fileInput = "//div[@class='oxd-file-input-div']";
    String fileTitle = "//div[@class='orangehrm-file-preview']//p";
    public void fillRecruitmentPageInput(String type, String value){
        page.fill(String.format(inputForm, type), value);
    }
    public void enterDropValue(String type, String value){
       page.click(String.format(dropDawn, type));
       page.click(String.format(dropDawnValue, value));
    }
    public void fillTextArea(String value){
        page.fill(textArea, value);
    }
    public String enterHiringManager(String type, String value){
        page.fill(String.format(inputForm, type), value);
        page.click(String.format(dropDawnValue, value));
        String managerName = page.locator(String.format(inputForm, type)).inputValue().replaceAll("\\s+"," ");
        return managerName;
    }
    public void enterRecruitmentDropInput(String label, String value) {
        page.fill(String.format(inputForm, label), value);
        page.click(String.format(dropDawnValue, value));
    }
    public String copyRecruitmentValue(String type) {
        page.waitForTimeout(1000);
        String value = page.locator(String.format(recruitmentValue, type)).textContent();
        return value;
    }
    public String attachFile(){
        page.setInputFiles(fileAttachBtn, Paths.get("build/file/1596734766622.pdf"));
        String value = page.locator(fileInput).textContent();
        return value;
    }
    public void checkFile(String value) {
        String actualValue = page.locator(fileTitle).textContent().trim();
        Assertions.assertEquals(value, actualValue);
    }
}
