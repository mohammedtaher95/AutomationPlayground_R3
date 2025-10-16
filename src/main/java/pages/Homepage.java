package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private Driver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By carousel = By.xpath("(//div[@class=\"carousel-inner\"])[1]");

    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /******************************* Assertions ***********************************/

    public Homepage checkThatCarouselShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(carousel));
        return this;
    }

    public Homepage checkThatUserShouldBeLoggedIn() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));

        return this;
    }

    public Homepage checkThatUserShouldBeLoggedOut() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    /******************************** Actions ***********************************/

    public LoginPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginPage(driver);
    }

    public LoginPage clickOnLogoutLink() {
        driver.element().click(logoutLink);
        return new LoginPage(driver);
    }

    public AccountDeletionPage clickOnDeleteAccountLink() {
        driver.element().click(deleteAccountLink);
        return new AccountDeletionPage(driver);
    }

//    public ContactUsPage clickOnContactUsLink() {
//        driver.element().click(contactUsLink);
//        return new ContactUsPage(driver);
//    }

}
