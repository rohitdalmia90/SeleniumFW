package Framework;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    private static List<WebDriver> driverPool = new ArrayList<WebDriver>();


    public static WebDriver driver ;
    public static Properties prop;


    @BeforeSuite
    public void setUpSuite(){
        System.setProperty("webdriver.chrome.driver","/home/rohitdalmia/Documents/New_Framework/src/main/resources/chromedriver");


    }
    //Method Overloading
    public WebDriver getDriver() throws IOException {

        return getDriver(BrowserType.CHROME,getParam("url"));
    }

    public WebDriver getDriver(BrowserType type,String BaseUrl){
        WebDriver driver = DriverFactory.getInstance().getDriver(type);
        driverPool.add(driver);
        driver.get(BaseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }


/*This is an another method of initialising the webdriver.
* As this is not using the thread pool concept*/

    public static WebDriver initializerDriver() throws IOException {
         prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/rohitdalmia/Documents/New_Framework/src/main/resources/data.properties");

        prop.load(fis);
      String browserName =  prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }else if(browserName.equalsIgnoreCase("firefox")){

        }else if(browserName.equalsIgnoreCase("ie")){

        }


        return driver;

    }



    public static String getParam(String param) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/rohitdalmia/Documents/New_Framework/src/main/resources/data.properties");

        prop.load(fis);
        String val = prop.getProperty(param);
        return val;
    }

    public void getScreenshot(String result) throws IOException{
       File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/rohitdalmia/Documents/New_Framework/ScreenShot/screenshot.png"));
    }

    @AfterSuite
    public void TearDown(){
        for (WebDriver webDriver : driverPool){
            webDriver.quit();
        }


    }
}
