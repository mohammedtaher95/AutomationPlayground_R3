package automationexercisetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void login(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
