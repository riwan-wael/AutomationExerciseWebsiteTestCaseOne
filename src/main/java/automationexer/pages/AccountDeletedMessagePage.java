package automationexer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedMessagePage {
    private WebDriver driver;

    // Locators
    private By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']");

    public AccountDeletedMessagePage(WebDriver driver){
        this.driver= driver;
    }
    // Assertion Methods
    public String AccountDeletedMessageIsDisplayed() {
        return driver.findElement(accountDeletedMessage).getText();
    }

}

