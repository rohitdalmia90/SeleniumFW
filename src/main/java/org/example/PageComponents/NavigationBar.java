package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    
    By flights = By.cssSelector("a[title='Flights']");
    By links = By.tagName("a");
    
    public NavigationBar(WebDriver webDriver, By sectionElement) {
        super(webDriver, sectionElement);
    }
    
    public void getFlightAttribute() {
        System.out.println(findElement(flights).getAttribute("class"));
    }
    
    public void getLinkCount() {
        System.out.println(findElements(links).size());
    }
    
}
