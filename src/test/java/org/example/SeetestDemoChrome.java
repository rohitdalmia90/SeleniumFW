package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class SeetestDemoChrome {
    
    
    private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMDgzODcxLCJ4cC5wIjoyMDgzODY3LCJ4cC5tIjoxNjExNzg0MDI1NTIzLCJleHAiOjE5MjcxNDQwMjUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.09lwzhhCTg9jPuhsZtHeORyOs1bdlARaZyk5tnqDRLs";
    private RemoteWebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();
    
    @Before
    public void setUp() throws Exception {
        dc.setCapability("testName", "Demo web browser chrome");
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        dc.setCapability(CapabilityType.BROWSER_VERSION, "86.0.4240.75");
        dc.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
        driver = new RemoteWebDriver(new URL("https://uscloud.experitest.com/wd/hub"), dc);
    }
    
    
    @Test
    public void browserTestGoogleSearch() {
        for (int i = 0; i < 7; i++) {
            driver.get("https://www.google.com");
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
            WebElement searchBar = driver.findElement(By.name("q"));
            searchBar.click();
            searchBar.sendKeys("Experitest");
            searchBar.sendKeys(Keys.ENTER);
        }
    }
    
    @After
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
    
    
    
    
}
