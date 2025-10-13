package browseractions;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions get(String url) {
        System.out.println("Get to: " + url);
        driver.get(url);
        return this;
    }
    public BrowserActions navigateTo(String url) {
        System.out.println("Navigating to: " + url);
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions navigateForward() {
        System.out.println("Navigating Forward.....");
        driver.navigate().forward();
        return this;
    }

    public BrowserActions refreshPage() {
        System.out.println("Refreshing Page.....");
        driver.navigate().refresh();
        return this;
    }
}
