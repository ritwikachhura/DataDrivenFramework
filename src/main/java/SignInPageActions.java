import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SignInPageActions extends SignInPageObjects {

    public void fillSignInForm(WebDriver driver, String email, String password) {

        driver.findElement(emailBoxObj).sendKeys(email);
        driver.findElement(pswdBoxObj).sendKeys(password);
    }

    public void clickSignInButton(WebDriver driver) {

        driver.findElement(signinbuttonBoxObj).click();
    }

    public String getErrorPromptMsg(WebDriver driver) {

        return driver.findElement(errorComponentBoxObj).getText();
    }

    public String getMyAccountPageHeading(WebDriver driver) {

        return driver.findElement(myAccountBoxObj).getText();
    }
}
