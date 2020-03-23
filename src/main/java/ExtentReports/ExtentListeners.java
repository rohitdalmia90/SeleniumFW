package ExtentReports;

import Framework.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import static Framework.Base.initializerDriver;

public class ExtentListeners implements ITestListener {

    Base base = new Base();


   private static  ExtentReports extent = ExtentManager.createInstance();
   private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult iTestResult) {

        ExtentTest test = extent.createTest(iTestResult.getTestClass().getName() + " :: " + iTestResult.getMethod().getMethodName());

        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult iTestResult) {

        String logText = "<b> Test Method " + iTestResult.getMethod().getMethodName() + " Successful </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,m);

    }

    public void onTestFailure(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(iTestResult.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary><b><font color = red>" + "Exception Occured, click to see details:" + "</font></b></summary>" + exceptionMessage.replaceAll(",","<br>") + "</details>  \n");


        try {
            base.getScreenshot(iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = null;
        try {
            driver = initializerDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = takeScreenshot(driver,iTestResult.getMethod().getMethodName());
        try{
            extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            extentTest.get().fail("Test Failed, cannot attach Screenshot");

        }
        String logText = "<b>Test Method " + methodName + "Failed /<b>";
        Markup m = MarkupHelper.createLabel(logText,ExtentColor.RED);
        extentTest.get().log(Status.FAIL,m);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        String logText = "<b>Test Method " + iTestResult.getMethod().getMethodName() + " Skipped  </b>";
        Markup m = MarkupHelper.createLabel(logText,ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP,m);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        if(extent != null)
            extent.flush();

    }


    public String takeScreenshot(WebDriver driver,String methodName){
        String fileName = getScreenshotName(methodName);
        String directory = System.getProperty("user.dir")+ "/Screenshot/";
        new File(directory).mkdirs();
        String path = directory+fileName;

        try{
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(path));
            System.out.println("**********************************************");
            System.out.println("Screenshot stared at  : " + path);
            System.out.println("************************************************");




        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }


    public static String getScreenshotName(String methodName){

        Date d = new Date();
        String fileName = methodName + d.toString().replace(":","_").replace(" ","_") + ".png";
        return fileName;

    }
}
