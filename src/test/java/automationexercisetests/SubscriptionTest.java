package automationexercisetests;

import driverfactory.Driver;
import org.testng.annotations.*;
import pages.Homepage;

public class SubscriptionTest {

    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = "browserName")
    public void setUp(@Optional("CHROME") String driverType) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(driverType));
    }

    @Test
    public void userCanSubscribeSuccessfully() {
        new Homepage(driver.get()).checkThatCarouselShouldBeDisplayed()
                .checkThatSubscriptionSectionShouldBeDisplayedSuccessfully()
                .fillSubscriptionEmail("test3789@test.com")
                .clickOnSubscribeButton()
                .checkThatSubscriptionShouldBeDoneSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.get().quit();
    }
}
