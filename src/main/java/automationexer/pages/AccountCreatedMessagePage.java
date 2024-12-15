package automationexer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedMessagePage {
    private WebDriver driver;

    // Locators
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedMessagePage(WebDriver driver){
        this.driver = driver;
    }

    // Assertion Methods
    public String AccountCreatedMessageIsDisplayed() {
        return driver.findElement(accountCreatedMessage).getText();
    }

    // Action Methods
    public HomeWithLoggedInUser clickContinueButton() {
        driver.findElement(continueButton).click();
        return new HomeWithLoggedInUser(driver);    // Navigate to the next page
    }
}
