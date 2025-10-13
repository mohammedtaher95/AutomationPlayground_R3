package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactoryTest {

    //WebDriver driver;
    Driver driver;
    @BeforeClass
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new Driver("FIREFX");
    }

    @Test
    public void login(){
        driver.browser().navigateTo("https://the-internet.herokuapp.com/login");

        driver.element().fillField(By.id("username"), "tomsmith");
        driver.element().fillField(By.name("password"), "SuperSecretPassword!");
        driver.element().click(By.cssSelector("button.radius"));


        Assert.assertTrue(driver.get().findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/secure"));
        Assert.assertTrue(driver.get().findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
