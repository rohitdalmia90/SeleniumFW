package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
    
    @Test
    public void flightTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        travelHomePage.getFooterNav().getFlightAttribute();
        travelHomePage.getFooterNav().getLinkCount();
        travelHomePage.getNavigationBar().getFlightAttribute();
        travelHomePage.getNavigationBar().getLinkCount();
        driver.quit();
        
    }
}
