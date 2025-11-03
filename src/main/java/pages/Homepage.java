package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private Driver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By productsLink = By.xpath("//a[@href=\"/products\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By carousel = By.xpath("(//div[@class=\"carousel-inner\"])[1]");
    By subscriptionSection = By.cssSelector("div.single-widget");
    By subscriptionEmailField = By.id("susbscribe_email");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccessMessage = By.id("success-subscribe");

    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /******************************* Assertions ***********************************/

    @Step("Check That Carousel Should Be Displayed")
    public Homepage checkThatCarouselShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(carousel));
        return this;
    }

    @Step("Check That User Should be Logged in")
    public Homepage checkThatUserShouldBeLoggedIn() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));

        return this;
    }

    @Step("check That User Should Be Logged Out")
    public Homepage checkThatUserShouldBeLoggedOut() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    @Step("Check That Subscription Section Should Be Displayed Successfully")
    public Homepage checkThatSubscriptionSectionShouldBeDisplayedSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(subscriptionSection));
        return this;
    }

    @Step("check That Subscription Should Be Done Successfully")
    public Homepage checkThatSubscriptionShouldBeDoneSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(subscriptionSuccessMessage));
        Assert.assertTrue(driver.element().getTextOf(subscriptionSuccessMessage).contains("You have been successfully subscribed!"));
        return this;
    }

    /******************************** Actions ***********************************/

    @Step("Click on Login link")
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

    public ProductsPage clickOnProductsLink() {
        driver.element().click(productsLink);
        return new ProductsPage(driver);
    }

    @Step("Fill Subscription Email")
    public Homepage fillSubscriptionEmail(String email) {
        driver.element().fillField(subscriptionEmailField, email);
        return this;
    }

    @Step("Click on Subscribe Button")
    public Homepage clickOnSubscribeButton() {
        driver.element().click(subscriptionButton);
        return this;
    }

}
