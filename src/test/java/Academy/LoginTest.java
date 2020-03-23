package Academy;

import Framework.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginTest extends Base {
    public static Logger log = LogManager.getLogger(Base.class.getName());


    @Test
    public void loginCredentials() throws IOException {

        driver =  getDriver();
        log.info("Driver is initialised");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys("rd");
        loginPage.getPassword().sendKeys("po");

    }
}
