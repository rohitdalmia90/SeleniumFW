package Academy;

import Framework.Base;
import Framework.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;


public class HomePage  extends Base {

    public static Logger log = LogManager.getLogger(Base.class.getName());


    @Test(dataProvider = "getData")
    public void basePageNavigation(String userName, String password , String text) throws IOException {


   //   driver =  initializerDriver();
        driver =  getDriver();
       log.info("Driver is initialised");


        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys("rd");
        loginPage.getPassword().sendKeys("po");
        loginPage.getLogin().click();


    }

    @DataProvider
    public Object[][] getData(){


        Object[][] data = new Object[2][3];
        data[0][0] = "bc@gmail.com";
        data[0][1]= "123";
        data[0][2] = "Restricted User";

        data[1][0] = "cvhwq@gmail.com";
        data[1][1] = "2223";
        data[1][2] = "Non Restricted User";

        return data;
    }

}
