package starter.account.register;

import gherkin.ast.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterSteps {

    @Steps
    Register register;

    @Given("I am on the register page")
    public void i_am_on_the_register_page() {

    }

    @When("I input my valid username and password")
    public void i_input_my_valid_username_and_password() {
        register.setBodyReq();
    }

    @When("I entered a registered account")
    public void i_entered_a_registered_account() {
        register.setBodyReqFailed();
    }

    @When("i click register button")
    public void i_click_register_button() {
        register.hitEnpointRegister();
    }

    @When("i click register button when account exist")
    public void i_click_register_button_when_account_exist() {
        register.hitEnpointRegisterFailed();
    }

    @Then("I am redirected to the profile")
    public void i_am_redirected_to_the_profile() {
        register.validateEndpointRegister();
    }

    @Then("failed register and show user exist")
    public void failed_register_and_show_user_exist() {
        //throw new cucumber.api.PendingException();
    }
}
