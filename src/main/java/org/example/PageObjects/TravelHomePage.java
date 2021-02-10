package org.example.PageObjects;

import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * It is the base page of the application*/
public class TravelHomePage {
    
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver webDriver;
    
    public TravelHomePage(WebDriver driver) {
        this.webDriver = driver;
    }
    
    public void goTo() {
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    
    
    public NavigationBar getNavigationBar() {
        return new NavigationBar(webDriver, footerNavSectionElement);
    }
    
    public FooterNav getFooterNav() {
        return new FooterNav(webDriver, sectionElement);
        
    }
    
    
}
