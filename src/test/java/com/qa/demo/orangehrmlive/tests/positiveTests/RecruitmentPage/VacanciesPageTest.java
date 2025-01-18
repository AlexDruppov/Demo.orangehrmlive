package com.qa.demo.orangehrmlive.tests.positiveTests.RecruitmentPage;

import com.demo.orangehrmlive.pages.RecruitmentPage;
import com.github.javafaker.Faker;
import com.qa.demo.orangehrmlive.tests.base.BaseTest;
import org.testng.annotations.Test;
public class VacanciesPageTest extends BaseTest {
    @Test
    public void addVacancy(){
        login();
        recruitmentPage = dashboardPage.navigateTo(RecruitmentPage.class, "Recruitment");
        recruitmentPage.clickTabMenuItem("Vacancies");
        recruitmentPage.clickBtn("Add");
        String vacancyName = faker.name().title();
        recruitmentPage.fillRecruitmentPageInput("Vacancy Name", vacancyName);
        recruitmentPage.enterDropValue("Job Title","Software Engineer");
        recruitmentPage.fillTextArea("Description","test");
        String managerName = recruitmentPage.enterHiringManager("Hiring Manager",userName);
        System.out.println(managerName);
        recruitmentPage.clickBtn("Save");
        recruitmentPage.clickTabMenuItem("Vacancies");
        recruitmentPage.enterDropValue("Vacancy",vacancyName);
        recruitmentPage.clickBtn("Search");
        recruitmentPage.checkTableRow("Vacancy", vacancyName);
        //recruitmentPage.checkTableRow("Hiring Manager", managerName);
        recruitmentPage.checkTableRow("Job Title", "Software Engineer");
    }
    @Test
    public void addDocToVacancy(){
        addVacancy();
        recruitmentPage.clickEditVacancyBtn();
        recruitmentPage.clickBtn("Add");
        String fileName = recruitmentPage.attachFile();
        String comment = recruitmentPage.fillTextArea("Comment","Test1");
        recruitmentPage.saveAttachedFile();
        recruitmentPage.checkTableRow("File Name", fileName);
        recruitmentPage.checkTableRow("Comment",comment);
    }
}
