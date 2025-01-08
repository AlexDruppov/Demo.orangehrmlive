package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Page;

public class RecruitmentPage extends BasePage {
    public RecruitmentPage(Page page){
        super(page);
    }
    public void fillVacancyInput(String type, String value){
        page.fill(String.format(inputForm, type), value);
    }
    public void enterJobTitle(String value){
       page.click(dropDawn);
       page.click(String.format(dropDawnValue, value));
    }
    public void fillDescription(String value){
        page.fill(textArea, value);
    }
}
