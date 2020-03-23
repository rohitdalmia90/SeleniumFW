package Academy;

import Framework.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class validateNavigationTest extends Base {
    public static Logger log = LogManager.getLogger(Base.class.getName());


    @Test
    public void baseNavigation() throws IOException{

        driver= getDriver();
        log.info("Driver is initialised");
        LandingPage l1 = new LandingPage(driver);
      Assert.assertTrue( l1.getNavigationBar().isDisplayed());

    }
}
