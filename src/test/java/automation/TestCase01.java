package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;

public class TestCase01 {

    private WebDriver driver;

    private Homepage homepage;

    @BeforeTest
    void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://discountcode.dailymail.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    void launchSiteAndGetCoupon() throws InterruptedException {
        homepage = new Homepage(driver);
        homepage.acceptCookies();
        homepage.enterTextIntoSearchBox("laptop");
        homepage.clickSeeCodesButton();
        System.out.println(homepage.getCouponCode());
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }
}
