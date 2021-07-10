import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SignInPageActions extends SignInPageObjects {

    public void fillSignInForm(WebDriver driver, String email, String password) {

        driver.findElement(emailBoxSignInObj).sendKeys(email);
        driver.findElement(passwordBoxSignInObj).sendKeys(password);
    }

    public void clickSignInButton(WebDriver driver) {

        driver.findElement(signInButtonObj).click();
    }

    public String getSignInErrorPromptMessage(WebDriver driver) {

        return driver.findElement(signInErrorComponentBoxObj).getText();
    }

    public String getMyAccountPageHeading(WebDriver driver) {

        return driver.findElement(myAccountPageHeadingObj).getText();
    }

    public String getLoginPageTitle(Webdriver driver) {

        return driver.getTitle();
    }
}
