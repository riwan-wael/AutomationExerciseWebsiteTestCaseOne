package automationexer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EnterAccountInformationPage {
    private WebDriver driver;

    // Locators
    private By genderFemaleRadio = By.id("id_gender2");
    private By passwordInput = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By Checkbox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    // for assertion
    private By enterAccountInforamationText = By.xpath("//b[text()='Enter Account Information']");

    public EnterAccountInformationPage(WebDriver driver){
        this.driver=driver;
    }

    // Assertion Methods
    public String enterAccountInformationIsDisplayed(){
        return driver.findElement(enterAccountInforamationText).getText();
    }

    // Action Methods
    public EnterAccountInformationPage selectGenderFemale() {
        driver.findElement(genderFemaleRadio).click();
        return this;
    }

    public EnterAccountInformationPage enterAccountDetails(String password, String day, String month, String year) {
        driver.findElement(passwordInput).sendKeys(password);
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        driver.findElement(Checkbox).click();
        return this;
    }

    public EnterAccountInformationPage enterAddressDetails(
            String firstName, String lastName, String company, String address1, String address2,
            String country, String state, String city, String zipCode, String mobileNumber
    ) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(companyInput).sendKeys(company);
        driver.findElement(address1Input).sendKeys(address1);
        driver.findElement(address2Input).sendKeys(address2);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
        return this;
    }

    public AccountCreatedMessagePage clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
        return new AccountCreatedMessagePage(driver);  // Navigate to the next page
    }
}
