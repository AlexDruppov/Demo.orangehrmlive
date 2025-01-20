package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Paths;

public class RecruitmentPage extends BasePage {
    public RecruitmentPage(Page page){
        super(page);
    }
    String recruitmentValue = "//div[label[text()='%s']]//following-sibling::div//p";
    String fileAttachBtn = "//input[@class='oxd-file-input']";
    String fileInput = "//div[@class='oxd-file-input-div']";
    String fileTitle = "//div[@class='orangehrm-file-preview']//p";
    String viewCandidateProfileBtn = "//button//i[@class='oxd-icon bi-eye-fill']";
    String editVacancyBtn = "//button//i[@class='oxd-icon bi-pencil-fill']";
    String attachBlockSaveBtn = "//h6[contains(., 'Add Attachment')]/parent::div//button[contains(.,'Save')]";
    //String toaster = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']";
    String toaster = "//p[contains(., '%s')]";
    public void fillRecruitmentPageInput(String type, String value){
        page.fill(String.format(inputLabelForm, type), value);
    }
    public String fillTextArea(String type, String value){
        page.fill(String.format(textArea, type), value);
        String text = page.locator(String.format(textArea, type)).inputValue();
        return text;
    }
    public String enterHiringManager(String type, String value){
        String first = getFirstWord(value);
        System.out.println(first);
        page.fill(String.format(inputLabelForm, type), first);
        page.click(String.format(dropDawnValue, first));
        String managerName = page.locator(String.format(inputLabelForm, type)).inputValue().replaceAll("\\s+"," ");
        return managerName;
    }
    public void enterRecruitmentDropInput(String label, String value) {
        page.fill(String.format(inputLabelForm, label), value);
        page.click(String.format(dropDawnValue, value));
    }
    public String copyRecruitmentValue(String type) {
        page.waitForTimeout(1000);
        String value = page.locator(String.format(recruitmentValue, type)).textContent();
        return value;
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
    public void clickViewProfile(){
        page.click(viewCandidateProfileBtn);
    }
    public void clickEditVacancyBtn(){
        page.click(editVacancyBtn);
    }
    public String copyFileName(){
        String name = page.locator(fileInput).textContent().trim();
        return name;
    }
    public void saveAttachedFile(){
        page.click(attachBlockSaveBtn);
    }

}
