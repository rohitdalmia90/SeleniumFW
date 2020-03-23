package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public WebDriver driver;

  By email =   By.cssSelector("input[id='user_email']");
    By password =   By.cssSelector("input[type='password']");
    By loginBtn = By.cssSelector("input[type='submit']");



    public WebElement getEmail(){
      return driver.findElement(email);
  }
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public WebElement getLogin(){
        return driver.findElement(loginBtn);
    }
}
