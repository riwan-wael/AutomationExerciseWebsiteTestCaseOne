import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://google.com/");
        driver.navigate().to("https://automationexercise.com/");
        driver.findElement(By.partialLinkText("Signup")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Riwan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("riwan@ttest.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        new Select(driver.findElement(By.id("days"))).selectByValue("18");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("December");
        new Select(driver.findElement(By.id("years"))).selectByValue("2002");
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Cairo");
        driver.findElement(By.id("last_name")).sendKeys("New Cairo");
        driver.findElement(By.id("company")).sendKeys("Giza Systems");
        driver.findElement(By.id("address1")).sendKeys("Tgmo3");
        driver.findElement(By.id("address2")).sendKeys("Cairo");
        new Select(driver.findElement(By.id("country"))).selectByValue("United States");
        driver.findElement(By.id("state")).sendKeys("Egypt");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("1234");
        driver.findElement(By.id("mobile_number")).sendKeys("01167459023");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        System.out.println("Account created successfully!");
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.findElement(By.partialLinkText("Delete")).click();
        System.out.println("Account deleted successfully!");
        driver.quit();

    }
}
