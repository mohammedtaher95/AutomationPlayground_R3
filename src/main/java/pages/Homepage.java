package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private WebDriver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By carousel = By.xpath("(//div[@class=\"carousel-inner\"])[1]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************* Assertions ***********************************/

    public void checkThatCarouselShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(carousel).isDisplayed());
    }

    /******************************** Actions ***********************************/

    public void clickOnLoginLink() {
        driver.findElement(loginLink).click();
    }

}
