package com.qa.demo.orangehrmlive.tests;

import com.demo.orangehrmlive.pages.PIMPage;
import com.demo.orangehrmlive.pages.RecruitmentPage;
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
        page.waitForTimeout(5000);

//        pimPage.logout();
//        loginPage.fillInput("username", loginName);
//        loginPage.fillInput("password", "Password1");
//        dashboardPage = loginPage.clickLoginBtn("Login");
//        dashboardPage.checkTabTitle("Dashboard");
    }

    @Test
    public void addVacancy(){
        login();
        recruitmentPage = dashboardPage.navigateTo(RecruitmentPage.class, "Recruitment");
        recruitmentPage.clickTabMenuItem("Vacancies");
        recruitmentPage.clickBtn("Add");
        String vacancyName = faker.name().title();
        System.out.println(vacancyName);
        recruitmentPage.fillVacancyInput("Vacancy Name", vacancyName);
        recruitmentPage.enterDropValue("Job Title","Software Engineer");
        recruitmentPage.fillDescription("test");
        String managerName = recruitmentPage.enterHiringManager("Hiring Manager","Shaheen");
        System.out.println(managerName);
        recruitmentPage.clickBtn("Save");
        recruitmentPage.clickTabMenuItem("Vacancies");
        recruitmentPage.enterDropValue("Vacancy",vacancyName);
        recruitmentPage.clickBtn("Search");
        recruitmentPage.checkTableRow("Vacancy", vacancyName);
        recruitmentPage.checkTableRow("Hiring Manager", managerName);
        recruitmentPage.checkTableRow("Job Title", "Software Engineer");
        page.waitForTimeout(5000);
    }

}
