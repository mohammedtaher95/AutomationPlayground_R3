package elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions click(By locator) {
        System.out.println("Click on: " + locator);
        driver.findElement(locator).click();
        return this;
    }

    public ElementActions fillField(By locator, String text) {
        System.out.println("Fill " + text + " in " + locator);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clearField(By locator) {
        System.out.println("Clearing " + locator);
        driver.findElement(locator).clear();
        return this;
    }
}
