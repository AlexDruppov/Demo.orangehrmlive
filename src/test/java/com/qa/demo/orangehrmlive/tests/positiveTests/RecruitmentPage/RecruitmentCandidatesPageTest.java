package com.qa.demo.orangehrmlive.tests.positiveTests.RecruitmentPage;

import com.demo.orangehrmlive.pages.RecruitmentPage;
import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;
public class RecruitmentCandidatesPageTest extends BaseTest {
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
        String text = faker.pokemon().name();
        recruitmentPage.fillTextArea("Notes",text);
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
        recruitmentPage.toasterVisibility("Successfully Deleted");
        recruitmentPage.fillRecruitmentPageInput("Keywords", keywords);
        recruitmentPage.clickBtn("Search");
        recruitmentPage.toasterVisibility("No Records Found");

    }
}
