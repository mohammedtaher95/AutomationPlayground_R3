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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************** Assertions *********************************/

    public void checkThatUserShouldBeNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.findElement(signUpForm).isDisplayed());
        Assert.assertTrue(driver.findElement(loginForm).isDisplayed());
    }

    /********************************* Actions ************************************/

    public void fillSignUpForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(signUpEmailField).sendKeys(email);
    }

    public void fillLoginForm(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }



}
