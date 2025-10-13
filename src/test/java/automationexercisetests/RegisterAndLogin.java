package automationexercisetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class RegisterAndLogin {

    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    AccountCreationSuccessPage successPage;
    AccountDeletionPage deletionPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homepage = new Homepage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        successPage = new AccountCreationSuccessPage(driver);
        deletionPage = new AccountDeletionPage(driver);
    }

    @Test(priority = 1)
    public void registerNewUser() {

        new Homepage(driver).checkThatCarouselShouldBeDisplayed()
                .clickOnLoginLink()
                .checkThatUserShouldBeNavigatedToLoginSignUpPage()
                .fillSignUpForm("Mohammed", "testr8t5r791767@test.com")
                .clickOnSignUpButton().checkThatRegistrationPageShouldBeLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccountButton()
                .checkThatUserShouldBeNavigatedToCreationSuccessPage();

//        homepage.checkThatCarouselShouldBeDisplayed();
//        homepage.clickOnLoginLink();
//
//        loginPage.checkThatUserShouldBeNavigatedToLoginSignUpPage();
//        loginPage.fillSignUpForm("Mohammed", "testr8t5r791767@test.com");
//        loginPage.clickOnSignUpButton();
//
//        registrationPage.checkThatRegistrationPageShouldBeLoadedSuccessfully();
//        registrationPage.fillInRegistrationForm();
//        registrationPage.clickOnCreateAccountButton();
//
//        successPage.checkThatUserShouldBeNavigatedToCreationSuccessPage();
    }

    @Test(priority = 2, dependsOnMethods = {"registerNewUser"})
    public void userCanLogoutSuccessfully() {
        new AccountCreationSuccessPage(driver).clickOnContinueButton()
                .checkThatCarouselShouldBeDisplayed()
                .checkThatUserShouldBeLoggedIn()
                .clickOnLogoutLink().checkThatUserShouldBeNavigatedToLoginSignUpPage();

//        successPage.clickOnContinueButton();
//        homepage.checkThatCarouselShouldBeDisplayed();
//        homepage.checkThatUserShouldBeLoggedIn();
//        homepage.clickOnLogoutLink();
//        loginPage.checkThatUserShouldBeNavigatedToLoginSignUpPage();
    }

    @Test(priority = 3, dependsOnMethods = {"userCanLogoutSuccessfully"})
    public void userCanLoginSuccessfully() {
        loginPage.fillLoginForm("testr8t5r791767@test.com", "12345678");
        loginPage.clickOnLoginButton();
        homepage.checkThatCarouselShouldBeDisplayed();
        homepage.checkThatUserShouldBeLoggedIn();
    }

    @Test(priority = 4, dependsOnMethods = {"userCanLoginSuccessfully"})
    public void userCanDeleteHisAccount() {
        homepage.clickOnDeleteAccountLink();
        deletionPage.checkThatUserShouldBeNavigatedToAccountDeletionPage();
        deletionPage.clickOnContinueButton();
        homepage.checkThatCarouselShouldBeDisplayed();
        homepage.checkThatUserShouldBeLoggedOut();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
