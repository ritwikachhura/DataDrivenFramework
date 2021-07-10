import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {

        driver.close();
    }
}
