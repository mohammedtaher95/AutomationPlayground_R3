package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;

public class LoginTestCases {

    Driver driver;
    Homepage homepage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://automationexercise.com/");

//        homepage = new Homepage(driver);
//        loginPage = new LoginPage(driver);
    }


    @Test
    public void loginWithInvalidCredentials() {
        new Homepage(driver).checkThatCarouselShouldBeDisplayed()
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
        driver.quit();
    }
}