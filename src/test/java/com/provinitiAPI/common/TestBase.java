package com.provinitiAPI.common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class TestBase extends AbstractTestNGSpringContextTests {
    public static ExtentReports extent;
    public static ExtentTest test;



    @BeforeMethod
    public void createSoftAssertion() {


    }

    @AfterMethod
    public void endSoftAssertion() {
        try {
            ExtentTestManager.softAssert.assertAll();
        } catch (AssertionError e) {
        }
    }

    @AfterTest
    public void afterTest() {
        ExtentTestManager.endTest();
    }

    @AfterClass
    public static void tearDown() {
        ExtentManager.getReporter().flush();

    }





}
