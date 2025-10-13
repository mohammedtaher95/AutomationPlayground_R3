package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************** Assertions *********************************/

    public LoginPage checkThatUserShouldBeNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.findElement(signUpForm).isDisplayed());
        Assert.assertTrue(driver.findElement(loginForm).isDisplayed());
        return this;
    }

    public LoginPage checkThatErrorShouldBeDisplayedWhenEnteringWrongCredentials() {
        Assert.assertTrue(driver.findElement(incorrectCredentialsError).isDisplayed());
        return this;
    }

    /********************************* Actions ************************************/

    public LoginPage fillSignUpForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(signUpEmailField).sendKeys(email);
        return this;
    }

    public LoginPage fillLoginForm(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegistrationPage clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
        return new RegistrationPage(driver);
    }

    public LoginPage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }



}
