package com.qa.demo.orangehrmlive.tests.base;

import com.demo.orangehrmlive.pages.DashboardPage;
import com.demo.orangehrmlive.pages.LoginPage;
import com.demo.orangehrmlive.pages.PIMPage;
import com.demo.orangehrmlive.pages.RecruitmentPage;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import factory.Factory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Properties;

import static constant.Constant.Credentials.PASSWORD;
import static constant.Constant.Credentials.USERNAME;


public class BaseTest {

    protected Factory factory;
    protected Properties properties;
    protected Playwright playwright;
    protected Page page;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected PIMPage pimPage;
    protected RecruitmentPage recruitmentPage;
    public Faker faker = new Faker();
    public String keywords;
    public String userName;

    @BeforeTest
    public void setup() {
        factory = new Factory();
        properties = factory.init_prop();
        page = factory.initBrowser(properties);
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void tearDown() {
//        if (page != null) {
//            page.context().browser().close();
//        }
        page.close();
    }
    public void login() {
        loginPage.fillInput("username", USERNAME);
        loginPage.fillInput("password", PASSWORD);
        dashboardPage =  loginPage.clickLoginBtn("Login");
        dashboardPage.checkTabTitle("Dashboard");
        userName = dashboardPage.getUserNameValue();
    }
}

