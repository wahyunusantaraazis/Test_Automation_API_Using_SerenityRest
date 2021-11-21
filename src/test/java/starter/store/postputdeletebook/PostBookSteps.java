package starter.store.postputdeletebook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PostBookSteps {

    @Steps
    PostBook postbook;

    @Given("I have account in bookstore")
    public void i_have_account_in_bookstore() {
        postbook.setBodyReq();
        postbook.hitEndpointLogin();
    }

    //POST BOOK to favorite
    @When("I want to add certain book by ISBN")
    public void i_want_to_add_certain_book_by_ISBN() {
        postbook.hitEndpointPostBook();
    }

    @Then("status code {int} and correct Response Body Post")
    public void status_code_and_correct_Response_Body_Post(Integer int1) {
        postbook.validateJSONSchemaPostBook();
    }

    //PUT book in favorite with different ISBN
    @When("I want to change certain book by ISBN")
    public void i_want_to_change_certain_book_by_ISBN() {
        postbook.hitEnpointPutBook();
    }

    @Then("status code {int} and succes change certain book in favorite")
    public void status_code_and_succes_change_certain_book_in_favorite(Integer int1) {
        postbook.validateJSONSchemaPutBook();
    }

    //DELETE book in favorite book in my collection
    @When("I want to delete book with request body isbn and userid")
    public void i_want_to_delete_book_with_request_body_isbn_and_userid() {
        postbook.hitEndpointDeleteBook();
    }

    @Then("status code {int} and response body correctly")
    public void status_code_and_response_body_correctly(Integer int1) {

    }
}
