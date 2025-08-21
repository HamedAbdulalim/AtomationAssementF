package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P03_RecordsTab {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By tableRows = By.xpath("//span[contains(normalize-space(.),'Records Found')]");
    private final By searchUsername = By.xpath("//label[normalize-space()='Username']/../following-sibling::div//input");
    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By clearBtn = By.xpath("//button[normalize-space()='Reset' or normalize-space()='Clear']");
    private final By resultRowUsernames = By.cssSelector("div.oxd-table-body div.oxd-table-card div.oxd-table-row div:nth-child(2) div");
    private final By rowCheckboxes = By.cssSelector("div.oxd-table-body div.oxd-table-card input[type='checkbox']");
    private final By deleteIconFirst = By.cssSelector("div.oxd-table-body div.oxd-table-card:first-child i.bi-trash, div.oxd-table-body div.oxd-table-card:first-child button:has(i.bi-trash)");
    private final By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");

    public P03_RecordsTab(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getRecordsCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.size();
    }

    public void clickAdd(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void searchForUser(String username){
        wait.until(ExpectedConditions.elementToBeClickable(clearBtn)).click(); // reset filters if present
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsername)).clear();
        driver.findElement(searchUsername).sendKeys(username);
        driver.findElement(searchBtn).click();
    }

    public boolean isUserPresentInResults(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        List<WebElement> users = driver.findElements(resultRowUsernames);
        for (WebElement u : users){
            if (u.getText().trim().equalsIgnoreCase(username)) return true;
        }
        return false;
    }

    public void deleteFirstResult(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteIconFirst)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }

    public void assertCountChangedBy(int before, int delta){
        int after = getRecordsCount();
        Assert.assertEquals(after, before + delta, "Record count did not change by " + delta);
    }
}
