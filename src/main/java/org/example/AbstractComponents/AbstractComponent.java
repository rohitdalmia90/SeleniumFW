package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent {
    WebElement sectionElement;
    
    public AbstractComponent(WebDriver webDriver, By sectionElement) {
        this.sectionElement = webDriver.findElement(sectionElement);
    }
    
    public WebElement findElement(By findElementBy) {
        return sectionElement.findElement(findElementBy);
    }
    
    public List<WebElement> findElements(By findElementBy) {
        return sectionElement.findElements(findElementBy);
    }
}
