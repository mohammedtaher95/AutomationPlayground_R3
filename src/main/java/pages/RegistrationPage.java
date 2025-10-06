package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage {

    private WebDriver driver;

    By header = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By passwordField = By.id("password");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By addressField = By.id("address1");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipCode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************ Assertions ************************************/

    public void checkThatRegistrationPageShouldBeLoadedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.findElement(header).getText(), "ENTER ACCOUNT INFORMATION");
    }

    /*********************************** Actions **************************************/

    public void fillInRegistrationForm() {
        driver.findElement(passwordField).sendKeys("12345678");
        driver.findElement(firstNameField).sendKeys("Mohammed");
        driver.findElement(lastNameField).sendKeys("Taher");
        driver.findElement(addressField).sendKeys("Alexandria");
        driver.findElement(stateField).sendKeys("Alex");
        driver.findElement(cityField).sendKeys("Alexandria");
        driver.findElement(zipCode).sendKeys("34597");
        driver.findElement(mobileNumber).sendKeys("01234567893");
    }

    public void clickOnCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}
