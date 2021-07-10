import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageActions extends  SignInPageObjects{

    public  void fillSignInForm(WebDriver driver, String email, String password){
        driver.findElement(emailBoxObj).sendKeys(email);
        driver.findElement(pswdBoxObj).sendKeys(password);
    }
    public void clickSignInButton(WebDriver driver){
        driver.findElement(signinbuttonBoxObj).click();
    }
}
