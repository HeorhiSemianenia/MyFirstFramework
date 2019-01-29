package com.selenium.test.listeners;


import com.selenium.test.webtestbase.WebDriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Array;

public class ScreenShotOnFailListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult){
        String[] array = iTestResult.getInstanceName().split("\\.");
        WebDriverFactory.getScreenshot(array[array.length-1]);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
