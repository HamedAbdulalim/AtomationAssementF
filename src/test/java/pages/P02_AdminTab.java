package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_AdminTab {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By adminMenuLink = By.xpath("//span[normalize-space()='Admin']/ancestor::a");

    public P02_AdminTab(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ClickAdmin(){
        wait.until(ExpectedConditions.elementToBeClickable(adminMenuLink)).click();
    }
}
