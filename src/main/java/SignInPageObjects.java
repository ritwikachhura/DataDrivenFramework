import org.openqa.selenium.By;

public class SignInPageObjects {
    public By emailBoxObj= By.name("email");
    public By pswdBoxObj= By.name("passwd");
    public By signinbuttonBoxObj=By.xpath("//button[@id='SubmitLogin']");
    public By errorComponentBoxObj=By.xpath("//div[@class='alert alert-danger']//ol//li");
    public By myAccountBoxObj=By.xpath("//h1[@class='page-heading']");

}
