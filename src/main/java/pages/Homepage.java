package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private WebDriver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By carousel = By.xpath("(//div[@class=\"carousel-inner\"])[1]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************* Assertions ***********************************/

    public void checkThatCarouselShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(carousel).isDisplayed());
    }

    public void checkThatUserShouldBeLoggedIn() {
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
    }

    public void checkThatUserShouldBeLoggedOut() {
        Assert.assertTrue(driver.findElement(loginLink).isDisplayed());
    }

    /******************************** Actions ***********************************/

    public void clickOnLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickOnLogoutLink() {
        driver.findElement(logoutLink).click();
    }

    public void clickOnDeleteAccountLink() {
        driver.findElement(deleteAccountLink).click();
    }

}
