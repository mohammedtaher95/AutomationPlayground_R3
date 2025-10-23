package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private Driver driver;
    private WebDriverWait wait;

    By signUpForm = By.cssSelector("div.signup-form");
    By nameField = By.name("name");
    By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By loginForm = By.cssSelector("div.login-form");
    By loginEmailField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    By incorrectCredentialsError = By.xpath("//p[contains(text(),\"Your email or password is incorrect!\")]");
    //p[contains(text(), "")]

    public LoginPage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver.get(), Duration.ofSeconds(20));
    }

    /********************************** Assertions *********************************/

    public LoginPage checkThatUserShouldBeNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.element().isDisplayed(signUpForm));
        Assert.assertTrue(driver.element().isDisplayed(loginForm));
        return this;
    }

    public LoginPage checkThatErrorShouldBeDisplayedWhenEnteringWrongCredentials() {
//        WebDriverWait explicitWait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(incorrectCredentialsError));
//
//        FluentWait wait = new FluentWait<>(driver.get()).withTimeout(Duration.ofSeconds(15))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectCredentialsError));

        driver.element().waitForVisibility(incorrectCredentialsError, Duration.ofSeconds(10));
        Assert.assertTrue(driver.element().isDisplayed(incorrectCredentialsError));
        return this;
    }

    /********************************* Actions ************************************/

    public LoginPage fillSignUpForm(String name, String email) {
        driver.element().fillField(nameField, name);
        driver.element().fillField(signUpEmailField, email);
        return this;
    }

    public LoginPage fillLoginForm(String email, String password) {
        driver.element().fillField(loginEmailField, email);
        driver.element().fillField(passwordField, password);
        return this;
    }

    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }

    public LoginPage clickOnLoginButton() {
        driver.element().click(loginButton);
        return this;
    }



}
