package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public LandingPage(WebDriver driver){

        this.driver = driver;
    }

    public WebDriver driver;

  By signIn =   By.cssSelector("a[href*='sign_in']");
  By title = By.cssSelector(".text-center>h2");
  By NavBar = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul > li:nth-child(2) > a");


  public WebElement getLogin(){
      return driver.findElement(signIn);
  }


    public WebElement getNavigationBar(){
        return driver.findElement(NavBar);
    }
}