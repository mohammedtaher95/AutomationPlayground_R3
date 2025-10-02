package automationexercisetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;

public class RegisterAndLogin {

    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void registerNewUser() {
        homepage = new Homepage(driver);
        loginPage = new LoginPage(driver);

        homepage.checkThatCarouselShouldBeDisplayed();
        homepage.clickOnLoginLink();

        loginPage.checkThatUserShouldBeNavigatedToLoginSignUpPage();
        loginPage.fillSignUpForm("Mohammed", "test88767@test.com");
        loginPage.clickOnSignUpButton();


        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.findElement(By.xpath("(//h2[@class=\"title text-center\"])[1]")).getText(), "ENTER ACCOUNT INFORMATION");


    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
