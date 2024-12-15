package automationexer.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLoginPage {
    private WebDriver driver;

    // Locators
    private By signupNameInput = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    // for assertion
    private By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");

    public SignUpLoginPage (WebDriver driver){
        this.driver=driver;

    }

    // Assertion Methods
    public String newUserSignUpIsDisplayed(){
        return driver.findElement(newUserSignupText).getText();
    }

    // Action Methods
    public SignUpLoginPage enterSignupDetails(String name, String email) {
        driver.findElement(signupNameInput).sendKeys(name);
        driver.findElement(signupEmailInput).sendKeys(email);
        return this;
    }

    public EnterAccountInformationPage submitSignup() {
        driver.findElement(signupButton).click();
        return new EnterAccountInformationPage(driver); // Navigate to the next page
    }
}
