package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {

    private WebDriver driver;

    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitButton = By.name("submit");
    By titleText = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeButton = By.cssSelector("a.btn.btn-success");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }


    /******************************* Assertions ***********************************/

    public ContactUsPage checkThatContactUsPageShouldBeLoadedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"));
        Assert.assertTrue(driver.findElement(nameField).isDisplayed());
        Assert.assertEquals(driver.findElement(titleText).getText(), "GET IN TOUCH");
        return this;
    }

    public ContactUsPage checkThatSuccessMessageShouldBeDisplayedSuccessfully() {
        Assert.assertEquals(driver.findElement(successMessage).getText(), "Success! Your details have been submitted successfully.");
        return this;
    }


    /********************************* Actions ************************************/

    public ContactUsPage fillContactUsForm() {
        driver.findElement(nameField).sendKeys("Mohammed");
        driver.findElement(emailField).sendKeys("test25678@test.com");
        driver.findElement(subjectField).sendKeys("Testing Contact Us Page");
        driver.findElement(messageField).sendKeys("wedrfghyujikolhghdjkjhgvbclkdjhgfghjkl");
        return this;
    }

    public ContactUsPage clickOnSubmitButton() {
        driver.findElement(submitButton).click();
        driver.switchTo().alert().accept();
        return this;
    }

//    public Homepage clickOnHomeButton() {
//        driver.findElement(homeButton).click();
//        return new Homepage(driver);
//    }

}
