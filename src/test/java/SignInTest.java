import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    SignInPageActions signInPageActions = new SignInPageActions();

    @Test(dataProvider = "testdata" )
    public void signIn(String email,String password,String expected){


        signInPageActions.fillSignInForm(driver,email,password);
        signInPageActions.clickSignInButton(driver);

        try{
            String error=signInPageActions.getErrorPromptMsg(driver);
            Assert.assertEquals(error,expected,"expected error msg is:"+expected+"but actual message is"+error);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @DataProvider(name = "testdata")
    public Object[][] testDataExample(){
        ReadExcelFile readExcelFile = new ReadExcelFile("UserCredentials_demo.xlsx");
        int rows = readExcelFile.getRowCount(0);
        Object[][]signin_credentials = new Object[rows][3];

        for(int i=0;i<rows;i++)
        {
            signin_credentials[i][0] = readExcelFile.getData(0, i, 0);
            signin_credentials[i][1] = readExcelFile.getData(0, i, 1);
            signin_credentials[i][2] = readExcelFile.getData(0, i, 2);

        }
        return signin_credentials;
    }
       }
