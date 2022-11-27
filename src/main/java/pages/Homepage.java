package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Homepage {

    private WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=':r0:']")
    WebElement searchBox;

    @FindBy(xpath = "//span[text()='Accept All']")
    WebElement acceptCookies;

    @FindBy(xpath = "//div[contains(text(),'See Code')]")
    List<WebElement> seeCodes;

    @FindBy(xpath="//span[@data-testid='voucherPopup-codeHolder-voucherType-code']//h4")
    WebElement couponCode;

    public void acceptCookies() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies.click();
    }

    public void enterTextIntoSearchBox(String value) {
        searchBox.sendKeys(value);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clickSeeCodesButton() throws InterruptedException {
    /**    for (int i  = 0; i< seeCodes.size() ; i++) {
            seeCodes.get(i).click();
        }**/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        seeCodes.get(1).click();
    }

    public String getCouponCode() {
        return couponCode.getText().trim();
    }





}
