package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {
    
    WebDriver driver;
    
    
    By flights = By.cssSelector("a[title='Flights']");
    By links = By.tagName("a");
    
    public FooterNav(WebDriver webDriver, By sectionElement) {
        super(webDriver, sectionElement);//when u inherit the prent class, then you should invoke parent class constructor
    }
    
    //method to handle flights
    //when selenium executes any method in this class - scope of selenium
    //should be in the footer only
    
    public void getFlightAttribute() {
        System.out.println(findElement(flights).getAttribute("class"));
    }
    
    public void getLinkCount() {
        System.out.println(findElements(links).size());
    }
}
