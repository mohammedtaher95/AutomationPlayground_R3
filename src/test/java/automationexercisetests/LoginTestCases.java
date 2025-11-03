package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Homepage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTestCases {

    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = "browserName")
    public void setUp(@Optional("CHROME") String driverType) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(driverType));
    }


    @Test
    public void loginWithInvalidCredentials() {
        new Homepage(driver.get()).checkThatCarouselShouldBeDisplayed()
                .clickOnLoginLink()
                .checkThatUserShouldBeNavigatedToLoginSignUpPage()
                .fillLoginForm("fghjk@tex.com", "12345678")
                .clickOnLoginButton()
                .checkThatErrorShouldBeDisplayedWhenEnteringWrongCredentials();

//        homepage.checkThatCarouselShouldBeDisplayed();
//        homepage.clickOnLoginLink().
//        loginPage.checkThatUserShouldBeNavigatedToLoginSignUpPage();
//        loginPage.fillLoginForm("fghjk@tex.com", "12345678");
//        loginPage.clickOnLoginButton();
//        loginPage.checkThatErrorShouldBeDisplayedWhenEnteringWrongCredentials();
    }


    @AfterClass
    public void tearDown() {
        driver.get().quit();
    }
}