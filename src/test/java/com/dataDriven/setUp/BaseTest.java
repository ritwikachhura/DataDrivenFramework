package com.dataDriven.setUp;

import com.dataDriven.pageActions.SignInPageActions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static RemoteWebDriver driver;
    SignInPageActions signInPageActions = new SignInPageActions();

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        int implicitWaitTime = 30;
        String actualSignInPageTitle;
        String websiteUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String expectedSignInPageTitle = "Login - My Store";

        driver.get(websiteUrl);
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        actualSignInPageTitle = driver.getTitle();
        Assert.assertEquals(actualSignInPageTitle, expectedSignInPageTitle, "Expected Sign In page title is: " + expectedSignInPageTitle +
                ". But actual Sign In page title is: " + actualSignInPageTitle);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {

        driver.close();
        System.out.println("*******");
    }
}
