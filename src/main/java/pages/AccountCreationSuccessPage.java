package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreationSuccessPage {

    private WebDriver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountCreationSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    /*********************************** Assertions ***********************************/

    public AccountCreationSuccessPage checkThatUserShouldBeNavigatedToCreationSuccessPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"));
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT CREATED!");
        return this;
    }

    /*********************************** Actions ************************************/

    public Homepage clickOnContinueButton() {
        driver.findElement(continueButton).click();
        return new Homepage(driver);
    }
}
