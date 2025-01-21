package com.qa.demo.orangehrmlive.tests.positiveTests.PIMPage;

import com.demo.orangehrmlive.pages.PIMPage;
import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;
public class PIMEmployeeListTest extends BaseTest {
    @Test
    public void createNewUserFromEmployeeListTab(){
        login();
        pimPage = dashboardPage.navigateTo(PIMPage.class, "PIM");
        pimPage.addEmployee("Add");
        String firstName = faker.name().firstName();
        pimPage.fillInput("firstName", firstName);
        String lastName = faker.name().lastName();
        pimPage.fillInput("lastName", lastName);
        String id = faker.idNumber().valid();
        System.out.println(id + " - notUsId");
        pimPage.switchLoginDetails();
        String loginName = pimPage.createUniqueName(firstName);
        System.out.println(loginName);
        pimPage.fillAddEmployeeInput("Username", loginName);
        String userID = pimPage.fillAddEmployeeInput("Employee Id", id);
        System.out.println(userID);
        pimPage.fillAddEmployeeInput("Password","Password1");
        pimPage.fillAddEmployeeInput("Confirm Password","Password1");
        pimPage.clickBtn("Save");
        System.out.println(firstName);
        System.out.println(lastName);
        pimPage.checkUserName("firstName", firstName);
        pimPage.checkUserName("lastName", lastName);
        pimPage.checkPersonalDetailsValue("Employee Id", userID);
        String otherId = faker.idNumber().valid();
        System.out.println(otherId + " otherId");
        pimPage.fillAddEmployeeInput("Other Id", otherId);
        pimPage.enterDriverLicense("dl-"+otherId);
        String date = pimPage.calendar("License Expiry Date", "2022", "16", "May");
        System.out.println(date);
        pimPage.enterDropValue("Nationality", "Mexican");
        pimPage.enterDropValue("Marital Status", "Other");
        pimPage.calendar("Date of Birth", "1995", "9", "April");
        pimPage.femaleGender();
        pimPage.clickBtn("Save");
        pimPage.toasterVisibility("Successfully Updated");
        pimPage.enterDropValue("Blood Type","AB+");
        pimPage.saveCustomFile();
        pimPage.toasterVisibility("Successfully Updated");
        pimPage.clickBtn("Add");
        String fileName = pimPage.attachFile();
        String comment = pimPage.fillTextArea("Comment","Test1");
        pimPage.saveAttachedFile();
        pimPage.toasterVisibility("Successfully Saved");
        pimPage.checkTableRow("File Name", fileName);
        pimPage.checkTableRow("Description",comment);



        pimPage.clickTabMenuItem("Employee List");
        pimPage.fillAddEmployeeInput("Employee Id", userID);
        pimPage.clickBtn("Search");
        pimPage.checkTableRow("Last Name", lastName);
//        pimPage.logout();
//        loginPage.fillInput("username", loginName);
//        loginPage.fillInput("password", "Password1");
//        dashboardPage = loginPage.clickLoginBtn("Login");
//        dashboardPage.checkTabTitle("Dashboard");
    }
    @Test
    public void deleteEmployee(){
        login();
        pimPage = dashboardPage.navigateTo(PIMPage.class, "PIM");
        pimPage.addEmployee("Add");
        String firstName = faker.name().firstName();
        pimPage.fillInput("firstName", firstName);
        String lastName = faker.name().lastName();
        pimPage.fillInput("lastName", lastName);
        String id = faker.idNumber().valid();
        System.out.println(id + " -id");
        pimPage.switchLoginDetails();
        String loginName = pimPage.createUniqueName(firstName);
        System.out.println(loginName);
        pimPage.fillAddEmployeeInput("Username", loginName);
        String userID = pimPage.fillAddEmployeeInput("Employee Id", "5589");
        System.out.println(userID);
        pimPage.fillAddEmployeeInput("Password","Password1");
        pimPage.fillAddEmployeeInput("Confirm Password","Password1");
        pimPage.clickBtn("Save");
        System.out.println(firstName);
        System.out.println(lastName);
        pimPage.checkUserName("firstName", firstName);
        pimPage.checkUserName("lastName", lastName);
        pimPage.checkPersonalDetailsValue("Employee Id", userID);
        pimPage.clickTabMenuItem("Employee List");
        pimPage.fillAddEmployeeInput("Employee Id", userID);
        pimPage.clickBtn("Search");
        pimPage.checkTableRow("Last Name", lastName);
        pimPage.clickDeleteProfileBtn();
        pimPage.toasterVisibility("Successfully Deleted");
        pimPage.fillAddEmployeeInput("Employee Id", userID);
        pimPage.clickBtn("Search");
        pimPage.toasterVisibility("No Records Found");
    }
}
