package starter.account.generatetoken;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GenerateTokenSteps {

    @Steps
    GenerateToken generateToken;

    @Given("I have account in demoqa")
    public void i_have_account_in_demoqa() {

    }

    //Success generate token
    @When("I am enter valid request payload")
    public void i_am_enter_valid_request_payload() {
        generateToken.setBodyReq();
    }

    @When("I click hit endpoint")
    public void i_click_hit_endpoint() {
        generateToken.hitEndpointGenerateToken();
    }

    @Then("I am get token")
    public void i_am_get_token() {
        generateToken.validateEndpointGenerateToken();
    }

    //Failed generate token
    @When("I am enter invalid request payload")
    public void i_am_enter_invalid_request_payload() {
        generateToken.setBodyReqFailed();
    }

    @When("I click hit endpoint with invalid request payload")
    public void i_click_hit_endpoint_with_invalid_request_payload() {
        generateToken.hitEndpointGenerateToken();
    }

    @Then("I am not get token")
    public void i_am_not_get_token() {
        generateToken.validateEndpointGenerateTokenFailed();
    }

}
