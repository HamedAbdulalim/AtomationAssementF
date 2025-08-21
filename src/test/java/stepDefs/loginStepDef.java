package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.P01_login;

import static stepDefs.Hooks.driver;

public class loginStepDef {

    P01_login login = new P01_login(driver);

    @Given("user go to login page")
    public void openLoginPage(){
        login = new P01_login(driver);
        login.LoginPageAssertion();
    }

    @When("^user login with \"(.*)\" \"(.*)\"$")
    public void enterValidLoginData(String Username, String password){
        login = new P01_login(driver);
        login.loginSteps(Username, password);
    }
}
