package automationexercisetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

public class ContactUsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void contactUsTest() {
//        new Homepage(driver).clickOnContactUsLink()
//                .checkThatContactUsPageShouldBeLoadedSuccessfully()
//                .fillContactUsForm()
//                .clickOnSubmitButton()
//                .checkThatSuccessMessageShouldBeDisplayedSuccessfully()
//                .clickOnHomeButton().checkThatCarouselShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
