package driverfactory;

import browseractions.BrowserActions;
import elementactions.ElementActions;
import listeners.webdriver.DriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static utilities.PropertiesManager.frameworkConfig;
import static utilities.PropertiesManager.initializeProperties;

public class Driver {

    private WebDriver driver;

    public Driver(){
        String driverType = frameworkConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = getDriverFactory(driverType).startDriver();
        driver = new EventFiringDecorator<>(WebDriver.class, new DriverListener(undecoratedDriver)).decorate(undecoratedDriver);

        System.out.println("Starting the execution via " + driverType + " driver");
        driver.manage().window().maximize();

        if(!frameworkConfig.getProperty("BaseUrl").isEmpty()) {
            driver.navigate().to(frameworkConfig.getProperty("BaseUrl"));
        }

    }

    private DriverAbstract getDriverFactory(String driverType) {

        switch(driverType) {
            case "CHROME": {
                return new ChromeDriverFactory();
            }

            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }

            case "EDGE": {
                return new EdgeDriverFactory();
            }

            default:{
                throw new IllegalStateException("Unexpected Driver: " + driverType);
            }
        }
    }

    public WebDriver get() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }

    public BrowserActions browser() {
        return new BrowserActions(driver);
    }

}
