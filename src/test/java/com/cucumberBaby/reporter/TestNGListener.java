package com.cucumberBaby.reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {

    ExtentReports reports = new ExtentReports("Results\\ExtentResults.html", true);

    ExtentTest test;

    static String browserInUSe = null;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test started, details are : " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Success, details are :" + iTestResult.getName());

        test = reports.startTest(iTestResult.getTestName());

        test.log(LogStatus.PASS, iTestResult.getName() + " " + iTestResult.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test FAILED !, details are :" + iTestResult.getName());

        test = reports.startTest(iTestResult.getTestName());

        test.log(LogStatus.FAIL, iTestResult.getName() + " " + iTestResult.getStatus());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test skipped, details are :" + iTestResult.getName());

        test = reports.startTest(iTestResult.getTestName());

        test.log(LogStatus.SKIP, iTestResult.getName() + " " + iTestResult.getStatus());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test partially completed, details are :" + iTestResult.getName());

        test = reports.startTest(iTestResult.getTestName());

        test.log(LogStatus.INFO, iTestResult.getName() + " partially completed " + iTestResult.getStatus());

    }

    @Override
    public void onStart(ITestContext iTestContext) {

        test = reports.startTest("TestNGListener");



    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        reports.endTest(test);
        reports.flush();
    }
}
