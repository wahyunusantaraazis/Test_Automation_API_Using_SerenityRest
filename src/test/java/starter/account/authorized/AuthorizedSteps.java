package starter.account.authorized;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AuthorizedSteps {

    @Steps
    Authorized authorized;

    @Given("I am have an account")
    public void i_am_have_an_account() {

    }

    @When("I enter username and password my account")
    public void i_enter_username_and_password_my_account() {
        authorized.setBodyReq();
    }

    @When("I click hit endpoint authorized")
    public void i_click_hit_endpoint_authorized() {
        authorized.hitEndpoitnAuthorized();
    }

    @Then("Response body {string}")
    public void response_body(String string) {

    }
}
