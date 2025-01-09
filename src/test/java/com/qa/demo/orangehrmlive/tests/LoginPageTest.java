package com.qa.demo.orangehrmlive.tests;

import com.demo.orangehrmlive.pages.PIMPage;
import com.demo.orangehrmlive.pages.RecruitmentPage;
import com.github.javafaker.Faker;
import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    Faker faker = new Faker();
    private String keywords;
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
        recruitmentPage.fillRecruitmentPageInput("Vacancy Name", vacancyName);
        recruitmentPage.enterDropValue("Job Title","Software Engineer");
        recruitmentPage.fillTextArea("test");
        String managerName = recruitmentPage.enterHiringManager("Hiring Manager","Shaheen");
        System.out.println(managerName);
        recruitmentPage.clickBtn("Save");
        recruitmentPage.clickTabMenuItem("Vacancies");
        recruitmentPage.enterDropValue("Vacancy",vacancyName);
        recruitmentPage.clickBtn("Search");
        recruitmentPage.checkTableRow("Vacancy", vacancyName);
        recruitmentPage.checkTableRow("Hiring Manager", managerName);
        recruitmentPage.checkTableRow("Job Title", "Software Engineer");
    }
    @Test
    public void addCandidate(){
        login();
        recruitmentPage = dashboardPage.navigateTo(RecruitmentPage.class, "Recruitment");
        recruitmentPage.clickBtn("Add");
        String candidateFirstName = faker.name().firstName();
        recruitmentPage.fillInput("firstName", candidateFirstName);
        String candidateLastName = faker.name().lastName();
        recruitmentPage.fillInput("lastName", candidateLastName);
        recruitmentPage.enterDropValue("Vacancy", "Senior Support Specialist");
        recruitmentPage.fillRecruitmentPageInput("Email", "test@maiil.org");
        String contactNumber = faker.phoneNumber().subscriberNumber();
        recruitmentPage.fillRecruitmentPageInput("Contact Number", contactNumber);
        keywords = faker.random().hex();
        recruitmentPage.fillRecruitmentPageInput("Keywords", keywords);
        String text = faker.yoda().quote();
        recruitmentPage.fillTextArea(text);
        String fileName = recruitmentPage.attachFile();
        recruitmentPage.clickBtn("Save");
        String candidate = recruitmentPage.copyRecruitmentValue("Name");
        recruitmentPage.checkFile(fileName);
        recruitmentPage.clickTabMenuItem("Candidates");
        recruitmentPage.fillRecruitmentPageInput("Keywords", keywords);
        recruitmentPage.clickBtn("Search");
        recruitmentPage.checkTableRow("Vacancy", "Senior Support Specialist");
        recruitmentPage.checkTableRow("Candidate", candidate);
    }
    @Test
    public void editCandidateProfile() {
        addCandidate();
        recruitmentPage.clickViewProfile();
    }
    @Test
    public void deleteCandidateProfile() {
        addCandidate();
        recruitmentPage.clickDeleteProfileBtn();
        recruitmentPage.fillRecruitmentPageInput("Keywords", keywords);
        System.out.println(keywords);
        recruitmentPage.clickBtn("Search");
        page.pause();
    }
}
