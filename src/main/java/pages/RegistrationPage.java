package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    private Driver driver;

    By header = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By passwordField = By.id("password");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By addressField = By.id("address1");
    By countryField = By.id("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipCode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    /************************************ Assertions ************************************/

    public RegistrationPage checkThatRegistrationPageShouldBeLoadedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(header), "ENTER ACCOUNT INFORMATION");
        return this;
    }

    /*********************************** Actions **************************************/

    public RegistrationPage fillInRegistrationForm() {
        driver.element().fillField(passwordField,"12345678");
        driver.element().fillField(firstNameField,"Mohammed");
        driver.element().fillField(lastNameField,"Taher");
        driver.element().fillField(addressField,"Alexandria");
        driver.element().selectByValue(countryField, "Canada");

        driver.element().fillField(stateField, "Alex");
        driver.element().fillField(cityField, "Alexandria");

        driver.element().fillField(zipCode, "34597");
        driver.element().fillField(mobileNumber, "01234567893");
        return this;
    }

    public AccountCreationSuccessPage clickOnCreateAccountButton() {
        driver.element().click(createAccountButton);
        return new AccountCreationSuccessPage(driver);
    }
}
