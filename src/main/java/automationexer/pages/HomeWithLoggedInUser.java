package automationexer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWithLoggedInUser {
    private WebDriver driver;

    // Locators
    private By deleteAccountLink = By.partialLinkText("Delete");

    private By loggenInAsUsername = By.xpath("//li/a[contains(text(),'Logged in as')]");

    public HomeWithLoggedInUser (WebDriver driver){
        this.driver =driver;
    }

    // Assertion Methods
    // Get Username after login
    public String GetUserNameAfterLogin() {
        return driver.findElement(loggenInAsUsername).getText();
    }

    // Action Methods
    public AccountDeletedMessagePage deleteAccount() {
        driver.findElement(deleteAccountLink).click();
        return new AccountDeletedMessagePage(driver);   //  Navigate to the next page
    }
}
