package com.qa.demo.orangehrmlive.tests.base;

import com.demo.orangehrmlive.pages.DashboardPage;
import com.demo.orangehrmlive.pages.LoginPage;
import com.demo.orangehrmlive.pages.PIMPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.demo.orangehrmlive.pages.factory.Factory;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    protected Factory factory;
    protected Properties properties;
    protected Playwright playwright;
    protected Page page;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected PIMPage pimPage;



    @BeforeTest
    public void setup(){
        factory = new Factory();
        properties = factory.init_prop();
        page = factory.initBrowser(properties);
        loginPage = new LoginPage(page);


    }
//    @AfterTest
//    public void tearDown(){
//        page.context().browser().close();
//    }
}
