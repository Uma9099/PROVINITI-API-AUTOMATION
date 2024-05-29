package com.provinitiAPI.common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();
    public static SoftAssert softAssert;
    static ExtentTest testLog;

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
       // softAssert.assertAll();
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        softAssert = new SoftAssert();
        return test;
    }

    public static synchronized void assertTrue(Boolean result, String statement) {
        if(result){
            getTest().log(LogStatus.PASS,statement + " --- Working Fine");
            softAssert.assertTrue(true);
        }else{
            getTest().log(LogStatus.FAIL,statement + " --- Not Working");
           softAssert.assertTrue(false);
        }

    }


    public static synchronized void logStep(String statement){
        getTest().log(LogStatus.INFO, statement);
    }
    public static synchronized void logStepFail(String statement){
        getTest().log(LogStatus.FAIL, statement);
        softAssert.assertTrue(false);
    }
    public static synchronized void logStepPass(String statement){
        getTest().log(LogStatus.PASS, statement);
    }

    public static synchronized  List<String> buildTestReportData(Object object){
        String actualAsString = ReflectionToStringBuilder.toString(object);
        List<String> buildReportData = new ArrayList<>();
        // TODO
        return buildReportData;
    }
}
