package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private WebDriver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By carousel = By.xpath("(//div[@class=\"carousel-inner\"])[1]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************* Assertions ***********************************/

    public Homepage checkThatCarouselShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(carousel).isDisplayed());
        return this;
    }

    public Homepage checkThatUserShouldBeLoggedIn() {
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
        return this;
    }

    public Homepage checkThatUserShouldBeLoggedOut() {
        Assert.assertTrue(driver.findElement(loginLink).isDisplayed());
        return this;
    }

    /******************************** Actions ***********************************/

    public LoginPage clickOnLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public LoginPage clickOnLogoutLink() {
        driver.findElement(logoutLink).click();
        return new LoginPage(driver);
    }

    public AccountDeletionPage clickOnDeleteAccountLink() {
        driver.findElement(deleteAccountLink).click();
        return new AccountDeletionPage(driver);
    }

    public ContactUsPage clickOnContactUsLink() {
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

}
