package automationexercisetests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

public class SubscriptionTest {

    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
    }

    @Test
    public void userCanSubscribeSuccessfully() {
        new Homepage(driver).checkThatCarouselShouldBeDisplayed()
                .checkThatSubscriptionSectionShouldBeDisplayedSuccessfully()
                .fillSubscriptionEmail("test3789@test.com")
                .clickOnSubscribeButton()
                .checkThatSubscriptionShouldBeDoneSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
