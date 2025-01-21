package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class PIMPage extends BasePage {
    //label[contains(.,'%s')]/ancestor-or-self::div[@class='oxd-input-group__label-wrapper']//following-sibling::div//input
    String calendarInput = "//div[label[text()='%s']]//following-sibling::div//input";
    String monthItemBtn = "//li[@class='oxd-calendar-selector-month']//p";
    String dropDownSelector = "//ul[@class='oxd-calendar-dropdown']//li[contains(., '%s')]";
    String yearsItemBtn = "//div[@class='oxd-calendar-selector-year-selected']//p";
    String dayItem = "//div[@class='oxd-calendar-dates-grid']//div[text()='%s']";
    String driverLicense = "//div[label[contains(., 'License Number')]]//following-sibling::div//input";
    String maleRadioBtn = "//div[@class='--gender-grouped-field']/div[1]//span";
    String femaleRadioBtn = "//div[@class='--gender-grouped-field']/div[2]//span";
    public PIMPage(Page page) {
        super(page);
    }
    public void addEmployee(String type){
        page.click(String.format(btn, type));
    }
    public void switchLoginDetails() {
        page.click(switchBtn);
    }
    public String fillAddEmployeeInput(String label, String value) {
        Locator inputElement = page.locator(String.format(inputLabelForm, label));
        String currentValue = inputElement.inputValue();
        if (currentValue.isEmpty()) {
            inputElement.fill(value);
            return value;
        } else {
           return currentValue;
        }
    }
    public void checkUserName(String label, String value) {
        String element = String.format(input, label);
        Locator locator = page.locator(element);
        //PlaywrightAssertions.assertThat(locator).isVisible();
        //Locator element = page.locator(String.format(input, label));
        //page.waitForSelector(element, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        String actualvalue = locator.inputValue();
        Assertions.assertEquals(value, actualvalue);
    }
    public void checkPersonalDetailsValue(String label, String value){
        String actualvalue = page.locator(String.format(inputLabelForm, label)).inputValue();
        Assertions.assertEquals(value, actualvalue);
    }
    public void enterDriverLicense(String value){
        page.fill(driverLicense, value);
    }
    public String calendar(String type, String year, String day, String month){
        page.click(String.format(calendarInput, type));
        selectFromDropdown(monthItemBtn, month);
        selectFromDropdown(yearsItemBtn, year);
        page.click(String.format(dayItem, day));
        String date = page.locator(String.format(calendarInput, type)).inputValue();
        return date;
    }
    public void selectFromDropdown(String button, String item){
        page.click(button);
        page.click(String.format(dropDownSelector, item));
    }
    public void maleGender(){
        page.click(maleRadioBtn);
    }
    public void femaleGender(){
        page.click(femaleRadioBtn);
    }


}
