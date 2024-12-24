package com.qa.demo.orangehrmlive.tests;

import com.github.javafaker.Faker;
import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    Faker faker = new Faker();
    @Test
    public void login() {
        loginPage.fillInput("username", "Admin");
        loginPage.fillInput("password", "admin123");
        dashboardPage = loginPage.clickLoginBtn("Login");
        dashboardPage.checkTabTitle("Dashboard");
    }
    @Test
    public void createNewUser(){
        login();
        pimPage = dashboardPage.menuItemClick("PIM");
        pimPage.addEmployee("Add");
        String firstName = faker.name().firstName();
        pimPage.fillInput("firstName", firstName);
        String lastName = faker.name().lastName();
        pimPage.fillInput("lastName", lastName);
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
        page.waitForTimeout(5000);

//        pimPage.logout();
//        loginPage.fillInput("username", loginName);
//        loginPage.fillInput("password", "Password1");
//        dashboardPage = loginPage.clickLoginBtn("Login");
//        dashboardPage.checkTabTitle("Dashboard");



    }


}
