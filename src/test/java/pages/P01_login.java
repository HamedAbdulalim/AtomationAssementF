package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P01_login {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By loginTile = By.xpath("//h5[text()='Login']");
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By submitBtn = By.cssSelector("button[type='submit']");

    public P01_login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void LoginPageAssertion(){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(loginTile));
        Assert.assertEquals(title.getText().trim(), "Login");
    }

    public void loginSteps(String username, String password){
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput)).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();
    }
}
