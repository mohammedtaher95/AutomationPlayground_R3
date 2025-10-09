package automationexercisetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewTestClass {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void login() {
        driver.navigate().to("https://www.booking.com/hotel/eg/royal-tulip-alexandria.html?aid=2311236&label=ar-eg-booking-desktop-JY5PJ4%2AshiSz%2Aw9OdP6MHwS652897951130%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-65526620%3Alp9222601%3Ali%3Adec%3Adm&sid=ed082106bf13b888905b56f6bbbb38b4&all_sr_blocks=78883120_386871369_2_34_0_131741&checkin=2025-10-15&checkout=2025-10-20&dest_id=-290263&dest_type=city&dist=0&group_adults=2&group_children=0&hapos=3&highlighted_blocks=78883120_386871369_2_34_0_131741&hpos=3&matching_block_id=78883120_386871369_2_34_0_131741&no_rooms=1&req_adults=2&req_children=0&room1=A%2CA&sb_price_type=total&sr_order=popularity&sr_pri_blocks=78883120_386871369_2_34_0_131741_36000&srepoch=1759868376&srpvid=ab30557ad36806d2&type=total&ucfs=1&chal_t=1759875504828&force_referer=");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid=\"date-display-field-start\"]")));
        String date = driver.findElement(By.xpath("//button[@data-testid=\"date-display-field-start\"]")).getText();
        System.out.println(date);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
