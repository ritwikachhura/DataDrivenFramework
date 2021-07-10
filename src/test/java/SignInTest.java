import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    SignInPageActions signInPageActions = new SignInPageActions();
    String actualSignInPromptErrorMessage, myAccoutPageHeading;

    @Test(dataProvider = "signindata")
    public void signIn(String signInEmail, String signInPassword, String expectedSignInValue) {

        signInPageActions.fillSignInForm(driver, signInEmail, signInPassword);
        signInPageActions.clickSignInButton(driver);

        try {
            actualSignInPromptErrorMessage = signInPageActions.getSignInErrorPromptMessage(driver);
            Assert.assertEquals(actualSignInPromptErrorMessage, expectedSignInValue, "Expected Sign In error message is: " + expectedSignInValue +
                    ". But actual Sign In error message is: " + actualSignInPromptErrorMessage);
        } catch (Exception e) {
            actualMyAccoutPageHeading = signInPageActions.getMyAccountPageHeading(driver);
            Assert.assertEquals(actualMyAccoutPageHeading, expectedSignInValue, "Expected My account page heading: " + expectedSignInValue +
                    ". But received: " + actualMyAccoutPageHeading);
        }
    }

    @DataProvider(name = "signindata")
    public Object[][] signInTestData() {

        ReadExcelFile readExcelFile = new ReadExcelFile("UserCredentials_demo.xlsx");
        int rows = readExcelFile.getRowCount(0);
        Object[][] signin_credentials = new Object[rows][3];

        for (int i = 0; i < rows; i++) {
            signin_credentials[i][0] = readExcelFile.getData(0, i, 0);
            signin_credentials[i][1] = readExcelFile.getData(0, i, 1);
            signin_credentials[i][2] = readExcelFile.getData(0, i, 2);
        }
        return signin_credentials;
    }
}
