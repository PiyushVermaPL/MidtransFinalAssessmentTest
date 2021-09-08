package org.assessment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * @author verma.piyush
 */
public class TestNGListener extends TestBase implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestNGListener.class);
    @Override
    public void onFinish(ITestContext result) {

        logger.info(result.getName());
    }

    @Override
    public void onStart(ITestContext result) {

        logger.info(result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        logger.info(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        takeScreenShotOnTestFailure();
        logger.info("screen shot has been taken successfully : ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.info(result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(result.getName());
    }
}
