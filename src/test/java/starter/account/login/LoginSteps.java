package starter.account.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

    @Steps
    Login login;


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("I enter my valid username and password")
    public void i_enter_my_valid_username_and_password() {
        login.setBodyReq();

    }

    @When("i click Login button")
    public void i_click_Login_button() {
        login.hitEndpointLogin();
    }

    @Then("I am redirected to the dashboard")
    public void i_am_redirected_to_the_dashboard() {
        login.validateEndpointLogin();
    }

    @Then("get userID")
    public void get_userID() {
        login.hitEndpointUserID();
    }

}
