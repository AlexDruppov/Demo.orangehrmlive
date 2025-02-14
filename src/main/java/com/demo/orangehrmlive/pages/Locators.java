package com.demo.orangehrmlive.pages;

public interface Locators {
    String userName = "//span[@class='oxd-userdropdown-tab']/p";
    String input = "//input[@name='%s']";
    String textArea = "//div[label[text()='%s']]//following-sibling::div//textarea";
    String dropDawn = "//div[label[text()='%s']]//following-sibling::div//div[@class='oxd-select-text-input']";
    String dropDawnValue = "//div[@role='option']//span[contains(.,'%s')]";
    String inputLabelForm = "//div[label[text()='%s']]//following-sibling::div//input";
    String mainMenuItem = "//a[contains(@class, 'oxd-main-menu-item')]//span[contains(.,'%s')]";
    String btn = "//button[contains(.,'%s')]";
    String switchBtn = "//span[contains(@class, 'oxd-switch-input')]";
    String tabMenuItem = "//a[contains(.,'%s')]";
    String userAccountBtn = "//span[@class='oxd-userdropdown-tab']//p";
    String logoutBtn = "//a[contains(., 'Logout')]";
    String tableRow = "//div[text()='%s']/ancestor::div[@class='orangehrm-container']//div[text()='%s']";
    String toaster = "//p[contains(., '%s')]";
    String fileAttachBtn = "//input[@class='oxd-file-input']";
    String fileInput = "//div[@class='oxd-file-input-div']";
    String fileTitle = "//div[@class='orangehrm-file-preview']//p";
    String attachBlockSaveBtn = "//div[@class='orangehrm-attachment']//button[contains(.,'Save')]";
    String customBlockSaveBtn = "//div[@class='orangehrm-custom-fields']//button[contains(.,'Save')]";



}
