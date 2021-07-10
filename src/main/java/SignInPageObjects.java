import org.openqa.selenium.By;

public class SignInPageObjects {

    public By emailBoxSignInObj = By.name("email");
    public By passwordBoxSignInObj = By.name("passwd");
    public By signInButtonObj = By.xpath("//button[@id='SubmitLogin']");
    public By signInErrorComponentBoxObj = By.xpath("//div[@class='alert alert-danger']//ol//li");
    public By myAccountPageHeadingObj = By.xpath("//h1[@class='page-heading']");
}
