package automationexercisetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterAndLogin {

    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void registerNewUser() {
        homepage = new Homepage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        homepage.checkThatCarouselShouldBeDisplayed();
        homepage.clickOnLoginLink();

        loginPage.checkThatUserShouldBeNavigatedToLoginSignUpPage();
        loginPage.fillSignUpForm("Mohammed", "testru87798767@test.com");
        loginPage.clickOnSignUpButton();

        registrationPage.checkThatRegistrationPageShouldBeLoadedSuccessfully();
        registrationPage.fillInRegistrationForm();
        registrationPage.clickOnCreateAccountButton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
