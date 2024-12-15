package automationexer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By signupLinkButton = By.partialLinkText("Signup");

    // for assertion
    private By featureItemsText = By.xpath("//h2[@class='title text-center' and text()='Features Items']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    // Assertion Methods
    public String homePageIsDisplayed(){
        return driver.findElement(featureItemsText).getText();
    }

    // Action Methods
    public SignUpLoginPage clickSignUpButton() {
        driver.findElement(signupLinkButton).click();
        return new SignUpLoginPage(driver); // Returns next page object
    }

}
