package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class P04_AddUser {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Form fields (OrangeHRM Add User)

    private final By userRoleField   = By.xpath("//label[normalize-space()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    private final By userRoption  = By.xpath("(//div[contains(@role,'option')])[3]");

    private final By statusDrop = By.xpath("//label[normalize-space()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    private final By statusOption   = By.xpath("(//div[contains(.,'Enabled')])[13]");
    private final By empName    = By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input");
    private final By selectEmpName = By.xpath("(//div[@role='option'])[2]");

    private final By username   = By.xpath("//label[normalize-space()='Username']/../following-sibling::div//input");
    private final By pwd        = By.xpath("//label[normalize-space()='Password']/../following-sibling::div//input");
    private final By confirmPwd = By.xpath("//label[normalize-space()='Confirm Password']/../following-sibling::div//input");
    private final By saveBtn    = By.xpath("//button[normalize-space()='Save']");

  /*
    private final By roleDrop = By.xpath("//label[text()='User Role']/following::div[1]");
    private final By statusFiled = By.xpath("//label[normalize-space()='Status']/following::div[@class='oxd-select-text");
    private final By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//i");
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input");
    private final By usernameInput = By.xpath("//label[normalize-space()='Username']/../following-sibling::div//input");
    private final By passwordInput = By.xpath("//label[text()='Password']/following::input[1");
    private final By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    private final By saveBtn = By.xpath("//button[normalize-space()='Save']");
*/
    public P04_AddUser(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillRequiredData( String user, String password){
        // User Role
        driver.findElement(userRoleField).click();
        driver.findElement(userRoption).click();
        // User status
        driver.findElement(statusDrop).click();
        driver.findElement(statusOption).click();
        // Employee name
        driver.findElement(empName).sendKeys("M");
        driver.findElement(selectEmpName).click();
        // User name
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(pwd).sendKeys(password);
        driver.findElement(confirmPwd).sendKeys(password);
    }

    public void clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
}
