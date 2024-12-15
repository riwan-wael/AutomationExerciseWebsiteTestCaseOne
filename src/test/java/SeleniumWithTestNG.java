import Utilities.JsonFileManager;
import automationexer.pages.*;
import framework.engine.DriverFactory;
import framework.engine.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumWithTestNG {
    private WebDriver driver;

    JsonFileManager testData;

    HomePage homePage;
    SignUpLoginPage signupLoginPage;
    EnterAccountInformationPage accountInforamationPage;
    AccountCreatedMessagePage accountCreatedMessagePage;
    HomeWithLoggedInUser homeWithLoggedInUser;
    AccountDeletedMessagePage accountDeletedMessagePage;


    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();
    }
    @BeforeClass
    public  void beforeClass(){
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
    }
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.intiateDriver(System.getProperty("browserType"),Boolean.valueOf(System.getProperty("maximize")));
        //driver = DriverFactory.intiateDriver("chrome",true);
       // driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
        homePage = new HomePage(driver);
        signupLoginPage = new SignUpLoginPage(driver);
        accountInforamationPage = new EnterAccountInformationPage(driver);
        accountCreatedMessagePage = new AccountCreatedMessagePage(driver);
        homeWithLoggedInUser = new HomeWithLoggedInUser(driver);
        accountDeletedMessagePage = new AccountDeletedMessagePage(driver);
    }

    @Test
    public void testSignUpAndDeleteAccount() {
        Assert.assertEquals(homePage.homePageIsDisplayed(),"FEATURES ITEMS");
        homePage.clickSignUpButton();
        Assert.assertEquals(signupLoginPage.newUserSignUpIsDisplayed(),"New User Signup!");
        signupLoginPage.enterSignupDetails(testData.getTestData("name"), testData.getTestData("email"));
        signupLoginPage.submitSignup();
        Assert.assertEquals(accountInforamationPage.enterAccountInformationIsDisplayed(),"ENTER ACCOUNT INFORMATION");
        accountInforamationPage.selectGenderFemale();
        accountInforamationPage.enterAccountDetails(testData.getTestData("password"), testData.getTestData("day"), testData.getTestData("month"), testData.getTestData("year"));
        accountInforamationPage.enterAddressDetails(
                testData.getTestData("firstName"), testData.getTestData("lastName"), testData.getTestData("company"), testData.getTestData("address1"), testData.getTestData("address2"),
                testData.getTestData("country"), testData.getTestData("state"), testData.getTestData("city"), testData.getTestData("zipCode"), testData.getTestData("mobileNumber"));

        accountInforamationPage.clickCreateAccountButton();
        Assert.assertEquals(accountCreatedMessagePage.AccountCreatedMessageIsDisplayed(),"ACCOUNT CREATED!");
        accountCreatedMessagePage.clickContinueButton();
        Assert.assertEquals(homeWithLoggedInUser.GetUserNameAfterLogin(), "Logged in as Riwan");
        homeWithLoggedInUser.deleteAccount();
        Assert.assertEquals(accountDeletedMessagePage.AccountDeletedMessageIsDisplayed(),"ACCOUNT DELETED!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
