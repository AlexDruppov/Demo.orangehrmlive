package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;

public class RecruitmentPage extends BasePage {
    public RecruitmentPage(Page page){
        super(page);
    }
    public void fillVacancyInput(String type, String value){
        page.fill(String.format(inputForm, type), value);
    }
    public void enterDropValue(String type, String value){
       page.click(String.format(dropDawn, type));
       page.click(String.format(dropDawnValue, value));
    }
    public void fillDescription(String value){
        page.fill(textArea, value);
    }
    public String enterHiringManager(String type, String value){
        page.fill(String.format(inputForm, type), value);
        page.click(String.format(dropDawnValue, value));
        String managerName = page.locator(String.format(inputForm, type)).inputValue().replaceAll("\\s+"," ");
        return managerName;
    }
}
