package com.demo.orangehrmlive.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class PIMPage extends BasePage {
    //label[contains(.,'%s')]/ancestor-or-self::div[@class='oxd-input-group__label-wrapper']//following-sibling::div//input
    String inputForm = "//div[label[text()='%s']]//following-sibling::div//input";


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
        Locator inputElement = page.locator(String.format(inputForm, label));
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
        System.out.println(actualvalue + " checkUserName");
        System.out.println(value);
    }

    public void checkPersonalDetailsValue(String label, String value){
        String actualvalue = page.locator(String.format(inputForm, label)).inputValue();
        Assertions.assertEquals(value, actualvalue);
        System.out.println(actualvalue + " checkFormValue");
        System.out.println(value);
    }


}
