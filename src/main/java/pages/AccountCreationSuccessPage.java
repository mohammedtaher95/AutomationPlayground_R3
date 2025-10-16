package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreationSuccessPage {

    private Driver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountCreationSuccessPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************** Assertions ***********************************/

    public AccountCreationSuccessPage checkThatUserShouldBeNavigatedToCreationSuccessPage() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/account_created"));
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT CREATED!");
        return this;
    }

    /*********************************** Actions ************************************/

    public Homepage clickOnContinueButton() {
        driver.element().click(continueButton);
        return new Homepage(driver);
    }
}
