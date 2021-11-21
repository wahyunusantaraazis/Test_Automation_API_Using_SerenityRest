package starter.account.getdeleteuser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GetUserSteps {

    @Steps
    GetUser getuser;

    @Given("I have a valid User ID")
    public void i_have_a_valid_User_ID() {
        getuser.setBodyReq();
    }

    @When("I enter endpoint with parameter User ID")
    public void i_enter_endpoint_with_parameter_User_ID() {
        getuser.hitEndpointLogin();
    }

    @When("I click endpoint")
    public void i_click_endpoint() {
        getuser.hitEndpointDeleteUserID();
    }

    @Then("I get data by User ID")
    public void i_get_data_by_User_ID() {
        getuser.hitEndpointUserID();
    }
}
