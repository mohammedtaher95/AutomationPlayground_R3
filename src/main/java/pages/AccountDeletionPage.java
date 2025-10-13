package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletionPage {

    private WebDriver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountDeletionPage(WebDriver driver) {
        this.driver = driver;
    }

    /*********************************** Assertions ***********************************/

    public AccountDeletionPage checkThatUserShouldBeNavigatedToAccountDeletionPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"));
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT DELETED!");
        return this;
    }

    /*********************************** Actions ************************************/

    public Homepage clickOnContinueButton() {
        driver.findElement(continueButton).click();
        return new Homepage(driver);
    }
}
