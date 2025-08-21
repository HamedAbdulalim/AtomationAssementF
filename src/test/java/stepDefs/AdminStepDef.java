package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P01_login;
import pages.P02_AdminTab;
import pages.P03_RecordsTab;
import pages.P04_AddUser;

import static stepDefs.Hooks.driver;

public class AdminStepDef {

    P01_login login;
    P02_AdminTab adminTab;
    P03_RecordsTab records;
    P04_AddUser addUser;

    int beforeCount;
    String newUsername = "Hamed_0003";

    @Given("user Login to System")
    public void userLoginToSystem(){
        login = new P01_login(driver);
        login.loginSteps("Admin", "admin123");
    }

    @When("user click on AdminTab")
    public void userClickOnAdminTab(){
        adminTab = new P02_AdminTab(driver);
        adminTab.ClickAdmin();
    }

    @Then("Count Records number")
    public void countRecordsNumber(){
        records = new P03_RecordsTab(driver);
        beforeCount = records.getRecordsCount();
        Assert.assertTrue(beforeCount >= 0, "Records should be >= 0");
    }

    @And("Fill the required data")
    public void fillTheRequiredData(){
        records.clickAdd();
        addUser = new P04_AddUser(driver);
        addUser.fillRequiredData( newUsername, "Hamed.123");
    }

    @Then("Click on save button")
    public void clickOnSaveButton(){
        addUser.clickSave();
    }

    @And("Number of Records increased by one")
    public void numberOfRecordsIncreasedByOne(){
        records.assertCountChangedBy(beforeCount, 1);
    }

    @When("search for user")
    public void searchForUser(){
        records.searchForUser(newUsername);
    }

    @Then("Delete User")
    public void deleteUser(){
        Assert.assertTrue(records.isUserPresentInResults(newUsername), "Expected user not found in results");
        records.deleteFirstResult();
    }

    @And("Number of Records decreased by one")
    public void numberOfRecordsDecreasedByOne(){
        records.assertCountChangedBy(beforeCount + 1, -1);
    }
}
