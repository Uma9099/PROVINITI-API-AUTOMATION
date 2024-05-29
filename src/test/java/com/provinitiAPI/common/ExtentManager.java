package com.provinitiAPI.common;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {

                extent = new ExtentReports(workingDir + "\\ExtentReports\\provinitiAPITestReport.html", true);

                extent.loadConfig(new File("src\\test\\resources\\extent-config.xml"));
            } else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                extent = new ExtentReports(workingDir + "/ExtentReports/provinitiAPITestReport.html", true);
                extent.loadConfig(new File("src/test/resources/extent-config.xml"));
            }
        }
        return extent;
    }
}

