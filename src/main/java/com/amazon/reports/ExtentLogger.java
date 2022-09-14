package com.amazon.reports;

import com.amazon.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

    public static void info(String message){
        ExtentManager.getExtentTest().info(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
}
